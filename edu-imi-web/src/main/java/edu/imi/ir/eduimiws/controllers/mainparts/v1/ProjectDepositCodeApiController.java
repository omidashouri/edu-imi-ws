package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.ProjectDepositCodeApiResponseAssembler;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiRequestMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponse;
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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            throw new NotFoundException("requested project code api not found");
        }

        ProjectDepositCodeApiResponse projectDepositCodeApiResponse =
                projectDepositCodeApiResponseAssembler.toModel(projectDepositCodeApiDto);

        return ResponseEntity.ok(projectDepositCodeApiResponse);
    }


    @Operation(
            summary = "Create Project Deposit Code Api Response by national code and Expense Public Id and Project Public Id",
            description = "Search depositCode By Public Id and Project Public Id",
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

        ProjectDepositCodeApiDto savedProjectDepositCodeApiDto =
                projectDepositCodeApiService.save(projectDepositCodeApiDto);

//#
        ProjectDepositCodeApiResponse projectDepositCodeApiResponse =
                projectDepositCodeApiResponseAssembler.toModel(savedProjectDepositCodeApiDto);

        //        todo: optional for sending SMS
/*        if (projectDepositCodeApiRequest.getApplicantMobileNumber() != null) {
            FarapayamakSendSmsDto farapayamakSendSmsDto = paymentCodeApiDtoFarapayamakSendSmsDtoMapper
                    .paymentCodeApiDtoToFarapayamakSendSmsDto(savedPaymentCodeApiDto, farapayamakCredential);
            farapayamakSendSmsDto.setText(String.format("سازمان مدیریت صنعتی \n  شناسه پرداخت: \n %s \n بابت: %s",
                    savedPaymentCodeApiDto.getPaymentCode(), savedPaymentCodeApi.getProject().getProjectName()));

            farapayamakServiceAsync.sendSMS(farapayamakSendSmsDto);
        }*/

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
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponse>> getProjectDepositCodes(@Parameter(hidden = true)
                                                                                            @SortDefault(sort = "id",
                                                                                                    direction = Sort.Direction.DESC)
                                                                                            @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                    Pageable pageable) {

        Page<ProjectDepositCodeApiDto> projectDepositCodeApiPages = projectDepositCodeApiService.findAll(pageable);

        if (projectDepositCodeApiPages.getContent().isEmpty() || projectDepositCodeApiPages.getContent().size() < 1)
            throw new NotFoundException("Project Deposit Codes  Not Found");

        PagedModel<ProjectDepositCodeApiResponse> depositCodeApiResponsePagedModel =
                projectDepositCodeApiDtoPagedResourcesAssembler
                .toModel(projectDepositCodeApiPages, projectDepositCodeApiResponseAssembler);

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

        return ResponseEntity.ok(depositCodeApiResponsePagedModel);
    }

   /* @DeleteMapping(path = "/{deleteProjectDepositCodeApiId}",
    produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?>deleteProjectDepositCodeApiByPublicId(@PathVariable String publicId){
        projectDepositCodeApiService.findProjectDepositCodeApiDtoByPublicId(publicId);
        return ResponseEntity.ok("record deleted");
    }*/


   /* @PutMapping(path = "/forDipositCode",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updateProjectDepositCodeApiForDepositCode(@RequestBody ProjectDepositCodeApiRequest
                                                                               projectDepositCodeApiRequest) {
        String projectPublicId = projectDepositCodeApiRequest.getProjectPublicId();
        ProjectDepositCodeApiEntity editTblProjectDepositCodeApi = null;
        ProjectDepositCodeApiDto newProjectDepositCodeApiDto;

        commonUtils.nullInstanceFieldsForValues(projectDepositCodeApiRequest, List.of("string", ""));

        convertorUtil.changeInstanceCharAndNumSetByType(projectDepositCodeApiRequest, "db");

        if (projectPublicId != null) {
            editTblProjectDepositCodeApi = projectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectPublicId(projectPublicId);
        }
        if (editTblProjectDepositCodeApi == null) {
            throw new NotFoundException("requested project not found")
        }


    }*/
}
    /*   @GetMapping(path = "/all",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> allProjectDepositCodeApi() {
        List<ProjectDepositCodeApiEntity> projectDepositCodeApiEntities = projectDepositCodeApiService.findAll();
        return ResponseEntity.ok(projectDepositCodeApiEntities);
    }*/

    /*    @GetMapping(path = "/findByProjectPublicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectDepositCodeApiByProjectPublicId(@PathVariable String projectPublicId) {

        ProjectDepositCodeApiDto projectDepositCodeApiDto = projectDepositCodeApiService.findProjectDepositCodeApiDtoByProjectPublicId(projectPublicId);
        if (projectDepositCodeApiDto == null) {
            throw new NotFoundException("requested project not found");
        }

        //   ProjectDepositCodeApiDto projectDepositCodeApiDto1 = projectDepositCodeApiMapper.toProjectDepositCodeApiDto(projectDepositCodeApiDto, new CycleAvoidingMappingContext());

        return null;
    }*/

/*    public ResponseEntity<PagedModel<ProjectDepositCodeApiResponse>> getProjectDepositCodeApis(@Parameter(hidden = true)
                                                                                       @SortDefault(sort = "publicId", direction = Sort.Direction.DESC)
                                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                                               Pageable pageable) {

*//*        Page<VoucherListItemsApiEntity> voucherListItemsPages =
                voucherListItemsService.findAllByDeleteStatusIsNull(pageable);

        Page<VoucherListItemsApiDto> voucherListItemsApiDtoPage = voucherListItemsPages
                .map(voucherListItemsApiMapper::voucherListItemsApiToVoucherListItemsApiDto);

        PagedModel<VoucherListItemsApiResponse> voucherListItemsResponsePagedModel = voucherListItemsApiDtoPagedResourcesAssembler
                .toModel(voucherListItemsApiDtoPage, voucherListItemsApiResponseAssembler);

        return ResponseEntity.ok(voucherListItemsResponsePagedModel);*//*
        return ResponseEntity.ok(null);
    }*/




