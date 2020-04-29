package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentApiEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.repositories.edu.StudentApiRepository;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentApiServiceImpl implements StudentApiService{

    private final StudentApiRepository studentApiRepository;
    private final PersonWebServiceService personApiService;
    private final Utils utils;

    @Override
    public StudentApiEntity selectLastRecord() {
        return studentApiRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Long studentApiCount() {
        return studentApiRepository.count();
    }

    @Override
    public List<StudentApiEntity> generateStudentApiPublicId(List<StudentEntity> newStudentEntities) {
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
/*                if(s.getPerson()!=null && null!=s.getPerson().getPersonApiEntity()) {
                    if(null!=s.getPerson().getPersonApiEntity().getPersonPublicId()){
                        newStudentApi
                                .setPersonPublicId(s.getPerson().getPersonApiEntity().getPersonPublicId());
                    }
                }*/
            }
            if(null != s.getDeleteStatus()){
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

        List<Long> personIds = new ArrayList<>();
//        personIds =
                newStudentApiEntities
                .stream()
                .filter(Objects::nonNull)
                .filter(e->e.getPerson()!=null)
                .map(StudentApiEntity::getPerson)
                .map(PersonEntity::getId)
                        .forEachOrdered(personIds::add);
//                .collect(Collectors.toCollection(personIds::new));

        List<PersonApiEntity> personApis = personApiService.
                findAllByPersonIdIn(personIds);

//omiddo: check if it had public id insert it into StudentApiEntity


        List<StudentApiEntity> limitedStudentApiEntities = new ArrayList<>();

        limitedStudentApiEntities = newStudentApiEntities.stream().limit(10).collect(Collectors.toList());

        studentApiRepository.saveAll(limitedStudentApiEntities);
//        studentApiRepository.saveAll(newStudentApiEntities);

        return newStudentApiEntities;
    }

    private String generateStudentApiPublicId() {
        return utils.generateUniquePublicId();
    }
}
