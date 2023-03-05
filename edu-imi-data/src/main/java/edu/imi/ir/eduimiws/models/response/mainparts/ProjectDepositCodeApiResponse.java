package edu.imi.ir.eduimiws.models.response.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Tag(name = "projectDepositCodeApi")
@Schema(name = "projectDepositCodeApiResponse", description = "Class representing Project Deposit Code Api in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "projectDepositCodeApi")
@Relation(collectionRelation = "projectDepositCodeApis")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiResponse extends RepresentationModel<ProjectDepositCodeApiResponse> {

    @Schema(title = "Project Deposit Code Api Public Id", maxLength = 36)
    private String publicId;

    @Schema(title = "Deposit Code", maxLength = 30)
    private String depositCode;

    @Schema(title = "Project Public Id", maxLength = 36)
    private String projectPublicId;

    @Schema(title = "Project Code", maxLength = 30)
    private String projectCode;

    @Schema(title = "Project Name", maxLength = 500)
    private String projectName;

    @Schema(title = "Creator Public Id", maxLength = 36)
    private String creatorPublicId;

    @Schema(title = "Creator Full Name", maxLength = 500)
    private String creatorFullName;

    @Schema(title = "Create Date", maxLength = 30)
    private String createDateTs;

    @Schema(title = "Editor Public Id", maxLength = 36)
    private String editorPublicId;

    @Schema(title = "Editor Full Name", maxLength = 500)
    private String editorFullName;

    @Schema(title = "Edit Date", maxLength = 30)
    private Timestamp editDateTs;

    @Schema(title = "Delete Date", maxLength = 30)
    private Timestamp deleteDateTs;

    @Schema(title = "Project Deposit Code Api Description", maxLength = 500)
    private String description;
}
