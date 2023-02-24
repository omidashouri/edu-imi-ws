package edu.imi.ir.eduimiws.controllers.pmis.v1;

import edu.imi.ir.eduimiws.assemblers.pmis.ProjectResponseAssembler;
import edu.imi.ir.eduimiws.assemblers.pmis.ProjectResponseForPaymentCodeProjectDtoAssembler;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectResponseForPaymentCodeProjectDtoMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectResponseProjectDtoMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponseDescriptive;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponse;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponseForPaymentCode;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
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
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "projects", description = "The project API")
public class ProjectController {

    public static final String LAST_VERSION_YES = "y";
    private final ConvertorUtil convertorUtil;
    private final ProjectService projectService;
    private final ProjectResponseProjectDtoMapper projectResponseProjectDtoMapper;
    private final ProjectResponseForPaymentCodeProjectDtoMapper projectResponseForPaymentCodeProjectDtoMapper;
    private final ProjectFastMapper projectFastMapper;
    private final ProjectResponseAssembler projectResponseAssembler;
    private final PagedResourcesAssembler<ProjectDto> projectDtoPagedResourcesAssembler;
    private final ProjectResponseForPaymentCodeProjectDtoAssembler projectResponseForPaymentCodeProjectDtoAssembler;

    @Operation(
            summary = "find All projects",
            description = "Search project detail pageable",
            tags = "projects",
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
                                            schema = @Schema(implementation = ProjectResponse.class)
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
    public ResponseEntity<PagedModel<ProjectResponse>> getProjects(@Parameter(hidden = true)
                                                                   @SortDefault(sort = "createDate",
                                                                           direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {

        Page<ProjectEntity> projectPages =
                projectService.findAllProjectEntityPages(pageable);

        Page<ProjectDto> projectFastDtoPage = projectPages
                .map(cp -> projectFastMapper
                        .toProjectDto(cp, new CycleAvoidingMappingContext()));

        PagedModel<ProjectResponse> projectResponsePagedModel = projectDtoPagedResourcesAssembler
                .toModel(projectFastDtoPage, projectResponseAssembler);

        return ResponseEntity.ok(projectResponsePagedModel);
    }


    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<ProjectResponse>> getAllProjects(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<ProjectEntity> projectPages =
                projectService.findAllProjectEntityPages(pageable);

        List<ProjectEntity> projectEntities = StreamSupport
                .stream(projectPages.spliterator(), false)
                .collect(Collectors.toList());

        List<ProjectDto> projectFastDtos = projectFastMapper
                .toProjectDtos(projectEntities, new CycleAvoidingMappingContext());

        CollectionModel<ProjectResponse> projectResponseCollectionModel =
                projectResponseAssembler.toCollectionModel(projectFastDtos);

        return ResponseEntity.ok(projectResponseCollectionModel);
    }

    @Operation(
            summary = "Find Project by public ID",
            description = "Search project by the public id",
            tags = "projects",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectResponse.class)
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
    @GetMapping(path = "/{projectPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectByProjectPublicId(@PathVariable String projectPublicId) {

        ProjectEntity project = projectService.findProjectEntityByProjectApiPublicId(projectPublicId);
        if (project == null) {
            throw new NotFoundException("requested project not found");
        }

        ProjectDto projectFastDto =
                projectFastMapper.toProjectDto(project, new CycleAvoidingMappingContext());

        ProjectResponse projectResponse =
                projectResponseAssembler.toModel(projectFastDto);

        return ResponseEntity.ok(projectResponse);

    }


    @Operation(
            summary = "Find Project by Project Public Id",
            description = "Search project by by Project Public Id",
            tags = "projects",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectResponse.class)
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
    @GetMapping(path = "/lastVersionByProjectCode",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectLastVersionByProjectCode(@RequestParam("projectCode") String projectCode) {

        if (projectCode == null || projectCode.length() < 8) {
            throw new NotAcceptableException("project code must contain eight digit");
        }

        ProjectDto projectDto = projectService
                .findProjectDtoByProjectCodeAndLastVersion(projectCode, LAST_VERSION_YES);

            /*Page<ProjectEntity> projectPages =
                    projectService.findAllByPredicate(expression, pageable);

            Page<ProjectDto> projectFastDtoPage = projectPages
                    .map(cp -> projectFastMapper
                            .toProjectDto(cp, new CycleAvoidingMappingContext()));

            PagedModel<ProjectResponse> projectResponsePagedModel = projectPagedResourcesAssembler
                    .toModel(projectFastDtoPage, projectResponseAssembler);*/

        if (projectDto == null)
            throw new NotFoundException(String.format("Not Found Any Project with project Code: %s", projectCode));

        ProjectResponse projectResponse =
                projectResponseAssembler.toModel(projectDto);

        projectResponseProjectDtoMapper.characterEncodingPersianForProjectName(projectResponse, convertorUtil);

        return ResponseEntity.ok(projectResponse);
    }


    @Operation(
            hidden = true,
            summary = "find All projects for payment codes",
            description = "Search projects for payment code detail pageable",
            tags = "projects",
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
                                            schema = @Schema(implementation = ProjectResponseForPaymentCode.class)
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
    @DisableMethod
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/forPaymentCodes",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectResponseForPaymentCode>> getProjectsForPaymentCode(@Parameter(hidden = true)
                                                                                               @SortDefault(sort = "projectName",
                                                                                                       direction = Sort.Direction.DESC)
                                                                                               @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                       Pageable pageable) {

        Page<ProjectDto> projectDtoPages =
                projectService.findAllPageableProjectForPaymentCode(pageable);

        PagedModel<ProjectResponseForPaymentCode> projectResponseForPaymentCodePagedModel = projectDtoPagedResourcesAssembler
                .toModel(projectDtoPages, projectResponseForPaymentCodeProjectDtoAssembler);

        projectResponseForPaymentCodePagedModel.getContent().forEach(projectResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(projectResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(projectResponseForPaymentCodePagedModel);
    }

    @Operation(
            hidden = true,
            summary = "Find Project for payment code by public ID",
            description = "Search project for payment code by the public id",
            tags = "projects",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectResponseForPaymentCode.class)
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
    @DisableMethod
    @GetMapping(path = "/publicId/{projectPublicId}/forPaymentCode",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectByProjectPublicIdForPaymentCode(@PathVariable String projectPublicId) {


        String projectPublicIdDbChar = convertorUtil.getDbCharAndNum(projectPublicId);

        ProjectEntity project = projectService.findProjectEntityByProjectApiPublicId(projectPublicIdDbChar);
        if (project == null) {
            throw new NotFoundException("requested project not found");
        }

        ProjectDto projectDto =
                projectFastMapper.toProjectDto(project, new CycleAvoidingMappingContext());

        ProjectResponseForPaymentCode projectResponseForPaymentCode =
                projectResponseForPaymentCodeProjectDtoAssembler.toModel(projectDto);

        return ResponseEntity.ok(projectResponseForPaymentCode);

    }

    @Operation(
            hidden = true,
            summary = "find All project for payment code parameterized",
            description = "Search project for payment code pageable parameterized",
            tags = "projects",
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
    @DisableMethod
    @SwaggerUtil.ProjectResponseForPaymentCodeAsQueryParam
    @GetMapping(path = "/forPaymentCodes/parameterized",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectResponseForPaymentCode>> getProjectResponseForPaymentCodeWithParameter(@Parameter(hidden = true)
                                                                                                @RequestParam Map<String, String> queryParams) {


        Page<ProjectDto> projectDtos =
                projectService.findAllPageableProjectForPaymentCodeByQueryParam(queryParams);

        PagedModel<ProjectResponseForPaymentCode> paymentCodeResponseDescriptivesPagedModel = projectDtoPagedResourcesAssembler
                .toModel(projectDtos, projectResponseForPaymentCodeProjectDtoAssembler);

        paymentCodeResponseDescriptivesPagedModel.getContent().forEach(projectResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(projectResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(paymentCodeResponseDescriptivesPagedModel);
    }




    @Operation(
            summary = "find All projects for Deposit code Api",
            description = "Search projects for Deposit code Api pageable",
            tags = "projects",
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
                                            schema = @Schema(implementation = ProjectResponseForPaymentCode.class)
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
    @GetMapping(path = "/forDepositCodeApi",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectResponseForPaymentCode>> getProjectsForDepositCode(@Parameter(hidden = true)
                                                                                               @SortDefault(sort = "projectName",
                                                                                                       direction = Sort.Direction.DESC)
                                                                                               @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                       Pageable pageable) {

        Page<ProjectDto> projectDtoPages =
                projectService.findAllPageableProjectForPaymentCode(pageable);

        PagedModel<ProjectResponseForPaymentCode> projectResponseForPaymentCodePagedModel = projectDtoPagedResourcesAssembler
                .toModel(projectDtoPages, projectResponseForPaymentCodeProjectDtoAssembler);

        projectResponseForPaymentCodePagedModel.getContent().forEach(projectResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(projectResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(projectResponseForPaymentCodePagedModel);
    }



    @Operation(
            summary = "find All project for Deposit code Api parameterized",
            description = "Search project for Deposit code Api pageable parameterized",
            tags = "projects",
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
    @SwaggerUtil.ProjectResponseForPaymentCodeAsQueryParam
    @GetMapping(path = "/forDepositCodeApi/parameterized",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectResponseForPaymentCode>> getProjectResponseForDepositCodeApiWithParameter(@Parameter(hidden = true)
                                                                                                                   @RequestParam Map<String, String> queryParams) {


        Page<ProjectDto> projectDtos =
                projectService.findAllPageableProjectForPaymentCodeByQueryParam(queryParams);

        PagedModel<ProjectResponseForPaymentCode> paymentCodeResponseDescriptivesPagedModel = projectDtoPagedResourcesAssembler
                .toModel(projectDtos, projectResponseForPaymentCodeProjectDtoAssembler);

        paymentCodeResponseDescriptivesPagedModel.getContent().forEach(projectResponseForPaymentCode -> {
            convertorUtil.changeInstanceCharAndNumSetByType(projectResponseForPaymentCode, "persian");
        });

        return ResponseEntity.ok(paymentCodeResponseDescriptivesPagedModel);
    }



}
