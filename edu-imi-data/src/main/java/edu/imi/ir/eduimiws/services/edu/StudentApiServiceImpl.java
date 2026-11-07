package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentApiEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.repositories.edu.StudentApiRepository;
import edu.imi.ir.eduimiws.services.crm.PersonApiService;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentApiServiceImpl implements StudentApiService {

    private final StudentApiRepository studentApiRepository;
    private final PersonApiService personApiService;
    private final PublicIdUtil publicIdUtil;

    @Override
    public StudentApiEntity selectLastRecord() {
        log.info("StudentApiService.selectLastRecord - start");
        StudentApiEntity result = studentApiRepository.findFirstByOrderByIdDesc();
        log.info("StudentApiService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Long studentApiCount() {
        log.info("StudentApiService.studentApiCount - start");
        Long result = studentApiRepository.count();
        log.info("StudentApiService.studentApiCount - result: {}", result);
        return result;
    }

    @Override
    public List<StudentApiEntity> generateStudentApiPublicId(List<StudentEntity> newStudentEntities) {
        log.info("StudentApiService.generateStudentApiPublicId - newStudentEntities: {}", newStudentEntities);
        List<StudentApiEntity> newStudentApiEntities = new ArrayList<>();

        newStudentEntities.forEach(s -> {
            StudentApiEntity newStudentApi = new StudentApiEntity();
            newStudentApi.setStudent(s);
            newStudentApi.setStudentId(s.getId());
            newStudentApi.setStudentPublicId(this.generateStudentApiPublicId());
            if (null != s.getPersonId()) {
                PersonEntity person = new PersonEntity();
                person.setId(s.getPersonId());
                newStudentApi.setPerson(person);
            }
            if (null != s.getDeleteStatus()) {
                newStudentApi.setStudentDeleteStatus(s.getDeleteStatus());
                if (s.getDeleteStatus().equals(1L)) {
                    newStudentApi.setDeleteDateTs(new Timestamp(new Date().getTime()));
                }
            }
            if (null != s.getEditDate()) {
                newStudentApi.setStudentEditDate(s.getEditDate());
            }
            newStudentApi.setCreateDateTs(new Timestamp(new Date().getTime()));
            newStudentApiEntities.add(newStudentApi);
        });

        newStudentApiEntities.sort(Comparator.comparing(StudentApiEntity::getStudentId));

        List<Long> personIds = newStudentApiEntities
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getPerson() != null)
                .map(StudentApiEntity::getPerson)
                .map(PersonEntity::getId)
                .collect(Collectors.toList());

        final int chunkSize = 900;
        final AtomicInteger counter = new AtomicInteger();
        Collection<List<Long>> hundredPersonIds = personIds
                .stream()
                .collect(Collectors.groupingBy(pi -> counter.getAndIncrement() / chunkSize))
                .values();

        List<PersonApiEntity> fullPersonApis = new ArrayList<>();
        hundredPersonIds.stream().forEach(lp->{
             personApiService
                    .findAllByPersonIdIn(lp)
                    .stream()
                    .forEachOrdered(fullPersonApis::add);
        });

        Map<Long, String> personIdPersonPublicIdMap = fullPersonApis
                .stream()
                .filter(pa -> pa.getPersonPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(PersonApiEntity::getPersonId, PersonApiEntity::getPersonPublicId));

        newStudentApiEntities
                .stream()
                .filter(s->s.getPerson()!=null)
                .filter(s->Objects.nonNull(personIdPersonPublicIdMap.get(s.getPerson().getId())))
                .forEach(s -> {
                    s.setPersonPublicId(personIdPersonPublicIdMap.get(s.getPerson().getId()));
                });

        studentApiRepository.saveAll(newStudentApiEntities);

        log.info("StudentApiService.generateStudentApiPublicId - resultSize: {}", newStudentApiEntities == null ? null : newStudentApiEntities.size());
        return newStudentApiEntities;
    }

    @Override
    public List<StudentApiEntity> findAllByStudentIdIn(List<Long> studentIds) {
        log.info("StudentApiService.findAllByStudentIdIn - studentIds: {}", studentIds);
        List<StudentApiEntity> result = studentApiRepository
                .findAllByStudentIdIn(studentIds);
        log.info("StudentApiService.findAllByStudentIdIn - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<StudentApiEntity> findAllByStudentIdInAndStudentPublicIdIsNotNull(List<Long> studentIds) {
        log.info("StudentApiService.findAllByStudentIdInAndStudentPublicIdIsNotNull - studentIds: {}", studentIds);
        List<StudentApiEntity> result = studentApiRepository
                .findAllByStudentIdInAndStudentPublicIdIsNotNull(studentIds);
        log.info("StudentApiService.findAllByStudentIdInAndStudentPublicIdIsNotNull - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    private String generateStudentApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
