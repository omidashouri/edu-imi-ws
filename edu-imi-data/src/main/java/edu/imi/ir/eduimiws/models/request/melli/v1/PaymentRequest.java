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
@JsonRootName(value = "paymentRequest")
@Relation(collectionRelation = "paymentRequests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest implements Serializable {

    @Schema(title = "Merchant Id", required = true,
            description = "Merchant Number(Shomare Pazirande)")
    @JsonProperty("MerchantId")
    private String merchantId;

    @Schema(title = "Terminal Id", required = true,
            description = "Terminal Number(Shomare terminal)")
    @JsonProperty("TerminalId")
    private String terminalId;

    @Schema(title = "amount", required = true,
            description = "Transaction Amount")
    @JsonProperty("Amount")
    private Long amount;

    @Schema(title = "Order Id", required = true,
            description = "Order Number")
    @JsonProperty("OrderId")
    private Long orderId;

    @Schema(title = "amount", required = true,
            description = "Transaction Date and Time")
    @JsonProperty("LocalDateTime")
    private String localDateTime;

    @Schema(title = "Return URL", required = true,
        description = "return url")
    @JsonProperty("ReturnUrl")
    private String returnUrl;


    @Schema(title = "Sign Date", required = true,
        description = "Encrypting Transaction through Merchant key")
    @JsonProperty("SignData")
    private String signDate;

    @Schema(title = "Additional data",
        description = "additional transaction information")
    @JsonProperty("AdditionalData")
    private String additionalDate;

    @Schema(title = "Multiplexing data",
            description = "Division Information")
    @JsonProperty("MultiplexingData")
    private MultiplexingData multiplexingData;

    @Schema(title = "User Id",
            description = "Card Holder Mobile Number")
    @JsonProperty("UserId")
    private Long userId;

    @Schema(title = "Application Name",
        description = "Requested Application Name")
    @JsonProperty("ApplicationName")
    private String applicationName;

    @Schema(title = "Pan authentication Type",
        description = "authentication type")
    @JsonProperty("PanAuthenticationType")
    private Long panAuthenticationType;


    @Schema(title = "National Code",
        description = "card owner national code")
    @JsonProperty("NationalCode")
    private String nationalCode;


    @Schema(title = "Card Holder Identity",
        description = "card owner mobile number")
    @JsonProperty("CardHolderIdentity")
    private String cardHolderIdentity;

}
