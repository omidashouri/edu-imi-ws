package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.RegisterOnly;
import edu.imi.ir.eduimiws.repositories.edu.RegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;



@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class RegisterServiceImpl implements RegisterService{

    private final RegisterRepository registerRepository;
    private final RegisterOnlyMapper registerOnlyMapper;

    @Override
    public Long countRegisterByIdLessThanEqual(Long registerId) {
        log.info("RegisterService.countRegisterByIdLessThanEqual - registerId: {}", registerId);
        Long result = registerRepository.countByIdLessThanEqual(registerId);
        log.info("RegisterService.countRegisterByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public RegisterEntity selectLastRecord() {
        log.info("RegisterService.selectLastRecord - start");
        RegisterEntity result = registerRepository.findFirstByOrderByIdDesc();
        log.info("RegisterService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public RegisterEntity saveNewRegister(RegisterEntity newRegister) {
        log.info("RegisterService.saveNewRegister - newRegister: {}", newRegister);
        RegisterEntity result = registerRepository.save(newRegister);
        log.info("RegisterService.saveNewRegister - result: {}", result);
        return result;
    }

    @Override
    public Page<RegisterEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("RegisterService.findAllByOrderPageable - pageable: {}", pageable);
        Page<RegisterEntity> result = registerRepository
                .findAllByDeleteStatusIsNotNull(pageable);
        log.info("RegisterService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public List<RegisterEntity> findAllByDeleteStatusIsNotNull() {
        log.info("RegisterService.findAllByDeleteStatusIsNotNull - start");
        List<RegisterEntity> result = registerRepository.findAllByDeleteStatusIsNotNull();
        log.info("RegisterService.findAllByDeleteStatusIsNotNull - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<RegisterEntity>> findAllByDeleteStatusIsNotNullThread() throws ExecutionException, InterruptedException {
        log.info("RegisterService.findAllByDeleteStatusIsNotNullThread - start");
        System.out.println(" >>> is currently running in " + Thread.currentThread().getName());
//        final  List<RegisterEntity> registers = registerRepository.findAllByDeleteStatusIsNotNull();
        CompletableFuture<List<RegisterEntity>> result = CompletableFuture.completedFuture(registerRepository.findAllByDeleteStatusIsNotNull());
        log.info("RegisterService.findAllByDeleteStatusIsNotNullThread - result: {}", result);
        return result;
    }

    @Override
    public Page<RegisterEntity> findAllWithStudentPeriodNameByOrderPageable(Pageable pageable) {
        log.info("RegisterService.findAllWithStudentPeriodNameByOrderPageable - pageable: {}", pageable);
        Page<RegisterEntity> result = registerRepository
                .readAllByDeleteStatusIsNotNull(pageable);
        log.info("RegisterService.findAllWithStudentPeriodNameByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public RegisterEntity findByRegisterPublicId(String registerPublicId) {
        log.info("RegisterService.findByRegisterPublicId - registerPublicId: {}", registerPublicId);
        RegisterEntity result = registerRepository
                .findByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(registerPublicId);
        log.info("RegisterService.findByRegisterPublicId - result: {}", result);
        return result;
    }

    @Override
    public RegisterEntity findWithStudentPeriodNameByRegisterPublicId(String registerPublicId) {
        log.info("RegisterService.findWithStudentPeriodNameByRegisterPublicId - registerPublicId: {}", registerPublicId);
        RegisterEntity result = registerRepository
                .readByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(registerPublicId);
        log.info("RegisterService.findWithStudentPeriodNameByRegisterPublicId - result: {}", result);
        return result;
    }

    @Override
    public List<RegisterEntity> findAllRegisterOnlyByIdBetween(Long startId, Long endId) {
        log.info("RegisterService.findAllRegisterOnlyByIdBetween - startId: {}, endId: {}", startId, endId);
        List<RegisterOnly> allRegisterOnlys = registerRepository.findAllRegisterOnlyByIdBetween(startId,endId);
        List<RegisterEntity> result = registerOnlyMapper
                .toRegisterEntities(allRegisterOnlys, new CycleAvoidingMappingContext());
        log.info("RegisterService.findAllRegisterOnlyByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<RegisterEntity> selectAllRegisterOnly() {
        log.info("RegisterService.selectAllRegisterOnly - start");
        List<RegisterOnly> registerOnlys = registerRepository.findAllRegisterOnly();
        registerOnlys.sort(Comparator.comparing(RegisterOnly::getId));
        List<RegisterEntity> result = registerOnlyMapper
                .toRegisterEntities(registerOnlys, new CycleAvoidingMappingContext());
        log.info("RegisterService.selectAllRegisterOnly - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public RegisterEntity findFirstByIdLessThanOrderByIdDesc(Long registerId) {
        log.info("RegisterService.findFirstByIdLessThanOrderByIdDesc - registerId: {}", registerId);
        RegisterEntity result = registerRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(registerId);
        log.info("RegisterService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectRegisterLastSequenceNumber() {
        log.info("RegisterService.selectRegisterLastSequenceNumber - start");
        Long result = registerRepository.selectLastSequenceNumber();
        log.info("RegisterService.selectRegisterLastSequenceNumber - result: {}", result);
        return result;
    }
}
