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

import java.util.Collection;
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
        log.info("PeriodService.findAllByDeleteStatusEqualsOneAndOrderPageable - pageable: {}", pageable);
        Page<PeriodEntity> result = periodRepository
                .findAllByDeleteStatusIsNotNullAndDeleteStatusEquals(1L, pageable);
        log.info("PeriodService.findAllByDeleteStatusEqualsOneAndOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<PeriodEntity> findAllByPeriodApi_FieldPublicIdPageable(String fieldPublicId, Pageable pageable) {
        log.info("PeriodService.findAllByPeriodApi_FieldPublicIdPageable - fieldPublicId: {}, pageable: {}", fieldPublicId, pageable);
        Page<PeriodEntity> result = periodRepository
                .findAllByPeriodApi_FieldPublicId(fieldPublicId, pageable);
        log.info("PeriodService.findAllByPeriodApi_FieldPublicIdPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Long countPeriodByIdLessThanEqual(Long periodId) {
        log.info("PeriodService.countPeriodByIdLessThanEqual - periodId: {}", periodId);
        Long result = periodRepository.countByIdLessThanEqual(periodId);
        log.info("PeriodService.countPeriodByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public Long periodCount() {
        log.info("PeriodService.periodCount - start");
        Long result = periodRepository.count();
        log.info("PeriodService.periodCount - result: {}", result);
        return result;
    }

    @Override
    public PeriodEntity selectLastRecord() {
        log.info("PeriodService.selectLastRecord - start");
        PeriodEntity result = periodRepository.findFirstByOrderByIdDesc();
        log.info("PeriodService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        log.info("PeriodService.findAllPeriodEntityPagesOrderByCreateDateDesc - pageable: {}", pageable);
        Page<PeriodEntity> result = periodRepository
                .findAllPeriodEntityPagesOrderByCreateDateDesc(pageable);
        ;
        log.info("PeriodService.findAllPeriodEntityPagesOrderByCreateDateDesc - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public PeriodEntity findPeriodEntityByPeriodApiPublicId(String periodPublicId) {
        log.info("PeriodService.findPeriodEntityByPeriodApiPublicId - periodPublicId: {}", periodPublicId);
        PeriodEntity result = periodRepository.findByPeriodApi_PeriodPublicId(periodPublicId);
        log.info("PeriodService.findPeriodEntityByPeriodApiPublicId - result: {}", result);
        return result;
    }

    public List<PeriodEntity> findAllPeriodOnly() {
        log.info("PeriodService.findAllPeriodOnly - start");
        List<PeriodOnly> allPeriodOnlys = periodRepository.findAllPeriodOnly();
        allPeriodOnlys.sort(Comparator.comparing(PeriodOnly::getId));
        List<PeriodEntity> result = periodOnlyMapper
                .PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        log.info("PeriodService.findAllPeriodOnly - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id) {
        log.info("PeriodService.findAllPeriodOnlyByIdGreaterThan - id: {}", id);
        List<PeriodOnly> allPeriodOnlys = periodRepository.findPeriodOnlyByIdGreaterThan(id);
        List<PeriodEntity> result = periodOnlyMapper.PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        log.info("PeriodService.findAllPeriodOnlyByIdGreaterThan - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNull() {
        log.info("PeriodService.findAllByDeleteStatusIsNotNullAndExecuterIsNotNull - start");
        Iterable<PeriodEntity> result =
                periodRepository.findAllByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntityIsNull();
        log.info("PeriodService.findAllByDeleteStatusIsNotNullAndExecuterIsNotNull - resultSize: {}",
                result == null ? null : (result instanceof Collection ? ((Collection<?>) result).size() : null));
        return result;
    }

    @Override
    public Page<PeriodEntity> findAllPageableByExecutorPublicId(Pageable pageable, String executorPublicId) {
        log.info("PeriodService.findAllPageableByExecutorPublicId - pageable: {}, executorPublicId: {}", pageable, executorPublicId);
        Page<PeriodEntity> result =
                periodRepository
                        .findByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntity_PersonPublicId
                                (pageable, executorPublicId);
        log.info("PeriodService.findAllPageableByExecutorPublicId - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdBetween(Long startId, Long endId) {
        log.info("PeriodService.findAllPeriodOnlyByIdBetween - startId: {}, endId: {}", startId, endId);
        List<PeriodOnly> allPeriodOnlys = periodRepository
                .findAllPeriodOnlyByIdBetween(startId, endId);
        List<PeriodEntity> result = periodOnlyMapper
                .PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        log.info("PeriodService.findAllPeriodOnlyByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public PeriodEntity findFirstByIdLessThanOrderByIdDesc(Long periodId) {
        log.info("PeriodService.findFirstByIdLessThanOrderByIdDesc - periodId: {}", periodId);
        PeriodEntity result = periodRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(periodId);
        log.info("PeriodService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectPeriodLastSequenceNumber() {
        log.info("PeriodService.selectPeriodLastSequenceNumber - start");
        Long result = periodRepository.selectLastSequenceNumber();
        log.info("PeriodService.selectPeriodLastSequenceNumber - result: {}", result);
        return result;
    }

    @Override
    public List<PeriodEntity> findAllById(List<Long> periodIds) {
        log.info("PeriodService.findAllById - periodIds: {}", periodIds);
        List<PeriodEntity> result = periodRepository
                .findAllByIdIn(periodIds);
        log.info("PeriodService.findAllById - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public Page<PeriodEntity>
    findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable(String periodName, Pageable pageable) {
        log.info("PeriodService.findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable - periodName: {}, pageable: {}", periodName, pageable);
        Page<PeriodEntity> result = periodRepository
                .readAllByDeleteStatusIsNotNullAndDeleteStatusEqualsAndNameContains(1L,
                        periodName,
                        pageable);
        log.info("PeriodService.findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
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
        log.info("PeriodService.queryAllPeriodsCustomTwo - periodPublicId: {}, fieldPublicId: {}, eduCategoryPublicId: {}, levelPublicId: {}, fieldCode: {}, periodOfferNumber: {}, periodName: {}, levelDescription: {}, fieldName: {}, eduCategoryName: {}, periodStartDate: {}, periodEndDate: {}, registerStartDate: {}, registerEndDate: {}, periodMaxCapacity: {}, periodHoldingType: {}, periodCanRegisterOnline: {}, periodType: {}, periodFee: {}, periodDiscount: {}, periodSchedule: {}, periodActivityStatus: {}, periodDeleteStatus: {}, periodTotalUnit: {}, periodId: {}, periodExecutorFirstName: {}, periodExecutorLastName: {}, periodExecutorFullName: {}, pageable: {}",
                periodPublicId, fieldPublicId, eduCategoryPublicId, levelPublicId, fieldCode, periodOfferNumber,
                periodName, levelDescription, fieldName, eduCategoryName, periodStartDate, periodEndDate,
                registerStartDate, registerEndDate, periodMaxCapacity, periodHoldingType, periodCanRegisterOnline,
                periodType, periodFee, periodDiscount, periodSchedule, periodActivityStatus, periodDeleteStatus,
                periodTotalUnit, periodId, periodExecutorFirstName, periodExecutorLastName, periodExecutorFullName, pageable);

        String encodedPeriodName = convertorUtil.characterEncodingInputStringForDb.apply(periodName);
        String encodedFieldName = convertorUtil.characterEncodingInputStringForDb.apply(fieldName);
        String encodedEduCategoryName = convertorUtil.characterEncodingInputStringForDb.apply(eduCategoryName);


        Page<PeriodProjectionCustomTwo> result = periodRepository.queryAllPeriodCustomTwo(periodPublicId,
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

        log.info("PeriodService.queryAllPeriodsCustomTwo - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }


    @Override
    public List<PeriodProjectionCustomFour> queryAllPeriodsCustomFour(String periodPublicId, String fieldPublicId,
                                                                      String eduCategoryPublicId, String levelPublicId,
                                                                      String fieldCode, Long offerNumber,
                                                                      String periodName, String levelTitle,
                                                                      String fieldName, String eduCategoryTitle,
                                                                      String startDate, String endDate,
                                                                      String regStartDate, String regEndDate,
                                                                      Long maxCapacity, String holdingType,
                                                                      String canRegisterOnline, String type,
                                                                      Long fee, Long periodDiscount,
                                                                      String schedule, Long activityStatus,
                                                                      Long deleteStatus, Long totalUnit,
                                                                      String executorFirstName,
                                                                      String executorLastName,
                                                                      String depositCode,
                                                                      String projectCode, String projectName,
                                                                      String projectPublicId,
                                                                      String publicId, Long planId,
                                                                      String betweenRegStartDate,
                                                                      String betweenRegEndDate,
                                                                      String fullName) {
        log.info("PeriodService.queryAllPeriodsCustomFour - periodPublicId: {}, fieldPublicId: {}, eduCategoryPublicId: {}, levelPublicId: {}, fieldCode: {}, offerNumber: {}, periodName: {}, levelTitle: {}, fieldName: {}, eduCategoryTitle: {}, startDate: {}, endDate: {}, regStartDate: {}, regEndDate: {}, maxCapacity: {}, holdingType: {}, canRegisterOnline: {}, type: {}, fee: {}, periodDiscount: {}, schedule: {}, activityStatus: {}, deleteStatus: {}, totalUnit: {}, executorFirstName: {}, executorLastName: {}, depositCode: {}, projectCode: {}, projectName: {}, projectPublicId: {}, publicId: {}, planId: {}, betweenRegStartDate: {}, betweenRegEndDate: {}, fullName: {}",
                periodPublicId, fieldPublicId, eduCategoryPublicId, levelPublicId, fieldCode, offerNumber,
                periodName, levelTitle, fieldName, eduCategoryTitle, startDate, endDate, regStartDate, regEndDate,
                maxCapacity, holdingType, canRegisterOnline, type, fee, periodDiscount, schedule, activityStatus,
                deleteStatus, totalUnit, executorFirstName, executorLastName, depositCode, projectCode, projectName,
                projectPublicId, publicId, planId, betweenRegStartDate, betweenRegEndDate, fullName);

        String encodedPeriodName = convertorUtil.characterEncodingInputStringForDb.apply(periodName);
        String encodedFieldName = convertorUtil.characterEncodingInputStringForDb.apply(fieldName);
        String encodedEduCategoryTitle = convertorUtil.characterEncodingInputStringForDb.apply(eduCategoryTitle);
        String encodedProjectName = convertorUtil.characterEncodingInputStringForDb.apply(projectName);
        String encodedExecutorFullName = convertorUtil.characterEncodingInputStringForDb.apply(fullName);
        String encodedLevelTitle = convertorUtil.characterEncodingInputStringForDb.apply(levelTitle);


        List<PeriodProjectionCustomFour> result =
            periodRepository.queryAllPeriodCustomFour(this.checkNullLongParam(null),
                                                       this.checkNullLongParam(offerNumber),
                                                       this.checkNullLongParam(totalUnit),
                                                       this.checkNullLongParam(maxCapacity),
                                                       this.checkNullLongParam(fee),
                                                       this.checkNullLongParam(periodDiscount),
                                                       this.checkNullLongParam(null),
                                                       this.checkNullLongParam(null),
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
                                                       this.checkNullStringParam(encodedLevelTitle),
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
                                                        this.checkNullStringParam(encodedExecutorFullName)
                );
        log.info("PeriodService.queryAllPeriodsCustomFour - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public PeriodProjectionCustomTwo queryPeriodsCustomTwoByPeriodPublicId(String periodPublicId) {
        log.info("PeriodService.queryPeriodsCustomTwoByPeriodPublicId - periodPublicId: {}", periodPublicId);
        PeriodProjectionCustomTwo result = periodRepository.queryPeriodCustomTwoByPeriodPublicId(periodPublicId);
        log.info("PeriodService.queryPeriodsCustomTwoByPeriodPublicId - result: {}", result);
        return result;
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
