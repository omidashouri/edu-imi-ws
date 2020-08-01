package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.crm.RoleResponseAssembler;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.RoleFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.RoleFastDto;
import edu.imi.ir.eduimiws.models.request.RoleForm;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.PrivilegeResponse;
import edu.imi.ir.eduimiws.models.response.crm.RoleResponse;
import edu.imi.ir.eduimiws.services.crm.RoleApiService;
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
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Tag(name = "roles", description = "The role API")
public class RoleController {

    private final RoleApiService roleApiService;
    private final RoleFastDtoMapper roleFastDtoMapper;
    private final RoleResponseAssembler roleResponseAssembler;
    private final PagedResourcesAssembler<RoleFastDto> rolePagedResourcesAssembler;


    @Operation(
            summary = "find All roles",
            description = "Search role detail pageable",
            tags = "roles",
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
                                            schema = @Schema(implementation = RoleResponse.class)
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
    public ResponseEntity<PagedModel<RoleResponse>> getRoles(@Parameter(hidden = true)
                                                                 @SortDefault(sort = "createDateTs", direction = Sort.Direction.DESC)
                                                                 @PageableDefault(page = 0, size = 10, value = 10)
                                                                         Pageable pageable) {

        Page<RoleApiEntity> rolePages =
                roleApiService.findAllRoleEntityPagesOrderByCreateDateDesc(pageable);

        Page<RoleFastDto> roleFastDtoPage = rolePages
                .map(p -> roleFastDtoMapper
                        .toRoleFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<RoleResponse> roleResponsePagedModel = rolePagedResourcesAssembler
                .toModel(roleFastDtoPage, roleResponseAssembler);

        return ResponseEntity.ok(roleResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<RoleResponse>> getAllRoles(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDateTs", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<RoleApiEntity> rolePages =
                roleApiService.findAllRoleEntityPagesOrderByCreateDateDesc(pageable);

        List<RoleApiEntity> roleEntities = StreamSupport
                .stream(rolePages.spliterator(), false)
                .collect(Collectors.toList());

        List<RoleFastDto> roleFastDtos = roleFastDtoMapper
                .toRoleFastDtos(roleEntities,new CycleAvoidingMappingContext());

        CollectionModel<RoleResponse> roleResponseCollectionModel =
                roleResponseAssembler.toCollectionModel(roleFastDtos);

        return ResponseEntity.ok(roleResponseCollectionModel);
    }


    @Operation(
            summary = "Find Role by public ID",
            description = "Search role by the public id",
            tags = "roles",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = RoleResponse.class)
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
    @GetMapping(path = "/{rolePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRoleByRolePublicId(@PathVariable String rolePublicId) {

        try {
            RoleApiEntity roleApi = roleApiService.findByRolePublicId(rolePublicId);
            if (roleApi == null) {
                return this.roleNotFound();
            }

            RoleFastDto roleFastDto = roleFastDtoMapper
                    .toRoleFastDto(roleApi, new CycleAvoidingMappingContext());

            RoleResponse roleResponse =
                    roleResponseAssembler.toModel(roleFastDto);

            return ResponseEntity.ok(roleResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Create Role",
            description = "Role ",
            tags = "roles",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = RoleResponse.class
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
    @PostMapping(path = "/new",
            consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createRole(@RequestBody RoleForm roleForm) {

        RoleResponse returnValue = new RoleResponse();
        RoleApiEntity savedRole = new RoleApiEntity();

//        omiddo: check if roleName is null return exception

        String roleName = roleForm.getRoleName();

        savedRole = roleApiService.createRoleByRoleForm(roleForm);

        returnValue.setRolePublicId(savedRole.getRolePublicId());
        returnValue.setName(savedRole.getName());

//        omiddo: handle it with mapper
        if(savedRole.getPrivileges()!=null && savedRole.getPrivileges().size()>0){
            Set<PrivilegeResponse> privilegeResponses = new HashSet<>();
            savedRole.getPrivileges().forEach(privilege->{
                PrivilegeResponse privilegeResponse = new PrivilegeResponse();
                privilegeResponse.setName(privilege.getName());
                privilegeResponse.setPrivilegePublicId(privilege.getPrivilegePublicId());
                privilegeResponses.add(privilegeResponse);
            });
            returnValue.setPrivilegeResponses(privilegeResponses);
        }
        return ResponseEntity.ok(returnValue);
    }



    private ResponseEntity<?> roleNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested role not found")
                , HttpStatus.NOT_FOUND
        );
    }



}
