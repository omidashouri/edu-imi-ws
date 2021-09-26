package edu.imi.ir.eduimiws.models.response.melli.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "melli",description = "melli purchase Result")
@JsonRootName(value = "purchaseResult")
@Relation(collectionRelation = "purchaseResult")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResult implements Serializable {

    @Schema(title = "Order Id",
            description = "Order Id")
    @JsonProperty("OrderId")
    public String orderId;

    @Schema(title = "Token",
            description = "Token")
    @JsonProperty("Token")
    public String token;

    @Schema(title = "ResCode",
            description = "Response Code")
    @JsonProperty("ResCode")
    public String resCode;

    @Schema(title = "Verify Result Data",
            description = "Verify Result Data")
    @JsonProperty("VerifyResultDataBank")
    public VerifyResultDataBank verifyResultDataBank;
}
