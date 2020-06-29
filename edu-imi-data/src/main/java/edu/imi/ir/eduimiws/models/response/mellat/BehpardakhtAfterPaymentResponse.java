package edu.imi.ir.eduimiws.models.response.mellat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "behpardakhts",description = "Class representing a behpardakht after payment response in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "behpardakht")
@Relation(collectionRelation = "behpardakhts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BehpardakhtAfterPaymentResponse {

    @Schema(title = "Reference ID",
            description = "reference id which send with bpPayRequest")
    private String refId;

    @Schema(title = "Response Code",
    description = "buy status according to table eleven")
    private String resCode;

    @Schema(title = "Sale Order Id",
    description = "sale order request number")
    private Long saleOrderId;

    @Schema(title = "Sale Reference Id",
    description = "reference code which is generate by bank")
    private Long saleReferenceId;

    @Schema(title = "Card Holder PAN",
    description = "response code in buying iranian goods")
    private String cardHolderPAN;

    @Schema(title = "Credit Card Sale Response Detail",
    description = "final amount reduced from card in one line discount plan")
    private String creditCardSaleResponseDetail;

    @Schema(title = "Final Amount")
    private Long finalAmount;
}
