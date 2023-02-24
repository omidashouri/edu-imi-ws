package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.ProjectDepositCodeApiResponseAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.ProjectDepositCodeApiRequestMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.ProjectDepositCodeApiResponse;
import edu.imi.ir.eduimiws.services.mainparts.ProjectDepositCodeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projectDepositCodeApis")
@RequiredArgsConstructor
@Tag(name = "projectDepositCodeApis", description = "Project Deposit Code API")
public class ProjectDepositCodeApiController {

    private final ProjectDepositCodeApiService projectDepositCodeApiService;
    private final ProjectDepositCodeApiResponseAssembler projectDepositCodeApiResponseAssembler;
    private final PagedResourcesAssembler<ProjectDepositCodeApiDto> projectDepositCodeApiDtoPagedResourcesAssembler;
    private final ProjectDepositCodeApiRequestMapper depositCodeApiRequestMapper;

    @GetMapping(path = "/all",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> allProjectDepositCodeApi() {
        List<ProjectDepositCodeApiEntity> projectDepositCodeApiEntities = projectDepositCodeApiService.findAll();
        return ResponseEntity.ok(projectDepositCodeApiEntities);
    }


    @Operation(
            summary = "Find  Project Deposit Code by public ID",
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


    @Operation(
            summary = "Create ProjectDepositCodeApiResponse by national code and Expense Public Id and Project Public Id",
            description = "Search paymentCode by national code and Expense Public Id and Project Public Id",
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
                            description = "paymentCode not found",
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

}
