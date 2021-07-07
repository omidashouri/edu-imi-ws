package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.ProfessorResponseProfessorFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.ProfessorFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.ProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.ProfessorResponse;
import edu.imi.ir.eduimiws.services.edu.ProfessorService;
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
@RequestMapping("/api/v1/professors")
@RequiredArgsConstructor
@Tag(name = "professors", description = "The professor API")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorResponseProfessorFastDtoAssembler professorResponseProfessorFastDtoAssembler;
    private final PagedResourcesAssembler<ProfessorFastDto> professorFastDtoPagedResourcesAssembler;
    private final ProfessorFastDtoMapper professorFastDtoMapper;

    @Operation(
            summary = "find All professors",
            description = "Search professor detail pageable",
            tags = "professors",
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
                                            schema = @Schema(implementation = ProfessorResponse.class)
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
    public ResponseEntity<PagedModel<ProfessorResponse>> getPeriods(@Parameter(hidden = true)
                                                                    @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                    @PageableDefault(page = 0, size = 10, value = 10)
                                                                            Pageable pageable) {

        Page<ProfessorEntity> professorPages =
                professorService.findAllByPageable(pageable);

        Page<ProfessorFastDto> professorFastDtoPage = professorPages
                .map(p -> professorFastDtoMapper
                        .toProfessorFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<ProfessorResponse> professorResponsePagedModel = professorFastDtoPagedResourcesAssembler
                .toModel(professorFastDtoPage, professorResponseProfessorFastDtoAssembler);

        return ResponseEntity.ok(professorResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<ProfessorResponse>> getAllProfessors(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<ProfessorEntity> professorPages =
                professorService.findAllByPageable(pageable);

        List<ProfessorEntity> professorEntities = StreamSupport
                .stream(professorPages.spliterator(), false)
                .collect(Collectors.toList());

        List<ProfessorFastDto> professorFastDtos = professorFastDtoMapper
                .toProfessorFastDtos(professorEntities, new CycleAvoidingMappingContext());

        CollectionModel<ProfessorResponse> professorResponseCollectionModel =
                professorResponseProfessorFastDtoAssembler.toCollectionModel(professorFastDtos);

        return ResponseEntity.ok(professorResponseCollectionModel);
    }


    @Operation(
            summary = "Find Professor by public ID",
            description = "Search professor by the public id",
            tags = "professors",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ProfessorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "professor not found",
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
    @GetMapping(path = "/{professorPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getProfessorByProfessorPublicId(@PathVariable String professorPublicId) {

            ProfessorEntity professor = professorService.findByProfessorPublicId(professorPublicId);
            if (professor == null) {
                throw new NotFoundException("requested professor not found");
            }

            ProfessorFastDto professorFastDto = professorFastDtoMapper
                    .toProfessorFastDto(professor, new CycleAvoidingMappingContext());

            ProfessorResponse professorResponse =
                    professorResponseProfessorFastDtoAssembler.toModel(professorFastDto);

            return ResponseEntity.ok(professorResponse);

    }
}
