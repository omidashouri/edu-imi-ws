package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.FieldOnly;
import edu.imi.ir.eduimiws.repositories.edu.FieldRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FieldServiceImpl implements FieldService{

    private final FieldRepository fieldRepository;
    private final FieldOnlyMapper fieldOnlyMapper;

    @Override
    public Long countFieldByIdLessThanEqual(Long fieldId) {
        Long fieldCount = fieldRepository.countByIdLessThanEqual(fieldId);
        return fieldCount;
    }

    @Override
    public FieldEntity selectLastRecord() {
        return fieldRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<FieldEntity> findAllByOrderPageable(Pageable pageable) {
        Page<FieldEntity> fieldPages = fieldRepository
                .findAll(pageable);
        return fieldPages;
    }

    @Override
    public FieldEntity findByFieldPublicId(String fieldPublicId) {
        FieldEntity field = fieldRepository
                .findByFieldApi_FieldPublicId(fieldPublicId);
        return field;
    }

    @Override
    public Page<FieldEntity> findAllByLevelPublicIdPageable(String levelPublicId, Pageable pageable) {
        Page<FieldEntity> fieldPages = fieldRepository
                .findByFieldApiIsNotNullAndFieldApi_LevelPublicId(levelPublicId, pageable);
        return fieldPages;
    }

    @Override
    public Page<FieldEntity> findAllByEduCategoryPublicIdPageable(String eduCategoryPublicId, Pageable pageable) {
        Page<FieldEntity> fieldPages = fieldRepository
                .findByFieldApiIsNotNullAndFieldApi_EduCategoryPublicId(eduCategoryPublicId, pageable);
        return fieldPages;
    }

    @Override
    public List<FieldEntity> findAllFieldOnlyByIdBetween(Long startId, Long endId) {
        List<FieldOnly> allFieldOnlys = fieldRepository.findAllFieldOnlyByIdBetween(startId, endId);
        List<FieldEntity> allFields = fieldOnlyMapper
                .toFieldEntities(allFieldOnlys, new CycleAvoidingMappingContext());
        return allFields;
    }

    @Override
    public List<FieldEntity> selectAllFieldOnly() {
        List<FieldOnly> fieldOnlys = fieldRepository.findAllFieldOnly();
        fieldOnlys.sort(Comparator.comparing(FieldOnly::getId));
        List<FieldEntity> allFields = fieldOnlyMapper
                .toFieldEntities(fieldOnlys, new CycleAvoidingMappingContext());
        return allFields;
    }

    @Override
    public FieldEntity findFirstByIdLessThanOrderByIdDesc(Long fieldId) {
        FieldEntity field = fieldRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(fieldId);
        return field;
    }

    @Override
    public Long selectFieldLastSequenceNumber() {
        return fieldRepository.selectLastSequenceNumber();
    }
}
