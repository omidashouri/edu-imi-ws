package edu.imi.ir.eduimiws.controllers.hamkaran.v1;

import edu.imi.ir.eduimiws.mapper.hamkaran.HamkaranAuthenticationTokenResponseMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.hamkaran.HamkaranDeletedFinancialResponseMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.hamkaran.HamkaranFinancialResponseMapper;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranAuthenticationTokenDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranDeletedFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranFinancialResponseDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranAuthenticationTokenResponse;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranDeletedFinancialResponse;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranFinancialResponse;
import edu.imi.ir.eduimiws.services.hamkaran.HamkaranService;
import edu.imi.ir.eduimiws.utilities.SwaggerUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


//    Done: get the financial records from erp
//      1-VoucherListItemsApiResponse
//      2-VoucherListItemsResponseMapper
//      3-VoucherListItemsApiResponseMapper
//    ---
//    Done: get the delete records by request from api
//      1-HamkaranDeletedVoucherDeleteItemsApiDtoMapper
//      2-HamkaranDeletedFinancialResponseMapper
//      3-searchHamkaranDeletedFinancialResponseBySearchQuery
//      4-HamkaranServiceimpl → searchHamkaranDeletedFinancialResponseBySearchQuery
//      5-HamkaranController → getDeletedFinancialBySearchQuery
//    Done: get the delete records by request from erp
//    ---
//    Done: get the last record from voucherItems by
//     1-create Date
//     2-edit Date
//     3-delete Date
//    ---
//    Done: get the last record from DeletedItems by
//     1-order by IdApi
//    ---
//    Done: get the last record from HamkaranVoucherItems by
//     1-operand=greater,operand_target=create,last_create_date=?,limit=1000
//     2-operand=greater,operand_target=edit,last_edit_date=?,limit=1000
//    ---
//    Done: get the last record from HamkaranDeletedItems by
//     1-deletedVoucherID=?  → return list of record grater than ?
//    ---
//    todo: update delete records by request from api
//        1-get the record of last inserted record, from erp
//        2-get the records after last inserted record from api
//        3-insert new records to the erp
//        4-insert the last new id and function name and date to check table erp
//    ---
//    todo: get the max create date from api
//    todo: get the max create date from check table erp
//    todo: compare and insert the new record in database
//    todo: insert the last new id and function name and date to check table erp
//    ---
//    todo: get the max create date from api
//    todo: get the max create date from check table erp
//    todo: compare and insert the new record in erp
//    todo: insert the last new id and function name and date to check table erp
//     ---
//    todo: get the max edit date by request
//    todo: get the max edit date from check table erp
//    todo: compare and insert the new record in erp
//    todo: insert the last new id and function name and date to check table erp
//    ---
//    todo: read new api from old erp

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/hamkarans")
@RequiredArgsConstructor
@Tag(name = "Hamkarans", description = "The hamkaran API")
public class HamkaranController {

    private final HamkaranService hamkaranService;
    private final HamkaranFinancialResponseMapper hamkaranFinancialResponseMapper;
    private final HamkaranAuthenticationTokenResponseMapper hamkaranAuthenticationTokenResponseMapper;
    private final HamkaranDeletedFinancialResponseMapper hamkaranDeletedFinancialResponseMapper;


    @Operation(
            summary = "hamkaran get token",
            description = "hamkaran get token",
            security = @SecurityRequirement(name = "imi-security-key"),
            tags = "HamkaranAuthenticationTokenResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = HamkaranAuthenticationTokenResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "authentication token not found",
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
    @GetMapping(path = "/token",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> authenticationGetToken(@RequestParam(name = "code") String code) {

        HamkaranAuthenticationTokenDto hamkaranAuthenticationTokenDto = new HamkaranAuthenticationTokenDto();
        hamkaranAuthenticationTokenDto.setCode(code);

        hamkaranAuthenticationTokenDto = hamkaranService.getToken(hamkaranAuthenticationTokenDto);

        HamkaranAuthenticationTokenResponse hamkaranAuthenticationTokenResponse = hamkaranAuthenticationTokenResponseMapper
                .hamkaranAuthenticationTokenDtoToResponse(hamkaranAuthenticationTokenDto);

        return ResponseEntity.ok(hamkaranAuthenticationTokenResponse);
    }


    @Operation(
            summary = "hamkaran get financial",
            description = "hamkaran get financial",
            security = @SecurityRequirement(name = "imi-security-key"),
            tags = "HamkaranFinancialResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = HamkaranFinancialResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "authentication token not found",
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
    @GetMapping(path = "/financial/searchQuery",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFinancialBySearchQuery(@RequestParam Optional<String> limit,
                                                                                   @RequestParam Optional<String> salemali,
                                                                                   @RequestParam Optional<String> createDateTime,
                                                                                   @RequestParam Optional<String> editDateTime,
                                                                                   @Parameter(hidden = true) @RequestParam Map<String, String> allParams
    ) {

//        https://sanati.imi.ir/api/v1/fin/filter?limit=50&salemali=1400&datetime_create=2021-04-14T08:28:21.353&datetime_edit=2021-04-14T08:43:36.32

        HamkaranFinancialResponseDto hamkaranFinancialResponseDto = new HamkaranFinancialResponseDto();
        String searchQuery = allParams.keySet().stream()
                .filter(Objects::nonNull)
                .map(key -> key + "=" + allParams.get(key))
                .collect(Collectors.joining("&"));

/*        String searchString = "";
        if (limit != null) {
            searchString = completeSearchString(searchString, "limit", limit.get());
        }
        if (salemali.isPresent()) {
            searchString = completeSearchString(searchString, "salemali", salemali.get());
        }
        if (createDateTime.isPresent()) {
            searchString = completeSearchString(searchString, "createDateTime", createDateTime.get());
        }
        if (editDateTime.isPresent()) {
            searchString = completeSearchString(searchString, "editDateTime", editDateTime.get());
        }*/

        hamkaranFinancialResponseDto.setSearchQuery(searchQuery);

        hamkaranFinancialResponseDto = hamkaranService
                .searchHamkaranFinancialResponseBySearchQuery(hamkaranFinancialResponseDto);

        return ResponseEntity.ok(hamkaranFinancialResponseDto);
    }



    @Operation(
            summary = "hamkaran get financial",
            description = "hamkaran get financial",
            security = @SecurityRequirement(name = "imi-security-key"),
            tags = "HamkaranFinancialResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = HamkaranFinancialResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "authentication token not found",
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
    @SwaggerUtil.HamkaranGreaterThanDateTimeAsQueryParam
    @GetMapping(path = "/financial/greaterThanDateTime",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFinancialGreaterThanFromCreateDateTime(@Parameter(hidden = true)
                                                                           @RequestParam Map<String, String> allParams
    ) {

/*        1-https://sanati.imi.ir/api/v1/fin/filter?operand=greater&operand_target=create&datetime_create=2022-02-02T12:39:52.933&limit=1000
          2-operand=greater,operand_target=edit,last_edit_date=?,limit=1000*/

        HamkaranFinancialResponseDto hamkaranFinancialResponseDto = new HamkaranFinancialResponseDto();
        String searchQuery = allParams.keySet().stream()
                .filter(Objects::nonNull)
                .map(key -> key + "=" + allParams.get(key))
                .collect(Collectors.joining("&"));

        hamkaranFinancialResponseDto.setSearchQuery(searchQuery);

        hamkaranFinancialResponseDto = hamkaranService
                .searchHamkaranFinancialResponseBySearchQuery(hamkaranFinancialResponseDto);

        return ResponseEntity.ok(hamkaranFinancialResponseDto);
    }




    @Operation(
            summary = "hamkaran get financial deleted",
            description = "hamkaran get financial deleted",
            security = @SecurityRequirement(name = "imi-security-key"),
            tags = "HamkaranDeletedFinancialResponse",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = HamkaranDeletedFinancialResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "authentication token not found",
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
    @SwaggerUtil.HamkaranDeletedFinancialAsQueryParam
    @GetMapping(path = "/deletedFinancial/searchQuery",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getDeletedFinancialBySearchQuery(@Parameter(hidden = true)
                                                              @RequestParam Map<String, String> allParams
    ) {

//        https://sanati.imi.ir/api/v1/fin/Deleted?deletedVoucherID=977&limit=100

        HamkaranDeletedFinancialResponseDto hamkaranDeletedFinancialResponseDto = new HamkaranDeletedFinancialResponseDto();
        HamkaranDeletedFinancialResponse hamkaranDeletedFinancialResponse;

        String searchQuery = allParams.keySet().stream()
                .filter(Objects::nonNull)
                .map(key -> key + "=" + allParams.get(key))
                .collect(Collectors.joining("&"));

        hamkaranDeletedFinancialResponseDto.setSearchQuery(searchQuery);

        hamkaranDeletedFinancialResponseDto = hamkaranService
                .searchHamkaranDeletedFinancialResponseBySearchQuery(hamkaranDeletedFinancialResponseDto);

        hamkaranDeletedFinancialResponse = hamkaranDeletedFinancialResponseMapper
                .hamkaranDeletedFinancialResponseDtoToHamkaranDeletedFinancialResponse(hamkaranDeletedFinancialResponseDto);

        return ResponseEntity.ok(hamkaranDeletedFinancialResponse);
    }





    public String completeSearchString(String searchString, String paramKey, String paramValue) {
        if (searchString.isBlank()) {
            for (int i = 0; i < searchString.length(); i++) {
                System.out.println("sasa");

            }
            return searchString.concat("?").concat(paramKey).concat("=").concat(paramValue);
        } else {
            return searchString.concat("&").concat(paramKey).concat("=").concat(paramValue);
        }
    }
}
