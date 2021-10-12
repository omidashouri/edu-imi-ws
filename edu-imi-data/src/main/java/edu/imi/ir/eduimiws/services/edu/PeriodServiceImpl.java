package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;
    private final PeriodOnlyMapper periodOnlyMapper;
    private final ConvertorUtil convertorUtil;

    @Override
    public Page<PeriodEntity> findAllByDeleteStatusEqualsOneAndOrderPageable(Pageable pageable) {
        Page<PeriodEntity> periodPages = periodRepository
                .findAllByDeleteStatusIsNotNullAndDeleteStatusEquals(1L, pageable);
        return periodPages;
    }

    @Override
    public Page<PeriodEntity> findAllByPeriodApi_FieldPublicIdPageable(String fieldPublicId, Pageable pageable) {
        Page<PeriodEntity> periodPages = periodRepository
                .findAllByPeriodApi_FieldPublicId(fieldPublicId, pageable);
        return periodPages;
    }

    @Override
    public Long countPeriodByIdLessThanEqual(Long periodId) {
        Long periodCount = periodRepository.countByIdLessThanEqual(periodId);
        return periodCount;
    }

    @Override
    public Long periodCount() {
        return periodRepository.count();
    }

    @Override
    public PeriodEntity selectLastRecord() {
        return periodRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        Page<PeriodEntity> periodPages = periodRepository
                .findAllPeriodEntityPagesOrderByCreateDateDesc(pageable);
        ;
        return periodPages;
    }

    @Override
    public PeriodEntity findPeriodEntityByPeriodApiPublicId(String periodPublicId) {

        PeriodEntity period = periodRepository.findByPeriodApi_PeriodPublicId(periodPublicId);
        return period;
    }

    public List<PeriodEntity> findAllPeriodOnly() {
        List<PeriodOnly> allPeriodOnlys = periodRepository.findAllPeriodOnly();
        allPeriodOnlys.sort(Comparator.comparing(PeriodOnly::getId));
        List<PeriodEntity> allPeriods = periodOnlyMapper
                .PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id) {
        List<PeriodOnly> allPeriodOnlys = periodRepository.findPeriodOnlyByIdGreaterThan(id);
        List<PeriodEntity> allPeriods = periodOnlyMapper.PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNull() {
        Iterable<PeriodEntity> periodEntities =
                periodRepository.findAllByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntityIsNull();
        return periodEntities;
    }

    @Override
    public Page<PeriodEntity> findAllPageableByExecutorPublicId(Pageable pageable, String executorPublicId) {
        Page<PeriodEntity> pageablePeriods =
                periodRepository
                        .findByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntity_PersonPublicId
                                (pageable, executorPublicId);
        return pageablePeriods;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdBetween(Long startId, Long endId) {
        List<PeriodOnly> allPeriodOnlys = periodRepository
                .findAllPeriodOnlyByIdBetween(startId, endId);
        List<PeriodEntity> allPeriods = periodOnlyMapper
                .PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public PeriodEntity findFirstByIdLessThanOrderByIdDesc(Long periodId) {
        PeriodEntity period = periodRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(periodId);
        return period;
    }

    @Override
    public Long selectPeriodLastSequenceNumber() {
        return periodRepository.selectLastSequenceNumber();
    }

    @Override
    public List<PeriodEntity> findAllById(List<Long> periodIds) {
        List<PeriodEntity> periods = periodRepository
                .findAllByIdIn(periodIds);
        return periods;
    }

    @Override
    public Page<PeriodEntity>
    findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable(String periodName, Pageable pageable) {
        Page<PeriodEntity> periodPages = periodRepository
                .readAllByDeleteStatusIsNotNullAndDeleteStatusEqualsAndNameContains(1L,
                        periodName,
                        pageable);
        return periodPages;
    }

    @Override
    public Page<PeriodProjectionCustomTwo> queryAllPeriodsCustomTwo(String periodPublicId, String fieldPublicId,
                                                                    String eduCategoryPublicId, String levelPublicId,
                                                                    String fieldCode, Long periodOfferNumber,
                                                                    String periodName, String levelDescription, String fieldName,
                                                                    String eduCategoryName, String periodStartDate,
                                                                    String periodEndDate, String registerStartDate,
                                                                    String registerEndDate, Long periodMaxCapacity,
                                                                    String periodHoldingType, String periodCanRegisterOnline,
                                                                    String periodType, Long periodFee, Long periodDiscount,
                                                                    String periodSchedule,
                                                                    Long periodActivityStatus, Long periodDeleteStatus,
                                                                    Long periodTotalUnit, Long periodId,
                                                                    String periodExecutorFirstName, String periodExecutorLastName,
                                                                    String periodExecutorFullName, Pageable pageable) {

        String encodedPeriodName = convertorUtil.characterEncodingStringRequest.apply(periodName);
        String encodedFieldName = convertorUtil.characterEncodingStringRequest.apply(fieldName);
        String encodedEduCategoryName = convertorUtil.characterEncodingStringRequest.apply(eduCategoryName);


        Page<PeriodProjectionCustomTwo> periodProjectionCustomTwoPages = periodRepository.queryAllPeriodCustomTwo(periodPublicId,
                                                                                        fieldPublicId,
                                                                                        eduCategoryPublicId, levelPublicId,
                                                                                        fieldCode, periodOfferNumber,
                                                                                        encodedPeriodName, levelDescription,encodedFieldName,
                                                                                        encodedEduCategoryName, periodStartDate,
                                                                                        periodEndDate, registerStartDate,
                                                                                        registerEndDate, periodMaxCapacity,
                                                                                        periodHoldingType, periodCanRegisterOnline,
                                                                                        periodType, periodFee, periodDiscount,
                                                                                        periodSchedule,
                                                                                        periodActivityStatus, periodDeleteStatus,
                                                                                        periodTotalUnit, periodId,
                                                                                        periodExecutorFirstName, periodExecutorLastName,
                                                                                        periodExecutorFullName, pageable);

        return periodProjectionCustomTwoPages;
    }

    @Override
    public PeriodProjectionCustomTwo queryPeriodsCustomTwoByPeriodPublicId(String periodPublicId) {
        return periodRepository.queryPeriodCustomTwoByPeriodPublicId(periodPublicId);
    }

    protected Predicate<Object> isValueDefault = (input) -> {
        if (input == null)
            return false;

        if (input != null) {
            String str = (String) input;
            if (str.equalsIgnoreCase(""))
                return true;
        }
        return false;
    };

    protected <T> T nullDefaultValue(T input){
        if(isValueDefault.test(input))
            return null;
        return input;
    }
}
