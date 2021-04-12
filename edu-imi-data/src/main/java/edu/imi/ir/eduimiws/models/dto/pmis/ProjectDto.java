package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto implements Serializable {

    private static final long serialVersionUID = 3633026288364266840L;

    private Long id;
    private String publicId;

    private String lastVersion;

    private ProjectDto previousVersion;
    private Long previousVersionId;
    private String previousVersionPublicId;

    private Long versionNumber;

    private String projectName;

    private String projectCode;

    private String startDate;

    private String endDate;

    private Long projectBudget;

    private Long weightPercent;

    private String description;

    private Long improvePercent;

    private String projectOperationType;

    private Long accountId;

    private String createDate;

    private Long creator;

    private Long operationalPlanId;

    private Long reportPatternNumber;

    private String reportPatternUnit;

    private Character affectEfficiency;

    private Character statusForTimeshit;

    private Long projectStatusId;

    private ProjectTypeDto projectType;
    private Long projectTypeId;
    private String projectTypePublicId;

    private ProjectEntity motherProject;
    private Long motherProjectId;
    private String motherProjectPublicId;

    private Long salePresentAmount;

    private Character salePresent;

    private Character benefit;

    private Long benefitAmount;

    private String presentBenefitDescription;

    private Long budgetCofficient;

    private String startDatePlan;

    private String endDatePlan;

    private Long offerId;

    private Long requestId;

    private Long incomeIndicator;

    private Long orgCostCodeId;

    private PersonDto manager;
    private Long managerId;
    private String managerPublicId;

    private PersonDto executer;
    private Long executerId;
    private String executerPublicId;

    private String taskScheduleConfirmed;

    private Long planImprovementPercent;

    private Long suspendReasonId;

    private String fileOldName;

    private String lessonLearn;

    private String fileNewName;

    private Long stageId;

    private Long mainContractId;

    private Long supervisorId;

    private Long coordinateX;

    private Long coordinateY;

    private Long coordinateLang;

    private String coordinateLat;

    private Long projectAdditionalInfoId;


}
