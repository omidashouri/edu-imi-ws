package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.domain.crm.ParameterApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ParameterEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Schema(name = "parameters", description = "Class representing a parameter in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "parameter")
@Relation(collectionRelation = "parameters")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParameterResponse extends RepresentationModel<ParameterResponse> {

    @Schema(title = "parameter Public Id", maxLength = 36)
    private String parameterPublicId;

    @Schema(title = "PARAM_NAME", maxLength =130)
    private String paramName;

    @Schema(title = "PARAM_VALUE", maxLength =300)
    private String paramValue;

    @Schema(title = "MAIN PARAM Public ID", maxLength =36)
    private String mainParamPublicId;

}
