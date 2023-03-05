package edu.imi.ir.eduimiws.models.request.mainparts;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@Tag(name = "projectDepositCodeApis")
@Schema(name = "ProjectDepositCodeApiRequest", description = "Class representing a Project Deposit code in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "projectDepositCodeApiRequest")
@Relation(collectionRelation = "projectDepositCodeApiRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiRequest {

    @Schema(title = "Project Deposit Code Public Id",
            description = "project public Id", maxLength =36,
            type = "string", example = " ")
    private String publicId;

    @Schema(title = "Project Public Id",
            description = "project public Id", maxLength =36,
            type = "string", example = " ")
    private String projectPublicId;

    @Schema(title = "Project Deposit Code",
            description = "depositCode", maxLength =30,
            type = "string", example = " ")
    private String depositCode;

    @Schema(title = "Project Deposit Code Description",
            description = "description", maxLength =500,
            type = "string", example = " ")
    private String description;

}
