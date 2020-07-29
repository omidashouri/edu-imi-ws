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
    private final PeriodEntityPeriodApiFromProjectionMapper periodEntityPeriodApiFromProjectionMapper;
    private final PublicIdUtil publicIdUtil;

    @Override
    public Long periodApiCount() {
        return periodApiRepository.count();
    }

    @Override
    public List<PeriodApiEntity> generatePeriodApiPublicId(List<PeriodEntity> newPeriods) {

/*        List<PeriodApiEntity> newPeriodApiEntities = new ArrayList<>();

        newPeriods.forEach(p -> {
            PeriodApiEntity newPeriodApi = new PeriodApiEntity();
            newPeriodApi.setPeriod(p);
            newPeriodApi.setPeriodId(p.getId());
            newPeriodApi.setPeriodPublicId(this.generatePeriodApiPublicId());
            if (null != p.getCanRegisterOnline()) {
                newPeriodApi.setCanRegisterOnline(p.getCanRegisterOnline().trim());
            }
            if (null != p.getDeleteStatus() && p.getDeleteStatus().equals(1L)) {
                newPeriodApi.setDeleteTs(new Timestamp(new Date().getTime()));
            }
            if (null != p.getEditDate()) {
                newPeriodApi.setPeriodEditDate(p.getEditDate());
            }
            newPeriodApi.setCreateDateTs(new Timestamp(new Date().getTime()));
            newPeriodApiEntities.add(newPeriodApi);
        });

        newPeriodApiEntities.sort(Comparator.comparing(PeriodApiEntity::getPeriodId));

        periodApiRepository.saveAll(newPeriodApiEntities);

        return newPeriodApiEntities;*/

        List<PeriodApiEntity> newPeriodApis = new ArrayList<>();
        final int chunkSize = 900;
        final AtomicInteger atomicField = new AtomicInteger();

        newPeriodApis = periodEntityPeriodApiFromProjectionMapper
                .toPeriodApis(newPeriods,new CycleAvoidingMappingContext());

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
        return newPeriodApis;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdIn(List<Long> periodIds) {
        List<PeriodApiEntity> periodApis = periodApiRepository
                .findAllByPeriodIdIn(periodIds);
        return periodApis;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdInAndPeriodPublicIdIsNotNull(List<Long> periodIds) {
        List<PeriodApiEntity> periodApis = periodApiRepository
                .findAllByPeriodIdInAndPeriodPublicIdIsNotNull(periodIds);
        return periodApis;
    }

    @Override
    public PeriodApiEntity selectLastRecord() {
        return periodApiRepository.findFirstByOrderByIdDesc();
    }

    private String generatePeriodApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
