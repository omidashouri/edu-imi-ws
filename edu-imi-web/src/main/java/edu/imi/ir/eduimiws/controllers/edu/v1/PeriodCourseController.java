package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.PeriodCourseResponsePeriodCourseFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseResponse;
import edu.imi.ir.eduimiws.services.edu.PeriodCourseService;
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
@RequestMapping("/api/v1/periodCourses")
@RequiredArgsConstructor
@Tag(name = "PeriodCourses", description = "The period course API")
public class PeriodCourseController {

    private final PeriodCourseService periodCourseService;
    private final PeriodCourseResponsePeriodCourseFastDtoAssembler periodCourseResponsePeriodCourseFastDtoAssembler;
    private final PagedResourcesAssembler<PeriodCourseFastDto> periodCourseFastDtoPagedResourcesAssembler;
    private final PeriodCourseFastDtoMapper periodCourseFastDtoMapper;

    @Operation(
            summary = "find All periodCourses",
            description = "Search periodCourse detail pageable",
            tags = "periodCourses",
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
                                            schema = @Schema(implementation = PeriodCourseResponse.class)
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
    public ResponseEntity<PagedModel<PeriodCourseResponse>> getPeriods(@Parameter(hidden = true)
                                                                       @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                               Pageable pageable) {

        Page<PeriodCourseEntity> periodCoursePages =
                periodCourseService.findAllByPageable(pageable);

        Page<PeriodCourseFastDto> periodCourseFastDtoPage = periodCoursePages
                .map(p -> periodCourseFastDtoMapper
                        .toPeriodCourseFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodCourseResponse> periodCourseResponsePagedModel = periodCourseFastDtoPagedResourcesAssembler
                .toModel(periodCourseFastDtoPage, periodCourseResponsePeriodCourseFastDtoAssembler);

        return ResponseEntity.ok(periodCourseResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PeriodCourseResponse>> getAllPeriodCourses(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PeriodCourseEntity> periodCoursePages =
                periodCourseService.findAllByPageable(pageable);

        List<PeriodCourseEntity> periodCourseEntities = StreamSupport
                .stream(periodCoursePages.spliterator(), false)
                .collect(Collectors.toList());

        List<PeriodCourseFastDto> periodCourseFastDtos = periodCourseFastDtoMapper
                .toPeriodCourseFastDtos(periodCourseEntities, new CycleAvoidingMappingContext());

        CollectionModel<PeriodCourseResponse> periodCourseResponseCollectionModel =
                periodCourseResponsePeriodCourseFastDtoAssembler.toCollectionModel(periodCourseFastDtos);

        return ResponseEntity.ok(periodCourseResponseCollectionModel);
    }


    @Operation(
            summary = "Find PeriodCourse by public ID",
            description = "Search periodCourse by the public id",
            tags = "periodCourses",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PeriodCourseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "periodCourse not found",
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
    @GetMapping(path = "/{periodCoursePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPeriodCourseByPeriodCoursePublicId(@PathVariable String periodCoursePublicId) {

        try {
            PeriodCourseEntity periodCourse = periodCourseService.findByPeriodCoursePublicId(periodCoursePublicId);
            if (periodCourse == null) {
                return this.periodCourseNotFound();
            }

            PeriodCourseFastDto periodCourseFastDto = periodCourseFastDtoMapper
                    .toPeriodCourseFastDto(periodCourse, new CycleAvoidingMappingContext());

            PeriodCourseResponse periodCourseResponse =
                    periodCourseResponsePeriodCourseFastDtoAssembler.toModel(periodCourseFastDto);

            return ResponseEntity.ok(periodCourseResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    private ResponseEntity<?> periodCourseNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested periodCourse not found")
                , HttpStatus.NOT_FOUND
        );
    }
}
