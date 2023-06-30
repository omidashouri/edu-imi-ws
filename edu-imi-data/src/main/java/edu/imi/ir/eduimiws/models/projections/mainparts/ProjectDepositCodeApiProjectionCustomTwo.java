package edu.imi.ir.eduimiws.models.projections.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "projectDepositCodeApiCustomTwo",
types = {ProjectDepositCodeApiEntity.class})
public interface ProjectDepositCodeApiProjectionCustomTwo {

    @Value("#{target.publicId}")
    String getPublicId();

    @Value("#{target.depositCode}")
    String getDepositCode();

    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.createDateTs}")
    Timestamp getCreateDateTs();

    @Value("#{target.editDateTs}")
    Timestamp getEditDateTs();

    @Value("#{target.deleteDateTs}")
    Timestamp getDeleteDateTs();

    String getProjectName();

    String getProjectCode();

    String getCreatorFullName();

    String getEditorFullName();

}
