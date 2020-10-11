package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.edu.FieldResponseFieldDtoAssembler;
import edu.imi.ir.eduimiws.assemblers.edu.FieldResponseFieldFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.FieldFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.FieldDto;
import edu.imi.ir.eduimiws.models.dto.edu.FieldFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.FieldResponse;
import edu.imi.ir.eduimiws.services.edu.FieldApiService;
import edu.imi.ir.eduimiws.services.edu.FieldService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/fields")
@RequiredArgsConstructor
@Tag(name = "Fields", description = "The Field API")
public class FieldController {

    private final FieldService fieldService;
    private final FieldApiService fieldApiService;
    private final FieldDtoMapper fieldDtoMapper;
    private final FieldFastDtoMapper fieldFastDtoMapper;
    private final FieldResponseFieldDtoAssembler fieldResponseFieldDtoAssembler;
    private final FieldResponseFieldFastDtoAssembler fieldResponseFieldFastDtoAssembler;
    private final PagedResourcesAssembler<FieldDto> fieldDtoPagedResourcesAssembler;
    private final PagedResourcesAssembler<FieldFastDto> fieldFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All fields",
            description = "Search field detail pageable",
            tags = "fields",
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
                                            schema = @Schema(implementation = FieldResponse.class)
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
    public ResponseEntity<PagedModel<FieldResponse>> getFields(@Parameter(hidden = true)
                                                                     @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                     @PageableDefault(page = 0, size = 10, value = 10)
                                                                             Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByOrderPageable(pageable);

        Page<FieldFastDto> fieldFastDtoPage = fieldPages
                .map(p -> fieldFastDtoMapper
                        .toFieldFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<FieldResponse> fieldResponsePagedModel = fieldFastDtoPagedResourcesAssembler
                .toModel(fieldFastDtoPage, fieldResponseFieldFastDtoAssembler);

            return ResponseEntity.ok(fieldResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<FieldResponse>> getAllFields(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByOrderPageable(pageable);

        List<FieldEntity> fieldEntities = StreamSupport
                .stream(fieldPages.spliterator(), false)
                .collect(Collectors.toList());

        List<FieldFastDto> fieldFastDtos = fieldFastDtoMapper
                .toFieldFastDtos(fieldEntities, new CycleAvoidingMappingContext());

        CollectionModel<FieldResponse> fieldResponseCollectionModel =
                fieldResponseFieldFastDtoAssembler.toCollectionModel(fieldFastDtos);

        return ResponseEntity.ok(fieldResponseCollectionModel);
    }

    @Operation(
            summary = "Find Field by public ID",
            description = "Search field by the public id",
            tags = "fields",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = FieldResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "field not found",
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
    @GetMapping(path = "/{fieldPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFieldByFieldPublicId(@PathVariable String fieldPublicId) {

        try {
            FieldEntity field = fieldService.findByFieldPublicId(fieldPublicId);
            if (field == null) {
                return this.fieldNotFound();
            }

            FieldFastDto fieldFastDto = fieldFastDtoMapper
                    .toFieldFastDto(field, new CycleAvoidingMappingContext());

            FieldResponse fieldResponse =
                    fieldResponseFieldFastDtoAssembler.toModel(fieldFastDto);

            return ResponseEntity.ok(fieldResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "find All fields with level and education category information",
            description = "Search field detail pageable with level and education category information",
            tags = "fields",
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
                                            schema = @Schema(implementation = FieldResponse.class)
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
    @GetMapping(path = "/descriptive",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<FieldResponse>> getFieldsWithStudentPeriodName(@Parameter(hidden = true)
                                                                                          @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                          @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                  Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByOrderPageable(pageable);

        Page<FieldDto> fieldDtoPage = fieldPages
                .map(p -> fieldDtoMapper
                        .toFieldDto(p, new CycleAvoidingMappingContext()));

        PagedModel<FieldResponse> fieldResponsePagedModel = fieldDtoPagedResourcesAssembler
                .toModel(fieldDtoPage, fieldResponseFieldDtoAssembler);

        return ResponseEntity.ok(fieldResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel/descriptive",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<FieldResponse>> getAllFieldsWithStudentPeriodName(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByOrderPageable(pageable);

        List<FieldEntity> fieldEntities = StreamSupport
                .stream(fieldPages.spliterator(), false)
                .collect(Collectors.toList());

        List<FieldDto> fieldDtos = fieldDtoMapper
                .toFieldDtos(fieldEntities, new CycleAvoidingMappingContext());

        CollectionModel<FieldResponse> fieldResponseCollectionModel =
                fieldResponseFieldDtoAssembler.toCollectionModel(fieldDtos);

        return ResponseEntity.ok(fieldResponseCollectionModel);
    }

    @Operation(
            summary = "Find Field by public ID ",
            description = "Search field by the public id ",
            tags = "fields",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = FieldResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "field not found",
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
    @GetMapping(path = "/descriptive/{fieldPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFieldWithStudentPeriodNameByFieldPublicId(@PathVariable String fieldPublicId) {

        try {
            FieldEntity field = fieldService
                    .findByFieldPublicId(fieldPublicId);
            if (field == null) {
                return this.fieldNotFound();
            }

            FieldDto fieldDto = fieldDtoMapper
                    .toFieldDto(field, new CycleAvoidingMappingContext());

            FieldResponse fieldResponse =
                    fieldResponseFieldDtoAssembler.toModel(fieldDto);

            return ResponseEntity.ok(fieldResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Find Fields by Level Public ID ",
            description = "Search field by Level public id ",
            tags = "fields",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = FieldResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "field not found",
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
    @GetMapping(path = "/descriptive/levels/{levelPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFieldsDescriptiveByLevelPublicId(@PathVariable String levelPublicId,
                                                                 @Parameter(hidden = true)
                                                                 @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                 @PageableDefault(page = 0, size = 10, value = 10)
                                                                         Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByLevelPublicIdPageable(levelPublicId, pageable);

        Page<FieldDto> fieldDtoPage = fieldPages
                .map(p -> fieldDtoMapper
                        .toFieldDto(p, new CycleAvoidingMappingContext()));

        PagedModel<FieldResponse> fieldResponsePagedModel = fieldDtoPagedResourcesAssembler
                .toModel(fieldDtoPage, fieldResponseFieldDtoAssembler);

        return ResponseEntity.ok(fieldResponsePagedModel);
    }

    @Operation(
            summary = "Find Fields by Education Category Public ID ",
            description = "Search field by Education Category public id ",
            tags = "fields",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = FieldResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "field not found",
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
    @GetMapping(path = "/descriptive/eduCategories/{eduCategoryPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFieldsDescriptiveByEduCategoryPublicId(@PathVariable String eduCategoryPublicId,
                                                                       @Parameter(hidden = true)
                                                                       @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                               Pageable pageable) {

        Page<FieldEntity> fieldPages =
                fieldService.findAllByEduCategoryPublicIdPageable(eduCategoryPublicId, pageable);

        Page<FieldDto> fieldDtoPage = fieldPages
                .map(p -> fieldDtoMapper
                        .toFieldDto(p, new CycleAvoidingMappingContext()));

        PagedModel<FieldResponse> fieldResponsePagedModel = fieldDtoPagedResourcesAssembler
                .toModel(fieldDtoPage, fieldResponseFieldDtoAssembler);

        return ResponseEntity.ok(fieldResponsePagedModel);
    }


    @Operation(
            summary = "Find new field numbers",
            description = "search for new fields that do not have field public id " +
                    "by comparing max id field and field web service entity. ",
            tags = "fields",
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
    @GetMapping(path = "/new/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewFieldCount() {

        OperationStatus returnValue = new OperationStatus();
        Long fieldApiCount;
        Long fieldCount;
        Long newFieldCount;

        fieldApiCount = fieldApiService.fieldApiCount();
        Long fieldSequenceNumber = fieldService.selectFieldLastSequenceNumber();
        fieldCount = fieldService.countFieldByIdLessThanEqual(fieldSequenceNumber);

        if (fieldCount == null || fieldCount == 0) {
            this.conflictFieldCount();
        }

        if (fieldApiCount != null) {
            newFieldCount = fieldCount - fieldApiCount;
        } else {
            newFieldCount = fieldCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newFieldCount > 0) {
            returnValue.setDescription(newFieldCount + " New Record Found. use 'new public id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(FieldController.class)
                            .createFieldApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }

    @Operation(
            hidden = true,
            summary = "Generate Field Public Id",
            description = "generate public id for new fields",
            tags = "fields",
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
    public ResponseEntity<?> createFieldApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long fieldApiCount;
        FieldApiEntity fieldApiLastRecord;
        FieldEntity fieldLastRecord;
        List<FieldEntity> newFields = new ArrayList<>();
        List<FieldApiEntity> newFieldApi = new ArrayList<>();

        fieldApiCount = fieldApiService.fieldApiCount();

        if (0 != fieldApiCount) {
            Long fieldSequenceNumber = fieldService.selectFieldLastSequenceNumber();
            fieldApiLastRecord = fieldApiService.selectLastRecord();
            fieldLastRecord = fieldService.findFirstByIdLessThanOrderByIdDesc(fieldSequenceNumber);
            if (fieldLastRecord.getId() > fieldApiLastRecord.getFieldId()) {
                Long fieldApiFieldIdPlusOne = fieldApiLastRecord.getFieldId() + 1;
                newFields = fieldService.findAllFieldOnlyByIdBetween(fieldApiFieldIdPlusOne, fieldLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newFields = fieldService.selectAllFieldOnly();
        }

        newFieldApi = fieldApiService.generateFieldApiPublicId(newFields);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newFieldApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictFieldCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "field count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ResponseEntity<?> fieldNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested field not found")
                , HttpStatus.NOT_FOUND
        );
    }


}
