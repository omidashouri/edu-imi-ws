package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;

import java.util.List;

public interface EduCategoryApiService {

    EduCategoryApiEntity selectLastRecord();

    Long eduCategoryApiCount();

    List<EduCategoryApiEntity> generateEduCategoryApiPublicId(List<EduCategoryEntity> newEduCategoryEntities);

    List<EduCategoryApiEntity> findAllByEduCategoryIdIn(List<Long> eduCategoryIds);
}
