package edu.imi.ir.eduimiws.controllers.v2;

import edu.imi.ir.eduimiws.mapper.crm.ClientApiMapper;
import edu.imi.ir.eduimiws.models.request.ClientApiCreateRequest;
import edu.imi.ir.eduimiws.models.request.ClientApiUpdateRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.ClientApiResponse;
import edu.imi.ir.eduimiws.services.crm.ClientApiService;
import edu.imi.ir.eduimiws.utilities.SwaggerUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/v2/clients")
@RequiredArgsConstructor
@Tag(name = "Clients-Management-V2", description = "B2B API client management")
public class ClientApiController {

    private final ClientApiService clientApiService;
    private final ClientApiMapper clientApiMapper;

    @Operation(
            summary = "Create B2B client",
            description = "Creates a client linked to an existing PersonApi. "
                    + "Returns plaintext clientSecret and Base64(clientId:clientSecret) once.",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ClientApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "404", description = "Person not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientApiResponse> createClient(@RequestBody ClientApiCreateRequest request) {
        return ResponseEntity.ok(clientApiMapper.toClientApiResponse(clientApiService.create(request)));
    }

    @Operation(
            summary = "List B2B clients",
            description = "Pageable list of non-deleted clients. Client secret is never returned.",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientApiResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Page<ClientApiResponse>> getClients(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDateTs", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
            Pageable pageable) {
        Page<ClientApiResponse> page = clientApiService.findAllActive(pageable)
                .map(clientApiMapper::toClientApiResponse);
        return ResponseEntity.ok(page);
    }

    @Operation(
            summary = "Get B2B client by public ID",
            description = "Returns a non-deleted client. Client secret is never returned.",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ClientApiResponse.class))),
            @ApiResponse(responseCode = "404", description = "client not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping(path = "/{clientPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientApiResponse> getClientByPublicId(@PathVariable String clientPublicId) {
        return ResponseEntity.ok(
                clientApiMapper.toClientApiResponse(clientApiService.findByClientPublicId(clientPublicId)));
    }

    @Operation(
            summary = "Update B2B client",
            description = "Partial update. Only non-blank fields are applied "
                    + "(clientId, clientSecret, personPublicId, companyName, description, enabled).",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ClientApiResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "404", description = "client not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PutMapping(path = "/{clientPublicId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientApiResponse> updateClient(@PathVariable String clientPublicId,
                                                          @RequestBody ClientApiUpdateRequest request) {
        return ResponseEntity.ok(
                clientApiMapper.toClientApiResponse(clientApiService.update(clientPublicId, request)));
    }

    @Operation(
            summary = "Soft delete B2B client",
            description = "Sets DELETE_DATE_TS. Soft-deleted clients are excluded from list/get/login.",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = ClientApiResponse.class))),
            @ApiResponse(responseCode = "404", description = "client not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @DeleteMapping(path = "/{clientPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ClientApiResponse> deleteClient(@PathVariable String clientPublicId) {
        return ResponseEntity.ok(
                clientApiMapper.toClientApiResponse(clientApiService.softDelete(clientPublicId)));
    }
}
