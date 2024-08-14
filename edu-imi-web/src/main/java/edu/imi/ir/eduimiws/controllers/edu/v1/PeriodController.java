package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler;
import edu.imi.ir.eduimiws.assemblers.edu.PeriodResponsePeriodFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.InternalServerErrorException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodProjectionCustomFourMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodProjectionCustomTwoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponseCustomFourPeriodProjectionCustomFourDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomFourDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomFour;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomFour;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomTwo;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.edu.PeriodApiService;
import edu.imi.ir.eduimiws.services.edu.PeriodService;
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
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//___periodfour

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/periods")
@RequiredArgsConstructor
@Tag(name = "Periods", description = "The period API")
public class PeriodController {

    private final PeriodService periodService;
    private final UserService userService;
    private final PeriodApiService periodApiService;
    private final PeriodResponsePeriodFastDtoAssembler periodResponsePeriodFastDtoAssembler;
    private final PagedResourcesAssembler<PeriodFastDto> periodFastDtoPagedResourcesAssembler;
    private final PeriodFastDtoMapper periodFastDtoMapper;
    private final PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler periodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler;
    private final PagedResourcesAssembler<PeriodProjectionCustomTwoDto> periodProjectionCustomTwoDtoDtoPagedResourcesAssembler;
    private final PeriodProjectionCustomTwoMapper periodProjectionCustomTwoMapper;
    private final PeriodProjectionCustomFourMapper periodProjectionCustomFourMapper;
    private final PeriodResponseCustomFourPeriodProjectionCustomFourDtoMapper periodResponseCustomFourPeriodProjectionCustomFourDtoMapper;
    private final ConvertorUtil convertorUtil;

    @Operation(
            summary = "find All periods",
            description = "Search period detail pageable",
            tags = "periods",
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
                                            schema = @Schema(implementation = PeriodResponse.class)
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
    public ResponseEntity<PagedModel<PeriodResponse>> getPeriods(@Parameter(hidden = true)
                                                                 @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                 @PageableDefault(page = 0, size = 10, value = 10)
                                                                         Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllByDeleteStatusEqualsOneAndOrderPageable(pageable);

        Page<PeriodFastDto> periodFastDtoPage = periodPages
                .map(p -> periodFastDtoMapper
                        .toPeriodFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodResponse> periodResponsePagedModel = periodFastDtoPagedResourcesAssembler
                .toModel(periodFastDtoPage, periodResponsePeriodFastDtoAssembler);

        return ResponseEntity.ok(periodResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PeriodResponse>> getAllPeriods(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllByDeleteStatusEqualsOneAndOrderPageable(pageable);

        List<PeriodEntity> periodEntities = StreamSupport
                .stream(periodPages.spliterator(), false)
                .collect(Collectors.toList());

        List<PeriodFastDto> periodFastDtos = periodFastDtoMapper
                .toPeriodFastDtos(periodEntities, new CycleAvoidingMappingContext());

        CollectionModel<PeriodResponse> periodResponseCollectionModel =
                periodResponsePeriodFastDtoAssembler.toCollectionModel(periodFastDtos);

        return ResponseEntity.ok(periodResponseCollectionModel);
    }

    @Operation(
            summary = "find All periods Descriptive by Period Name",
            description = "Search period descriptive detail pageable by Period Name." +
                    "('periodName' is optional, use single space to fetch all records)",
            tags = "periods",
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
                                            schema = @Schema(implementation = PeriodResponse.class)
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
    @GetMapping(path = "/{periodName}/descriptive",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodResponse>>
    getPeriodsDescriptiveByPeriodName(@PathVariable(name = "periodName", required = false)
                                              Optional<String> periodName,
                                      @Parameter(hidden = true)
                                      @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                      @PageableDefault(page = 0, size = 10, value = 10)
                                              Pageable pageable) {

        String inputPeriodName = null;
        if (periodName.isPresent()) {
            inputPeriodName = periodName.get();
        }

        Page<PeriodEntity> periodPages =
                periodService
                        .findAllDescriptiveByDeleteStatusEqualsOneAndPeriodNameAndOrderPageable(inputPeriodName, pageable);

        Page<PeriodFastDto> periodFastDtoPage = periodPages
                .map(p -> periodFastDtoMapper
                        .toPeriodFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodResponse> periodResponsePagedModel = periodFastDtoPagedResourcesAssembler
                .toModel(periodFastDtoPage, periodResponsePeriodFastDtoAssembler);

        return ResponseEntity.ok(periodResponsePagedModel);
    }

    @Operation(
            summary = "find All periods by field public Id",
            description = "Search period detail pageable by field public Id",
            tags = "periods",
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
                                            schema = @Schema(implementation = PeriodResponse.class)
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
    @GetMapping(path = "/fields/{fieldPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodResponse>> getPeriodsFields(@PathVariable String fieldPublicId,
                                                                       @Parameter(hidden = true)
                                                                       @SortDefault(sort = "createDate",
                                                                               direction = Sort.Direction.DESC)
                                                                       @PageableDefault(page = 0,
                                                                               size = 10,
                                                                               value = 10)
                                                                               Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllByPeriodApi_FieldPublicIdPageable(fieldPublicId, pageable);

        Page<PeriodFastDto> periodFastDtoPage = periodPages
                .map(p -> periodFastDtoMapper
                        .toPeriodFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodResponse> periodResponsePagedModel = periodFastDtoPagedResourcesAssembler
                .toModel(periodFastDtoPage, periodResponsePeriodFastDtoAssembler);

        return ResponseEntity.ok(periodResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/fields/{fieldPublicId}/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PeriodResponse>> getAllPeriodsFields(
            @PathVariable String fieldPublicId,
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate",
                    direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllByPeriodApi_FieldPublicIdPageable(fieldPublicId, pageable);

        List<PeriodEntity> periodEntities = StreamSupport
                .stream(periodPages.spliterator(), false)
                .collect(Collectors.toList());

        List<PeriodFastDto> periodFastDtos = periodFastDtoMapper
                .toPeriodFastDtos(periodEntities, new CycleAvoidingMappingContext());

        CollectionModel<PeriodResponse> periodResponseCollectionModel =
                periodResponsePeriodFastDtoAssembler.toCollectionModel(periodFastDtos);

        return ResponseEntity.ok(periodResponseCollectionModel);
    }


    @Operation(
            summary = "Find Period by public ID",
            description = "Search period by the public id",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PeriodResponse.class)
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
    @GetMapping(path = "/{periodPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPeriodByPeriodPublicId(@PathVariable String periodPublicId) {

        PeriodEntity period = periodService.findPeriodEntityByPeriodApiPublicId(periodPublicId);
        if (period == null) {
            throw new NotFoundException("requested period not found");
        }

        PeriodFastDto periodFastDto = periodFastDtoMapper
                .toPeriodFastDto(period, new CycleAvoidingMappingContext());

        PeriodResponse periodResponse =
                periodResponsePeriodFastDtoAssembler.toModel(periodFastDto);

        return ResponseEntity.ok(periodResponse);

    }

    @Operation(
            summary = "query All periods Custom Two",
            description = "Search period Custom Two detail pageable",
            tags = "periodCustomTwo",
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
                                            schema = @Schema(implementation = PeriodResponseCustomTwo.class)
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
    @GetMapping(path = "/periodResponseCustomTwo",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodResponseCustomTwo>> queryPeriods(
            @RequestParam("periodPublicId") Optional<String> periodPublicId,
            @RequestParam("fieldPublicId") Optional<String> fieldPublicId,
            @RequestParam("eduCategoryPublicId") Optional<String> eduCategoryPublicId,
            @RequestParam("levelPublicId") Optional<String> levelPublicId,
            @RequestParam("fieldCode") Optional<String> fieldCode,
            @RequestParam("periodOfferNumber") Optional<Long> periodOfferNumber,
            @RequestParam("periodName") Optional<String> periodName,
            @RequestParam("levelName") Optional<String> levelName,
            @RequestParam("fieldName") Optional<String> fieldName,
            @RequestParam("eduCategoryName") Optional<String> eduCategoryName,
            @RequestParam("periodStartDate") Optional<String> periodStartDate,
            @RequestParam("periodEndDate") Optional<String> periodEndDate,
            @RequestParam("registerStartDate") Optional<String> registerStartDate,
            @RequestParam("registerEndDate") Optional<String> registerEndDate,
            @RequestParam("periodMaxCapacity") Optional<Long> periodMaxCapacity,
            @RequestParam("periodHoldingType") Optional<String> periodHoldingType,
            @RequestParam("periodCanRegisterOnline") Optional<String> periodCanRegisterOnline,
            @RequestParam("periodType") Optional<String> periodType,
            @RequestParam("periodFee") Optional<Long> periodFee,
            @RequestParam("periodDiscount") Optional<Long> periodDiscount,
            @RequestParam("periodSchedule") Optional<String> periodSchedule,
            @RequestParam(value = "periodActivityStatus", defaultValue = "1") Optional<Long> periodActivityStatus,
            @RequestParam(value = "periodDeleteStatus", defaultValue = "1") Optional<Long> periodDeleteStatus,
            @RequestParam("periodTotalUnit") Optional<Long> periodTotalUnit,
            @RequestParam("periodExecutorFirstName") Optional<String> periodExecutorFirstName,
            @RequestParam("periodExecutorLastName") Optional<String> periodExecutorLastName,
            @RequestParam("periodExecutorFullName") Optional<String> periodExecutorFullName,
            @RequestParam("periodId") Optional<Long> periodId,
            @Parameter(hidden = true)
            @SortDefault(sort = "regStartDate",
                    direction = Sort.Direction.DESC)
            @PageableDefault(page = 1, size = 50, value = 10)
                    Pageable pageable) {

        Page<PeriodProjectionCustomTwo> periodProjectionCustomTwoPages =
                periodService.queryAllPeriodsCustomTwo(periodPublicId.orElse(null),
                        fieldPublicId.orElse(null),
                        eduCategoryPublicId.orElse(null), levelPublicId.orElse(null),
                        fieldCode.orElse(null), periodOfferNumber.orElse(null),
                        periodName.orElse(null), levelName.orElse(null),
                        fieldName.orElse(null), eduCategoryName.orElse(null),
                        periodStartDate.orElse(null), periodEndDate.orElse(null),
                        registerStartDate.orElse(null), registerEndDate.orElse(null),
                        periodMaxCapacity.orElse(null), periodHoldingType.orElse(null),
                        periodCanRegisterOnline.orElse(null), periodType.orElse(null),
                        periodFee.orElse(null), periodDiscount.orElse(null), periodSchedule.orElse(null),
                        periodActivityStatus.orElse(null), periodDeleteStatus.orElse(null),
                        periodTotalUnit.orElse(null), periodId.orElse(null),
                        periodExecutorFirstName.orElse(null), periodExecutorLastName.orElse(null),
                        periodExecutorFullName.orElse(null), pageable);


        Page<PeriodProjectionCustomTwoDto> periodProjectionCustomTwoDtoPages = periodProjectionCustomTwoPages
                .map(periodProjectionCustomTwoMapper::periodProjectionCustomTwoToPeriodProjectionCustomTwoDto);

        PagedModel<PeriodResponseCustomTwo> periodResponseCustomTwoPagedModel = periodProjectionCustomTwoDtoDtoPagedResourcesAssembler
                .toModel(periodProjectionCustomTwoDtoPages, periodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler);

        periodResponseCustomTwoPagedModel
                .forEach(periodResponseCustomTwo -> convertorUtil.makeCharacterSetPersian(periodResponseCustomTwo));

        return ResponseEntity.ok(periodResponseCustomTwoPagedModel);
    }
























    @Operation(
            summary = "query All periods Custom Four",
            description = "Search period Custom Four detail",
            tags = "periodCustomFour",
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
                                            schema = @Schema(implementation = PeriodResponseCustomFour.class)
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
    @GetMapping(path = "/periodResponseCustomFour",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PeriodResponseCustomFour>> queryPeriodsCustomFour(
            @RequestParam("periodPublicId") Optional<String> periodPublicId,
            @RequestParam("fieldPublicId") Optional<String> fieldPublicId,
            @RequestParam("eduCategoryPublicId") Optional<String> eduCategoryPublicId,
            @RequestParam("levelPublicId") Optional<String> levelPublicId,
            @RequestParam("projectPublicId") Optional<String> projectPublicId,
            @RequestParam("publicId") Optional<String> depositPublicId,
            @RequestParam("code") Optional<String> fieldCode,
            @RequestParam("depositCode") Optional<String> depositCode,
            @RequestParam("projectCode") Optional<String> projectCode,
            @RequestParam("offerNumber") Optional<Long> periodOfferNumber,
            @RequestParam("fName") Optional<String> fieldName,
            @RequestParam("name") Optional<String> periodName,
            @RequestParam("projectName") Optional<String> projectName,
            @RequestParam("levelDescription") Optional<String> levelDescription,
            @RequestParam("eduCategoryTitle") Optional<String> eduCategoryName,
            @RequestParam("startDate") Optional<String> periodStartDate,
            @RequestParam("endDate") Optional<String> periodEndDate,
            @RequestParam("regStartDate") Optional<String> registerStartDate,
            @RequestParam("regEndDate") Optional<String> registerEndDate,
            @RequestParam("maxCapacity") Optional<Long> periodMaxCapacity,
            @RequestParam("holdingType") Optional<String> periodHoldingType,
            @RequestParam("canRegisterOnline") Optional<String> periodCanRegisterOnline,
            @RequestParam("type") Optional<String> periodType,
            @RequestParam("fee") Optional<Long> periodFee,
            @RequestParam("periodDiscount") Optional<Long> periodDiscount,
            @RequestParam("schedule") Optional<String> periodSchedule,
            @RequestParam(value = "activityStatus", defaultValue = "1") Optional<Long> periodActivityStatus,
            @RequestParam(value = "deleteStatus", defaultValue = "1") Optional<Long> periodDeleteStatus,
            @RequestParam("totalUnit") Optional<Long> periodTotalUnit,
            @RequestParam("executorFirstName") Optional<String> periodExecutorFirstName,
            @RequestParam("executorLastName") Optional<String> periodExecutorLastName,
            @RequestParam("planId") Optional<Long> planId,
            @RequestParam("betweenRegStartDate") Optional<String> betweenRegStartDate,
            @RequestParam("betweenRegEndDate") Optional<String> betweenRegEndDate,
            @RequestParam("periodExecutorFullName") Optional<String> periodExecutorFullName
           // @RequestParam("periodId") Optional<Long> periodId,
                    ) {

        List<PeriodProjectionCustomFour> periodProjectionCustomFours =
                periodService.queryAllPeriodsCustomFour(periodPublicId.orElse(null),
                        fieldPublicId.orElse(null),
                        eduCategoryPublicId.orElse(null), levelPublicId.orElse(null),
                        fieldCode.orElse(null), periodOfferNumber.orElse(null),
                        periodName.orElse(null),
                        levelDescription.orElse(null),
                        fieldName.orElse(null), eduCategoryName.orElse(null),
                        periodStartDate.orElse(null), periodEndDate.orElse(null),
                        registerStartDate.orElse(null), registerEndDate.orElse(null),
                        periodMaxCapacity.orElse(null), periodHoldingType.orElse(null),
                        periodCanRegisterOnline.orElse(null), periodType.orElse(null),
                        periodFee.orElse(null),
                        periodDiscount.orElse(null),
                        periodSchedule.orElse(null),
                        periodActivityStatus.orElse(null), periodDeleteStatus.orElse(null),
                        periodTotalUnit.orElse(null),
                        null,null,
                        null,
                        periodExecutorFirstName.orElse(null), periodExecutorLastName.orElse(null),
                        null, depositCode.orElse(null),projectCode.orElse(null),
                        projectName.orElse(null),projectPublicId.orElse(null),
                        depositPublicId.orElse(null),planId.orElse(null),
                        betweenRegStartDate.orElse(null),betweenRegEndDate.orElse(null),
                        periodExecutorFullName.orElse(null)
                );


        List<PeriodProjectionCustomFourDto> periodProjectionCustomFourDtos =
                periodProjectionCustomFourMapper
                        .periodProjectionCustomFourToPeriodProjectionCustomFourDtos(periodProjectionCustomFours);

        List<PeriodResponseCustomFour> periodResponseCustomFours = periodResponseCustomFourPeriodProjectionCustomFourDtoMapper
                .periodProjectionCustomFourDtoToPeriodResponseCustomFours(periodProjectionCustomFourDtos);

        return ResponseEntity.ok(periodResponseCustomFours);
    }



    @Operation(
            summary = "Find Period Response Custom Two by public ID",
            description = "Search Period Response Custom Two by the public id",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PeriodResponseCustomTwo.class)
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
    @GetMapping(path = "/periodResponseCustomTwo/{periodPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPeriodResponseCustomTwoByPeriodPublicId(@PathVariable String periodPublicId) {

        PeriodProjectionCustomTwo periodProjectionCustomTwo = periodService.queryPeriodsCustomTwoByPeriodPublicId(periodPublicId);
        if (periodProjectionCustomTwo == null) {
            throw new NotFoundException("requested period not found");
        }

        PeriodProjectionCustomTwoDto periodProjectionCustomTwoDto = periodProjectionCustomTwoMapper
                .periodProjectionCustomTwoToPeriodProjectionCustomTwoDto(periodProjectionCustomTwo);

        PeriodResponseCustomTwo periodResponseCustomTwo =
                periodResponseCustomTwoPeriodProjectionCustomTwoDtoAssembler
                        .toModel(periodProjectionCustomTwoDto);

        convertorUtil.makeCharacterSetPersian(periodResponseCustomTwo);

        return ResponseEntity.ok(periodResponseCustomTwo);

    }


    // ---------------------------------------------------------Not complete


    @Operation(
            summary = "find All period executors",
            description = "Search period executors pageable",
            tags = "periods",
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
                                            schema = @Schema(implementation = PeriodResponse.class)
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
    @GetMapping(path = "/executors/{executorPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodResponse>> getPeriodExecutors(@PathVariable String executorPublicId,
                                                                         @Parameter(hidden = true)
                                                                         @SortDefault(sort = "createDate",
                                                                                 direction = Sort.Direction.DESC)
                                                                         @PageableDefault(page = 0, size = 10, value = 10)
                                                                                 Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllPageableByExecutorPublicId(pageable, executorPublicId);

        Page<PeriodFastDto> periodFastDtoPage = periodPages
                .map(p -> periodFastDtoMapper
                        .toPeriodFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodResponse> periodResponsePagedModel = periodFastDtoPagedResourcesAssembler
                .toModel(periodFastDtoPage, periodResponsePeriodFastDtoAssembler);

        return ResponseEntity.ok(periodResponsePagedModel);
    }


    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/executors/{executorPublicId}/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PeriodResponse>> getAllPeriodsByExecutorPublicId(@PathVariable String executorPublicId,
                                                                                           @Parameter(hidden = true)
                                                                                           @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                           @PageableDefault(page = 0, size = 10)
                                                                                                   Pageable pageable) {

        Page<PeriodEntity> periodPages =
                periodService.findAllPageableByExecutorPublicId(pageable, executorPublicId);

        List<PeriodEntity> periods = StreamSupport
                .stream(periodPages.spliterator(), false)
                .collect(Collectors.toList());

        List<PeriodFastDto> periodFastDtos = periodFastDtoMapper
                .toPeriodFastDtos(periods, new CycleAvoidingMappingContext());

        CollectionModel<PeriodResponse> periodResponseCollectionModel =
                periodResponsePeriodFastDtoAssembler.toCollectionModel(periodFastDtos);

        return ResponseEntity.ok(periodResponseCollectionModel);
    }

    @Operation(
            hidden = true,
            summary = "Generate Executor Public Id",
            description = "generate public id for new executors",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
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
    @PostMapping(path = "/new/executors",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> generateExecutorPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long executorCount = 0L;
        List<PersonEntity> savedPersons = new ArrayList<>();

        Iterable<PeriodEntity> periodEntities =
                periodService.findAllByDeleteStatusIsNotNullAndExecuterIsNotNull();

        List<PersonEntity> executors = StreamSupport
                .stream(periodEntities.spliterator(), false)
                .filter(Objects::nonNull)
                .map(PeriodEntity::getExecuter)
                .distinct()
                .collect(Collectors.toList());

        if (!executors.isEmpty()) {
            savedPersons = userService.generatePersonPublicIdByPersons(executors);
            executorCount = Long.valueOf(savedPersons.size());
        }

        if (executorCount == 0) {
            returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
            returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
            returnValue.setDescription("New Record Not Found.");
            return ResponseEntity.ok(returnValue);
        } else {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
            returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
            returnValue.setDescription(executorCount + " New Public Id Generated");
        }

        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            hidden = true,
            summary = "Find new period numbers",
            description = "search for new periods that do not have period public id " +
                    "by comparing max id period and period web service entity. ",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
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
    @GetMapping(path = "/new/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewPeriodCount() {

        OperationStatus returnValue = new OperationStatus();
        Long periodApiCount;
        Long periodCount;
        Long newPeriodCount;

        periodApiCount = periodApiService.periodApiCount();
        Long periodSequenceNumber = periodService.selectPeriodLastSequenceNumber();
        periodCount = periodService.countPeriodByIdLessThanEqual(periodSequenceNumber);

        if (periodCount == null || periodCount == 0) {
            throw new InternalServerErrorException("period count is null or zero");
        }

        if (periodApiCount != null) {
            newPeriodCount = periodCount - periodApiCount;
        } else {
            newPeriodCount = periodCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newPeriodCount > 0) {
            returnValue.setDescription(newPeriodCount + " New Record Found. use 'generate-public-id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(PeriodController.class)
                            .createPeriodApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            hidden = true,
            summary = "Generate Period Public Id",
            description = "generate public id for new periods",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
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
    @PostMapping(path = "/new/publicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPeriodApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long periodApiCount;
        PeriodApiEntity periodApiLastRecord;
        PeriodEntity periodLastRecord;
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<PeriodApiEntity> newPeriodApi = new ArrayList<>();

        periodApiCount = periodApiService.periodApiCount();

        if (0 != periodApiCount) {
            Long periodSequenceNumber = periodService.selectPeriodLastSequenceNumber();
            periodApiLastRecord = periodApiService.selectLastRecord();
            periodLastRecord = periodService.findFirstByIdLessThanOrderByIdDesc(periodSequenceNumber);
            if (periodLastRecord.getId() > periodApiLastRecord.getPeriodId()) {
                Long periodApiPeriodIdPlusOne = periodApiLastRecord.getPeriodId() + 1;
                newPeriods = periodService.findAllPeriodOnlyByIdBetween(periodApiPeriodIdPlusOne, periodLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newPeriods = periodService.findAllPeriodOnly();
        }

        newPeriodApi = periodApiService.generatePeriodApiPublicId(newPeriods);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newPeriodApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    @Operation(
            hidden = true,
            summary = "Update Field Public Id",
            description = "update public id for new fields",
            tags = "periods",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
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
    @PutMapping(path = "/fields/update/publicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updatePeriodApiFieldPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long periodApiCount;
        List<PeriodApiEntity> newPeriodApis = new ArrayList<>();
        List<PeriodApiEntity> updatedPeriodApi = new ArrayList<>();

        periodApiCount = periodApiService.periodApiCount();

        if (0 != periodApiCount) {
            newPeriodApis = periodApiService.findAllPeriodApisByFieldPublicIdIsNull();
            if (newPeriodApis != null) {
                updatedPeriodApi = periodApiService.updatePeriodApiByFieldPublicId(newPeriodApis);
            }
        }

        if (updatedPeriodApi == null) {
            returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
            returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
            returnValue.setDescription("New Record Not Found.");
            return ResponseEntity.ok(returnValue);
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.UPDATE_ENTITIES.name());
        returnValue.setDescription(updatedPeriodApi.size() + " record updated ");
        return ResponseEntity.ok(returnValue);

    }

}
