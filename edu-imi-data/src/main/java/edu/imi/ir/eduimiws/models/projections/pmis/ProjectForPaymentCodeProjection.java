package edu.imi.ir.eduimiws.models.projections.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projectForPaymentCodeProjection",
        types = { ProjectEntity.class })
public interface ProjectForPaymentCodeProjection {


    @Value("#{target.id}")
    Long getId();

    String getProjectPublicId();

    @Value("#{target.projectCode}")
    String getProjectCode();

    @Value("#{target.projectName}")
    String getProjectName();

    @Value("#{target.lastVersion}")
    String getLastVersion();

}
