package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.EduCategoryResponseEduCategoryDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.EduCategoryDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.EduCategoryResponse;
import edu.imi.ir.eduimiws.services.edu.EduCategoryApiService;
import edu.imi.ir.eduimiws.services.edu.EduCategoryService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/eduCategories")
@RequiredArgsConstructor
@Tag(name = "EduCategories", description = "The Education Category API")
public class EduCategoryController {

    private final EduCategoryService eduCategoryService;
    private final EduCategoryApiService eduCategoryApiService;
    private final EduCategoryDtoMapper eduCategoryDtoMapper;
    private final EduCategoryResponseEduCategoryDtoAssembler eduCategoryResponseEduCategoryDtoAssembler;
    private final PagedResourcesAssembler<EduCategoryDto> eduCategoryDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All eduCategories",
            description = "Search eduCategory detail pageable",
            tags = "eduCategories",
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
                                            schema = @Schema(implementation = EduCategoryResponse.class)
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
    public ResponseEntity<PagedModel<EduCategoryResponse>> getEduCategorys(@Parameter(hidden = true)
                                                               @SortDefault(sort = "id", direction = Sort.Direction.DESC)
                                                               @PageableDefault(page = 0, size = 10, value = 10)
                                                                       Pageable pageable) {

        Page<EduCategoryEntity> eduCategoryPages =
                eduCategoryService.findAllByOrderPageable(pageable);

        Page<EduCategoryDto> eduCategoryDtoPage = eduCategoryPages
                .map(p -> eduCategoryDtoMapper
                        .toEduCategoryDto(p, new CycleAvoidingMappingContext()));

        PagedModel<EduCategoryResponse> eduCategoryResponsePagedModel = eduCategoryDtoPagedResourcesAssembler
                .toModel(eduCategoryDtoPage, eduCategoryResponseEduCategoryDtoAssembler);

        return ResponseEntity.ok(eduCategoryResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<EduCategoryResponse>> getAllEduCategorys(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<EduCategoryEntity> eduCategoryPages =
                eduCategoryService.findAllByOrderPageable(pageable);

        List<EduCategoryEntity> eduCategoryEntities = StreamSupport
                .stream(eduCategoryPages.spliterator(), false)
                .collect(Collectors.toList());

        List<EduCategoryDto> eduCategoryDtos = eduCategoryDtoMapper
                .toEduCategoryDtos(eduCategoryEntities, new CycleAvoidingMappingContext());

        CollectionModel<EduCategoryResponse> eduCategoryResponseCollectionModel =
                eduCategoryResponseEduCategoryDtoAssembler.toCollectionModel(eduCategoryDtos);

        return ResponseEntity.ok(eduCategoryResponseCollectionModel);
    }

    @Operation(
            summary = "Find EduCategory by public ID",
            description = "Search eduCategory by the public id",
            tags = "eduCategories",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = EduCategoryResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "eduCategory not found",
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
    @GetMapping(path = "/publicId/{eduCategoryPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getEduCategoryByEduCategoryPublicId(@PathVariable String eduCategoryPublicId) {

        try {
            EduCategoryEntity eduCategory = eduCategoryService.findByEduCategoryPublicId(eduCategoryPublicId);
            if (eduCategory == null) {
                return this.eduCategoryNotFound();
            }

            EduCategoryDto eduCategoryDto = eduCategoryDtoMapper
                    .toEduCategoryDto(eduCategory, new CycleAvoidingMappingContext());

            EduCategoryResponse eduCategoryResponse =
                    eduCategoryResponseEduCategoryDtoAssembler.toModel(eduCategoryDto);

            return ResponseEntity.ok(eduCategoryResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "Find EduCategory by Title",
            description = "Search eduCategory by Title",
            tags = "eduCategories",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = EduCategoryResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "eduCategory not found",
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
    @GetMapping(path = "/title/{eduCategoryTitle}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getEduCategoryByEduCategoryTitle(@PathVariable String eduCategoryTitle) {

        try {

            List<EduCategoryEntity> eduCategories = eduCategoryService
                    .findAllByEduCategoryTitle(eduCategoryTitle);
            if (eduCategories == null || eduCategories.size() == 0) {
                return this.eduCategoryNotFound();
            }

            List<EduCategoryDto> eduCategoryDtos = eduCategoryDtoMapper
                    .toEduCategoryDtos(eduCategories, new CycleAvoidingMappingContext());

            CollectionModel<EduCategoryResponse> eduCategoryResponseCollectionModel =
                    eduCategoryResponseEduCategoryDtoAssembler.toCollectionModel(eduCategoryDtos);

            return ResponseEntity.ok(eduCategoryResponseCollectionModel);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Find new eduCategory numbers",
            description = "search for new eduCategories that do not have eduCategory public id " +
                    "by comparing max id eduCategory and eduCategory web service entity. ",
            tags = "eduCategories",
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
    public ResponseEntity<?> getNewEduCategoryCount() {

        OperationStatus returnValue = new OperationStatus();
        Long eduCategoryApiCount;
        Long eduCategoryCount;
        Long newEduCategoryCount;

        eduCategoryApiCount = eduCategoryApiService.eduCategoryApiCount();
        Long eduCategorySequenceNumber = eduCategoryService.selectEduCategoryLastSequenceNumber();
        eduCategoryCount = eduCategoryService.countEduCategoryByIdLessThanEqual(eduCategorySequenceNumber);

        if (eduCategoryCount == null || eduCategoryCount == 0) {
            this.conflictEduCategoryCount();
        }

        if (eduCategoryApiCount != null) {
            newEduCategoryCount = eduCategoryCount - eduCategoryApiCount;
        } else {
            newEduCategoryCount = eduCategoryCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newEduCategoryCount > 0) {
            returnValue.setDescription(newEduCategoryCount + " New Record Found. use 'new public id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(EduCategoryController.class)
                            .createEduCategoryApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }

    @Operation(
            hidden = true,
            summary = "Generate EduCategory Public Id",
            description = "generate public id for new eduCategories",
            tags = "eduCategories",
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
    public ResponseEntity<?> createEduCategoryApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long eduCategoryApiCount;
        EduCategoryApiEntity eduCategoryApiLastRecord;
        EduCategoryEntity eduCategoryLastRecord;
        List<EduCategoryEntity> newEduCategorys = new ArrayList<>();
        List<EduCategoryApiEntity> newEduCategoryApi = new ArrayList<>();

        eduCategoryApiCount = eduCategoryApiService.eduCategoryApiCount();

        if (0 != eduCategoryApiCount) {
            Long eduCategorySequenceNumber = eduCategoryService.selectEduCategoryLastSequenceNumber();
            eduCategoryApiLastRecord = eduCategoryApiService.selectLastRecord();
            eduCategoryLastRecord = eduCategoryService.findFirstByIdLessThanOrderByIdDesc(eduCategorySequenceNumber);
            if (eduCategoryLastRecord.getId() > eduCategoryApiLastRecord.getEduCategoryId()) {
                Long eduCategoryApiEduCategoryIdPlusOne = eduCategoryApiLastRecord.getEduCategoryId() + 1;
                newEduCategorys = eduCategoryService.findAllEduCategoryProjectionByIdBetween(eduCategoryApiEduCategoryIdPlusOne, eduCategoryLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newEduCategorys = eduCategoryService.selectAllEduCategoryProjection();
        }

        newEduCategoryApi = eduCategoryApiService.generateEduCategoryApiPublicId(newEduCategorys);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newEduCategoryApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictEduCategoryCount() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "eduCategory count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ResponseEntity<?> eduCategoryNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested eduCategory not found")
                , HttpStatus.NOT_FOUND
        );
    }
}
