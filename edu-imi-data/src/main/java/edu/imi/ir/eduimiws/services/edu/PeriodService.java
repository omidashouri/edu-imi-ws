package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import org.springframework.cache.annotation.Cacheable;
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

    List<PeriodEntity> findAllById(List<Long> periodIds);

    @Cacheable(value = "period", cacheManager = "jCacheCacheManager")
    Page<PeriodEntity> findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable(String periodName, Pageable pageable);

    Page<PeriodProjectionCustomTwo> queryAllPeriodsCustomTwo(String fieldPublicId,
                                                             String eduCategoryPublicId,
                                                             String levelPublicId,
                                                             String fieldCode,
                                                             Long periodOfferNumber,
                                                             String periodName,
                                                             String levelDescription,
                                                             String fieldName,
                                                             String eduCategoryName,
                                                             String periodStartDate,
                                                             String periodEndDate,
                                                             String registerStartDate,
                                                             String registerEndDate,
                                                             Long periodMaxCapacity,
                                                             String periodHoldingType,
                                                             String periodCanRegisterOnline,
                                                             String periodType,
                                                             Long periodFee,
                                                             String periodSchedule,
                                                             Long periodActivityStatus,
                                                             Long periodDeleteStatus,
                                                             Long periodTotalUnit,
                                                             String periodExecutorFirstName,
                                                             String periodExecutorLastName,
                                                             String periodExecutorFullName,
                                                             Pageable pageable);
}
