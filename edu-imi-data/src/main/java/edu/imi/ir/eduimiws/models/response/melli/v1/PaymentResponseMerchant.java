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

@Schema(name = "melliPayments",description = "Melli Payment Response Merchant")
@JsonRootName(value = "paymentResponseMerchant")
@Relation(collectionRelation = "paymentResponseMerchant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseMerchant implements Serializable {


    @Schema(title = "Public Id",
            description = "Public Id")
    @JsonProperty("PublicId")
    private String publicId;

    @Schema(title = "Response Code",
            description = "Transaction Result")
    @JsonProperty("ResCode")
    private Long resCode;

    @Schema(title = "Token",
            description = "Token")
    @JsonProperty("Token")
    private String token;

    @Schema(title = "Description",
            description = "Transaction Description Result")
    @JsonProperty("Description")
    private String description;
}
