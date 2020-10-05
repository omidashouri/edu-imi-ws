package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.edu.CourseResponseCourseFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.CourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.CourseFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.CourseResponse;
import edu.imi.ir.eduimiws.services.edu.CourseService;
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

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(name = "Courses", description = "The course API")
public class CourseController {

    private final CourseService courseService;
    private final CourseResponseCourseFastDtoAssembler courseResponseCourseFastDtoAssembler;
    private final PagedResourcesAssembler<CourseFastDto> courseFastDtoPagedResourcesAssembler;
    private final CourseFastDtoMapper courseFastDtoMapper;

    @Operation(
            summary = "find All courses",
            description = "Search course detail pageable",
            tags = "courses",
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
                                            schema = @Schema(implementation = CourseResponse.class)
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
    public ResponseEntity<PagedModel<CourseResponse>> getPeriods(@Parameter(hidden = true)
                                                                 @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                 @PageableDefault(page = 0, size = 10, value = 10)
                                                                         Pageable pageable) {

        Page<CourseEntity> coursePages =
                courseService.findAllByPageable(pageable);

        Page<CourseFastDto> courseFastDtoPage = coursePages
                .map(p -> courseFastDtoMapper
                        .toCourseFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<CourseResponse> courseResponsePagedModel = courseFastDtoPagedResourcesAssembler
                .toModel(courseFastDtoPage, courseResponseCourseFastDtoAssembler);

        return ResponseEntity.ok(courseResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<CourseResponse>> getAllCourses(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<CourseEntity> coursePages =
                courseService.findAllByPageable(pageable);

        List<CourseEntity> courseEntities = StreamSupport
                .stream(coursePages.spliterator(), false)
                .collect(Collectors.toList());

        List<CourseFastDto> courseFastDtos = courseFastDtoMapper
                .toCourseFastDtos(courseEntities, new CycleAvoidingMappingContext());

        CollectionModel<CourseResponse> courseResponseCollectionModel =
                courseResponseCourseFastDtoAssembler.toCollectionModel(courseFastDtos);

        return ResponseEntity.ok(courseResponseCollectionModel);
    }


    @Operation(
            summary = "Find Course by public ID",
            description = "Search course by the public id",
            tags = "courses",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = CourseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "course not found",
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
    @GetMapping(path = "/{coursePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getCourseByCoursePublicId(@PathVariable String coursePublicId) {

        try {
            CourseEntity course = courseService.findByCoursePublicId(coursePublicId);
            if (course == null) {
                return this.courseNotFound();
            }

            CourseFastDto courseFastDto = courseFastDtoMapper
                    .toCourseFastDto(course, new CycleAvoidingMappingContext());

            CourseResponse courseResponse =
                    courseResponseCourseFastDtoAssembler.toModel(courseFastDto);

            return ResponseEntity.ok(courseResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    private ResponseEntity<?> courseNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested course not found")
                , HttpStatus.NOT_FOUND
        );
    }

}
