package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "periodWithPeriodApiFieldLevelEduCategoryProjection",
        types = { PeriodEntity.class })
public interface PeriodWithPeriodApiFieldLevelEduCategoryProjection {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.field?.fieldApi?.fieldPublicId}")
    String getFieldPublicId();

    @Value("#{target.field?.fname}")
    String getFname();

    @Value("#{target.field?.fieldApi?.eduCategoryPublicId}")
    String getEduCategoryPublicId();

    @Value("#{target.field?.eduCategory?.title}")
    String getEduCategoryTitle();

    @Value("#{target.field?.fieldApi?.levelPublicId}")
    String getLevelPublicId();

    @Value("#{target.field?.level?.description}")
    String getLevelDescription();

}
