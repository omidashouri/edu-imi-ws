package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomFour;
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
import java.util.Optional;
import java.util.function.Predicate;
//___periodfour
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

        String encodedPeriodName = convertorUtil.characterEncodingInputStringForDb.apply(periodName);
        String encodedFieldName = convertorUtil.characterEncodingInputStringForDb.apply(fieldName);
        String encodedEduCategoryName = convertorUtil.characterEncodingInputStringForDb.apply(eduCategoryName);


        Page<PeriodProjectionCustomTwo> periodProjectionCustomTwoPages = periodRepository.queryAllPeriodCustomTwo(periodPublicId,
                fieldPublicId,
                eduCategoryPublicId, levelPublicId,
                fieldCode, periodOfferNumber,
                encodedPeriodName, levelDescription, encodedFieldName,
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
    public List<PeriodProjectionCustomFour> queryAllPeriodsCustomFour(String periodPublicId, String fieldPublicId,
                                                                      String eduCategoryPublicId, String levelPublicId,
                                                                      String fieldCode, Long offerNumber,
                                                                      String periodName, String levelDescription,
                                                                      String fieldName, String eduCategoryTitle,
                                                                      String startDate, String endDate,
                                                                      String regStartDate, String regEndDate,
                                                                      Long maxCapacity, String holdingType,
                                                                      String canRegisterOnline, String type,
                                                                      Long fee, Long periodDiscount,
                                                                      String schedule, Long activityStatus,
                                                                      Long deleteStatus, Long totalUnit,
                                                                      Long feeEquivalentFixed,
                                                                      Long feeEquivalentVariable,
                                                                      Long periodId, String executorFirstName,
                                                                      String executorLastName,
                                                                      String ExecutorFullName, String depositCode,
                                                                      String projectCode, String projectName,
                                                                      String projectPublicId,
                                                                      String publicId, Long planId,
                                                                      String betweenRegStartDate,
                                                                      String betweenRegEndDate,
                                                                      String fullName) {

        String encodedPeriodName = convertorUtil.characterEncodingInputStringForDb.apply(periodName);
        String encodedFieldName = convertorUtil.characterEncodingInputStringForDb.apply(fieldName);
        String encodedEduCategoryTitle = convertorUtil.characterEncodingInputStringForDb.apply(eduCategoryTitle);
        String encodedProjectName = convertorUtil.characterEncodingInputStringForDb.apply(projectName);


        List<PeriodProjectionCustomFour> periodProjectionCustomFours =
            periodRepository.queryAllPeriodCustomFour(this.checkNullLongParam(periodId),
                                                       this.checkNullLongParam(offerNumber),
                                                       this.checkNullLongParam(totalUnit),
                                                       this.checkNullLongParam(maxCapacity),
                                                       this.checkNullLongParam(fee),
                                                       this.checkNullLongParam(periodDiscount),
                                                       this.checkNullLongParam(feeEquivalentFixed),
                                                       this.checkNullLongParam(feeEquivalentVariable),
                                                       this.checkNullLongParam(activityStatus),
                                                       this.checkNullLongParam(deleteStatus),
                                                       this.checkNullStringParam(periodPublicId),
                                                       this.checkNullStringParam(fieldPublicId),
                                                       this.checkNullStringParam(eduCategoryPublicId),
                                                       this.checkNullStringParam(levelPublicId),
                                                       this.checkNullStringParam(projectPublicId),
                                                       this.checkNullStringParam(publicId),
                                                       this.checkNullStringParam(fieldCode),
                                                       this.checkNullStringParam(encodedFieldName),
                                                       this.checkNullStringParam(encodedPeriodName),
                                                       this.checkNullStringParam(levelDescription),
                                                       this.checkNullStringParam(encodedEduCategoryTitle),
                                                       this.checkNullStringParam(encodedProjectName),
                                                       this.checkNullStringParam(depositCode),
                                                       this.checkNullStringParam(projectCode),
                                                       this.checkNullStringParam(executorFirstName),
                                                       this.checkNullStringParam(executorLastName),
                                                       this.checkNullStringParam(startDate),
                                                       this.checkNullStringParam(endDate),
                                                       this.checkNullStringParam(regStartDate),
                                                       this.checkNullStringParam(regEndDate),
                                                       this.checkNullStringParam(holdingType),
                                                       this.checkNullStringParam(canRegisterOnline),
                                                       this.checkNullStringParam(type),
                                                       this.checkNullStringParam(schedule),
                                                       this.checkNullLongParam(planId),
                                                       this.checkNullStringParam(betweenRegStartDate),
                                                       this.checkNullStringParam(betweenRegEndDate),
                                                        this.checkNullStringParam(fullName)
                );
        return periodProjectionCustomFours;
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

    private Long checkNullLongParam(Long input) {
        return Optional.ofNullable(input).orElse(-999L);
    }

    private String checkNullStringParam(String input){
        return Optional.ofNullable(input).orElse("-999");
    }

}
