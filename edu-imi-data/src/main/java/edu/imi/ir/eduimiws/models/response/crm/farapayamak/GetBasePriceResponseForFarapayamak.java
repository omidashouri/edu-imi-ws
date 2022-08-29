package edu.imi.ir.eduimiws.models.response.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Tag(name = "farapayamaks")
@Schema(name = "getBasePriceResponseForFarapayamak", description = "Class representing a get price response from farapayamak in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "getBasePriceResponseForFarapayamak")
@Relation(collectionRelation = "getBasePriceResponseForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBasePriceResponseForFarapayamak extends RepresentationModel<GetBasePriceResponseForFarapayamak> {

    @Schema(title = "value")
    @JsonProperty("value")
    private String value;

    @Schema(title = "return_status", type = "number",
            description = "if request is successful return equal to 1")
    @JsonProperty("return_status")
    private Integer returnStatus;

    @Schema(title = "str_return_status", type = "string",
            description = "if request is successful return is 'OK' ")
    @JsonProperty("str_return_status")
    private String stringReturnStatus;


}
