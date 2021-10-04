package edu.imi.ir.eduimiws.controllers.melli.v1;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.DateParseException;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.*;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequestMerchant;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentDataResponseMerchant;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponseMerchant;
import edu.imi.ir.eduimiws.models.response.melli.v1.VerifyResultDataMerchant;
import edu.imi.ir.eduimiws.security.MelliCredential;
import edu.imi.ir.eduimiws.services.mainparts.MelliDigitalPaymentDataService;
import edu.imi.ir.eduimiws.services.mainparts.MelliDigitalPaymentService;
import edu.imi.ir.eduimiws.services.mainparts.MelliVerifyService;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import edu.imi.ir.eduimiws.utilities.MelliTripleDesImpl;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/sadadPayments")
@RequiredArgsConstructor
@Tag(name = "MelliPayments", description = "The Melli Bank API")
public class MelliController {

    private final MelliDigitalPaymentDataMapper melliDigitalPaymentDataMapper;
    private final MelliDigitalPaymentDataService melliDigitalPaymentDataService;
    private final MelliDigitalPaymentService melliDigitalPaymentService;
    private final VerifyResultDataMerchantMapper verifyResultDataMerchantMapper;
    private final MelliVerifyService melliVerifyService;
    private final CycleAvoidingMappingContext cycleAvoidingMappingContext;
    private final MelliDigitalPaymentMapper melliDigitalPaymentMapper;
    private final MelliDigitalPaymentDtoMelliVerifyDtoMapper melliDigitalPaymentDtoMelliVerifyDtoMapper;
    private final PaymentResponseMerchantMapper paymentResponseMerchantMapper;
    private final PaymentDataResponseMerchantMapper paymentDataResponseMerchantMapper;
    private final PaymentRequestMerchantMapper paymentRequestMerchantMapper;
    private final MelliCredential melliCredential;
    private final MelliTripleDesImpl melliTripleDesImpl;
    private final ConvertorUtil convertorUtil;
    private final SecurityUtil securityUtil;
    private final PublicIdUtil publicIdUtil;


    @Operation(
            summary = "melli payment get token",
            description = "sadad payment get token",
            security = @SecurityRequirement(name = "imi-security-key"),
            tags = "MelliPayments",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PaymentRequestMerchant.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PaymentResponseMerchant.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "paymentCode not found",
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
    @PostMapping(path = "/merchant/getToken",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> merchantGetTokens(@RequestBody PaymentRequestMerchant paymentRequestMerchant) {


        paymentRequestMerchant = convertorUtil.makeEmptyValueNull(paymentRequestMerchant);


        if (paymentRequestMerchant.getMerchantOrderId() == null) {
            throw new FiledValueNullException("Order Id is null");
        }

        if (paymentRequestMerchant.getAmount() == null) {
            throw new FiledValueNullException("Amount is null");
        }

        if (paymentRequestMerchant.getReturnUrl() == null) {
            throw new FiledValueNullException("Return Url is null");
        }

        if (paymentRequestMerchant.getLocalDateTime() == null) {
            throw new FiledValueNullException("Locale Date Time null");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'+04:30'");
        try {
            simpleDateFormat.parse(paymentRequestMerchant.getLocalDateTime());
        } catch (ParseException e) {
            throw new DateParseException("Locale Date Time Format is Not Correct");
        }

        MelliDigitalPaymentDto melliDigitalPaymentDto = paymentRequestMerchantMapper
                .paymentRequestMerchantToMelliDigitalPaymentDto(paymentRequestMerchant,
                        melliCredential);


        melliDigitalPaymentMapper
                .updateMelliDigitalPaymentEntity_BeforeSave(melliDigitalPaymentDto,
                        melliDigitalPaymentService, publicIdUtil, securityUtil, melliTripleDesImpl);

        //save request
        MelliDigitalPaymentEntity melliDigitalPayment = melliDigitalPaymentMapper
                .toMelliDigitalPaymentEntity(melliDigitalPaymentDto, cycleAvoidingMappingContext);

        melliDigitalPayment = melliDigitalPaymentService.saveMelliDigitalPaymentEntity(melliDigitalPayment);
        melliDigitalPaymentDto.setId(melliDigitalPayment.getId());

        melliDigitalPaymentDto = melliDigitalPaymentService.getToken(melliDigitalPaymentDto);

        melliDigitalPaymentMapper
                .updateMelliDigitalPaymentByMelliDigitalPaymentDto_PaymentResponse(melliDigitalPayment, melliDigitalPaymentDto);

        melliDigitalPaymentService.saveMelliDigitalPaymentEntity(melliDigitalPayment);

        PaymentResponseMerchant paymentResponseMerchant = paymentResponseMerchantMapper
                .melliDigitalPaymentDtoToPaymentResponseMerchant(melliDigitalPaymentDto);

//        paymentRequest.setReturnUrl("http://ashouri-pc.imi.ir:8080/edu-imi-ws/api/v1/mellies/bankResponse");

        return ResponseEntity.ok(paymentResponseMerchant);
    }


    @Operation(
            summary = "Find Payment Request Data by public ID",
            description = "Search Payment Requests by the public id",
            tags = "melliPayments",
            security = @SecurityRequirement(name = "imi-security-key"),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PaymentDataResponseMerchant.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "expenseCode not found",
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
    @GetMapping(path = "/merchant/publicId/{paymentRequestPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getMelliDigitalPaymentRequestDataByDigitalPaymentPublicId(@PathVariable String paymentRequestPublicId) {

        try {
            MelliDigitalPaymentDataEntity melliDigitalPaymentData = melliDigitalPaymentDataService
                    .findByMelliDigitalPaymentPublicId(paymentRequestPublicId);
            if (melliDigitalPaymentData == null) {
                throw new FiledValueNullException("Melli Digital Payment Data is null");
            }

            MelliDigitalPaymentDataDto melliDigitalPaymentDataDto = melliDigitalPaymentDataMapper
                    .toMelliDigitalPaymentDataDto(melliDigitalPaymentData, publicIdUtil, securityUtil);

            //--start refactor with join
            MelliDigitalPaymentEntity melliDigitalPayment = melliDigitalPaymentService
                    .findByPublicId(melliDigitalPaymentData.getMelliDigitalPaymentPublicId());

            MelliDigitalPaymentDto melliDigitalPaymentDto = melliDigitalPaymentMapper
                    .toMelliDigitalPaymentDto(melliDigitalPayment, cycleAvoidingMappingContext);

            melliDigitalPaymentDataMapper
                    .updateMelliDigitalPaymentDataDtoMelliDigitalPaymentDto_MerchantOrderId(melliDigitalPaymentDataDto, melliDigitalPaymentDto);
            //end refactor with join

            PaymentDataResponseMerchant paymentDataResponseMerchant = paymentDataResponseMerchantMapper
                    .toPaymentDataResponseMerchant(melliDigitalPaymentDataDto);

            return ResponseEntity.ok(paymentDataResponseMerchant);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "verify payment by public ID",
            description = "Verify Payment by the public id",
            tags = "melliPayments",
            security = @SecurityRequirement(name = "imi-security-key"),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VerifyResultDataMerchant.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "expenseCode not found",
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
    @GetMapping(path = "/verify/{digitalPaymentRequestPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> verify(@PathVariable(value = "digitalPaymentRequestPublicId") String digitalPaymentRequestPublicId) {

        MelliVerifyDto melliVerifyDto = new MelliVerifyDto();

        MelliDigitalPaymentEntity melliDigitalPayment = melliDigitalPaymentService
                .findByPublicId(digitalPaymentRequestPublicId);
        if (melliDigitalPayment == null) {
            throw new FiledValueNullException("Melli Digital Payment is null");
        }

        //check if digitalPaymentRequestPublicId is in tbl_melli_digital_verify response the result (Do not save again)

        MelliDigitalPaymentDto melliDigitalPaymentDto =
                melliDigitalPaymentMapper.toMelliDigitalPaymentDto(melliDigitalPayment, cycleAvoidingMappingContext);

        melliVerifyDto = melliDigitalPaymentDtoMelliVerifyDtoMapper
                .melliDigitalPaymentDtoToMelliVerifyDto(melliDigitalPaymentDto);

        melliVerifyDto = melliVerifyService.verify(melliVerifyDto);

        VerifyResultDataMerchant verifyResultDataMerchant = verifyResultDataMerchantMapper.
                melliVerifyDtoToVerifyResultDataMerchant(melliVerifyDto);

        return ResponseEntity.ok(verifyResultDataMerchant);
    }

}
