package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.aop.annotation.PerformanceLogger;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.EduCategoryDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.EduCategoryProjectionEduCategoryDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.projections.edu.EduCategoryProjection;
import edu.imi.ir.eduimiws.repositories.edu.EduCategoryRepository;
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
public class EduCategoryServiceImpl implements EduCategoryService{

    private final EduCategoryRepository eduCategoryRepository;
    private final EduCategoryDtoMapper eduCategoryDtoMapper;
    private final EduCategoryProjectionEduCategoryDtoMapper eduCategoryProjectionEduCategoryDtoMapper;


    @Override
    public Long countEduCategoryByIdLessThanEqual(Long eduCategoryId) {
        log.info("EduCategoryService.countEduCategoryByIdLessThanEqual - eduCategoryId: {}", eduCategoryId);
        Long result = eduCategoryRepository.countByIdLessThanEqual(eduCategoryId);
        log.info("EduCategoryService.countEduCategoryByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public EduCategoryEntity selectLastRecord() {
        log.info("EduCategoryService.selectLastRecord - start");
        EduCategoryEntity result = eduCategoryRepository.findFirstByOrderByIdDesc();
        log.info("EduCategoryService.selectLastRecord - result: {}", result);
        return result;
    }

    @PerformanceLogger
    @Override
    public Page<EduCategoryEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("EduCategoryService.findAllByOrderPageable - pageable: {}", pageable);
        Page<EduCategoryEntity> result = eduCategoryRepository
                .findAll(pageable);
        log.info("EduCategoryService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public EduCategoryEntity findByEduCategoryPublicId(String eduCategoryPublicId) {
        log.info("EduCategoryService.findByEduCategoryPublicId - eduCategoryPublicId: {}", eduCategoryPublicId);
        EduCategoryEntity result = eduCategoryRepository
                .findByEduCategoryApi_EduCategoryPublicId(eduCategoryPublicId);
        log.info("EduCategoryService.findByEduCategoryPublicId - result: {}", result);
        return result;
    }

    @Override
    public List<EduCategoryEntity> findAllEduCategoryProjectionByIdBetween(Long startId, Long endId) {
        log.info("EduCategoryService.findAllEduCategoryProjectionByIdBetween - startId: {}, endId: {}", startId, endId);
        List<EduCategoryProjection> allEduCategoryProjections = eduCategoryRepository
                .findAllByIdBetween(startId, endId);
        List<EduCategoryDto> eduCategoryDtos = eduCategoryProjectionEduCategoryDtoMapper
                .toEduCategoryDtos(allEduCategoryProjections, new CycleAvoidingMappingContext());
        List<EduCategoryEntity> result = eduCategoryDtoMapper
                .toEduCategoryEntities(eduCategoryDtos, new CycleAvoidingMappingContext());
        log.info("EduCategoryService.findAllEduCategoryProjectionByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<EduCategoryEntity> selectAllEduCategoryProjection() {
        log.info("EduCategoryService.selectAllEduCategoryProjection - start");
        List<EduCategoryProjection> eduCategoryProjections = eduCategoryRepository
                .findBy();
        eduCategoryProjections.sort(Comparator.comparing(EduCategoryProjection::getId));
        List<EduCategoryDto> eduCategoryDtos = eduCategoryProjectionEduCategoryDtoMapper
                .toEduCategoryDtos(eduCategoryProjections, new CycleAvoidingMappingContext());
        List<EduCategoryEntity> result = eduCategoryDtoMapper
                .toEduCategoryEntities(eduCategoryDtos, new CycleAvoidingMappingContext());
        log.info("EduCategoryService.selectAllEduCategoryProjection - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<EduCategoryEntity> findAllByEduCategoryTitle(String eduCategoryTitle) {
        log.info("EduCategoryService.findAllByEduCategoryTitle - eduCategoryTitle: {}", eduCategoryTitle);
        List<EduCategoryEntity> result = eduCategoryRepository
                .findAllByTitleContains(eduCategoryTitle);
        log.info("EduCategoryService.findAllByEduCategoryTitle - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public EduCategoryEntity findFirstByIdLessThanOrderByIdDesc(Long eduCategoryId) {
        log.info("EduCategoryService.findFirstByIdLessThanOrderByIdDesc - eduCategoryId: {}", eduCategoryId);
        EduCategoryEntity result = eduCategoryRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(eduCategoryId);
        log.info("EduCategoryService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectEduCategoryLastSequenceNumber() {
        log.info("EduCategoryService.selectEduCategoryLastSequenceNumber - start");
        Long result = eduCategoryRepository.selectLastSequenceNumber();
        log.info("EduCategoryService.selectEduCategoryLastSequenceNumber - result: {}", result);
        return result;
    }
}
