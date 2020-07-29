package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fieldWithFieldApiLevelEduCategoryProjection",
        types = { FieldEntity.class })
public interface FieldWithFieldApiLevelEduCategoryProjection {

    @Value("#{target.id}")
    Long getId();
    
    @Value("#{target.fieldApi?.fieldPublicId}")
    String getFieldPublicId();
    
    String getFname();
    
    @Value("#{target.fieldApi?.eduCategoryPublicId}")
    String getEduCategoryPublicId();

    @Value("#{target.eduCategory?.title}")
    String getEduCategoryTitle();

    @Value("#{target.fieldApi?.levelPublicId}")
    String getLevelPublicId();
    
    @Value("#{target.level?.description}")
    String getLevelDescription();
    
}
