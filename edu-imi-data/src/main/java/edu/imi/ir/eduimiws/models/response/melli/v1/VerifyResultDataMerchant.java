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

@Schema(name = "sadadPayments",description = "melli payment request")
@JsonRootName(value = "verifyResultDataMerchant")
@Relation(collectionRelation = "verifyResultDataMerchant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyResultDataMerchant implements Serializable {

    @Schema(title = "Public Id",
            description = "Public Id")
    @JsonProperty("PublicId")
    public String publicId;

    @Schema(title = "Payment Public Id",
            description = "Payment Public Id")
    @JsonProperty("PaymentPublicId")
    public String paymentPublicId;

    @Schema(title = "Succeed",
            description = "Succeed")
    @JsonProperty("Succeed")
    public Long succeed;

    @Schema(title = "Response Code",
            description = "Response Code")
    @JsonProperty("ResCode")
    public String resCode;

    @Schema(title = "Description",
            description = "Description")
    @JsonProperty("Description")
    public String description;

    @Schema(title = "Amount",
            description = "Amount")
    @JsonProperty("Amount")
    public String amount;

    @Schema(title = "Retrival Refrefrence No",
            description = "Retrival Reference NUmber")
    @JsonProperty("RetrivalRefNo")
    public String retrivalRefNo;

    @Schema(title = "System Trace Number",
            description = "System Trace Number")
    @JsonProperty("SystemTraceNo")
    public String systemTraceNo;

    @Schema(title = "Order Id",
            description = "Order Id")
    @JsonProperty("OrderId")
    public String orderId;

    @Schema(title = "Api Order Id",
            description = "Api Order Id")
    @JsonProperty("ApiOrderId")
    public String ApiOrderId;


}
