package edu.imi.ir.eduimiws.models.request.melli.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "melli",description = "melli payment request")
@JsonRootName(value = "payResultData")
@Relation(collectionRelation = "payResultData")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayResultData implements Serializable {

    @Schema(title = "Merchant Id",
            description = "ResponseCode")
    @JsonProperty("ResCode")
    public String resCode;

    @Schema(title = "Token",
            description = "Token")
    @JsonProperty("Token")
    public String token;

    @Schema(title = "Description",
            description = "Description")
    @JsonProperty("Description")
    public String description;
}
