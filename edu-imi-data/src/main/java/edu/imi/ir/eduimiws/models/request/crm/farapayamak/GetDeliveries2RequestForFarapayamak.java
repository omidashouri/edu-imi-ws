package edu.imi.ir.eduimiws.models.request.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Tag(name = "farapayamaks")
@Schema(name = "GetDeliveries2RequestForFarapayamak", description = "Class representing get deliveries2 for farapayamak in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "getDeliveries2RequestForFarapayamak")
@Relation(collectionRelation = "getDeliveries2RequestForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDeliveries2RequestForFarapayamak extends RepresentationModel<GetDeliveries2RequestForFarapayamak> {

    @Schema(title = "recID", required = true)
    @JsonProperty("recID")
    private Long recID;
}