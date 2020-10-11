package edu.imi.ir.eduimiws.controllers.v1;



import edu.imi.ir.eduimiws.assemblers.edu.LevelResponseLevelDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.LevelDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.LevelResponse;
import edu.imi.ir.eduimiws.services.edu.LevelApiService;
import edu.imi.ir.eduimiws.services.edu.LevelService;
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
@RequestMapping("/api/v1/levels")
@RequiredArgsConstructor
@Tag(name = "Levels", description = "The level API")
public class LevelController {

    private final LevelService levelService;
    private final LevelApiService levelApiService;
    private final LevelDtoMapper levelDtoMapper;
    private final LevelResponseLevelDtoAssembler levelResponseLevelDtoAssembler;
    private final PagedResourcesAssembler<LevelDto> levelDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All levels",
            description = "Search level detail pageable",
            tags = "levels",
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
                                            schema = @Schema(implementation = LevelResponse.class)
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
    public ResponseEntity<PagedModel<LevelResponse>> getLevels(@Parameter(hidden = true)
                                                                     @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                     @PageableDefault(page = 0, size = 10, value = 10)
                                                                             Pageable pageable) {

        Page<LevelEntity> levelPages =
                levelService.findAllByOrderPageable(pageable);

        Page<LevelDto> levelDtoPage = levelPages
                .map(p -> levelDtoMapper
                        .toLevelDto(p, new CycleAvoidingMappingContext()));

        PagedModel<LevelResponse> levelResponsePagedModel = levelDtoPagedResourcesAssembler
                .toModel(levelDtoPage, levelResponseLevelDtoAssembler);

        return ResponseEntity.ok(levelResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<LevelResponse>> getAllLevels(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<LevelEntity> levelPages =
                levelService.findAllByOrderPageable(pageable);

        List<LevelEntity> levelEntities = StreamSupport
                .stream(levelPages.spliterator(), false)
                .collect(Collectors.toList());

        List<LevelDto> levelDtos = levelDtoMapper
                .toLevelDtos(levelEntities, new CycleAvoidingMappingContext());

        CollectionModel<LevelResponse> levelResponseCollectionModel =
                levelResponseLevelDtoAssembler.toCollectionModel(levelDtos);

        return ResponseEntity.ok(levelResponseCollectionModel);
    }

    @Operation(
            summary = "Find Level by public ID",
            description = "Search level by the public id",
            tags = "levels",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = LevelResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "level not found",
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
    @GetMapping(path = "/{levelPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getLevelByLevelPublicId(@PathVariable String levelPublicId) {

        try {
            LevelEntity level = levelService.findByLevelPublicId(levelPublicId);
            if (level == null) {
                return this.levelNotFound();
            }

            LevelDto levelDto = levelDtoMapper
                    .toLevelDto(level, new CycleAvoidingMappingContext());

            LevelResponse levelResponse =
                    levelResponseLevelDtoAssembler.toModel(levelDto);

            return ResponseEntity.ok(levelResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "Find new level numbers",
            description = "search for new levels that do not have level public id " +
                    "by comparing max id level and level web service entity. ",
            tags = "levels",
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
    public ResponseEntity<?> getNewLevelCount() {

        OperationStatus returnValue = new OperationStatus();
        Long levelApiCount;
        Long levelCount;
        Long newLevelCount;

        levelApiCount = levelApiService.levelApiCount();
        Long levelSequenceNumber = levelService.selectLevelLastSequenceNumber();
        levelCount = levelService.countLevelByIdLessThanEqual(levelSequenceNumber);

        if (levelCount == null || levelCount == 0) {
            this.conflictLevelCount();
        }

        if (levelApiCount != null) {
            newLevelCount = levelCount - levelApiCount;
        } else {
            newLevelCount = levelCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newLevelCount > 0) {
            returnValue.setDescription(newLevelCount + " New Record Found. use 'new public id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(LevelController.class)
                            .createLevelApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }

    @Operation(
            hidden = true,
            summary = "Generate Level Public Id",
            description = "generate public id for new levels",
            tags = "levels",
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
    public ResponseEntity<?> createLevelApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long levelApiCount;
        LevelApiEntity levelApiLastRecord;
        LevelEntity levelLastRecord;
        List<LevelEntity> newLevels = new ArrayList<>();
        List<LevelApiEntity> newLevelApi = new ArrayList<>();

        levelApiCount = levelApiService.levelApiCount();

        if (0 != levelApiCount) {
            Long levelSequenceNumber = levelService.selectLevelLastSequenceNumber();
            levelApiLastRecord = levelApiService.selectLastRecord();
            levelLastRecord = levelService.findFirstByIdLessThanOrderByIdDesc(levelSequenceNumber);
            if (levelLastRecord.getId() > levelApiLastRecord.getLevelId()) {
                Long levelApiLevelIdPlusOne = levelApiLastRecord.getLevelId() + 1;
                newLevels = levelService.findAllLevelProjectionByIdBetween(levelApiLevelIdPlusOne, levelLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newLevels = levelService.selectAllLevelProjection();
        }

        newLevelApi = levelApiService.generateLevelApiPublicId(newLevels);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newLevelApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictLevelCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "level count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ResponseEntity<?> levelNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested level not found")
                , HttpStatus.NOT_FOUND
        );
    }


}
