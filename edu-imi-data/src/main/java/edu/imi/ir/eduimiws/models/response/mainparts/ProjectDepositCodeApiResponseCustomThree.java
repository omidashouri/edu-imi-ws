package edu.imi.ir.eduimiws.models.response.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Column;
import java.sql.Timestamp;


@Tag(name = "projectDepositCodeApi")
@Schema(name = "projectDepositCodeApiResponseCustomThree", description = "Class representing Project Deposit Code Api in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "ProjectDepositCodeApiResponseCustomThree")
@Relation(collectionRelation = "ProjectDepositCodeApiResponseCustomThree")
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude(JsonInclude.Include.ALWAYS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiResponseCustomThree extends RepresentationModel<ProjectDepositCodeApiResponseCustomTwo> {

    @Schema(title = "Project Deposit Code Api Public Id", maxLength = 36)
    private String publicId;

    @Schema(title = "Deposit Code", maxLength = 30)
    private String depositCode;

    @Schema(title = "Project Deposit Code Api Description", maxLength = 500)
    private String description;

    @Schema(title = "Create Date", maxLength = 30)
    private Timestamp createDateTs;

    @Schema(title = "Edit Date", maxLength = 30)
    private Timestamp editDateTs;

    @Schema(title = "Delete Date", maxLength = 30)
    private Timestamp deleteDateTs;

    @Schema(title = "Project Name", maxLength = 500)
    private String projectName;

    @Schema(title = "Project Code", maxLength = 30)
    private String projectCode;

    @Schema(title = "Create Date", maxLength =10 )
    private String projectCreateDate;

    @Schema(title = "Project Status Id", type = "number")
    private Long projectStatusId;

    @Schema(title = "Project Type Name", maxLength =500 )
    private String projectTypeName;

    @Schema(title = "Start Date Plan", maxLength =10 )
    private String startDatePlan;

    @Schema(title = "End date Plan", maxLength =10 )
    private String endDatePlan;

    @Schema(title = "Last Version", maxLength =1 )
    private String lastVersion;

    @Schema(title = "Status for Timesheet", maxLength =1 )
    private Character statusForTimeshit;

    @Schema(title = "Creator Full Name", maxLength = 500)
    private String creatorFullName;

    @Schema(title = "Editor Full Name", maxLength = 500)
    private String editorFullName;

    @Schema(title = "Executor", maxLength = 500)
    private String executor;

    @Column(name = "PROJECT_PUBLIC_ID", length = 500)
    private  String projectPublicId;
}
