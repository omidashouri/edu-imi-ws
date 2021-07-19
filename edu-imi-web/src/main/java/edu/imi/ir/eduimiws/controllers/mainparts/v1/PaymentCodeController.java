package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.PaymentCodeResponseAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeRequestMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponse;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.services.mainparts.PaymentCodeService;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
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
import io.swagger.v3.oas.annotations.tags.Tags;
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
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/paymentCodes")
@RequiredArgsConstructor
@Tag(name = "paymentCodes", description = "The payment code API")
public class PaymentCodeController {

    private final PaymentCodeService paymentCodeService;
    private final ExpenseCodeService expenseCodeService;
    private final ProjectService projectService;
    private final PaymentCodeApiMapper paymentCodeMapper;
    private final PaymentCodeResponseAssembler paymentCodeResponseAssembler;
    private final PagedResourcesAssembler<PaymentCodeApiDto> paymentCodeDtoPagedResourcesAssembler;
    private final DigitalPaymentCredential digitalPaymentCredential;
    private final PaymentCodeRequestMapper paymentCodeRequestMapper;


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

        Page<PaymentCodeApiEntity> PaymentCodePages = paymentCodeService
                .findAllByPaymentCodeContaining(paymentCode, pageable);

        Page<PaymentCodeApiDto> paymentCodeApiDtoPage = PaymentCodePages
                .map(p -> paymentCodeMapper
                        .toPaymentCodeApiDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PaymentCodeResponse> paymentCodeResponsePagedModel = paymentCodeDtoPagedResourcesAssembler
                .toModel(paymentCodeApiDtoPage, paymentCodeResponseAssembler);

        return ResponseEntity.ok(paymentCodeResponsePagedModel);

    }

    @Operation(
            summary = "Create PaymentCode by national code and Expense Public Id and Project Public Id",
            description = "Search paymentCode by national code and Expense Public Id and Project Public Id",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PaymentCodeRequest.class))
            )
    )
    @Tags( value = {
//            @Tag( name = "paymentCodeRequest"),
            @Tag( name = "paymentCodes")

    })
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
    @PostMapping(path = "/paymentCodeRequest",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPaymentByPaymentCodeRequest(@RequestBody PaymentCodeRequest paymentCodeRequest) {



        paymentCodeService.validatePaymentCodeRequestNullInputs(paymentCodeRequest);

        PaymentCodeApiDto paymentCodeApiDto = paymentCodeRequestMapper
                .paymentCodeRequestToPaymentCodeApiDto(paymentCodeRequest, new CycleAvoidingMappingContext());


        paymentCodeService.validatePaymentCodeApiDtoNulls(paymentCodeApiDto);

        PaymentCodeApiEntity paymentCodeApi = paymentCodeMapper
                .toPaymentCodeApiEntity(paymentCodeApiDto, new CycleAvoidingMappingContext());


        PaymentCodeApiEntity newPaymentCodeApi = paymentCodeService
                .generatePaymentCodeAndPublicId(paymentCodeApi);

        PaymentCodeApiEntity savedPaymentCodeApi = paymentCodeService.save(newPaymentCodeApi);

        PaymentCodeApiDto savedPaymentCodeApiDto = paymentCodeMapper
                .toPaymentCodeApiDto(savedPaymentCodeApi, new CycleAvoidingMappingContext());

        PaymentCodeResponse paymentCodeResponse =
                paymentCodeResponseAssembler.toModel(savedPaymentCodeApiDto);

        return ResponseEntity.ok(paymentCodeResponse);
    }

    @Operation(
            hidden = true,
            summary = "Create PaymentCode by national code and Expense Public Id and Project Public Id",
            description = "Search paymentCode by national code and Expense Public Id and Project Public Id",
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
    @DisableMethod
    @PostMapping(path = "/nationalCode/{nationalCode}/expensePublicId/{expensePublicId}/projectPublicId/{projectPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPaymentByNationalAndExpenseCodePublicIdAndProjectPublicId(@PathVariable String nationalCode,
                                                                                             @PathVariable String expensePublicId,
                                                                                             @PathVariable String projectPublicId) {

        ProjectEntity project = projectService
                .findProjectEntityByProjectApiPublicId(projectPublicId);

        ExpenseCodeApiEntity expenseCodeApi = expenseCodeService
                .findByExpenseCodePublicId(expensePublicId);

        PaymentCodeApiEntity newPaymentCodeApi = paymentCodeService
                .generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity(nationalCode,
                        project, expenseCodeApi, digitalPaymentCredential.getMelliTwoDigitCode());

        PaymentCodeApiEntity savedPaymentCodeApi = paymentCodeService.save(newPaymentCodeApi);

        PaymentCodeApiDto paymentCodeApiDto = paymentCodeMapper
                .toPaymentCodeApiDto(savedPaymentCodeApi, new CycleAvoidingMappingContext());

        PaymentCodeResponse paymentCodeResponse =
                paymentCodeResponseAssembler.toModel(paymentCodeApiDto);

        return ResponseEntity.ok(paymentCodeResponse);
    }
}
