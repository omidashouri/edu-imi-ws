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

@Schema(name = "melli",description = "melli payment data response bank")
@JsonRootName(value = "paymentRequestDataResponse")
@Relation(collectionRelation = "paymentRequestDataResponse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDataResponseBank implements Serializable {

    @Schema(title = "Order Id",
            description = "Order Id")
    @JsonProperty("OrderId")
    private String orderId;

    @Schema(title = "Hashed Card Number",
            description = "Hashed Card Number")
    @JsonProperty("HashedCardNumber")
    private String hashedCardNumber;

    @Schema(title = "Primary Acc No",
            description = "Primary Acc No")
    @JsonProperty("PrimaryAccNo")
    private String primaryAccNo;

    @Schema(title = "Switch Res Code",
            description = "Switch Res Code")
    @JsonProperty("SwitchResCode")
    private String switchResCode;

    @Schema(title = "Res Code",
            description = "Res Code")
    @JsonProperty("ResCode")
    private String resCode;

    @Schema(title = "Token",
            description = "Token")
    @JsonProperty("Token")
    private String token;

    @Schema(title = "Request Verification Token",
            description = "Request Verification Token")
    @JsonProperty("__RequestVerificationToken")
    private String requestVerificationToken;

    @Schema(title = "Is Wallet Payment",
            description = "Is Wallet Payment")
    @JsonProperty("IsWalletPayment")
    private String isWalletPayment;

}
