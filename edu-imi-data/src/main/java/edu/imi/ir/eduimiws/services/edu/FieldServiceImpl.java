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
        log.info("FieldService.countFieldByIdLessThanEqual - fieldId: {}", fieldId);
        Long result = fieldRepository.countByIdLessThanEqual(fieldId);
        log.info("FieldService.countFieldByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public FieldEntity selectLastRecord() {
        log.info("FieldService.selectLastRecord - start");
        FieldEntity result = fieldRepository.findFirstByOrderByIdDesc();
        log.info("FieldService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Page<FieldEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("FieldService.findAllByOrderPageable - pageable: {}", pageable);
        Page<FieldEntity> result = fieldRepository
                .findAll(pageable);
        log.info("FieldService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public FieldEntity findByFieldPublicId(String fieldPublicId) {
        log.info("FieldService.findByFieldPublicId - fieldPublicId: {}", fieldPublicId);
        FieldEntity result = fieldRepository
                .findByFieldApi_FieldPublicId(fieldPublicId);
        log.info("FieldService.findByFieldPublicId - result: {}", result);
        return result;
    }

    @Override
    public Page<FieldEntity> findAllByLevelPublicIdPageable(String levelPublicId, Pageable pageable) {
        log.info("FieldService.findAllByLevelPublicIdPageable - levelPublicId: {}, pageable: {}", levelPublicId, pageable);
        Page<FieldEntity> result = fieldRepository
                .findByFieldApiIsNotNullAndFieldApi_LevelPublicId(levelPublicId, pageable);
        log.info("FieldService.findAllByLevelPublicIdPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<FieldEntity> findAllByEduCategoryPublicIdPageable(String eduCategoryPublicId, Pageable pageable) {
        log.info("FieldService.findAllByEduCategoryPublicIdPageable - eduCategoryPublicId: {}, pageable: {}", eduCategoryPublicId, pageable);
        Page<FieldEntity> result = fieldRepository
                .findByFieldApiIsNotNullAndFieldApi_EduCategoryPublicId(eduCategoryPublicId, pageable);
        log.info("FieldService.findAllByEduCategoryPublicIdPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public List<FieldEntity> findAllFieldOnlyByIdBetween(Long startId, Long endId) {
        log.info("FieldService.findAllFieldOnlyByIdBetween - startId: {}, endId: {}", startId, endId);
        List<FieldOnly> allFieldOnlys = fieldRepository.findAllFieldOnlyByIdBetween(startId, endId);
        List<FieldEntity> result = fieldOnlyMapper
                .toFieldEntities(allFieldOnlys, new CycleAvoidingMappingContext());
        log.info("FieldService.findAllFieldOnlyByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<FieldEntity> selectAllFieldOnly() {
        log.info("FieldService.selectAllFieldOnly - start");
        List<FieldOnly> fieldOnlys = fieldRepository.findAllFieldOnly();
        fieldOnlys.sort(Comparator.comparing(FieldOnly::getId));
        List<FieldEntity> result = fieldOnlyMapper
                .toFieldEntities(fieldOnlys, new CycleAvoidingMappingContext());
        log.info("FieldService.selectAllFieldOnly - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public FieldEntity findFirstByIdLessThanOrderByIdDesc(Long fieldId) {
        log.info("FieldService.findFirstByIdLessThanOrderByIdDesc - fieldId: {}", fieldId);
        FieldEntity result = fieldRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(fieldId);
        log.info("FieldService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectFieldLastSequenceNumber() {
        log.info("FieldService.selectFieldLastSequenceNumber - start");
        Long result = fieldRepository.selectLastSequenceNumber();
        log.info("FieldService.selectFieldLastSequenceNumber - result: {}", result);
        return result;
    }
}
