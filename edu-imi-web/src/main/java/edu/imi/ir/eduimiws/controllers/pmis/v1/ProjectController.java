package edu.imi.ir.eduimiws.controllers.pmis.v1;

import com.querydsl.core.types.dsl.BooleanExpression;
import edu.imi.ir.eduimiws.assemblers.pmis.ProjectResponseAssembler;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectResponseProjectDtoMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.pmis.ProjectResponse;
import edu.imi.ir.eduimiws.predicates.v2.QueryDSLPredicatesBuilder;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
import edu.imi.ir.eduimiws.utilities.QueryDslAsQueryParam;
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
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "projects", description = "The project API")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectResponseProjectDtoMapper projectResponseProjectDtoMapper;
    private final ProjectFastMapper projectFastMapper;
    private final ProjectResponseAssembler projectResponseAssembler;
    private final PagedResourcesAssembler<ProjectDto> projectPagedResourcesAssembler;


    @Operation(
            summary = "find All projects",
            description = "Search project detail pageable",
            tags = "projects",
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
                                            schema = @Schema(implementation = ProjectResponse.class)
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
    public ResponseEntity<PagedModel<ProjectResponse>> getProjects(@Parameter(hidden = true)
                                                                   @SortDefault(sort = "createDate",
                                                                           direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {

        Page<ProjectEntity> projectPages =
                projectService.findAllProjectEntityPages(pageable);

        Page<ProjectDto> projectFastDtoPage = projectPages
                .map(cp -> projectFastMapper
                        .toProjectDto(cp, new CycleAvoidingMappingContext()));

        PagedModel<ProjectResponse> projectResponsePagedModel = projectPagedResourcesAssembler
                .toModel(projectFastDtoPage, projectResponseAssembler);

        return ResponseEntity.ok(projectResponsePagedModel);
    }


    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<ProjectResponse>> getAllProjects(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<ProjectEntity> projectPages =
                projectService.findAllProjectEntityPages(pageable);

        List<ProjectEntity> projectEntities = StreamSupport
                .stream(projectPages.spliterator(), false)
                .collect(Collectors.toList());

        List<ProjectDto> projectFastDtos = projectFastMapper
                .toProjectDtos(projectEntities, new CycleAvoidingMappingContext());

        CollectionModel<ProjectResponse> projectResponseCollectionModel =
                projectResponseAssembler.toCollectionModel(projectFastDtos);

        return ResponseEntity.ok(projectResponseCollectionModel);
    }

    @Operation(
            summary = "Find Project by public ID",
            description = "Search project by the public id",
            tags = "projects",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectResponse.class)
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
    @GetMapping(path = "/{projectPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectByProjectPublicId(@PathVariable String projectPublicId) {

        try {
            ProjectEntity project = projectService.findProjectEntityByProjectApiPublicId(projectPublicId);
            if (project == null) {
                return this.projectNotFound();
            }

            ProjectDto projectFastDto =
                    projectFastMapper.toProjectDto(project, new CycleAvoidingMappingContext());

            ProjectResponse projectResponse =
                    projectResponseAssembler.toModel(projectFastDto);

            return ResponseEntity.ok(projectResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            hidden = true,
            summary = "Find Project by Query",
            description = "Search project by Query",
            tags = "projects",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProjectResponse.class)
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
    @QueryDslAsQueryParam
    @PageableAsQueryParam
    @DisableMethod
    @GetMapping(path = "/search/{criteria}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProjectBySearch(@PathVariable String criteria,
                                                @Parameter(hidden = true)
                                                @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                @PageableDefault(page = 0, size = 10, value = 10)
                                                        Pageable pageable) {

/*        try {
            if (criteria == null || criteria.length() == 0) {
                return this.projectNotFound();
            }

            BooleanExpression expression = new QueryDSLPredicatesBuilder<>(ProjectEntity.class)
                    .with(criteria).build();

            Page<ProjectEntity> projectPages =
                    projectService.findAllByPredicate(expression, pageable);

            Page<ProjectDto> projectFastDtoPage = projectPages
                    .map(cp -> projectFastMapper
                            .toProjectDto(cp, new CycleAvoidingMappingContext()));

            PagedModel<ProjectResponse> projectResponsePagedModel = projectPagedResourcesAssembler
                    .toModel(projectFastDtoPage, projectResponseAssembler);

            return ResponseEntity.ok(projectResponsePagedModel);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }*/
        return null;
    }

    private ResponseEntity<?> projectNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.toString()
                        , "requested project not found")
                , HttpStatus.NOT_FOUND
        );
    }

}
