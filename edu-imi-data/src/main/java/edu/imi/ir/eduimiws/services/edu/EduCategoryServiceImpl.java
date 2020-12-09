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
        Long eduCategoryCount = eduCategoryRepository.countByIdLessThanEqual(eduCategoryId);
        return eduCategoryCount;
    }

    @Override
    public EduCategoryEntity selectLastRecord() {
        return eduCategoryRepository.findFirstByOrderByIdDesc();
    }

    @PerformanceLogger
    @Override
    public Page<EduCategoryEntity> findAllByOrderPageable(Pageable pageable) {
        Page<EduCategoryEntity> eduCategoryPages = eduCategoryRepository
                .findAll(pageable);
        return eduCategoryPages;
    }

    @Override
    public EduCategoryEntity findByEduCategoryPublicId(String eduCategoryPublicId) {
        EduCategoryEntity eduCategory = eduCategoryRepository
                .findByEduCategoryApi_EduCategoryPublicId(eduCategoryPublicId);
        return eduCategory;
    }

    @Override
    public List<EduCategoryEntity> findAllEduCategoryProjectionByIdBetween(Long startId, Long endId) {
        List<EduCategoryProjection> allEduCategoryProjections = eduCategoryRepository
                .findAllByIdBetween(startId, endId);
        List<EduCategoryDto> eduCategoryDtos = eduCategoryProjectionEduCategoryDtoMapper
                .toEduCategoryDtos(allEduCategoryProjections, new CycleAvoidingMappingContext());
        List<EduCategoryEntity> allEduCategorys = eduCategoryDtoMapper
                .toEduCategoryEntities(eduCategoryDtos, new CycleAvoidingMappingContext());
        return allEduCategorys;
    }

    @Override
    public List<EduCategoryEntity> selectAllEduCategoryProjection() {
        List<EduCategoryProjection> eduCategoryProjections = eduCategoryRepository
                .findBy();
        eduCategoryProjections.sort(Comparator.comparing(EduCategoryProjection::getId));
        List<EduCategoryDto> eduCategoryDtos = eduCategoryProjectionEduCategoryDtoMapper
                .toEduCategoryDtos(eduCategoryProjections, new CycleAvoidingMappingContext());
        List<EduCategoryEntity> allEduCategorys = eduCategoryDtoMapper
                .toEduCategoryEntities(eduCategoryDtos, new CycleAvoidingMappingContext());
        return allEduCategorys;
    }

    @Override
    public List<EduCategoryEntity> findAllByEduCategoryTitle(String eduCategoryTitle) {
        List<EduCategoryEntity> eduCategories = eduCategoryRepository
                .findAllByTitleContains(eduCategoryTitle);
        return eduCategories;
    }

    @Override
    public EduCategoryEntity findFirstByIdLessThanOrderByIdDesc(Long eduCategoryId) {
        EduCategoryEntity eduCategory = eduCategoryRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(eduCategoryId);
        return eduCategory;
    }

    @Override
    public Long selectEduCategoryLastSequenceNumber() {
        return eduCategoryRepository.selectLastSequenceNumber();
    }
}
