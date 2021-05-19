package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface RegisterService {

    Long countRegisterByIdLessThanEqual(Long registerId);

    RegisterEntity selectLastRecord();

    RegisterEntity saveNewRegister(RegisterEntity newRegister);

    Page<RegisterEntity> findAllByOrderPageable(Pageable pageable);

    List<RegisterEntity> findAllByDeleteStatusIsNotNull();

    CompletableFuture<List<RegisterEntity>> findAllByDeleteStatusIsNotNullThread() throws ExecutionException, InterruptedException;

    @Cacheable(value = "register")
    Page<RegisterEntity> findAllWithStudentPeriodNameByOrderPageable(Pageable pageable);

    RegisterEntity findByRegisterPublicId(String registerPublicId);

    RegisterEntity findWithStudentPeriodNameByRegisterPublicId(String registerPublicId);

    List<RegisterEntity> findAllRegisterOnlyByIdBetween(Long startId, Long endId);

    List<RegisterEntity> selectAllRegisterOnly();

    RegisterEntity findFirstByIdLessThanOrderByIdDesc(Long registerId);

    Long selectRegisterLastSequenceNumber();
}
