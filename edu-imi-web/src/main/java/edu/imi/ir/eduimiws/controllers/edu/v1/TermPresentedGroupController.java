package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.TermPresentedGroupResponseTermPresentedGroupFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermPresentedGroupFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedGroupFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedGroupResponse;
import edu.imi.ir.eduimiws.services.edu.TermPresentedGroupService;
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
@RequestMapping("/api/v1/termCourseProfessors")
@RequiredArgsConstructor
@Tag(name = "TermCourseProfessors", description = "The term course professors API")
public class TermPresentedGroupController {

    private final TermPresentedGroupService termPresentedGroupService;
    private final TermPresentedGroupFastDtoMapper termPresentedGroupFastDtoMapper;
    private final TermPresentedGroupResponseTermPresentedGroupFastDtoAssembler termPresentedGroupResponseTermPresentedGroupFastDtoAssembler;
    private final PagedResourcesAssembler<TermPresentedGroupFastDto> termPresentedGroupFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All term course professors",
            description = "Search term Course Professors detail pageable",
            tags = "termCourseProfessorss",
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
                                            schema = @Schema(implementation = TermPresentedGroupResponse.class)
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
    public ResponseEntity<PagedModel<TermPresentedGroupResponse>> getTermPresentedGroups(@Parameter(hidden = true)
                                                                                         @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                         @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                 Pageable pageable) {

        Page<TermPresentedGroupEntity> termPresentedGroupPages =
                termPresentedGroupService.findAllByOrderPageable(pageable);

        Page<TermPresentedGroupFastDto> termPresentedGroupFastDtoPage = termPresentedGroupPages
                .map(p -> termPresentedGroupFastDtoMapper
                        .toTermPresentedGroupFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<TermPresentedGroupResponse> termPresentedGroupResponsePagedModel = termPresentedGroupFastDtoPagedResourcesAssembler
                .toModel(termPresentedGroupFastDtoPage, termPresentedGroupResponseTermPresentedGroupFastDtoAssembler);

        return ResponseEntity.ok(termPresentedGroupResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<TermPresentedGroupResponse>> getAllTermPresentedGroups(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<TermPresentedGroupEntity> termPresentedGroupPages =
                termPresentedGroupService.findAllByOrderPageable(pageable);

        List<TermPresentedGroupEntity> termPresentedGroupEntities = StreamSupport
                .stream(termPresentedGroupPages.spliterator(), false)
                .collect(Collectors.toList());

        List<TermPresentedGroupFastDto> termPresentedGroupFastDtos = termPresentedGroupFastDtoMapper
                .toTermPresentedGroupFastDtos(termPresentedGroupEntities, new CycleAvoidingMappingContext());

        CollectionModel<TermPresentedGroupResponse> termPresentedGroupResponseCollectionModel =
                termPresentedGroupResponseTermPresentedGroupFastDtoAssembler.toCollectionModel(termPresentedGroupFastDtos);

        return ResponseEntity.ok(termPresentedGroupResponseCollectionModel);
    }

    @Operation(
            summary = "Find TermCourseProfessor by public ID",
            description = "Search term course professors by the public id",
            tags = "termCourseProfessors",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = TermPresentedGroupResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "termPresentedGroup not found",
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
    @GetMapping(path = "/{termCourseProfessorPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getTermPresentedGroupByTermPresentedGroupPublicId(@PathVariable String termPresentedGroupPublicId) {

        try {
            TermPresentedGroupEntity termPresentedGroup = termPresentedGroupService.findByTermPresentedGroupPublicId(termPresentedGroupPublicId);
            if (termPresentedGroup == null) {
                return this.termPresentedGroupNotFound();
            }

            TermPresentedGroupFastDto termPresentedGroupFastDto = termPresentedGroupFastDtoMapper
                    .toTermPresentedGroupFastDto(termPresentedGroup, new CycleAvoidingMappingContext());

            TermPresentedGroupResponse termPresentedGroupResponse =
                    termPresentedGroupResponseTermPresentedGroupFastDtoAssembler.toModel(termPresentedGroupFastDto);

            return ResponseEntity.ok(termPresentedGroupResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "find All term course professors with student and period name",
            description = "Search term course professors detail pageable with student and period name",
            tags = "termCourseProfessors",
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
                                            schema = @Schema(implementation = TermPresentedGroupResponse.class)
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
    @GetMapping(path = "/descriptive", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<TermPresentedGroupResponse>> getTermPresentedGroupsWithStudentPeriodName(@Parameter(hidden = true)
                                                                                                              @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                                              @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                                      Pageable pageable) {

        Page<TermPresentedGroupEntity> termPresentedGroupPages =
                termPresentedGroupService.selectAllWithCoursePeriodTermProfessorFieldCourseTermPresentedCourseByOrderPageable(pageable);

        Page<TermPresentedGroupFastDto> termPresentedGroupFastDtoPage = termPresentedGroupPages
                .map(p -> termPresentedGroupFastDtoMapper
                        .toTermPresentedGroupFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<TermPresentedGroupResponse> termPresentedGroupResponsePagedModel = termPresentedGroupFastDtoPagedResourcesAssembler
                .toModel(termPresentedGroupFastDtoPage, termPresentedGroupResponseTermPresentedGroupFastDtoAssembler);

        return ResponseEntity.ok(termPresentedGroupResponsePagedModel);
    }

    private ResponseEntity<?> termPresentedGroupNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested termPresentedGroup not found")
                , HttpStatus.NOT_FOUND
        );
    }

}
