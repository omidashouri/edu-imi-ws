package edu.imi.ir.eduimiws.controllers.edu.v1;

import edu.imi.ir.eduimiws.assemblers.edu.TermResponseTermFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.TermResponse;
import edu.imi.ir.eduimiws.services.edu.TermService;
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
@RequestMapping("/api/v1/terms")
@RequiredArgsConstructor
@Tag(name = "Terms", description = "The term API")
public class TermController {

    private final TermService termService;
    private final TermFastDtoMapper termFastDtoMapper;
    private final TermResponseTermFastDtoAssembler termResponseTermFastDtoAssembler;
    private final PagedResourcesAssembler<TermFastDto> termFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All terms",
            description = "Search term detail pageable",
            tags = "terms",
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
                                            schema = @Schema(implementation = TermResponse.class)
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
    public ResponseEntity<PagedModel<TermResponse>> getTerms(@Parameter(hidden = true)
                                                             @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                             @PageableDefault(page = 0, size = 10, value = 10)
                                                                     Pageable pageable) {

        Page<TermEntity> termPages =
                termService.findAllByOrderPageable(pageable);

        Page<TermFastDto> termFastDtoPage = termPages
                .map(p -> termFastDtoMapper
                        .toTermFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<TermResponse> termResponsePagedModel = termFastDtoPagedResourcesAssembler
                .toModel(termFastDtoPage, termResponseTermFastDtoAssembler);

        return ResponseEntity.ok(termResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<TermResponse>> getAllTerms(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<TermEntity> termPages =
                termService.findAllByOrderPageable(pageable);

        List<TermEntity> termEntities = StreamSupport
                .stream(termPages.spliterator(), false)
                .collect(Collectors.toList());

        List<TermFastDto> termFastDtos = termFastDtoMapper
                .toTermFastDtos(termEntities, new CycleAvoidingMappingContext());

        CollectionModel<TermResponse> termResponseCollectionModel =
                termResponseTermFastDtoAssembler.toCollectionModel(termFastDtos);

        return ResponseEntity.ok(termResponseCollectionModel);
    }

    @Operation(
            summary = "Find Term by public ID",
            description = "Search term by the public id",
            tags = "terms",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = TermResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "term not found",
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
    @GetMapping(path = "/{termPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getTermByTermPublicId(@PathVariable String termPublicId) {

            TermEntity term = termService.findByTermPublicId(termPublicId);
            if (term == null) {
                throw new NotFoundException("requested term not found");
            }

            TermFastDto termFastDto = termFastDtoMapper
                    .toTermFastDto(term, new CycleAvoidingMappingContext());

            TermResponse termResponse =
                    termResponseTermFastDtoAssembler.toModel(termFastDto);

            return ResponseEntity.ok(termResponse);

    }

}
