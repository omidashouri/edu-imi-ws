package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.PaymentCodeResponseAssembler;
import edu.imi.ir.eduimiws.assemblers.mainparts.PaymentCodeResponseDescriptiveAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeApiProjectionMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeRequestMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.PaymentCodeApiProjection;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponse;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponseDescriptive;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.services.mainparts.PaymentCodeService;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
import edu.imi.ir.eduimiws.utilities.SwaggerUtil;
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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    private final PaymentCodeApiProjectionMapper paymentCodeApiProjectionMapper;
    private final PaymentCodeResponseAssembler paymentCodeResponseAssembler;
    private final PaymentCodeResponseDescriptiveAssembler paymentCodeResponseDescriptiveAssembler;
    private final PagedResourcesAssembler<PaymentCodeApiDto> paymentCodeApiDtoPagedResourcesAssembler;
    private final DigitalPaymentCredential digitalPaymentCredential;
    private final PaymentCodeRequestMapper paymentCodeRequestMapper;


    @Operation(
            summary = "find All paymentCodes descriptive",
            description = "Search paymentCode descriptive detail pageable",
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
                                            schema = @Schema(implementation = PaymentCodeResponseDescriptive.class)
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
    @SwaggerUtil.PaymentCodeResponseDescriptiveAsQueryParam
    @GetMapping(path = "/paymentCodeDescriptive",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PaymentCodeResponseDescriptive>> getPaymentCodeDescriptive(@Parameter(hidden = true)
                                                                                @RequestParam Map<String, String> queryParams) {

        Page<PaymentCodeApiProjection> paymentCodeApiProjections =
                paymentCodeService.queryAllPaymentCodeProjection(queryParams);

       Page<PaymentCodeApiDto> paymentCodeApiDtoPage = paymentCodeApiProjections
                .map(paymentCodeApiProjectionMapper::toPaymentCodeApiDto);

         PagedModel<PaymentCodeResponseDescriptive> paymentCodeResponseDescriptivesPagedModel = paymentCodeApiDtoPagedResourcesAssembler
                .toModel(paymentCodeApiDtoPage, paymentCodeResponseDescriptiveAssembler);

             return ResponseEntity.ok(paymentCodeResponseDescriptivesPagedModel);
    }


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
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PaymentCodeResponse>> getPaymentCodes(@Parameter(hidden = true)
                                                                           @SortDefault(sort = "paymentCode", direction = Sort.Direction.DESC)
                                                                           @PageableDefault(page = 0, size = 10, value = 10)
                                                                                   Pageable pageable) {
        Page<PaymentCodeApiEntity> paymentCodePages =
                paymentCodeService.findAll(pageable);

        Page<PaymentCodeApiDto> paymentCodeApiDtoPage = paymentCodePages
                .map(p -> paymentCodeMapper
                        .toPaymentCodeApiDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PaymentCodeResponse> paymentCodeResponsePagedModel = paymentCodeApiDtoPagedResourcesAssembler
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

        PagedModel<PaymentCodeResponse> paymentCodeResponsePagedModel = paymentCodeApiDtoPagedResourcesAssembler
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
    @Tags(value = {
//            @Tag( name = "paymentCodeRequest"),
            @Tag(name = "paymentCodes")

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
