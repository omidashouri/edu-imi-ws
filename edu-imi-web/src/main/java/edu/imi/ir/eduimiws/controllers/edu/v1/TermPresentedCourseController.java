package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.TermPresentedCourseResponseTermPresentedCourseFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermPresentedCourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedCourseFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedCourseResponse;
import edu.imi.ir.eduimiws.services.edu.TermPresentedCourseService;
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
@RequestMapping("/api/v1/termPresentedCourses")
@RequiredArgsConstructor
@Tag(name = "TermPresentedCourses", description = "The term presented course API")
public class TermPresentedCourseController {

    private final TermPresentedCourseService termPresentedCourseService;
    private final TermPresentedCourseFastDtoMapper termPresentedCourseFastDtoMapper;
    private final TermPresentedCourseResponseTermPresentedCourseFastDtoAssembler termPresentedCourseResponseTermPresentedCourseFastDtoAssembler;
    private final PagedResourcesAssembler<TermPresentedCourseFastDto> termPresentedCourseFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All termPresentedCourses",
            description = "Search termPresentedCourse detail pageable",
            tags = "termPresentedCourses",
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
                                            schema = @Schema(implementation = TermPresentedCourseResponse.class)
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
    public ResponseEntity<PagedModel<TermPresentedCourseResponse>> getTermPresentedCourses(@Parameter(hidden = true)
                                                                                           @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                           @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                   Pageable pageable) {

        Page<TermPresentedCourseEntity> termPresentedCoursePages =
                termPresentedCourseService.findAllByOrderPageable(pageable);

        Page<TermPresentedCourseFastDto> termPresentedCourseFastDtoPage = termPresentedCoursePages
                .map(p -> termPresentedCourseFastDtoMapper
                        .toTermPresentedCourseFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<TermPresentedCourseResponse> termPresentedCourseResponsePagedModel = termPresentedCourseFastDtoPagedResourcesAssembler
                .toModel(termPresentedCourseFastDtoPage, termPresentedCourseResponseTermPresentedCourseFastDtoAssembler);

        return ResponseEntity.ok(termPresentedCourseResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<TermPresentedCourseResponse>> getAllTermPresentedCourses(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<TermPresentedCourseEntity> termPresentedCoursePages =
                termPresentedCourseService.findAllByOrderPageable(pageable);

        List<TermPresentedCourseEntity> termPresentedCourseEntities = StreamSupport
                .stream(termPresentedCoursePages.spliterator(), false)
                .collect(Collectors.toList());

        List<TermPresentedCourseFastDto> termPresentedCourseFastDtos = termPresentedCourseFastDtoMapper
                .toTermPresentedCourseFastDtos(termPresentedCourseEntities, new CycleAvoidingMappingContext());

        CollectionModel<TermPresentedCourseResponse> termPresentedCourseResponseCollectionModel =
                termPresentedCourseResponseTermPresentedCourseFastDtoAssembler.toCollectionModel(termPresentedCourseFastDtos);

        return ResponseEntity.ok(termPresentedCourseResponseCollectionModel);
    }

    @Operation(
            summary = "Find TermPresentedCourse by public ID",
            description = "Search termPresentedCourse by the public id",
            tags = "termPresentedCourses",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = TermPresentedCourseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "termPresentedCourse not found",
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
    @GetMapping(path = "/{termPresentedCoursePublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getTermPresentedCourseByTermPresentedCoursePublicId(@PathVariable String termPresentedCoursePublicId) {

        try {
            TermPresentedCourseEntity termPresentedCourse = termPresentedCourseService.findByTermPresentedCoursePublicId(termPresentedCoursePublicId);
            if (termPresentedCourse == null) {
                return this.termPresentedCourseNotFound();
            }

            TermPresentedCourseFastDto termPresentedCourseFastDto = termPresentedCourseFastDtoMapper
                    .toTermPresentedCourseFastDto(termPresentedCourse, new CycleAvoidingMappingContext());

            TermPresentedCourseResponse termPresentedCourseResponse =
                    termPresentedCourseResponseTermPresentedCourseFastDtoAssembler.toModel(termPresentedCourseFastDto);

            return ResponseEntity.ok(termPresentedCourseResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    private ResponseEntity<?> termPresentedCourseNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested termPresentedCourse not found")
                , HttpStatus.NOT_FOUND
        );
    }
}
