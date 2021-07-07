package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.PeriodResponsePeriodFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.InternalServerErrorException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.edu.PeriodApiService;
import edu.imi.ir.eduimiws.services.edu.PeriodService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
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
import org.springdoc.core.converters.PageableAsQueryParam;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
    @PageableAsQueryParam
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
