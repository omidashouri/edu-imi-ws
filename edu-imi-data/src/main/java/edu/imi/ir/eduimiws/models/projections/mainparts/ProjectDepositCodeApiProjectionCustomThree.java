package edu.imi.ir.eduimiws.models.projections.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(name = "projectDepositCodeApiProjectionCustomThree",
        types = {ProjectDepositCodeApiEntity.class})
public interface ProjectDepositCodeApiProjectionCustomThree {

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

    String getProjectCreateDate();

    Long getProjectStatusId();

    String getProjectTypeName();

    String getStartDatePlan();

    String getEndDatePlan();

    String getLastVersion();

   // @Column(nullable = false)
    Character getStatusForTimeshit();

    String getCreatorFullName();

    String getEditorFullName();

    String getExecutor();

    String getProjectPublicId();

}
