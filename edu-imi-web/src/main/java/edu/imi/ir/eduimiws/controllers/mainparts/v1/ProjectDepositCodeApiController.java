package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.ProjectDepositCodeApiResponseAssembler;
import edu.imi.ir.eduimiws.assemblers.mainparts.ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler;
import edu.imi.ir.eduimiws.assemblers.mainparts.ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiProjectionCustomThreeMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiProjectionCustomTwoMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiRequestMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomThreeDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponse;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomThree;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponseCustomTwo;
import edu.imi.ir.eduimiws.services.mainparts.ProjectDepositCodeApiService;
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
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER','ROLE_PROJECTDEPOSITCODE')")
@RestController
@RequestMapping("/api/v1/projectDepositCodeApis")
@RequiredArgsConstructor
@Tag(name = "projectDepositCodeApis", description = "Project Deposit Code API")
public class ProjectDepositCodeApiController {

    private final ProjectDepositCodeApiService projectDepositCodeApiService;
    private final ProjectDepositCodeApiResponseAssembler projectDepositCodeApiResponseAssembler;
    private final PagedResourcesAssembler<ProjectDepositCodeApiDto> projectDepositCodeApiDtoPagedResourcesAssembler;
    private final ProjectDepositCodeApiRequestMapper depositCodeApiRequestMapper;
    private final ProjectDepositCodeApiMapper projectDepositCodeApiMapper;
    private final ProjectDepositCodeApiProjectionCustomTwoMapper projectDepositCodeApiProjectionCustomTwoMapper;
    private final ProjectDepositCodeApiProjectionCustomThreeMapper projectDepositCodeApiProjectionCustomThreeMapper;
    private final ProjectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler;
    private final ProjectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler;
    private final PagedResourcesAssembler<ProjectDepositCodeApiProjectionCustomTwoDto> projectDepositCodeApiProjectionCustomTwoDtoDtoPagedResourcesAssembler;
    private final PagedResourcesAssembler<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtoPagedResourcesAssembler;
    private final PersonMapper personMapper;
    private final CommonUtils commonUtils;
    private final ConvertorUtil convertorUtil;


    @Operation(
            summary = "Find  Project Deposit Code Api By public ID",
            description = "Search Project Deposit Code by the public id",
            tags = "projectDepositCodeApi",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Project Deposit Code not found",
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
    @GetMapping(path = "/publicId/{publicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getByPublicId(@PathVariable String publicId) {

        ProjectDepositCodeApiDto projectDepositCodeApiDto =
                projectDepositCodeApiService.findProjectDepositCodeApiDtoByPublicId(publicId);

        if (projectDepositCodeApiDto == null) {
            throw new NotFoundException("requested project deposit code api not found");
        }

        ProjectDepositCodeApiResponse projectDepositCodeApiResponse =
                projectDepositCodeApiResponseAssembler.toModel(projectDepositCodeApiDto);

        changeInstanceToPersianCharAndNum(List.of(projectDepositCodeApiResponse));

        return ResponseEntity.ok(projectDepositCodeApiResponse);
    }


    @Operation(
            summary = "Create Project Deposit Code Api Response by Project Public Id and deposit code and description ",
            description = "Create Project Deposit Code Api Response by Project Public Id and deposit code and description",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = ProjectDepositCodeApiRequest.class))
            )
    )
    @Tags(value = {
            @Tag(name = "projectDepositCodeApis")

    })
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "depositCode not found",
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
    @PostMapping(path = "/projectDepositCodeApiRequest",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createProjectDepositCodeApiRequest(@RequestBody ProjectDepositCodeApiRequest projectDepositCodeApiRequest) {


        projectDepositCodeApiService.validateProjectDepositCodeApiRequestNullInputs(projectDepositCodeApiRequest);

        ProjectDepositCodeApiDto projectDepositCodeApiDto = depositCodeApiRequestMapper
                .toProjectDepositCodeApiDto(projectDepositCodeApiRequest);

//        todo: optional add validate depositCode
        projectDepositCodeApiService.validateProjectDepositCodeApiDtoNulls(projectDepositCodeApiDto);

        projectDepositCodeApiMapper.setPublicIdCreatorCreateDateTs(projectDepositCodeApiDto, personMapper);

        ProjectDepositCodeApiDto savedProjectDepositCodeApiDto =
                projectDepositCodeApiService.save(projectDepositCodeApiDto);

        ProjectDepositCodeApiResponse projectDepositCodeApiResponse =
                projectDepositCodeApiResponseAssembler.toModel(savedProjectDepositCodeApiDto);

        //        todo: optional for sending SMS

        changeInstanceToPersianCharAndNum(List.of(projectDepositCodeApiResponse));

        return ResponseEntity.ok(projectDepositCodeApiResponse);
    }


    @Operation(
            summary = "find All Project Deposit Codes",
            description = "Search projectDepositCode detail pageable",
            tags = "projectDepositCodeApis",
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
                                            schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
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
    @GetMapping(path = "/all",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponse>> getProjectDepositCodes(@Parameter(hidden = true)
                                                                                            @SortDefault(sort = "id",
                                                                                                    direction = Sort.Direction.DESC)
                                                                                            @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                    Pageable pageable) {

        Page<ProjectDepositCodeApiDto> projectDepositCodeApiPages = projectDepositCodeApiService.findAllAndDeleteDateTsIsNull(pageable);

        if (projectDepositCodeApiPages.getContent().isEmpty() || projectDepositCodeApiPages.getContent().size() < 1)
            throw new NotFoundException("Project Deposit Codes  Not Found");

        PagedModel<ProjectDepositCodeApiResponse> depositCodeApiResponsePagedModel =
                projectDepositCodeApiDtoPagedResourcesAssembler
                        .toModel(projectDepositCodeApiPages, projectDepositCodeApiResponseAssembler);

        changeInstanceToPersianCharAndNum(depositCodeApiResponsePagedModel.getContent());

        return ResponseEntity.ok(depositCodeApiResponsePagedModel);
    }


    @Operation(
            summary = "Find Project Deposit Code Api By Project Name",
            description = "Search ProjectDepositCodeApi by the Project Name",
            tags = "projectDepositCodeApis",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "projectName not found",
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
    @GetMapping(path = "/projectName/{projectName}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectDepositCodeApiByProjectName(@PathVariable String projectName,
                                                                   @Parameter(hidden = true)
                                                                   @SortDefault(sort = "project.projectName",
                                                                           direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {

        Page<ProjectDepositCodeApiDto> projectDepositCodeApiDtoPages = projectDepositCodeApiService
                .findByProjectNameContaining(projectName, pageable);

        if (projectDepositCodeApiDtoPages.getContent().isEmpty() || projectDepositCodeApiDtoPages.getContent().size() < 1)
            throw new NotFoundException("Project Name Not Found");

        //todo: check sort by projectName
       /* projectDepositCodeApiDtoPages.getContent().stream()
                .filter(Objects::nonNull)
                .filter(pDto->Objects.nonNull(pDto.getProjectName()))
                .sorted(Comparator.comparing(ProjectDepositCodeApiDto::getProjectName));*/

//        Collections.sort(projectDepositCodeApiDtoPages.getContent(),Comparator.comparing(ProjectDepositCodeApiDto::getProjectName));

        PagedModel<ProjectDepositCodeApiResponse> depositCodeApiResponsePagedModel = projectDepositCodeApiDtoPagedResourcesAssembler
                .toModel(projectDepositCodeApiDtoPages, projectDepositCodeApiResponseAssembler);

        changeInstanceToPersianCharAndNum(depositCodeApiResponsePagedModel.getContent());

        return ResponseEntity.ok(depositCodeApiResponsePagedModel);
    }

    @Operation(
            summary = "Delete Project Deposit Code Api By Public Id",
            description = "Delete ProjectDepositCodeApi by Public Id",
            tags = "projectDepositCodeApis",
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
    @DeleteMapping(path = "/publicId/{publicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> deleteProjectDepositCodeApiByPublicId(@PathVariable String publicId) {

        ProjectDepositCodeApiDto projectDepositCodeApiDto = projectDepositCodeApiService
                .findProjectDepositCodeApiDtoByPublicId(publicId);
        if (Objects.isNull(projectDepositCodeApiDto))
            throw new NotFoundException("Project Deposit Code Api Not Found");

        if (Objects.nonNull(projectDepositCodeApiDto.getDeleteDateTs()))
            throw new NotAcceptableException("Project Deposit Code Api Is Already Deleted");

        projectDepositCodeApiDto.setDeleteDateTs(new Timestamp(new Date().getTime()));

        ProjectDepositCodeApiDto savedProjectDepositCodeApiDto =
                projectDepositCodeApiService.save(projectDepositCodeApiDto);

        return ResponseEntity.ok("record deleted");
    }


    @Operation(
            summary = "Update Project Deposit Code Api",
            description = "Update Project Deposit Code Api",
            tags = "contacts",
            security = @SecurityRequirement(name = "imi-security-key"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = ProjectDepositCodeApiRequest.class))
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
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
    @PutMapping(path = "/projectDepositCodeApiRequest",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updateProjectDepositCodeApi(@RequestBody ProjectDepositCodeApiRequest
                                                                 projectDepositCodeApiRequest) {
        String projectDepositCodeApiPublicId = projectDepositCodeApiRequest.getPublicId();
        ProjectDepositCodeApiDto editProjectDepositCodeApiDto = new ProjectDepositCodeApiDto();

        commonUtils.nullInstanceFieldsForValues(projectDepositCodeApiRequest, List.of("string", ""));

        convertorUtil.changeInstanceCharAndNumSetByType(projectDepositCodeApiRequest, "db");

        if (projectDepositCodeApiPublicId != null) {
            editProjectDepositCodeApiDto = projectDepositCodeApiService
                    .findProjectDepositCodeApiDtoByPublicId(projectDepositCodeApiPublicId);
        }
        if (editProjectDepositCodeApiDto == null) {
            throw new NotFoundException("requested project api dto not found");
        }
        if (Objects.nonNull(editProjectDepositCodeApiDto.getDeleteDateTs()))
            throw new NotAcceptableException("Project Deposit Code Api Is Already Deleted");

        projectDepositCodeApiMapper
                .setEditorEditDateTs(editProjectDepositCodeApiDto, personMapper);

        depositCodeApiRequestMapper
                .updateProjectDepositCodeApiDto(projectDepositCodeApiRequest, editProjectDepositCodeApiDto);

        ProjectDepositCodeApiDto updatedProjectApiDto =
                projectDepositCodeApiService.save(editProjectDepositCodeApiDto);

        ProjectDepositCodeApiResponse projectDepositCodeApiResponse =
                projectDepositCodeApiResponseAssembler.toModel(updatedProjectApiDto);

        changeInstanceToPersianCharAndNum(List.of(projectDepositCodeApiResponse));

        return ResponseEntity.ok(projectDepositCodeApiResponse);
    }

    private void changeInstanceToPersianCharAndNum(Collection<ProjectDepositCodeApiResponse> content) {
        content.forEach(projectDepositCodeApi -> {
            convertorUtil.changeInstanceCharAndNumSetByType(projectDepositCodeApi, "persian");
        });
    }

    @Operation(
            summary = "find All Project Deposit Codes deleted",
            description = "Search projectDepositCodes deleted detail pageable",
            tags = "projectDepositCodeApis",
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
                                            schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
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
    @GetMapping(path = "/all/deleted",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponse>> getProjectDepositCodesDeleted(@Parameter(hidden = true)
                                                                                                   @SortDefault(sort = "id",
                                                                                                           direction = Sort.Direction.DESC)
                                                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                           Pageable pageable) {

        Page<ProjectDepositCodeApiDto> projectDepositCodeApiPages =
                projectDepositCodeApiService.findAllByDeleteDateTsNotNull(pageable);

        if (projectDepositCodeApiPages.getContent().isEmpty() || projectDepositCodeApiPages.getContent().size() < 1)
            throw new NotFoundException("Project Deposit Codes  Not Found");

        PagedModel<ProjectDepositCodeApiResponse> depositCodeApiResponsePagedModel =
                projectDepositCodeApiDtoPagedResourcesAssembler
                        .toModel(projectDepositCodeApiPages, projectDepositCodeApiResponseAssembler);

        changeInstanceToPersianCharAndNum(depositCodeApiResponsePagedModel.getContent());

        return ResponseEntity.ok(depositCodeApiResponsePagedModel);

    }


    @Operation(
            summary = "find All Project Deposit Codes Custom Two",
            description = "Search projectDepositCodeApi Custom Two detail pageable",
            tags = "projectDepositCodeApis",
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
                                            schema = @Schema(implementation = ProjectDepositCodeApiResponse.class)
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
    @GetMapping(path = "/projectDepositCodeApiResponseCustomTwo",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponseCustomTwo>> getProjectDepositCodeApiCustomTwo(
            @RequestParam("publicId") Optional<String> publicId,
            @RequestParam("depositCode") Optional<String> depositCode,
            @RequestParam("description") Optional<String> description,
            @RequestParam("createDateTs") Optional<Timestamp> createDateTs,
            @RequestParam("editDateTs") Optional<Timestamp> editDateTs,
            @RequestParam("deleteDateTs") Optional<Timestamp> deleteDateTs,
            @RequestParam("projectName") Optional<String> projectName,
            @RequestParam("projectCode") Optional<String> projectCode,
            @RequestParam("creatorFullName") Optional<String> creatorFullName,
            @RequestParam("editorFullName") Optional<String> editorFullName,
            @Parameter(hidden = true)
            @SortDefault(sort = "projectName", direction = Sort.Direction.DESC)
            @PageableDefault(page = 1, size = 50, value = 10)
                    Pageable pageable) {

        Page<ProjectDepositCodeApiProjectionCustomTwo> projectDepositCodeApiResponseCustomTwoPages =
                projectDepositCodeApiService.queryAllProjectDepositCodeApiCustomTwo(publicId.orElse(null),
                        depositCode.orElse(null),
                        description.orElse(null),
                        createDateTs.orElse(null),
                        editDateTs.orElse(null),
                        deleteDateTs.orElse(null),
                        projectName.orElse(null),
                        projectCode.orElse(null),
                        creatorFullName.orElse(null),
                        editorFullName.orElse(null), pageable);


//
        Page<ProjectDepositCodeApiProjectionCustomTwoDto> projectDepositCodeApiProjectionCustomTwoDtoPages = projectDepositCodeApiResponseCustomTwoPages
                .map(projectDepositCodeApiProjectionCustomTwoMapper::projectDepositCodeApiProjectionCustomTwoToProjectDepositCodeApiProjectionCustomTwoDto);


        PagedModel<ProjectDepositCodeApiResponseCustomTwo> projectDepositCodeApiResponseCustomTwoPagedModel = projectDepositCodeApiProjectionCustomTwoDtoDtoPagedResourcesAssembler
                .toModel(projectDepositCodeApiProjectionCustomTwoDtoPages, projectDepositCodeApiResponseCustomTwoProjectDepositCodeApiProjectionCustomTwoDtoAssembler);
        projectDepositCodeApiResponseCustomTwoPagedModel
                .forEach(projectDepositCodeApiResponseCustomTwo -> convertorUtil.makeCharacterSetPersian(projectDepositCodeApiResponseCustomTwo));
        return ResponseEntity.ok(projectDepositCodeApiResponseCustomTwoPagedModel);

    }

    @Operation(
            summary = "find All Project Deposit Codes Custom Three",
            description = "Search projectDepositCodeApi Custom Three detail pageable",
            tags = "projectDepositCodeApis",
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
                                            schema = @Schema(implementation = ProjectDepositCodeApiResponseCustomThree.class)
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
    @GetMapping(path = "/projectDepositCodeApiResponseCustomThree",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponseCustomThree>> getProjectDepositCodeApiCustomThree(
            @RequestParam("publicId") Optional<String> publicId,
            @RequestParam("depositCode") Optional<String> depositCode,
            @RequestParam("description") Optional<String> description,
            @RequestParam("createDateTs") Optional<Timestamp> createDateTs,
            @RequestParam("editDateTs") Optional<Timestamp> editDateTs,
            @RequestParam("deleteDateTs") Optional<Timestamp> deleteDateTs,
            @RequestParam("projectName") Optional<String> projectName,
            @RequestParam("projectCode") Optional<String> projectCode,
            @RequestParam("projectCreateDate") Optional<String> projectCreateDate,
            @RequestParam("projectStatusId") Optional<Long> projectStatusId,
            @RequestParam("projectTypeName") Optional<String> projectTypeName,
            @RequestParam("startDatePlan") Optional<String> startDatePlan,
            @RequestParam("endDatePlan") Optional<String> endDatePlan,
            @RequestParam("lastVersion") Optional<String> lastVersion,
            @RequestParam("statusForTimeshit") Optional<Character> statusForTimeshit,
            @RequestParam("creatorFullName") Optional<String> creatorFullName,
            @RequestParam("editorFullName") Optional<String> editorFullName,
            @RequestParam("executor") Optional<String> executor,
            @RequestParam("projectPublicId") Optional<String> projectPublicId,
            @Parameter(hidden = true)
            //@SortDefault(sort = "project.projectName", direction = Sort.Direction.DESC)
           @PageableDefault(page = 1, size = 50, value = 10)
                    Pageable pageable) {

        Page<ProjectDepositCodeApiProjectionCustomThree> projectDepositCodeApiResponseCustomThreePages =
                projectDepositCodeApiService.queryAllProjectDepositCodeApiCustomThree(publicId.orElse(null),
                        depositCode.orElse(null),
                        description.orElse(null),
                        createDateTs.orElse(null),
                        editDateTs.orElse(null),
                        deleteDateTs.orElse(null),
                        projectName.orElse(null),
                        projectCode.orElse(null),
                        projectCreateDate.orElse(null),
                        projectStatusId.orElse(null),
                        projectTypeName.orElse(null),
                        startDatePlan.orElse(null),
                        endDatePlan.orElse(null),
                        lastVersion.orElse(null),
                        statusForTimeshit.orElse(null),
                        creatorFullName.orElse(null),
                        editorFullName.orElse(null),
                        executor.orElse(null),
                        projectPublicId.orElse(null),pageable);

        Page<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtoPages =
                projectDepositCodeApiResponseCustomThreePages
                        .map(projectDepositCodeApiProjectionCustomThreeMapper::projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto);


/*        projectDepositCodeApiProjectionCustomThreeDtoPages.getContent().stream()
         .sorted(Comparator.comparing(ProjectDepositCodeApiProjectionCustomThreeDto::getDepositCode,
                Comparator.nullsFirst(Comparator.naturalOrder())));*/

        /*Pageable.unpaged();
        List<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtos =
                projectDepositCodeApiProjectionCustomThreeDtoPages
                .getContent().stream()
                .filter(pd -> Objects.isNull(pd.getDepositCode()))
                .collect(Collectors.toList());
        PageImpl<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtos1 =
                new PageImpl<>(projectDepositCodeApiProjectionCustomThreeDtos);*/

        PagedModel<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiResponseCustomThreePagedModel =
                projectDepositCodeApiProjectionCustomThreeDtoPagedResourcesAssembler
                .toModel(projectDepositCodeApiProjectionCustomThreeDtoPages,
                        projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler);

        projectDepositCodeApiResponseCustomThreePagedModel
                .forEach(projectDepositCodeApiResponseCustomThree ->
                        convertorUtil.makeCharacterSetPersian(projectDepositCodeApiResponseCustomThree));

        return ResponseEntity.ok(projectDepositCodeApiResponseCustomThreePagedModel);
/*        List<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiResponseCustomThrees =
                projectDepositCodeApiResponseCustomThreePagedModel.getContent().stream().collect(Collectors.toList());*/
    }


    @Operation(
            summary = "find All Project Deposit Codes Custom Three Deposit Null",
            description = "Search projectDepositCodeApi Custom Three Deposit Null detail pageable",
            tags = "projectDepositCodeApis",
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
                                            schema = @Schema(implementation = ProjectDepositCodeApiResponseCustomThree.class)
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
    @GetMapping(path = "/projectDepositCodeApiResponseCustomThreeDepositNull",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponseCustomThree>> getProjectDepositCodeApiCustomThreeDepositNull(
            @RequestParam("publicId") Optional<String> publicId,
            @RequestParam("depositCode") Optional<String> depositCode,
            @RequestParam("description") Optional<String> description,
            @RequestParam("createDateTs") Optional<Timestamp> createDateTs,
            @RequestParam("editDateTs") Optional<Timestamp> editDateTs,
            @RequestParam("deleteDateTs") Optional<Timestamp> deleteDateTs,
            @RequestParam("projectName") Optional<String> projectName,
            @RequestParam("projectCode") Optional<String> projectCode,
            @RequestParam("projectCreateDate") Optional<String> projectCreateDate,
            @RequestParam("projectStatusId") Optional<Long> projectStatusId,
            @RequestParam("projectTypeName") Optional<String> projectTypeName,
            @RequestParam("startDatePlan") Optional<String> startDatePlan,
            @RequestParam("endDatePlan") Optional<String> endDatePlan,
            @RequestParam("lastVersion") Optional<String> lastVersion,
            @RequestParam("statusForTimeshit") Optional<Character> statusForTimeshit,
            @RequestParam("creatorFullName") Optional<String> creatorFullName,
            @RequestParam("editorFullName") Optional<String> editorFullName,
            @RequestParam("executor") Optional<String> executor,
            @RequestParam("projectPublicId") Optional<String> projectPublicId,
            @Parameter(hidden = true)
            //@SortDefault(sort = "project.projectName", direction = Sort.Direction.DESC)
            @PageableDefault(page = 1, size = 50, value = 10)
                    Pageable pageable) {

        Page<ProjectDepositCodeApiProjectionCustomThree> projectDepositCodeApiResponseCustomThreePages =
                projectDepositCodeApiService.queryAllProjectDepositCodeApiCustomThree(publicId.orElse(null),
                        depositCode.orElse(null),
                        description.orElse(null),
                        createDateTs.orElse(null),
                        editDateTs.orElse(null),
                        deleteDateTs.orElse(null),
                        projectName.orElse(null),
                        projectCode.orElse(null),
                        projectCreateDate.orElse(null),
                        projectStatusId.orElse(null),
                        projectTypeName.orElse(null),
                        startDatePlan.orElse(null),
                        endDatePlan.orElse(null),
                        lastVersion.orElse(null),
                        statusForTimeshit.orElse(null),
                        creatorFullName.orElse(null),
                        editorFullName.orElse(null),
                        executor.orElse(null),
                        projectPublicId.orElse(null), Pageable.unpaged());

        Page<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtoPages =
                projectDepositCodeApiResponseCustomThreePages
                        .map(projectDepositCodeApiProjectionCustomThreeMapper::projectDepositCodeApiProjectionCustomThreeToProjectDepositCodeApiProjectionCustomThreeDto);


/*        projectDepositCodeApiProjectionCustomThreeDtoPages.getContent().stream()
         .sorted(Comparator.comparing(ProjectDepositCodeApiProjectionCustomThreeDto::getDepositCode,
                Comparator.nullsFirst(Comparator.naturalOrder())));*/

        /*Pageable.unpaged();*/
        List<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtos =
                projectDepositCodeApiProjectionCustomThreeDtoPages
                .getContent().stream()
                .filter(pd -> Objects.isNull(pd.getDepositCode()))
                .collect(Collectors.toList());
        PageImpl<ProjectDepositCodeApiProjectionCustomThreeDto> projectDepositCodeApiProjectionCustomThreeDtos1 =
                new PageImpl<>(projectDepositCodeApiProjectionCustomThreeDtos);

        PagedModel<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiResponseCustomThreePagedModel =
                projectDepositCodeApiProjectionCustomThreeDtoPagedResourcesAssembler
                        .toModel(projectDepositCodeApiProjectionCustomThreeDtos1,
                                projectDepositCodeApiResponseCustomThreeProjectDepositCodeApiProjectionCustomThreeDtoAssembler);

        projectDepositCodeApiResponseCustomThreePagedModel
                .forEach(projectDepositCodeApiResponseCustomThree ->
                        convertorUtil.makeCharacterSetPersian(projectDepositCodeApiResponseCustomThree));

        return ResponseEntity.ok(projectDepositCodeApiResponseCustomThreePagedModel);
/*        List<ProjectDepositCodeApiResponseCustomThree> projectDepositCodeApiResponseCustomThrees =
                projectDepositCodeApiResponseCustomThreePagedModel.getContent().stream().collect(Collectors.toList());*/
    }
//test
}

