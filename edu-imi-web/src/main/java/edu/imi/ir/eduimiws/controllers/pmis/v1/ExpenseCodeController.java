package edu.imi.ir.eduimiws.controllers.pmis.v1;

import edu.imi.ir.eduimiws.assemblers.pmis.ExpenseCodeResponseAssembler;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.pmis.ExpenseCodeResponse;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
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
@RequestMapping("/api/v1/expenseCodes")
@RequiredArgsConstructor
@Tag(name = "expenseCodes", description = "The expense code API")
public class ExpenseCodeController {

    private final ExpenseCodeService expenseCodeService;
    private final ExpenseCodeApiFastMapper expenseCodeApiFastMapper;
    private final ExpenseCodeResponseAssembler expenseCodeResponseAssembler;
    private final PagedResourcesAssembler<ExpenseCodeApiDto> expenseCodeFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All expenseCodes",
            description = "Search expenseCode detail pageable",
            tags = "expenseCodes",
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
                                            schema = @Schema(implementation = ExpenseCodeResponse.class)
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
    public ResponseEntity<PagedModel<ExpenseCodeResponse>> getExpenseCodes(@Parameter(hidden = true)
                                                                   @SortDefault(sort = "expenseTitle", direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {

        Page<ExpenseCodeApiEntity> ExpenseCodePages =
                expenseCodeService.findAll(pageable);

        Page<ExpenseCodeApiDto> expenseCodeApiDtoPage = ExpenseCodePages
                .map(p -> expenseCodeApiFastMapper
                        .toExpenseCodeApiDto(p, new CycleAvoidingMappingContext()));

        PagedModel<ExpenseCodeResponse> expenseCodeResponsePagedModel = expenseCodeFastDtoPagedResourcesAssembler
                .toModel(expenseCodeApiDtoPage, expenseCodeResponseAssembler);

        return ResponseEntity.ok(expenseCodeResponsePagedModel);
    }

    @Operation(
            summary = "Find ExpenseCode by public ID",
            description = "Search expenseCode by the public id",
            tags = "expenseCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ExpenseCodeResponse.class)
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
    @GetMapping(path = "/publicId/{expenseCodePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getExpenseCodeByExpenseCodePublicId(@PathVariable String expenseCodePublicId) {

        try {
            ExpenseCodeApiEntity expenseCode = expenseCodeService.findByExpenseCodePublicId(expenseCodePublicId);
            if (expenseCode == null) {
                throw new FiledValueNullException("Expense Code is null");
            }

            ExpenseCodeApiDto expenseCodeApiDto = expenseCodeApiFastMapper
                    .toExpenseCodeApiDto(expenseCode, new CycleAvoidingMappingContext());

            ExpenseCodeResponse expenseCodeResponse =
                    expenseCodeResponseAssembler.toModel(expenseCodeApiDto);

            return ResponseEntity.ok(expenseCodeResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Find ExpenseCode by code",
            description = "Search expenseCode by the code",
            tags = "expenseCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ExpenseCodeResponse.class)
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
    @GetMapping(path = "/expenseCode/{expenseCode}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getExpenseCodeByExpenseCode(@PathVariable String expenseCode) {

        try {
            ExpenseCodeApiEntity expenseCodeEntity = expenseCodeService.findByExpenseCode(Long.valueOf(expenseCode));
            if (expenseCode == null) {
                throw new FiledValueNullException("Expense Code is null");
            }

            ExpenseCodeApiDto expenseCodeApiDto = expenseCodeApiFastMapper
                    .toExpenseCodeApiDto(expenseCodeEntity, new CycleAvoidingMappingContext());

            ExpenseCodeResponse expenseCodeResponse =
                    expenseCodeResponseAssembler.toModel(expenseCodeApiDto);

            return ResponseEntity.ok(expenseCodeResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Find ExpenseCode by Expense Title",
            description = "Search expenseCode by the Expense Title",
            tags = "expenseCodes",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ExpenseCodeResponse.class)
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
    @GetMapping(path = "/expenseTitle/{expenseTitle}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getExpenseCodeByExpenseTitle(@PathVariable String expenseTitle,
                                                          @Parameter(hidden = true)
                                                          @SortDefault(sort = "expenseTitle", direction = Sort.Direction.DESC)
                                                          @PageableDefault(page = 0, size = 10, value = 10) Pageable pageable) {

        try {
            if (expenseTitle == null) {
                throw new FiledValueNullException("Expense Code is null");
            }
            Page<ExpenseCodeApiEntity> ExpenseCodePages = expenseCodeService
                    .findAllByExpenseTitleContaining(expenseTitle, pageable);

            Page<ExpenseCodeApiDto> expenseCodeApiDtoPage = ExpenseCodePages
                    .map(p -> expenseCodeApiFastMapper
                            .toExpenseCodeApiDto(p, new CycleAvoidingMappingContext()));

            PagedModel<ExpenseCodeResponse> expenseCodeResponsePagedModel = expenseCodeFastDtoPagedResourcesAssembler
                    .toModel(expenseCodeApiDtoPage, expenseCodeResponseAssembler);

            return ResponseEntity.ok(expenseCodeResponsePagedModel);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
