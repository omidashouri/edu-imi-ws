package edu.imi.ir.eduimiws.models.projections.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projectDepositCodeApiProjection",
        types = {ProjectDepositCodeApiEntity.class})
public interface ProjectDepositCodeApiProjection {


    Long getProjectId();

    String getProjectPublicId();

    String getProjectName();

    String getProjectCode();

    String getProjectLastVersion();

}
