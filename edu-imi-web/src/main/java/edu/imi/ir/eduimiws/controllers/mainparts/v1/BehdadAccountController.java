package edu.imi.ir.eduimiws.controllers.mainparts.v1;


import edu.imi.ir.eduimiws.mapper.mainparts.behdad.ChangePasswordRequestMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.PagedDataMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.PagingMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.*;
import edu.imi.ir.eduimiws.models.request.behdad.*;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.behdad.ListAccountTransactionInfosResponse;
import edu.imi.ir.eduimiws.models.response.behdad.PagedDataAccountTransactionInfoResponse;
import edu.imi.ir.eduimiws.models.response.behdad.PagedDataBankTransactionResponse;
import edu.imi.ir.eduimiws.services.mainparts.BehdadAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/behdad/accounts")
@RequiredArgsConstructor
@Tag(name = "behdadaccounts", description = "The Behdad Account API")
public class BehdadAccountController {


    private final BehdadAccountService behdadAccountService;
//→1    private final AccountService accountService;
    private final BalanceInfoMapper balanceInfoMapper;
    private final AccountTransactionFilterMapper accountTransactionFilterMapper;
    private final SideTransactionsRequestMapper sideTransactionsRequestMapper;
    private final PagingMapper pagingMapper;
    private final PagedDataMapper pagedDataMapper;
    private final AccountTransactionInfoMapper accountTransactionInfoMapper;
    private final MultipleAccountTransactionFilterMapper multipleAccountTransactionFilterMapper;
    private final AccountControlCreateModelMapper accountControlCreateModelMapper;
    private final ChangePasswordRequestMapper changePasswordRequestMapper;

    @Operation(
            summary = "Account Numbers",
            description = "Behdad Account Numbers",
            tags = "behdadaccounts",
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
                                            schema = @Schema(implementation = List.class)
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
    @GetMapping(path = "/accountNumbers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountNumbers() {

        List<String> accountNumbers = null;

        accountNumbers = behdadAccountService.getAccountNumbers();

        return ResponseEntity.ok(accountNumbers);
    }


    @Operation(
            summary = "Account Balance",
            description = "Behdad Account Balance",
            tags = "behdadaccounts",
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
/*                                    array = @ArraySchema(
                                            schema = @Schema(implementation = BalanceInfo.class)
                                    )*/
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
    @GetMapping(path = "/accountBalance/{accountNumber}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountBalance(@PathVariable String accountNumber) {

/*        List<String> accountNumbers = null;
        BalanceInfoDto balanceInfoDto = behdadAccountService.getAccountBalance(accountNumber);
        BalanceInfo balanceInfo = balanceInfoMapper.toBalanceInfo(balanceInfoDto);
        return ResponseEntity.ok(balanceInfo);*/
        return null;
    }


    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PagedAccountTransactionFilterRequest.class))
            )
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
                                            schema = @Schema(implementation = PagedDataBankTransactionResponse.class)
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
    @PostMapping(path = "/getBankTransactionsDetails",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getBankTransactionsDetails(@RequestBody PagedAccountTransactionFilterRequest pagedAccountTransactionFilter) {

/*        AccountTransactionFilterDto accountTransactionFilterDto = accountTransactionFilterMapper
                .toAccountTransactionFilterDto(pagedAccountTransactionFilter.getAccountTransactionFilter());
        PagingDto pagingDto = pagingMapper.toPagingDto(pagedAccountTransactionFilter.getPaging());
        PagedDataDto pagedDataDto = behdadAccountService
                .getBankTransactionDetails(accountTransactionFilterDto, pagingDto);
        PagedData pagedData = pagedDataMapper.toPagedData(pagedDataDto);
        return ResponseEntity.ok(pagedData);*/

//→1        accountService.getAccountBalance(null, null);
        System.out.println("salam");
        return null;
    }


    @Operation(
            summary = "Paged Destination Side Transactions",
            description = "Behdad Paged Destination Side Transactions",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PagedSideTransactionsRequest.class))
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            headers = {@Header(name = "authorization", description = "authorization description"),
                                    @Header(name = "userPublicId")},
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PagedDataAccountTransactionInfoResponse.class)
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
    @PostMapping(path = "/pagedDestinationSideTransactions",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPagedDestinationSideTransactions(@RequestBody PagedSideTransactionsRequest pagedSideTransactionsRequest) {

/*        SideTransactionsRequestDto sideTransactionsRequestDto = sideTransactionsRequestMapper
                .toSideTransactionsRequestDto(pagedSideTransactionsRequest.getSideTransactionsRequest());
        PagingDto pagingDto = pagingMapper.toPagingDto(pagedSideTransactionsRequest.getPaging());
        PagedDataDto pagedDataDto = behdadAccountService
                .getPagedDestinationSideTransactions(sideTransactionsRequestDto, pagingDto);
        PagedData pagedData = pagedDataMapper.toPagedData(pagedDataDto);
        return ResponseEntity.ok(pagedData);*/
        return null;
    }


    @Operation(
            summary = "List Destination Side Transactions",
            description = "Behdad List Destination Side Transactions",
            tags = "behdadaccounts",
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
                                            schema = @Schema(implementation = ListAccountTransactionInfosResponse.class)
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
    @GetMapping(path = "/getDestinationSideTransactions/accountNumber/{accountNumber}/transactionId/{transactionId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getDestinationSideTransactions(@PathVariable String accountNumber,
                                                            @PathVariable long transactionId) {

/*        List<AccountTransactionInfoDto> accountTransactionInfoDtos = behdadAccountService
                .getDestinationSideTransactions(accountNumber, transactionId);
        List<AccountTransactionInfo> accountTransactionInfos = accountTransactionInfoMapper
                .toAccountTransactionInfos(accountTransactionInfoDtos);
        return ResponseEntity.ok(accountTransactionInfos);*/
        return null;
    }


    @Operation(
            summary = "Paged Source Side Transactions",
            description = "Behdad Paged Source Side Transactions",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PagedSideTransactionsRequest.class))
            )
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
                                            schema = @Schema(implementation = PagedDataAccountTransactionInfoResponse.class)
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
    @PostMapping(path = "/getPagedSourceSideTransactions",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPagedSourceSideTransactions(@RequestBody PagedSourceSideTransactionRequest pagedSourceSideTransactionRequest) {

/*        SideTransactionsRequestDto sideTransactionsRequestDto = sideTransactionsRequestMapper
                .toSideTransactionsRequestDto(pagedSourceSideTransactionRequest.getSideTransactionsRequest());
        PagingDto pagingDto = pagingMapper.toPagingDto(pagedSourceSideTransactionRequest.getPaging());
        PagedDataDto pagedDataDto = behdadAccountService
                .getPagedSourceSideTransactions(sideTransactionsRequestDto, pagingDto);
        PagedData pagedData = pagedDataMapper.toPagedData(pagedDataDto);
        return ResponseEntity.ok(pagedData);*/
        return null;
    }


    @Operation(
            summary = "List Source Side Transactions",
            description = "Behdad List Source Side Transactions",
            tags = "behdadaccounts",
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
                                            //   response is not is document, choose it by myself.
                                            //   if not correct then change it to PagedData.class
                                            schema = @Schema(implementation = ListAccountTransactionInfosResponse.class)
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
    @GetMapping(path = "/getSourceSideTransactions/accountNumber/{accountNumber}/transactionId/{transactionId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getSourceSideTransactions(@PathVariable String accountNumber,
                                                       @PathVariable long transactionId) {

       /* List<AccountTransactionInfoDto> accountTransactionInfoDtos = behdadAccountService
                .getSourceSideTransactions(accountNumber, transactionId);
        List<AccountTransactionInfo> accountTransactionInfos = accountTransactionInfoMapper
                .toAccountTransactionInfos(accountTransactionInfoDtos);
        return ResponseEntity.ok(accountTransactionInfos);*/
        return null;
    }


    @Operation(
            summary = "Paged Pending Transactions",
            description = "Behdad Paged Pending Transactions",
            tags = "behdadaccounts",
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
                                            //   response is not is document, choose it by myself.
                                            //   if not correct then change it to PagedData.class
                                            schema = @Schema(implementation = PagedDataAccountTransactionInfoResponse.class)
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
    @GetMapping(path = "/getPendingTransactions/accountNumber/{accountNumber}/pageNumber/{pageNumber}/recordCount/{recordCount}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPendingTransactions(@PathVariable String accountNumber,
                                                    @PathVariable Integer pageNumber,
                                                    @PathVariable Integer recordCount) {

      /*  PagedDataDto pagedDataDto = behdadAccountService
                .getPendingTransactions(accountNumber, new PagingDto(null, pageNumber, recordCount));
        PagedData pagedData = pagedDataMapper.toPagedData(pagedDataDto);
        return ResponseEntity.ok(pagedData);*/
        return null;
    }


    @Operation(
            summary = "Account Control Type",
            description = "Behdad Account Control Type",
            tags = "behdadaccounts",
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
                                            schema = @Schema(implementation = String.class)
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
    @GetMapping(path = "/accountControlType/accountNumber/{accountNumber}/identifierType/{identifierType}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountControlType(@PathVariable String accountNumber,
                                                   @PathVariable String identifierType) {

        String accountControlType = behdadAccountService
                .getAccountControlType(accountNumber, identifierType);
        return ResponseEntity.ok(accountControlType);
    }


    @Operation(
            summary = "Account Control Type",
            description = "Behdad Account Control Type",
            tags = "behdadaccounts",
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
                                            schema = @Schema(implementation = String.class)
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
    @DeleteMapping(path = "/accountControlType/accountNumber/{accountNumber}/identifierType/{identifierType}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> clearAccountControlType(@PathVariable String accountNumber,
                                                     @PathVariable String identifierType) {

        behdadAccountService.clearAccountControlType(accountNumber, identifierType);
        return ResponseEntity.ok("Identifier Type Cleared Successfully");
    }


    @Operation(
            summary = "Account Control Type",
            description = "Behdad Account Control Type",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = AccountControlCreateModelRequest.class))
            )
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
                                            schema = @Schema(implementation = String.class)
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
    @PostMapping(path = "/accountControlType",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> setAccountControlType(){
//            (@RequestBody AccountControlCreateModel accountControlCreateModel) {

/*        AccountControlCreateModelDto accountControlCreateModelDto = accountControlCreateModelMapper
                .toAccountControlCreateModelDto(accountControlCreateModel);
        behdadAccountService.setAccountControlType(accountControlCreateModelDto);
        return ResponseEntity.ok("Identifier Type Created Successfully");*/
        return null;
    }


    @Operation(
            summary = "Paged Source Side Transactions",
            description = "Behdad Paged Source Side Transactions",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PagedMultipleAccountTransactionsDetailsRequest.class))
            )
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
                                            schema = @Schema(implementation = PagedDataBankTransactionResponse.class)
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
    @PostMapping(path = "/multipleAccountTransactionsDetails",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getMultipleAccountTransactionsDetails(@RequestBody PagedMultipleAccountTransactionsDetailsRequest pagedMultipleAccountTransactionsDetailsRequest) {

/*        MultipleAccountTransactionFilterDto multipleAccountTransactionFilterDto = multipleAccountTransactionFilterMapper
                .toMultipleAccountTransactionFilterDto(pagedMultipleAccountTransactionsDetailsRequest.getMultipleAccountTransactionFilter());
        PagingDto pagingDto = pagingMapper.toPagingDto(pagedMultipleAccountTransactionsDetailsRequest.getPaging());
        PagedDataDto pagedDataDto = behdadAccountService
                .getMultipleAccountTransactionsDetails(multipleAccountTransactionFilterDto, pagingDto);
        PagedData pagedData = pagedDataMapper.toPagedData(pagedDataDto);
        return ResponseEntity.ok(pagedData);*/
        return null;
    }



    @Operation(
            summary = "Change Password",
            description = "Behdad changePassword",
            tags = "behdadaccounts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = @Content(schema = @Schema(implementation = ChangePasswordRequest.class))
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            headers = {@Header(name = "authorization", description = "authorization description"),
                                    @Header(name = "userPublicId")},
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = String.class)
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
    @PostMapping(path = "/changePassword",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> changePassword(){
//    (@RequestBody ChangePasswordRequest changePasswordRequest) {


/*        ChangePasswordRequestDto changePasswordRequestDto = changePasswordRequestMapper
                .toChangePasswordRequestDto(changePasswordRequest);
        behdadAccountService.changePassword(changePasswordRequestDto);
        return ResponseEntity.ok("Password Changed Successfully");*/
        return null;
    }
}
