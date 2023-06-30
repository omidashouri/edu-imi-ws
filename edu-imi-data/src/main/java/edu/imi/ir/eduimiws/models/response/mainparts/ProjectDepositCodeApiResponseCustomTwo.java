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
@Schema(name = "projectDepositCodeApiResponseCustomTwo", description = "Class representing Project Deposit Code Api in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "ProjectDepositCodeApiResponseCustomTwo")
@Relation(collectionRelation = "projectDepositCodeApis")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiResponseCustomTwo extends RepresentationModel<ProjectDepositCodeApiResponseCustomTwo> {

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

    @Schema(title = "Creator Full Name", maxLength = 500)
    private String creatorFullName;

    @Schema(title = "Editor Full Name", maxLength = 500)
    private String editorFullName;

}
