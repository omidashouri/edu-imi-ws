package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fieldProjection",
        types = { FieldEntity.class })
public interface FieldProjection {

    @Value("#{target.id}")
    Long getId();
    Long getEduCategoryId();
    Long getLevelId();
    Long getActivityStatus();
    String getEditDate();
}
