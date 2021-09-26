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


@Schema(name = "MelliPayments", description = "Melli Payment Request Merchant")
@JsonRootName(value = "paymentRequestMerchant")
@Relation(collectionRelation = "paymentRequestMerchants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestMerchant implements Serializable {


    @Schema(title = "amount", required = true,
            description = "Transaction Amount")
    @JsonProperty("Amount")
    private Long amount;

    @Schema(title = "Order Id", required = true,
            description = "Order Number")
    @JsonProperty("OrderId")
    private Long merchantOrderId;

    @Schema(title = "amount", required = true,
            description = "Transaction Date and Time", example = "2021-09-21T09:25:24.0000858+04:30")
    @JsonProperty("LocalDateTime")
    private String localDateTime;

    @Schema(title = "Return URL", required = true, example = " ",
            description = "return url")
    @JsonProperty("ReturnUrl")
    private String returnUrl;

    @Schema(title = "Additional data", example = " ",
            description = "additional transaction information")
    @JsonProperty("AdditionalData")
    private String additionalData;

    @Schema(title = "Multiplexing data",
            description = "Division Information")
    @JsonProperty("MultiplexingData")
    private MultiplexingData multiplexingData;

    @Schema(title = "User Id",
            description = "Card Holder Mobile Number")
    @JsonProperty("UserId")
    private Long userId;

    @Schema(title = "Application Name", example = " ",
            description = "Requested Application Name")
    @JsonProperty(value = "ApplicationName")
    private String applicationName;

    @Schema(title = "Pan authentication Type",
            description = "authentication type")
    @JsonProperty("PanAuthenticationType")
    private Long panAuthenticationType;


    @Schema(title = "National Code", example = " ",
            description = "card owner national code", defaultValue = "")
    @JsonProperty("NationalCode")
    private String nationalCode;

    @Schema(title = "Card Holder Identity", example = " ",
            description = "card owner mobile number")
    @JsonProperty("CardHolderIdentity")
    private String cardHolderIdentity;

}
