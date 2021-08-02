package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fieldProjectionCustomOne",
        types = { FieldEntity.class })
public interface FieldProjectionCustomOne {


    String getEduCategoryPublicId();

    String getLevelPublicId();

    String getEduCategoryName();

    String getLevelName();

    Long getFieldCount();
}
