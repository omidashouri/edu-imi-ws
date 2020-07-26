package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "eduCategoryProjection",
        types = { EduCategoryEntity.class })
public interface EduCategoryProjection {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.eduCategoryApi?.eduCategoryPublicId}")
    String getEduCategoryPublicId();
}
