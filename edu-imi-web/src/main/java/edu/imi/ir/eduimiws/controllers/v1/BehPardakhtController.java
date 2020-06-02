package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mellat.BehpardakhtAfterPaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/behpardakhts")
@RequiredArgsConstructor
@Tag(name = "BehPardakhts", description = "The behpardakht API")
public class BehPardakhtController {


    @Operation(
            summary = "Behpardakht Response",
            description = "Behpardakht Response after Payment",
            tags = "behpardakhts",
            security = @SecurityRequirement(name = "imi-security-key")
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
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> afterPaymentResponse(@RequestParam(name = "RefId") String RefId,
                                            @RequestParam(name = "ResCode") String ResCode,
                                            @RequestParam(name = "SaleOrderId") Long SaleOrderId,
                                            @RequestParam(name = "SaleReferenceId") Long SaleReferenceId,
                                            @RequestParam(name = "CardHolderPAN") String CardHolderPAN,
                                            @RequestParam(name = "CreditCardSaleResponseDetail")
                                                    String CreditCardSaleResponseDetail,
                                            @RequestParam(name = "FinalAmount") Long FinalAmount) {

        BehpardakhtAfterPaymentResponse behpardakhtAfterPaymentResponse = new BehpardakhtAfterPaymentResponse();

        if (RefId != null) {
            behpardakhtAfterPaymentResponse.setRefId(RefId);
        }
        if (ResCode != null) {
            behpardakhtAfterPaymentResponse.setResCode(ResCode);
        }
        if (SaleOrderId != null) {
            behpardakhtAfterPaymentResponse.setSaleOrderId(SaleOrderId);
        }
        if (SaleReferenceId != null) {
            behpardakhtAfterPaymentResponse.setSaleReferenceId(SaleReferenceId);
        }
        if (CardHolderPAN != null) {
            behpardakhtAfterPaymentResponse.setCardHolderPAN(CardHolderPAN);
        }
        if (CreditCardSaleResponseDetail != null) {
            behpardakhtAfterPaymentResponse.setCreditCardSaleResponseDetail(CreditCardSaleResponseDetail);

        }
        if (FinalAmount != null) {
            behpardakhtAfterPaymentResponse.setFinalAmount(FinalAmount);
        }


        return ResponseEntity.ok(behpardakhtAfterPaymentResponse);
    }

}
