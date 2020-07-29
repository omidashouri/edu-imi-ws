package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeriodService {

    Page<PeriodEntity> findAllByDeleteStatusEqualsOneAndOrderPageable(Pageable pageable);

    Page<PeriodEntity> findAllByPeriodApi_FieldPublicIdPageable(String fieldPublicId,Pageable pageable);

    Long countPeriodByIdLessThanEqual(Long periodId);

    Long periodCount();

    PeriodEntity selectLastRecord();

    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    PeriodEntity findPeriodEntityByPeriodApiPublicId(String periodPublicId);

    List<PeriodEntity> findAllPeriodOnly();

    List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id);

    Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNull();

    Page<PeriodEntity> findAllPageableByExecutorPublicId(Pageable pageable, String executorPublicId);

    List<PeriodEntity> findAllPeriodOnlyByIdBetween(Long startId, Long endId);

    PeriodEntity findFirstByIdLessThanOrderByIdDesc(Long studentId);

    Long selectPeriodLastSequenceNumber();

}
