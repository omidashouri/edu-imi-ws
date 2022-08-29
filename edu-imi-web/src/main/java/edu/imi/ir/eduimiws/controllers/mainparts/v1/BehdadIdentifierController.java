package edu.imi.ir.eduimiws.controllers.mainparts.v1;


import edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier.*;
import edu.imi.ir.eduimiws.models.request.behdad.*;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.behdad.IdentifierDetailResponse;
import edu.imi.ir.eduimiws.models.response.behdad.IdentifierRemoveResultResponse;
import edu.imi.ir.eduimiws.models.response.behdad.IdentifierResultResponse;
import edu.imi.ir.eduimiws.services.mainparts.BehdadIdentifierService;
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

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/behdad/identifiers")
@RequiredArgsConstructor
@Tag(name = "behdadidentifiers", description = "The Behdad Identifiers API")
public class BehdadIdentifierController {


    private final BehdadIdentifierService behdadIdentifierService;
    private final IsVerhoeffRequestMapper isVerhoeffRequestMapper;
    private final IdentifierInfoMapper identifierInfoMapper;
    private final BatchIdentifierInfoMapper batchIdentifierInfoMapper;
    private final IdentifierResultMapper identifierResultMapper;
    private final GenerateIdentifierByOrganRequestMapper generateIdentifierByOrganRequestMapper;
    private final BatchIdentifierRemoveInfoMapper batchIdentifierRemoveInfoMapper;
    private final IdentifierRemoveResultMapper identifierRemoveResultMapper;
    private final IdentifierDetailMapper identifierDetailMapper;

    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadidentifiers",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = IdentifierIsVerhoeffRequest.class))
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
                                            schema = @Schema(implementation = Boolean.class)
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
    @PostMapping(path = "/isVerhoeff",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> isVerhoeff(@RequestBody IdentifierIsVerhoeffRequest verhoeffRequest) {

/*        IsVerhoeffRequestDto isVerhoeffRequestDto = isVerhoeffRequestMapper.toIsVerhoeffRequestDto(verhoeffRequest);
        Boolean isVerhoeff = behdadIdentifierService.isVerhoeff(isVerhoeffRequestDto);
        return ResponseEntity.ok(isVerhoeff);*/
        return null;
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
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = Boolean.class)
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
    @GetMapping(path = "/isValid/identifierCode/{identifierCode}/accountNumber/{accountNumber}/transactionAmount/{transactionAmount}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> isValidIdentifier(@PathVariable String identifierCode, @PathVariable String accountNumber,
                                               @PathVariable BigDecimal transactionAmount) {

/*        Boolean isValid = behdadIdentifierService
                .isValidIdentifier(identifierCode, accountNumber, transactionAmount);
        return ResponseEntity.ok(isValid);*/
        return null;
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
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = Boolean.class)
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
    @GetMapping(path = "/isEffective/identifierCode/{identifierCode}/accountNumber/{accountNumber}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> isEffectiveIdentifier(@PathVariable String identifierCode, @PathVariable String accountNumber) {

/*        Boolean isEffective = behdadIdentifierService
                .isEffectiveIdentifier(identifierCode, accountNumber);
        return ResponseEntity.ok(isEffective);*/
        return null;
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
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = Boolean.class)
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
    @GetMapping(path = "/isExist/identifierCode/{identifierCode}/accountNumber/{accountNumber}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> isExistIdentifier(@PathVariable String identifierCode, @PathVariable String accountNumber) {

/*        Boolean isEffective = behdadIdentifierService
                .isExistIdentifier(identifierCode, accountNumber);
        return ResponseEntity.ok(isEffective);*/
        return null;
    }


    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadidentifiers",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = IdentifierIsVerhoeffRequest.class))
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
    @PostMapping(path = "/addIdentifier",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> addIdentifier(@RequestBody IdentifierInfoRequest identifierInfoRequest) {


        //    void addIdentifier(IdentifierInfoDto identifierInfoDto); do not uncomment
/*        IdentifierInfoDto identifierInfoDto = identifierInfoMapper.toIdentifierInfoDto(identifierInfoRequest);
        behdadIdentifierService.addIdentifier(identifierInfoDto);
        return ResponseEntity.ok("Success");*/
        return null;
    }


    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadidentifiers",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = IdentifierIsVerhoeffRequest.class))
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
                                            schema = @Schema(implementation = IdentifierResultResponse.class)
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
    @PostMapping(path = "/addIdentifiers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> addIdentifiers(@RequestBody BatchIdentifierInfoRequest batchIdentifierInfo) {

/*        BatchIdentifierInfoDto batchIdentifierInfoDto = batchIdentifierInfoMapper
                .toBatchIdentifierInfoDto(batchIdentifierInfo);
        List<IdentifierResultDto> identifierResultDtos = behdadIdentifierService
                .addIdentifiers(batchIdentifierInfoDto);
        final List<IdentifierResult> identifierResults = identifierResultMapper
                .toIdentifierResults(identifierResultDtos);
        return ResponseEntity.ok(identifierResults);*/
        return null;
    }


    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadidentifiers",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = IdentifierGenerateIdentifierByOrganRequest.class))
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
    @PostMapping(path = "/generateIdentifierByOrganInfo",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> generateIdentifierByOrganInfo(){
//            (@RequestBody GenerateIdentifierByOrganRequest generateIdentifierByOrganRequest) {

/*        GenerateIdentifierByOrganRequestDto generateIdentifierByOrganRequestDto = generateIdentifierByOrganRequestMapper
                .toGenerateIdentifierByOrganRequestDto(generateIdentifierByOrganRequest);
        String returnValue = behdadIdentifierService
                .generateIdentifierByOrganInfo(generateIdentifierByOrganRequestDto);
        return ResponseEntity.ok(returnValue);*/
        return null;
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
    @DeleteMapping(path = "/removeIdentifier/identifierCode/{identifierCode}/accountNumber/{accountNumber}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> removeIdentifier(@PathVariable String identifierCode, @PathVariable String accountNumber) {

/*        behdadIdentifierService
                .removeIdentifier(identifierCode, accountNumber);
        return ResponseEntity.ok("identifierRemoved");*/
        return null;
    }


    @Operation(
            summary = "Bank Transactions Details",
            description = "Behdad Bank Transactions Details",
            tags = "behdadidentifiers",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = BatchIdentifierRemoveInfoRequest.class))
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
                                            schema = @Schema(implementation = IdentifierRemoveResultResponse.class)
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
    @PostMapping(path = "/removeIdentifiers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> removeIdentifiers(){
//            (@RequestBody BatchIdentifierRemoveInfo batchIdentifierRemoveInfo) {

/*        BatchIdentifierRemoveInfoDto batchIdentifierRemoveInfoDto = batchIdentifierRemoveInfoMapper
                .toBatchIdentifierRemoveInfoDto(batchIdentifierRemoveInfo);
        List<IdentifierRemoveResultDto> identifierRemoveResultDtos = behdadIdentifierService
                .removeIdentifiers(batchIdentifierRemoveInfoDto);
        List<IdentifierRemoveResult> identifierRemoveResults = identifierRemoveResultMapper
                .toIdentifierRemoveResults(identifierRemoveResultDtos);
        return ResponseEntity.ok(identifierRemoveResults);*/
        return null;
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
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = IdentifierDetailResponse.class)
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
    @GetMapping(path = "/getActiveIdentifiers/accountNumber/{accountNumber}/startShamsiDate/{startShamsiDate}/endShamsiDate/{endShamsiDate}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getActiveIdentifiers(@PathVariable String identifierCode, @PathVariable String startShamsiDate,
                                                  @PathVariable String endShamsiDate) {

/*        List<IdentifierDetailDto> identifierDetailDtos = behdadIdentifierService
                .getActiveIdentifiers(identifierCode, startShamsiDate, endShamsiDate);
        List<IdentifierDetail> identifierDetails = identifierDetailMapper
                .toIdentifierDetails(identifierDetailDtos);
        return ResponseEntity.ok(identifierDetails);*/
        return null;
    }

}
