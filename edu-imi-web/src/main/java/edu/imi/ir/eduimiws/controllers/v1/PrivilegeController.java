package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.crm.PrivilegeResponseAssembler;
import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PrivilegeFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PrivilegeFastDto;
import edu.imi.ir.eduimiws.models.request.PrivilegeForm;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.PrivilegeResponse;
import edu.imi.ir.eduimiws.services.crm.PrivilegeApiService;
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
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/v1/privileges")
@RequiredArgsConstructor
@Tag(name = "privileges", description = "The privilege API")
public class PrivilegeController {

    private final PrivilegeApiService privilegeApiService;
    private final PrivilegeFastDtoMapper privilegeFastDtoMapper;
    private final PrivilegeResponseAssembler privilegeResponseAssembler;
    private final PagedResourcesAssembler<PrivilegeFastDto> privilegePagedResourcesAssembler;

    @Operation(
            summary = "find All privileges",
            description = "Search privilege detail pageable",
            tags = "privileges",
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
                                            schema = @Schema(implementation = PrivilegeResponse.class)
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
    public ResponseEntity<PagedModel<PrivilegeResponse>> getPrivileges(@Parameter(hidden = true)
                                                             @SortDefault(sort = "createDateTs", direction = Sort.Direction.DESC)
                                                             @PageableDefault(page = 0, size = 10, value = 10)
                                                                     Pageable pageable) {

        Page<PrivilegeApiEntity> privilegePages =
                privilegeApiService.findAllPrivilegeEntityPagesOrderByCreateDateDesc(pageable);

        Page<PrivilegeFastDto> privilegeFastDtoPage = privilegePages
                .map(p -> privilegeFastDtoMapper
                        .toPrivilegeFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PrivilegeResponse> privilegeResponsePagedModel = privilegePagedResourcesAssembler
                .toModel(privilegeFastDtoPage, privilegeResponseAssembler);

        return ResponseEntity.ok(privilegeResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PrivilegeResponse>> getAllPrivileges(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDateTs", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PrivilegeApiEntity> privilegePages =
                privilegeApiService.findAllPrivilegeEntityPagesOrderByCreateDateDesc(pageable);

        List<PrivilegeApiEntity> privilegeEntities = StreamSupport
                .stream(privilegePages.spliterator(), false)
                .collect(Collectors.toList());

        List<PrivilegeFastDto> privilegeFastDtos = privilegeFastDtoMapper
                .toPrivilegeFastDtos(privilegeEntities,new CycleAvoidingMappingContext());

        CollectionModel<PrivilegeResponse> privilegeResponseCollectionModel =
                privilegeResponseAssembler.toCollectionModel(privilegeFastDtos);

        return ResponseEntity.ok(privilegeResponseCollectionModel);
    }

    @Operation(
            summary = "Find Privilege by public ID",
            description = "Search privilege by the public id",
            tags = "privileges",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PrivilegeResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "student not found",
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
    @GetMapping(path = "/{privilegePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPrivilegeByPrivilegePublicId(@PathVariable String privilegePublicId) {

            PrivilegeApiEntity privilegeApi = privilegeApiService.findByPrivilegePublicId(privilegePublicId);
            if (privilegeApi == null) {
                throw new NotFoundException("requested privilege not found");
            }

            PrivilegeFastDto privilegeFastDto = privilegeFastDtoMapper
                    .toPrivilegeFastDto(privilegeApi, new CycleAvoidingMappingContext());

            PrivilegeResponse privilegeResponse =
                    privilegeResponseAssembler.toModel(privilegeFastDto);

            return ResponseEntity.ok(privilegeResponse);

    }

    @Operation(
            hidden = true,
            summary = "Create Privilege",
            description = "Privilege ",
            tags = "privileges",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PrivilegeResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Not Acceptable",
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
    @PostMapping(path = "/new",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPrivilege(@RequestBody PrivilegeForm privilegeForm) {

        PrivilegeResponse returnValue = new PrivilegeResponse();
        PrivilegeApiEntity savedPrivilege = new PrivilegeApiEntity();

        String privilegeName = privilegeForm.getPrivilegeName();

        savedPrivilege = privilegeApiService.createPrivilegeByName(privilegeName);

        returnValue.setPrivilegePublicId(savedPrivilege.getPrivilegePublicId());
        returnValue.setName(savedPrivilege.getName());

        return ResponseEntity.ok(returnValue);
    }

}
