package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.PaymentCodeResponseAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeApiMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponse;
import edu.imi.ir.eduimiws.services.mainparts.PaymentCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/paymentCodes")
@RequiredArgsConstructor
@Tag(name = "paymentCodes", description = "The payment code API")
public class PaymentCodeController {

    private final PaymentCodeService paymentCodeService;
    private final PaymentCodeApiMapper paymentCodeMapper;
    private final PaymentCodeResponseAssembler paymentCodeResponseAssembler;
    private final PagedResourcesAssembler<PaymentCodeApiDto> paymentCodeDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All paymentCodes",
            description = "Search paymentCode detail pageable",
            tags = "paymentCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            headers = {@Header(name = "authorization", description = "authorization description"),
                                    @Header(name = "userPublicId")},
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = PaymentCodeResponse.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            })
    @PageableAsQueryParam
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PaymentCodeResponse>> getPaymentCodes(@Parameter(hidden = true)
                                                                           @SortDefault(sort = "paymentCode", direction = Sort.Direction.DESC)
                                                                           @PageableDefault(page = 0, size = 10, value = 10)
                                                                                   Pageable pageable) {

        Page<PaymentCodeApiEntity> PaymentCodePages =
                paymentCodeService.findAll(pageable);

        Page<PaymentCodeApiDto> paymentCodeApiDtoPage = PaymentCodePages
                .map(p -> paymentCodeMapper
                        .toPaymentCodeApiDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PaymentCodeResponse> paymentCodeResponsePagedModel = paymentCodeDtoPagedResourcesAssembler
                .toModel(paymentCodeApiDtoPage, paymentCodeResponseAssembler);

        return ResponseEntity.ok(paymentCodeResponsePagedModel);
    }

    @Operation(
            summary = "Find PaymentCode by public ID",
            description = "Search paymentCode by the public id",
            tags = "paymentCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PaymentCodeResponse.class)
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
    @GetMapping(path = "/publicId/{paymentCodePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPaymentCodeByPaymentCodePublicId(@PathVariable String paymentCodePublicId) {

            PaymentCodeApiEntity paymentCode = paymentCodeService.findByPaymentCodePublicId(paymentCodePublicId);
            if (paymentCode == null) {
                throw new FiledValueNullException("Payment Code is null");
            }

            PaymentCodeApiDto paymentCodeApiDto = paymentCodeMapper
                    .toPaymentCodeApiDto(paymentCode, new CycleAvoidingMappingContext());

            PaymentCodeResponse paymentCodeResponse =
                    paymentCodeResponseAssembler.toModel(paymentCodeApiDto);

            return ResponseEntity.ok(paymentCodeResponse);
    }

    @Operation(
            summary = "Find PaymentCode by Payment Code",
            description = "Search paymentCode by the Payment Code",
            tags = "paymentCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PaymentCodeResponse.class)
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
    @GetMapping(path = "/paymentCode/{paymentCode}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPaymentCodeByPaymentCode(@PathVariable String paymentCode,
                                                          @Parameter(hidden = true)
                                                          @SortDefault(sort = "paymentCode", direction = Sort.Direction.DESC)
                                                          @PageableDefault(page = 0, size = 10, value = 10) Pageable pageable) {

        try {
            if (paymentCode == null) {
                throw new FiledValueNullException("Payment Code is null");
            }
            Page<PaymentCodeApiEntity> PaymentCodePages = paymentCodeService
                    .findAllByPaymentCodeContaining(paymentCode, pageable);

            Page<PaymentCodeApiDto> paymentCodeApiDtoPage = PaymentCodePages
                    .map(p -> paymentCodeMapper
                            .toPaymentCodeApiDto(p, new CycleAvoidingMappingContext()));

            PagedModel<PaymentCodeResponse> paymentCodeResponsePagedModel = paymentCodeDtoPagedResourcesAssembler
                    .toModel(paymentCodeApiDtoPage, paymentCodeResponseAssembler);

            return ResponseEntity.ok(paymentCodeResponsePagedModel);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
