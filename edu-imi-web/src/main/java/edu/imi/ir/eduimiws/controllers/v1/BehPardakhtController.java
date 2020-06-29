package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mellat.BehpardakhtAfterPaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/behpardakhts")
@RequiredArgsConstructor
@Tag(name = "behPardakhts", description = "The behpardakht API")
public class BehPardakhtController {


    @Operation(
            summary = "Behpardakht Response",
            description = "Behpardakht Response after Payment",
            tags = "behpardakhts"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = BehpardakhtAfterPaymentResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Not Acceptable",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
    @PostMapping(path = "/afterPaymentResponse",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> afterPaymentResponse(@ModelAttribute String refId,
                                                  @ModelAttribute String resCode,
                                                  @ModelAttribute String saleOrderId,
                                                  @ModelAttribute String saleReferenceId,
                                                  @ModelAttribute String cardHolderPAN,
                                                  @ModelAttribute
                                                    String creditCardSaleResponseDetail,
                                                  @ModelAttribute String finalAmount) {

        BehpardakhtAfterPaymentResponse behpardakhtAfterPaymentResponse = new BehpardakhtAfterPaymentResponse();

        if (refId != null && refId!="") {
            behpardakhtAfterPaymentResponse.setRefId(refId);
        }
        if (resCode != null && resCode!="") {
            behpardakhtAfterPaymentResponse.setResCode(resCode);
        }
        if (saleOrderId != null && saleOrderId!="") {
            behpardakhtAfterPaymentResponse.setSaleOrderId(Long.valueOf(saleOrderId));
        }
        if (saleReferenceId != null&& saleReferenceId!="") {
            behpardakhtAfterPaymentResponse.setSaleReferenceId(Long.valueOf(saleReferenceId));
        }
/*        if (cardHolderPAN != null) {
            behpardakhtAfterPaymentResponse.setCardHolderPAN(cardHolderPAN);
        }
        if (creditCardSaleResponseDetail != null) {
            behpardakhtAfterPaymentResponse.setCreditCardSaleResponseDetail(creditCardSaleResponseDetail);

        }
        if (finalAmount != null) {
            behpardakhtAfterPaymentResponse.setFinalAmount(Long.valueOf(finalAmount));
        }*/


        return ResponseEntity.ok(null);
    }

}
