package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodEntityPeriodApiFromProjectionMapper;
import edu.imi.ir.eduimiws.repositories.edu.PeriodApiRepository;
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
public class PeriodApiServiceImpl implements PeriodApiService {

    private final PeriodApiRepository periodApiRepository;
    private final FieldApiService fieldApiService;
    private final PeriodService periodService;
    private final PeriodEntityPeriodApiFromProjectionMapper periodEntityPeriodApiFromProjectionMapper;
    private final PublicIdUtil publicIdUtil;

    @Override
    public Long periodApiCount() {
        log.info("PeriodApiService.periodApiCount - start");
        Long result = periodApiRepository.count();
        log.info("PeriodApiService.periodApiCount - result: {}", result);
        return result;
    }

    @Override
    public List<PeriodApiEntity> generatePeriodApiPublicId(List<PeriodEntity> newPeriods) {
        log.info("PeriodApiService.generatePeriodApiPublicId - newPeriods: {}", newPeriods);
        List<PeriodApiEntity> newPeriodApis = new ArrayList<>();
        final int chunkSize = 900;
        final AtomicInteger atomicField = new AtomicInteger();

        newPeriodApis = periodEntityPeriodApiFromProjectionMapper
                .toPeriodApis(newPeriods, new CycleAvoidingMappingContext());

        newPeriodApis.sort(Comparator.comparing(PeriodApiEntity::getFieldId));

        //        handle public id Field   >>>

        List<Long> fieldIds = newPeriodApis
                .stream()
                .filter(Objects::nonNull)
                .filter(periodApi -> periodApi.getField() != null)
                .map(PeriodApiEntity::getField)
                .map(FieldEntity::getId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredFieldIds = fieldIds
                .stream()
                .collect(Collectors.groupingBy(pi -> atomicField.getAndIncrement() / chunkSize))
                .values();

        List<FieldApiEntity> fullFieldApis = new ArrayList<>();
        hundredFieldIds.forEach(lp -> {
            fieldApiService
                    .findAllByFieldIdIn(lp)
                    .stream()
                    .forEachOrdered(fullFieldApis::add);
        });

        Map<Long, String> fieldIdFieldPublicIdMap = fullFieldApis
                .stream()
                .filter(fieldApi -> fieldApi.getFieldPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(FieldApiEntity::getFieldId,
                        FieldApiEntity::getFieldPublicId));

        newPeriodApis
                .stream()
                .filter(periodApi -> periodApi.getField() != null)
                .filter(periodApi -> Objects.nonNull(
                        fieldIdFieldPublicIdMap.get(
                                periodApi.getField().getId())))
                .forEach(periodApi -> {
                    periodApi.setFieldPublicId(
                            fieldIdFieldPublicIdMap.get(
                                    periodApi.getField().getId()));
                });

        periodApiRepository.saveAll(newPeriodApis);
        log.info("PeriodApiService.generatePeriodApiPublicId - resultSize: {}", newPeriodApis == null ? null : newPeriodApis.size());
        return newPeriodApis;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdIn(List<Long> periodIds) {
        log.info("PeriodApiService.findAllByPeriodIdIn - periodIds: {}", periodIds);
        List<PeriodApiEntity> result = periodApiRepository
                .findAllByPeriodIdIn(periodIds);
        log.info("PeriodApiService.findAllByPeriodIdIn - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdInAndPeriodPublicIdIsNotNull(List<Long> periodIds) {
        log.info("PeriodApiService.findAllByPeriodIdInAndPeriodPublicIdIsNotNull - periodIds: {}", periodIds);
        List<PeriodApiEntity> result = periodApiRepository
                .findAllByPeriodIdInAndPeriodPublicIdIsNotNull(periodIds);
        log.info("PeriodApiService.findAllByPeriodIdInAndPeriodPublicIdIsNotNull - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<PeriodApiEntity> findAllPeriodApisByFieldPublicIdIsNull() {
        log.info("PeriodApiService.findAllPeriodApisByFieldPublicIdIsNull - start");
        List<PeriodApiEntity> result = periodApiRepository
                .findAllByFieldPublicIdIsNull();
        log.info("PeriodApiService.findAllPeriodApisByFieldPublicIdIsNull - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<PeriodApiEntity> updatePeriodApiByFieldPublicId(List<PeriodApiEntity> newPeriodApis) {
        log.info("PeriodApiService.updatePeriodApiByFieldPublicId - newPeriodApis: {}", newPeriodApis);
        final int chunkSize = 900;
        final AtomicInteger atomicPeriod = new AtomicInteger();


        newPeriodApis.sort(Comparator.comparing(PeriodApiEntity::getPeriodId));

        List<Long> periodIds = newPeriodApis
                .stream()
                .filter(Objects::nonNull)
                .filter(periodApi -> periodApi.getPeriodId() != null)
                .map(PeriodApiEntity::getPeriodId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredPeriodIds = periodIds
                .stream()
                .collect(Collectors
                        .groupingBy(pi ->
                                atomicPeriod.getAndIncrement() / chunkSize))
                .values();

        List<PeriodEntity> periods = new ArrayList<>();
        hundredPeriodIds.forEach(lp -> {
            periodService
                    .findAllById(lp)
                    .stream()
                    .forEachOrdered(periods::add);
        });

        Map<Long, Long> periodIdFieldIdMap = periods
                .stream()
                .filter(period -> period.getDeleteStatus() != null)
                .filter(period -> period.getFieldId() != null)
                .filter(period -> period.getField() != null)
                .filter(period -> period.getField().getFieldApi() != null)
                .filter(period -> period.getField().getFieldApi().getFieldPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(PeriodEntity::getId,
                        PeriodEntity::getFieldId));

        newPeriodApis
                .stream()
                .filter(periodApi -> periodApi.getField() == null)
                .filter(periodApi -> periodApi.getFieldId() == null)
                .filter(periodApi -> Objects.nonNull(
                        periodIdFieldIdMap.get(
                                periodApi.getPeriodId())))
                .forEach(periodApi -> {
                    periodApi.setFieldId(
                            periodIdFieldIdMap.get(
                                    periodApi.getPeriodId()));
                    FieldEntity field = new FieldEntity();
                    field.setId(periodApi.getFieldId());
                    periodApi.setField(field);
                });

/*        newPeriodApis
                .stream()
                .filter(periodApi->periodApi.getFieldId()!=null)
                .forEach(periodApi -> {
                    FieldEntity field = new FieldEntity();
                    field.setId(periodApi.getFieldId());
                    periodApi.setField(field);
                });*/

        Map<Long, String> periodIdFieldPublicIdMap = periods
                .stream()
                .filter(period -> period.getDeleteStatus() != null)
                .filter(period -> period.getFieldId() != null)
                .filter(period -> period.getField() != null)
                .filter(period -> period.getField().getFieldApi() != null)
                .filter(period -> period.getField().getFieldApi().getFieldPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(PeriodEntity::getId,
                        period -> period.getField().getFieldApi().getFieldPublicId()));

        newPeriodApis
                .stream()
                .filter(periodApi -> periodApi.getField() != null)
                .filter(periodApi -> periodApi.getFieldId() != null)
                .filter(periodApi -> periodApi.getFieldPublicId() == null)
                .filter(periodApi -> Objects.nonNull(
                        periodIdFieldPublicIdMap.get(
                                periodApi.getPeriodId())))
                .forEach(periodApi -> {
                    periodApi.setFieldPublicId(
                            periodIdFieldPublicIdMap.get(
                                    periodApi.getPeriodId()));
                });

        periodApiRepository.saveAll(newPeriodApis);
        log.info("PeriodApiService.updatePeriodApiByFieldPublicId - resultSize: {}", newPeriodApis == null ? null : newPeriodApis.size());
        return newPeriodApis;
    }

    @Override
    public PeriodApiEntity selectLastRecord() {
        log.info("PeriodApiService.selectLastRecord - start");
        PeriodApiEntity result = periodApiRepository.findFirstByOrderByIdDesc();
        log.info("PeriodApiService.selectLastRecord - result: {}", result);
        return result;
    }

    private String generatePeriodApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
