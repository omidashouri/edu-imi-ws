package edu.imi.ir.eduimiws.controllers.crm.v1;

import edu.imi.ir.eduimiws.assemblers.crm.AccountResponseForPaymentCodeAssembler;
import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.mapper.crm.AccountRequestForPaymentCodeAccountDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.AccountResponseForPaymentCodeAccountDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.models.request.crm.AccountRequestForPaymentCode;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.AccountResponseForPaymentCode;
import edu.imi.ir.eduimiws.services.crm.AccountService;
import edu.imi.ir.eduimiws.services.crm.CompanyService;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
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
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import java.util.List;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@Tag(name = "Accounts", description = "The account API")
public class AccountController {

    private final AccountService accountService;
    private final AccountResponseForPaymentCodeAccountDtoMapper accountResponseForPaymentCodeAccountDtoMapper;
    private final AccountRequestForPaymentCodeAccountDtoMapper accountRequestForPaymentCodeAccountDtoMapper;
    private final AccountResponseForPaymentCodeAssembler accountResponseForPaymentCodeAssembler;
    private final PagedResourcesAssembler<AccountDto> accountDtoPagedResourcesAssembler;
    private final CompanyService companyService;
    private final AccountMapper accountMapper;
    private final CommonUtils commonUtils;
    private final ConvertorUtil convertorUtil;
    private final DefaultValues defaultValues;


    @Operation(
            summary = "find All accounts for payment codes",
            description = "Search accounts for payment code detail pageable",
            tags = "accounts",
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
                                            schema = @Schema(implementation = AccountResponseForPaymentCode.class)
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
    @GetMapping(path = "/forPaymentCodes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<AccountResponseForPaymentCode>> getAccountsForPaymentCode(@Parameter(hidden = true)
                                                                                               @SortDefault(sort = "accountName",
                                                                                                       direction = Sort.Direction.DESC)
                                                                                               @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                       Pageable pageable) {

        Page<AccountDto> accountDtoPages =
                accountService.findAllPageableAccountForPaymentCode(pageable);

        PagedModel<AccountResponseForPaymentCode> accountResponseForPaymentCodePagedModel = accountDtoPagedResourcesAssembler
                .toModel(accountDtoPages, accountResponseForPaymentCodeAssembler);

        accountResponseForPaymentCodePagedModel.getContent().forEach(accountResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(accountResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(accountResponseForPaymentCodePagedModel);
    }

    @Operation(
            summary = "Find Account for payment code by public ID",
            description = "Search account for payment code by the public id",
            tags = "contacts",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = AccountResponseForPaymentCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "period not found",
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
    @GetMapping(path = "/publicId/{accountPublicId}/forPaymentCode",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountByAccountPublicId(@PathVariable String accountPublicId) {


        String accountPublicIdDbChar = convertorUtil.getDbCharAndNum(accountPublicId);

        AccountEntity account = accountService.findAccountEntityByAccountApiPublicId(accountPublicIdDbChar);
        if (account == null) {
            throw new NotFoundException("requested account not found");
        }

        AccountDto accountDto =
                accountMapper.toAccountDto(account, new CycleAvoidingMappingContext());

        AccountResponseForPaymentCode accountResponseForPaymentCode =
                accountResponseForPaymentCodeAssembler.toModel(accountDto);

        return ResponseEntity.ok(accountResponseForPaymentCode);

    }


    @Operation(
            summary = "Find Account by economical Code for payment code",
            description = "Search account by the economical Code for payment code",
            tags = "accounts",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = AccountResponseForPaymentCode.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Account not found",
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
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/economicalCode/{economicalCode}/forPaymentCode",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<?>> getAccountForPaymentCodeByEconomicalCode(@PathVariable String economicalCode,
                                                                                  @Parameter(hidden = true)
                                                                                  @SortDefault(sort = "lastName", direction = Sort.Direction.DESC)
                                                                                  @PageableDefault(page = 0, size = 10)
                                                                                          Pageable pageable) {

        String economicalCodeDbChar = convertorUtil.getDbCharAndNum(economicalCode);

        Page<AccountDto> accountDtoPages =
                accountService.findAccountByEconomicalCodeForPaymentCode(economicalCodeDbChar, pageable);

        if (accountDtoPages == null || accountDtoPages.getContent().size() == 0) {
            throw new NotFoundException("requested account not found");
        }

        PagedModel<AccountResponseForPaymentCode> accountResponseForPaymentCodePagedModel = accountDtoPagedResourcesAssembler
                .toModel(accountDtoPages, accountResponseForPaymentCodeAssembler);

        accountResponseForPaymentCodePagedModel.getContent().forEach(accountResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(accountResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(accountResponseForPaymentCodePagedModel);
    }


    @Operation(
            summary = "Update Account for Payment Code by economical ID",
            description = "Update account for Payment Code by the economical id",
            tags = "accounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = AccountRequestForPaymentCode.class))
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = AccountResponseForPaymentCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "period not found",
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
    @PutMapping(path = "/forPaymentCode",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updateAccountForPaymentCodeByAccountPublicId(@RequestBody AccountRequestForPaymentCode
                                                                                  accountRequestForPaymentCode) {

        String accountPublicId = accountRequestForPaymentCode.getAccountPublicId();
        AccountEntity editableAccount = null;
        AccountDto newAccountDto;

        commonUtils.nullInstanceFieldsForValues(accountRequestForPaymentCode, List.of("string", ""));

        convertorUtil.changeInstanceCharAndNumSetByType(accountRequestForPaymentCode, "db");

        if (accountPublicId != null) {
            editableAccount = accountService.findAccountEntityByAccountApiPublicId(accountPublicId);
        }
        if (editableAccount == null) {
            throw new NotFoundException("requested account not found");
        }

        accountRequestForPaymentCodeAccountDtoMapper
                .setDefaultCompanyForَUpdateAccountEntity(editableAccount, defaultValues);

        newAccountDto = accountRequestForPaymentCodeAccountDtoMapper
                .accountRequestForPaymentCodeToAccountDto(accountRequestForPaymentCode);

        AccountDto updatedAccountDto = accountService
                .updateAccountForPaymentCode(newAccountDto, editableAccount);

        AccountResponseForPaymentCode accountResponseForPaymentCode = accountResponseForPaymentCodeAccountDtoMapper
                .accountDtoToAccountResponseForPaymentCode(updatedAccountDto);

        convertorUtil.changeInstanceCharAndNumSetByType(accountResponseForPaymentCode, "persian");

        return ResponseEntity.ok(accountResponseForPaymentCode);

    }


    @Operation(
            summary = "Create Account for Payment Code",
            description = "Create account for Payment Code",
            tags = "accounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = AccountRequestForPaymentCode.class))
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = AccountResponseForPaymentCode.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "period not found",
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
    @PostMapping(path = "/forPaymentCode",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createAccountForPaymentCode(@RequestBody AccountRequestForPaymentCode
                                                                 accountRequestForPaymentCode) {

        Page<AccountDto> accountDtoPage = null;
        accountRequestForPaymentCode.setAccountPublicId(null);

        commonUtils.nullInstanceFieldsForValues(accountRequestForPaymentCode, List.of("string", ""));
        convertorUtil.changeInstanceCharAndNumSetByType(accountRequestForPaymentCode, "db");

        String economicalCode = accountRequestForPaymentCode.getEconomicalCode();
        if (economicalCode != null) {
            Pageable pageable = PageRequest.of(0, 10);
            accountDtoPage = accountService.findAccountByEconomicalCodeForPaymentCode(economicalCode, pageable);
        }
        if (accountDtoPage != null && accountDtoPage.getContent().size() > 0) {
            throw new NotAcceptableException("found record with economical code, use update to edit record.");
        }

        AccountDto newAccountDto = accountRequestForPaymentCodeAccountDtoMapper
                .accountRequestForPaymentCodeToAccountDto(accountRequestForPaymentCode);

        accountRequestForPaymentCodeAccountDtoMapper
                .setDefaultCompanyForCreateAccountDto(newAccountDto, companyService);

        AccountDto savedAccountDto = accountService.createAccountForPaymentCode(newAccountDto);

        AccountDto foundAccountDto = accountService.findAccountById(savedAccountDto.getId());

        AccountResponseForPaymentCode accountResponseForPaymentCode = accountResponseForPaymentCodeAccountDtoMapper
                .accountDtoToAccountResponseForPaymentCode(foundAccountDto);

        convertorUtil.changeInstanceCharAndNumSetByType(accountResponseForPaymentCode, "persian");

        return ResponseEntity.ok(accountResponseForPaymentCode);
    }


}
