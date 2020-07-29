package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldEntityFieldApiFromProjectionMapper;
import edu.imi.ir.eduimiws.repositories.edu.FieldApiRepository;
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
public class FieldApiServiceImpl implements FieldApiService{

    private final FieldApiRepository fieldApiRepository;
    private final LevelApiService levelApiService;
    private final EduCategoryApiService eduCategoryApiService;
    private final FieldEntityFieldApiFromProjectionMapper fieldEntityFieldApiFromProjectionMapper;

    @Override
    public FieldApiEntity selectLastRecord() {
        return fieldApiRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Long fieldApiCount() {
        return fieldApiRepository.count();
    }

    @Override
    public List<FieldApiEntity> generateFieldApiPublicId(List<FieldEntity> newFields) {
        List<FieldApiEntity> newFieldApis = new ArrayList<>();
        final int chunkSize = 900;
        final AtomicInteger atomicLevel = new AtomicInteger();
        final AtomicInteger atomicEduCategory = new AtomicInteger();

        newFieldApis = fieldEntityFieldApiFromProjectionMapper
                .toFieldApis(newFields,new CycleAvoidingMappingContext());

        newFieldApis.sort(Comparator.comparing(FieldApiEntity::getFieldId));

        //        handle public id Level   >>>

        List<Long> levelIds = newFieldApis
                .stream()
                .filter(Objects::nonNull)
                .filter(fieldApi -> fieldApi.getLevel() != null)
                .map(FieldApiEntity::getLevel)
                .map(LevelEntity::getId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredLevelIds = levelIds
                .stream()
                .collect(Collectors.groupingBy(pi -> atomicLevel.getAndIncrement() / chunkSize))
                .values();

        List<LevelApiEntity> fullLevelApis = new ArrayList<>();
        hundredLevelIds.forEach(lp -> {
            levelApiService
                    .findAllByLevelIdIn(lp)
                    .stream()
                    .forEachOrdered(fullLevelApis::add);
        });

        Map<Long, String> levelIdLevelPublicIdMap = fullLevelApis
                .stream()
                .filter(levelApi -> levelApi.getLevelPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(LevelApiEntity::getLevelId,
                        LevelApiEntity::getLevelPublicId));

        newFieldApis
                .stream()
                .filter(fieldApi -> fieldApi.getLevel() != null)
                .filter(fieldApi -> Objects.nonNull(
                        levelIdLevelPublicIdMap.get(
                                fieldApi.getLevel().getId())))
                .forEach(fieldApi -> {
                    fieldApi.setLevelPublicId(
                        levelIdLevelPublicIdMap.get(
                                fieldApi.getLevel().getId()));
                });

        //        handle public id EduCategory   >>>

        List<Long> eduCategoryIds = newFieldApis
                .stream()
                .filter(Objects::nonNull)
                .filter(fieldApi -> fieldApi.getEduCategory() != null)
                .map(FieldApiEntity::getEduCategory)
                .map(EduCategoryEntity::getId)
                .collect(Collectors.toList());

        Collection<List<Long>> hundredEduCategoryIds = eduCategoryIds
                .stream()
                .collect(Collectors.groupingBy(si -> atomicEduCategory.getAndIncrement() / chunkSize))
                .values();

        List<EduCategoryApiEntity> fullEduCategoryApis = new ArrayList<>();
        hundredEduCategoryIds.forEach(ls -> {
            eduCategoryApiService
                    .findAllByEduCategoryIdIn(ls)
                    .stream()
                    .forEachOrdered(fullEduCategoryApis::add);
        });

        Map<Long, String> eduCategoryIdEduCategoryPublicIdMap = fullEduCategoryApis
                .stream()
                .filter(eduCategoryApi -> eduCategoryApi.getEduCategoryPublicId() != null)
                .distinct()
                .collect(Collectors.toMap(EduCategoryApiEntity::getEduCategoryId,
                        EduCategoryApiEntity::getEduCategoryPublicId));

        newFieldApis
                .stream()
                .filter(fieldApi -> fieldApi.getEduCategory() != null)
                .filter(fieldApi -> Objects.nonNull(
                        eduCategoryIdEduCategoryPublicIdMap.get(
                                fieldApi.getEduCategory().getId())))
                .forEach(fieldApi -> fieldApi.setEduCategoryPublicId(
                    eduCategoryIdEduCategoryPublicIdMap.get(
                            fieldApi.getEduCategory().getId())));

        fieldApiRepository.saveAll(newFieldApis);
        return newFieldApis;
    }

    @Override
    public List<FieldApiEntity> findAllByFieldIdIn(List<Long> fieldIds) {
        List<FieldApiEntity> fieldApis = fieldApiRepository
                .findAllByFieldIdIn(fieldIds);
        return fieldApis;
    }
}
