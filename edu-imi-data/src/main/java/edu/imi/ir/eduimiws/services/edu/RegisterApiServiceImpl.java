package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterEntityRegisterApiFromProjectionMapper;
import edu.imi.ir.eduimiws.repositories.edu.RegisterApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RegisterApiServiceImpl implements RegisterApiService {

    private final RegisterApiRepository registerApiRepository;
    private final PeriodApiService periodApiService;
    private final StudentApiService studentApiService;
    private final RegisterEntityRegisterApiFromProjectionMapper registerEntityRegisterApiFromProjectionMapper;
    private final PublicIdUtil publicIdUtil;

    @Override
    public RegisterApiEntity selectLastRecord() {
        return registerApiRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Long registerApiCount() {
        return registerApiRepository.count();
    }

    @Override
    public List<RegisterApiEntity> generateRegisterApiPublicId(List<RegisterEntity> newRegisters) {
        List<RegisterApiEntity> newRegisterApis = new ArrayList<>();
        final int chunkSize = 900;
        final AtomicInteger counterPeriod = new AtomicInteger();
        final AtomicInteger counterStudent = new AtomicInteger();

 /*       newRegisters.forEach(register -> {
            RegisterApiEntity newRegisterApi = new RegisterApiEntity();
            newRegisterApi.setRegister(register);
            newRegisterApi.setRegisterId(register.getId());
            newRegisterApi.setRegisterPublicId(this.generateRegisterApiPublicId());
            if(register.getPeriodId()!=null){
                newRegisterApi.setPeriodId(register.getPeriodId());
            }

            if (null != register.getPeriod()) {
                newRegisterApi.setPeriod(register.getPeriod());
            }
            if (null != register.getStudent()) {
                newRegisterApi.setStudent(register.getStudent());
            }
            if (null != register.getPeriodDeleteStatus()) {
                newRegisterApi.setRegisterDeleteStatus(register.getPeriodDeleteStatus());
                if (register.getPeriodDeleteStatus().equals(1L)) {
                    newRegisterApi.setDeleteDateTs(new Timestamp(new Date().getTime()));
                }
            }
            if (null != register.getActivityStatus()) {
                newRegisterApi.setRegisterActivityStatus(register.getActivityStatus());
            }
            if (null != register.getEditDate()) {
                newRegisterApi.setRegisterEditDate(register.getEditDate());
            }
            newRegisterApi.setCreateDateTs(new Timestamp(new Date().getTime()));
            newRegisterApis.add(newRegisterApi);
        });*/

        newRegisterApis = registerEntityRegisterApiFromProjectionMapper
                .toRegisterApis(newRegisters, new CycleAvoidingMappingContext());

        newRegisterApis.sort(Comparator.comparing(RegisterApiEntity::getRegisterId));

//        handle public id Period   >>>

        List<Long> periodIds = newRegisterApis
                .stream()
                .filter(Objects::nonNull)
                .filter(registerApi -> registerApi.getPeriod() != null)
                .map(RegisterApiEntity::getPeriod)
                .map(PeriodEntity::getId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredPeriodIds = periodIds
                .stream()
                .collect(Collectors.groupingBy(pi -> counterPeriod.getAndIncrement() / chunkSize))
                .values();

        List<PeriodApiEntity> fullPeriodApis = new ArrayList<>();
        hundredPeriodIds.stream().forEach(lp -> {
            periodApiService
                    .findAllByPeriodIdIn(lp)
                    .stream()
                    .forEachOrdered(fullPeriodApis::add);
        });

        Map<Long, String> periodIdPeriodPublicIdMap = fullPeriodApis
                .stream()
                .filter(periodApi -> periodApi.getPeriodPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(PeriodApiEntity::getPeriodId,
                        PeriodApiEntity::getPeriodPublicId));

        newRegisterApis
                .stream()
                .filter(registerApi -> registerApi.getPeriod() != null)
                .filter(registerApi -> Objects.nonNull(periodIdPeriodPublicIdMap.get(registerApi.getPeriod().getId())))
                .forEach(registerApi -> {
                    registerApi.setPeriodPublicId(periodIdPeriodPublicIdMap.get(registerApi.getPeriod().getId()));
                });


//        handle public id Student  >>>

        List<Long> studentIds = newRegisterApis
                .stream()
                .filter(Objects::nonNull)
                .filter(registerApi -> registerApi.getStudent() != null)
                .map(RegisterApiEntity::getStudent)
                .map(StudentEntity::getId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredStudentIds = studentIds
                .stream()
                .collect(Collectors.groupingBy(si -> counterStudent.getAndIncrement() / chunkSize))
                .values();

        List<StudentApiEntity> fullStudentApis = new ArrayList<>();
        hundredStudentIds.stream().forEach(ls -> {
            studentApiService
                    .findAllByStudentIdIn(ls)
                    .stream()
                    .forEachOrdered(fullStudentApis::add);
        });

        Map<Long, String> studentIdStudentPublicIdMap = fullStudentApis
                .stream()
                .filter(studentApi -> studentApi.getStudentPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(StudentApiEntity::getStudentId,
                        StudentApiEntity::getStudentPublicId));

        newRegisterApis
                .stream()
                .filter(registerApi -> registerApi.getStudent() != null)
                .filter(registerApi -> Objects.nonNull(studentIdStudentPublicIdMap.get(registerApi.getStudent().getId())))
                .forEach(registerApi -> {
                    registerApi.setStudentPublicId(studentIdStudentPublicIdMap.get(registerApi.getStudent().getId()));
                });

        registerApiRepository.saveAll(newRegisterApis);

        return newRegisterApis;
    }


    private String generateRegisterApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
