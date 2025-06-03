package edu.imi.ir.eduimiws.controllers.behdad.v1;

import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.BalanceInfoMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.BalanceInfoNewMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.AccountResponseForPaymentCode;
import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountInfo;
import edu.imi.ir.eduimiws.models.wsdl.behdad.BalanceInfo;
import edu.imi.ir.eduimiws.services.behdad.BehdadService;
import edu.imi.ir.eduimiws.services.behdad.BehdadServiceImpl;
import edu.imi.ir.eduimiws.utilities.SwaggerUtil;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/behdad/new")
@RequiredArgsConstructor
@Tag(name = "BehdadNewApis", description = "The behdad API")
public class BehdadController {

    private final BehdadService behdadService;
    private final BehdadServiceImpl behdadServiceImpl;
    private final BalanceInfoNewMapper balanceInfoNewMapper;

    @Operation(
            summary = "get account numbers",
            description = "Search accounts for payment code detail pageable",
            tags = "BehdadNewApis",
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
                                            schema = @Schema(implementation = AccountInfo.class)
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
    @GetMapping(path = "/getAccountNumbers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountNumbers() {
        List<AccountInfo> accountNumbers = behdadService.getAccountNumbers();
        accountNumbers.forEach(e -> System.out.println(e.getAccountNumber()));
        System.out.println("salam");
        return ResponseEntity.ok(accountNumbers);

    }

    @Operation(
            summary = "get account balance",
            description = "Provides different types of account balances",
            tags = "BehdadNewApis",
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
                                            schema = @Schema(implementation = AccountInfo.class)
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
                                    /*                                    array = @ArraySchema(
                                            schema = @Schema(implementation = BalanceInfo.class)
                                    )*/
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            })
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/getAccountBalance/{accountNumber}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAccountBalance(@PathVariable String accountNumber) {

        BalanceInfoDto balanceInfoDto = behdadService.getAccountBalance(accountNumber);
        BalanceInfo balanceInfo = balanceInfoNewMapper.toBalanceInfo(balanceInfoDto);
        System.out.println("salam");
        return ResponseEntity.ok(balanceInfo);

    }
}
