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
@Schema(name = "getDeliveries2ResponseForFarapayamak", description = "Class representing get deliveries2 response from farapayamak in the application")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "getDeliveries2ResponseForFarapayamak")
@Relation(collectionRelation = "getDeliveries2ResponseForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDeliveries2ResponseForFarapayamak extends RepresentationModel<GetDeliveries2ResponseForFarapayamak> {

  @Schema(title = "value", type = "string",
            description = "if status equal 0 it means submitted telecommunications" +
                    " if status equal 1 it means reached the phone" +
                    "if status equal 2 it means not reached the phone" +
                    "if status equal 3 it means telecommunication error" +
                    "if status equal 5 it means unspecified error" +
                    "if status equal 8 it means reached telecommunications" +
                    "if status equal 16 it means not reached telecommunications" +
                    "if status equal 35 it means black list" +
                    "if status equal 100 it means  unknown " +
                    "if status equal 200 it means Posted " +
                    "if status equal 300 it means  filtered" +
                    "if status equal 400 it means in the mailing list " +
                    "if status equal 500 it means  non-acceptance "
    )
    @JsonProperty("value")
    private String value;

    @Schema(title = "Return_Status", type = "number",
            description = "if request is successful return equal to 1")
    @JsonProperty("Return_Status")
    private Integer ReturnStatus;

    @Schema(title = "String_Return_Status", type = "string",
            description = "if request is successful return is 'OK'")
    @JsonProperty("String_Return_Status")
    private String StringReturnStatus;
}



