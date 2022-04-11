package edu.imi.ir.eduimiws.models.response.pmis;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "projectResponseForPaymentCode", description = "Class representing a project for payment code in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "projectResponseForPaymentCode")
@Relation(collectionRelation = "projectResponseForPaymentCode")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponseForPaymentCode extends RepresentationModel<ProjectResponseForPaymentCode> {

    @Schema(title = "Project Public Id", maxLength = 36)
    private String projectPublicId;

    @Schema(title = "Project Code", maxLength =30 )
    private String projectCode;

    @Schema(title = "Project Name", maxLength =500 )
    private String projectName;


}
