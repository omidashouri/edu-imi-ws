package edu.imi.ir.eduimiws.controllers.edu.v1;


import edu.imi.ir.eduimiws.assemblers.edu.PeriodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCourseProfessorFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseProfessorResponse;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedGroupResponse;
import edu.imi.ir.eduimiws.services.edu.PeriodCourseProfessorService;
import edu.imi.ir.eduimiws.utilities.SwaggerUtil;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/periodCourseProfessors")
@RequiredArgsConstructor
@Tag(name = "PeriodCourseProfessors", description = "The period course professor API")
public class PeriodCourseProfessorController {

    private final PeriodCourseProfessorService periodCourseProfessorService;
    private final PeriodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler periodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler;
    private final PagedResourcesAssembler<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtoPagedResourcesAssembler;
    private final PeriodCourseProfessorFastDtoMapper periodCourseProfessorFastDtoMapper;

    @Operation(
            summary = "find All periodCourseProfessors",
            description = "Search periodCourseProfessor detail pageable",
            tags = "periodCourseProfessors",
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
                                            schema = @Schema(implementation = PeriodCourseProfessorResponse.class)
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
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodCourseProfessorResponse>> getPeriods(@Parameter(hidden = true)
                                                                                @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                @PageableDefault(page = 0, size = 10, value = 10)
                                                                                        Pageable pageable) {

        Page<PeriodCourseProfessorEntity> periodCourseProfessorPages =
                periodCourseProfessorService.findAllByPageable(pageable);

        Page<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtoPage = periodCourseProfessorPages
                .map(p -> periodCourseProfessorFastDtoMapper
                        .toPeriodCourseProfessorFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodCourseProfessorResponse> periodCourseProfessorResponsePagedModel = periodCourseProfessorFastDtoPagedResourcesAssembler
                .toModel(periodCourseProfessorFastDtoPage, periodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler);

        return ResponseEntity.ok(periodCourseProfessorResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<PeriodCourseProfessorResponse>> getAllPeriodCourseProfessors(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PeriodCourseProfessorEntity> periodCourseProfessorPages =
                periodCourseProfessorService.findAllByPageable(pageable);

        List<PeriodCourseProfessorEntity> periodCourseProfessorEntities = StreamSupport
                .stream(periodCourseProfessorPages.spliterator(), false)
                .collect(Collectors.toList());

        List<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtos = periodCourseProfessorFastDtoMapper
                .toPeriodCourseProfessorFastDtos(periodCourseProfessorEntities, new CycleAvoidingMappingContext());

        CollectionModel<PeriodCourseProfessorResponse> periodCourseProfessorResponseCollectionModel =
                periodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler.toCollectionModel(periodCourseProfessorFastDtos);

        return ResponseEntity.ok(periodCourseProfessorResponseCollectionModel);
    }


    @Operation(
            summary = "Find PeriodCourseProfessor by public ID",
            description = "Search periodCourseProfessor by the public id",
            tags = "periodCourseProfessors",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = PeriodCourseProfessorResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "periodCourseProfessor not found",
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
    @GetMapping(path = "/{periodCourseProfessorPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPeriodCourseProfessorByPeriodCourseProfessorPublicId(
            @PathVariable String periodCourseProfessorPublicId) {

            PeriodCourseProfessorEntity periodCourseProfessor = periodCourseProfessorService
                    .findByPeriodCourseProfessorPublicId(periodCourseProfessorPublicId);
            if (periodCourseProfessor == null) {
                throw new NotFoundException("requested periodCourseProfessor not found");
            }

            PeriodCourseProfessorFastDto periodCourseProfessorFastDto = periodCourseProfessorFastDtoMapper
                    .toPeriodCourseProfessorFastDto(periodCourseProfessor, new CycleAvoidingMappingContext());

            PeriodCourseProfessorResponse periodCourseProfessorResponse =
                    periodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler
                            .toModel(periodCourseProfessorFastDto);

            return ResponseEntity.ok(periodCourseProfessorResponse);

    }

    @Operation(
            summary = "find All period course professors with professor and course and period name",
            description = "Search period course professors detail pageable with professor and course and period name",
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
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/descriptive", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<PeriodCourseProfessorResponse>> getPeriodCourseProfessorsWithCourseProfessorPeriodName(@Parameter(hidden = true)
                                                                                                                            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                                                                            @PageableDefault(page = 0, size = 10, value = 10)
                                                                                                                                    Pageable pageable) {

        Page<PeriodCourseProfessorEntity> periodCourseProfessorPages =
                periodCourseProfessorService.findAllByPeriodCourseProfessorFieldNamePageable(pageable);

        Page<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtoPage = periodCourseProfessorPages
                .map(p -> periodCourseProfessorFastDtoMapper
                        .toPeriodCourseProfessorFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<PeriodCourseProfessorResponse> periodCourseProfessorResponsePagedModel = periodCourseProfessorFastDtoPagedResourcesAssembler
                .toModel(periodCourseProfessorFastDtoPage, periodCourseProfessorResponsePeriodCourseProfessorFastDtoAssembler);

        return ResponseEntity.ok(periodCourseProfessorResponsePagedModel);
    }

}
