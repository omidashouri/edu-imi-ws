package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.crm.UserResponseAssembler;
import edu.imi.ir.eduimiws.assemblers.edu.PeriodResponseAssembler;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoMapper;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import edu.imi.ir.eduimiws.services.edu.PeriodService;
import edu.imi.ir.eduimiws.services.edu.PeriodWebServiceService;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/periods")
@RequiredArgsConstructor
@Tag(name = "Periods", description = "The period API")
public class PeriodController {

    private final PeriodService periodService;
    private final PersonService personService;
    private final UserService userService;
    private final PersonWebServiceService personWebServiceService;
    private final PeriodWebServiceService periodWebServiceService;
    private final PeriodResponseAssembler periodResponseAssembler;
    private final UserResponseAssembler userResponseAssembler;
    private final PagedResourcesAssembler<PeriodEntity> periodPagedResourcesAssembler;
    private final UserFastDtoMapper userFastDtoMapper;

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
                periodService.findAllPeriodEntityPagesOrderByCreateDateDesc(pageable);

        PagedModel<PeriodResponse> periodResponsePagedModel = periodPagedResourcesAssembler
                .toModel(periodPages, periodResponseAssembler);

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
                periodService.findAllPeriodEntityPagesOrderByCreateDateDesc(pageable);

        List<PeriodEntity> periodEntities = StreamSupport
                .stream(periodPages.spliterator(), false)
                .collect(Collectors.toList());

        CollectionModel<PeriodResponse> periodResponseCollectionModel =
                periodResponseAssembler.toCollectionModel(periodEntities);

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

        try {
            PeriodEntity period = periodService.findPeriodEntityByPeriodWebServicePublicId(periodPublicId);
            if (period == null) {
                return this.periodNotFound();
            }

            PeriodResponse periodResponse =
                    periodResponseAssembler.toModel(period);

            return ResponseEntity.ok(periodResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    // ---------------------------------------------------------Not complete


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

        CollectionModel<PeriodResponse> periodResponseCollectionModel =
                periodResponseAssembler.toCollectionModel(periods);

        return ResponseEntity.ok(periodResponseCollectionModel);
    }

    @Operation(
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
    @PostMapping(path = "/executors",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> generateExecutorPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long executorCount = 0L;
        List<PersonEntity> savedPersons = new ArrayList<>();

        Iterable<PeriodEntity> periodEntities =
                periodService.findAllByDeleteStatusIsNotNullAndExecuterIsNotNull();


//        omiddo: remove those have public id

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
    @GetMapping(path = "/count-new-periods",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewPeriodCount() {

        OperationStatus returnValue = new OperationStatus();
        Long periodWebserviceCount;
        Long periodCount;
        Long newPeriodCount;

        periodWebserviceCount = periodWebServiceService.periodWebServiceCount();
        periodCount = periodService.PeriodCount();

        if (periodCount == null || periodCount == 0) {
            this.conflictPeriodCount();
        }

        if (periodWebserviceCount != null) {
            newPeriodCount = periodCount - periodWebserviceCount;
        } else {
            newPeriodCount = periodCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newPeriodCount > 0) {
            returnValue.setDescription(newPeriodCount + " New Record Found. use 'generate-public-id' link");

            Link link = WebMvcLinkBuilder.linkTo(PeriodController.class)
                    .slash("generate-public-id")
                    .withRel("generate-public-id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
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
    @PostMapping(path = "/generate-public-id",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPeriodWebServicePublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long periodWebserviceCount;
        PeriodWebServiceEntity periodWebServiceLastRecord;
        PeriodEntity periodLastRecord;
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<PeriodWebServiceEntity> newPeriodWebService = new ArrayList<>();

        periodWebserviceCount = periodWebServiceService.periodWebServiceCount();

        if (0 != periodWebserviceCount) {
            periodWebServiceLastRecord = periodWebServiceService.selectLastRecord();
            periodLastRecord = periodService.selectLastRecord();
            if (periodLastRecord.getId() > periodWebServiceLastRecord.getPeriodId()) {
                newPeriods = periodService.findAllPeriodOnlyByIdGreaterThan(periodWebServiceLastRecord.getPeriodId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newPeriods = periodService.findAllPeriodOnly();
        }

        newPeriodWebService = periodWebServiceService.generatePeriodWebServicePublicId(newPeriods);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newPeriodWebService.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictPeriodCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "period count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private ResponseEntity<?> periodNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested period not found")
                , HttpStatus.NOT_FOUND
        );
    }

}
