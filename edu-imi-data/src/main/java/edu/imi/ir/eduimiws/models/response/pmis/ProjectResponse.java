package edu.imi.ir.eduimiws.models.response.pmis;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectTypeDto;
import edu.imi.ir.eduimiws.models.response.crm.UserContactResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "projects", description = "Class representing a project in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "project")
@Relation(collectionRelation = "projects")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse extends RepresentationModel<ProjectResponse> {

    @Schema(title = "Project Public Id", maxLength = 36)
    private String projectPublicId;

    @Schema(title = "Last Version", maxLength =1 )
    private String lastVersion;

    @Schema(title = "Previous Version Public Id", maxLength =36 )
    private String previousVersionPublicId;

    @Schema(title = "Version Number", type = "number")
    private Long versionNumber;

    @Schema(title = "Project Name", maxLength =500 )
    private String projectName;

    @Schema(title = "Project Code", maxLength =30 )
    private String projectCode;

    @Schema(title = "Start Date", maxLength =10 )
    private String startDate;

    @Schema(title = "End Date", maxLength =10 )
    private String endDate;

    @Schema(title = "Project Budget", type="number" )
    private Long projectBudget;

    @Schema(title = "Weight Percent", type="number")
    private Long weightPercent;

    @Schema(title = "Description", maxLength = 400)
    private String description;

    @Schema(title = "Improve Percent", type="number" )
    private Long improvePercent;

    @Schema(title = "Project Operation Type", maxLength = 10)
    private String projectOperationType;

    @Schema(title = "Account Public Id", maxLength = 36)
    private String accountPublicId;

    @Schema(title = "Create Date", maxLength =10 )
    private String createDate;

    @Schema(title = "Creator Public Id", maxLength =36 )
    private String creatorPublicId;

    @Schema(title = "Operation Plan public Id", maxLength =36 )
    private String operationalPlanPublicId;

    @Schema(title = "Report Pattern Number", type = "number")
    private Long reportPatternNumber;

    @Schema(title = "Report Pattern Unit", maxLength =20 )
    private String reportPatternUnit;

    @Schema(title = "Affect Efficiency", maxLength =1 )
    private Character affectEfficiency;

    @Schema(title = "Status for Timesheet", maxLength =1 )
    private Character statusForTimeshit;

    @Schema(title = "Project Status Id", type = "number")
    private Long projectStatusId;

    @Schema(title = "Project Type Public Id", maxLength =36 )
    private String projectTypePublicId;

    @Schema(title = "mother Project Public Id", maxLength =36 )
    private String motherProjectPublicId;

    @Schema(title = "Sale Present Amount", type = "number")
    private Long salePresentAmount;

    @Schema(title = "Sale Present", maxLength =1 )
    private Character salePresent;

    @Schema(title = "Benefit", maxLength =1 )
    private Character benefit;

    @Schema(title = "Benefit Amount", type = "number")
    private Long benefitAmount;

    @Schema(title = "Present Benefit Description", maxLength =200 )
    private String presentBenefitDescription;

    @Schema(title = "Budget Coefficient", type = "number")
    private Long budgetCofficient;

    @Schema(title = "Start Date Plan", maxLength =10 )
    private String startDatePlan;

    @Schema(title = "End date Plan", maxLength =10 )
    private String endDatePlan;

    @Schema(title = "Offer Public Id", maxLength = 36)
    private String offerPublicId;

    @Schema(title = "Project Request Public Id", maxLength =36 )
    private String projectRequestPublicId;

    @Schema(title = "Income Indicator", type = "number")
    private Long incomeIndicator;

    @Schema(title = "Organization Cost Code", type="number")
    private Long orgCostCodeId;

    @Schema(title = "Manager Public Id", maxLength =36 )
    private String managerPublicId;

    @Schema(title = "Executor Public Id", maxLength =36 )
    private String executerPublicId;

    @Schema(title = "Task Schedule Confirmed", maxLength =1 )
    private String taskScheduleConfirmed;

    @Schema(title = "Plan Improvement Percent", type = "number")
    private Long planImprovementPercent;

    @Schema(title = "Suspend Reason Id", type = "number")
    private Long suspendReasonId;

    @Schema(title = "File Old Name", maxLength =50 )
    private String fileOldName;

    @Schema(title = "Lesson Learn", maxLength =4000 )
    private String lessonLearn;

    @Schema(title = "file New Name", maxLength =20 )
    private String fileNewName;

    @Schema(title = "Stage Id", type = "number")
    private Long stageId;

    @Schema(title = "Main Contract Public Id", maxLength = 36)
    private String mainContractPublicId;

    @Schema(title = "Supervisor Id", type = "number")
    private Long supervisorId;

    @Schema(title = "", type = "number")
    private Long coordinateX;

    @Schema(title = "Coordinate Y", type = "number")
    private Long coordinateY;

    @Schema(title = "Coordinate Lang", type = "number")
    private Long coordinateLang;

    @Schema(title = "Coordinate Lat", maxLength =20 )
    private String coordinateLat;

    @Schema(title = "Project Additional Info Public Id", maxLength = 36)
    private String projectAdditionalInfoId;
}
