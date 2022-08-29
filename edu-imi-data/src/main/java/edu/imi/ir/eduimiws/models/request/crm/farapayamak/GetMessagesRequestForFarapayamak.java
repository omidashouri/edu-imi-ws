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
@Schema(name = "GetMessagesRequestForFarapayamak", description = "Class representing get messages from farapayamak in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "sendSmsRequestForFarapayamak")
@Relation(collectionRelation = "getMessagesRequestForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMessagesRequestForFarapayamak extends RepresentationModel<GetMessagesRequestForFarapayamak> {

    @Schema(title = "from", maxLength = 10, required = false)
    @JsonProperty("from")
    protected String from;
    @Schema(title = "location", maxLength = 100, required = true)
    @JsonProperty("location")
    private Integer location;
    @Schema(title = "index", required = true)
    @JsonProperty("index")
    private Integer index;

    @Schema(title = "count", required = true)
    @JsonProperty("count")
    private Integer count;
}
