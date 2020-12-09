package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.aop.annotation.PerformanceLogger;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EduCategoryService {

    Long countEduCategoryByIdLessThanEqual(Long eduCategoryId);

    EduCategoryEntity selectLastRecord();

    @PerformanceLogger
    Page<EduCategoryEntity> findAllByOrderPageable(Pageable pageable);

    EduCategoryEntity findByEduCategoryPublicId(String eduCategoryPublicId);

    List<EduCategoryEntity> findAllEduCategoryProjectionByIdBetween(Long startId, Long endId);

    List<EduCategoryEntity> selectAllEduCategoryProjection();

    List<EduCategoryEntity> findAllByEduCategoryTitle(String title);

    EduCategoryEntity findFirstByIdLessThanOrderByIdDesc(Long eduCategoryId);

    Long selectEduCategoryLastSequenceNumber();
}
