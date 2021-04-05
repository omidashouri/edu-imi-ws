package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.RegisterOnly;
import edu.imi.ir.eduimiws.repositories.edu.RegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Async
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RegisterServiceImpl implements RegisterService{

    private final RegisterRepository registerRepository;
    private final RegisterOnlyMapper registerOnlyMapper;

    @Override
    public Long countRegisterByIdLessThanEqual(Long registerId) {
        Long registerCount = registerRepository.countByIdLessThanEqual(registerId);
        return registerCount;
    }

    @Override
    public RegisterEntity selectLastRecord() {
        return registerRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public RegisterEntity saveNewRegister(RegisterEntity newRegister) {
        return registerRepository.save(newRegister);
    }

    @Override
    public Page<RegisterEntity> findAllByOrderPageable(Pageable pageable) {
        Page<RegisterEntity> registerPages = registerRepository
                .findAllByDeleteStatusIsNotNull(pageable);
        return registerPages;
    }

    @Override
    public List<RegisterEntity> findAllByDeleteStatusIsNotNull() {
        return registerRepository.findAllByDeleteStatusIsNotNull();
    }

    @Override
    public Page<RegisterEntity> findAllWithStudentPeriodNameByOrderPageable(Pageable pageable) {
        Page<RegisterEntity> registerPages = registerRepository
                .readAllByDeleteStatusIsNotNull(pageable);
        return registerPages;
    }

    @Override
    public RegisterEntity findByRegisterPublicId(String registerPublicId) {
        RegisterEntity register = registerRepository
                .findByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(registerPublicId);
        return register;
    }

    @Override
    public RegisterEntity findWithStudentPeriodNameByRegisterPublicId(String registerPublicId) {
        RegisterEntity register = registerRepository
                .readByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(registerPublicId);
        return register;
    }

    @Override
    public List<RegisterEntity> findAllRegisterOnlyByIdBetween(Long startId, Long endId) {
        List<RegisterOnly> allRegisterOnlys = registerRepository.findAllRegisterOnlyByIdBetween(startId,endId);
        List<RegisterEntity> allRegisters = registerOnlyMapper
                .toRegisterEntities(allRegisterOnlys, new CycleAvoidingMappingContext());
        return allRegisters;
    }

    @Override
    public List<RegisterEntity> selectAllRegisterOnly() {
        List<RegisterOnly> registerOnlys = registerRepository.findAllRegisterOnly();
        registerOnlys.sort(Comparator.comparing(RegisterOnly::getId));
        List<RegisterEntity> allRegisters = registerOnlyMapper
                .toRegisterEntities(registerOnlys, new CycleAvoidingMappingContext());
        return allRegisters;
    }

    @Override
    public RegisterEntity findFirstByIdLessThanOrderByIdDesc(Long registerId) {
        RegisterEntity register = registerRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(registerId);
        return register;
    }

    @Override
    public Long selectRegisterLastSequenceNumber() {
        return registerRepository.selectLastSequenceNumber();
    }
}
