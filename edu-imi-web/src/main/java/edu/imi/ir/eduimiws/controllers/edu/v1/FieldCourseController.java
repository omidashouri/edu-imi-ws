package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.FieldCourseResponseFieldCourseFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.FieldCourseResponse;
import edu.imi.ir.eduimiws.services.edu.FieldCourseService;
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
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/fieldCourses")
@RequiredArgsConstructor
@Tag(name = "FieldCourses", description = "The field course API")
public class FieldCourseController {

    private final FieldCourseService fieldCourseService;
    private final FieldCourseFastDtoMapper fieldCourseFastDtoMapper;
    private final FieldCourseResponseFieldCourseFastDtoAssembler fieldCourseResponseFieldCourseFastDtoAssembler;
    private final PagedResourcesAssembler<FieldCourseFastDto> fieldCourseFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All fieldCourses",
            description = "Search fieldCourse detail pageable",
            tags = "fieldCourses",
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
                                            schema = @Schema(implementation = FieldCourseResponse.class)
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
    public ResponseEntity<PagedModel<FieldCourseResponse>> getFieldCourses(@Parameter(hidden = true)
                                                                           @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                           @PageableDefault(page = 0, size = 10, value = 10)
                                                                                   Pageable pageable) {

        Page<FieldCourseEntity> fieldCoursePages =
                fieldCourseService.findAllByOrderPageable(pageable);

        Page<FieldCourseFastDto> fieldCourseFastDtoPage = fieldCoursePages
                .map(p -> fieldCourseFastDtoMapper
                        .toFieldCourseFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<FieldCourseResponse> fieldCourseResponsePagedModel = fieldCourseFastDtoPagedResourcesAssembler
                .toModel(fieldCourseFastDtoPage, fieldCourseResponseFieldCourseFastDtoAssembler);

        return ResponseEntity.ok(fieldCourseResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<FieldCourseResponse>> getAllFieldCourses(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<FieldCourseEntity> fieldCoursePages =
                fieldCourseService.findAllByOrderPageable(pageable);

        List<FieldCourseEntity> fieldCourseEntities = StreamSupport
                .stream(fieldCoursePages.spliterator(), false)
                .collect(Collectors.toList());

        List<FieldCourseFastDto> fieldCourseFastDtos = fieldCourseFastDtoMapper
                .toFieldCourseFastDtos(fieldCourseEntities, new CycleAvoidingMappingContext());

        CollectionModel<FieldCourseResponse> fieldCourseResponseCollectionModel =
                fieldCourseResponseFieldCourseFastDtoAssembler.toCollectionModel(fieldCourseFastDtos);

        return ResponseEntity.ok(fieldCourseResponseCollectionModel);
    }

    @Operation(
            summary = "Find FieldCourse by public ID",
            description = "Search fieldCourse by the public id",
            tags = "fieldCourses",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = FieldCourseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "fieldCourse not found",
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
    @GetMapping(path = "/{fieldCoursePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFieldCourseByFieldCoursePublicId(@PathVariable String fieldCoursePublicId) {

        try {
            FieldCourseEntity fieldCourse = fieldCourseService.findByFieldCoursePublicId(fieldCoursePublicId);
            if (fieldCourse == null) {
                return this.fieldCourseNotFound();
            }

            FieldCourseFastDto fieldCourseFastDto = fieldCourseFastDtoMapper
                    .toFieldCourseFastDto(fieldCourse, new CycleAvoidingMappingContext());

            FieldCourseResponse fieldCourseResponse =
                    fieldCourseResponseFieldCourseFastDtoAssembler.toModel(fieldCourseFastDto);

            return ResponseEntity.ok(fieldCourseResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    private ResponseEntity<?> fieldCourseNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested fieldCourse not found")
                , HttpStatus.NOT_FOUND
        );
    }
}
