package edu.imi.ir.eduimiws.controllers.mainparts.v1;

import edu.imi.ir.eduimiws.assemblers.mainparts.VoucherDeleteItemsApiResponseAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.VoucherDeleteItemsApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.VoucherDeleteItemsApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.VoucherDeleteItemsApiResponseMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.models.response.mainparts.VoucherDeleteItemsApiResponse;
import edu.imi.ir.eduimiws.services.mainparts.VoucherDeleteItemsService;
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
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/voucherDeleteItems")
@RequiredArgsConstructor
@Tag(name = "VoucherDeleteItems", description = "The Voucher Delete Items API")
public class VoucherDeleteItemsController {

    private final VoucherDeleteItemsService voucherDeleteItemsService;
    private final VoucherDeleteItemsApiMapper voucherDeleteItemsApiMapper;
    private final VoucherDeleteItemsApiResponseMapper voucherDeleteItemsApiResponseMapper;
    private final VoucherDeleteItemsApiResponseAssembler voucherDeleteItemsApiResponseAssembler;
    private final PagedResourcesAssembler<VoucherDeleteItemsApiDto> voucherDeleteItemsApiDtoPagedResourcesAssembler;

    @Operation(
            summary = "find All voucherDeleteItems",
            description = "Search voucherDeleteItems detail pageable",
            tags = "vouchers",
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
                                            schema = @Schema(implementation = PeriodResponse.class)
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
    public ResponseEntity<PagedModel<VoucherDeleteItemsApiResponse>> getVoucherDeleteItems(@Parameter(hidden = true)
                                                                                       @SortDefault(sort = "dateOfRemoval", direction = Sort.Direction.DESC)
                                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                                               Pageable pageable) {

        Page<VoucherDeleteItemsApiEntity> voucherDeleteItemsPages =
                voucherDeleteItemsService.findAllByDeleteStatusIsNull(pageable);

        Page<VoucherDeleteItemsApiDto> voucherDeleteItemsApiDtoPage = voucherDeleteItemsPages
                .map(voucherDeleteItemsApiMapper::voucherDeleteItemsApiToVoucherDeleteItemsApiDto);

        PagedModel<VoucherDeleteItemsApiResponse> voucherDeleteItemsResponsePagedModel = voucherDeleteItemsApiDtoPagedResourcesAssembler
                .toModel(voucherDeleteItemsApiDtoPage, voucherDeleteItemsApiResponseAssembler);

        return ResponseEntity.ok(voucherDeleteItemsResponsePagedModel);
    }



    @Operation(
            summary = "Find Voucher Deleted Items by public ID",
            description = "Search voucher List Deleted Items by the public id",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherDeleteItemsApiEntity.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "voucher not found",
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
    @GetMapping(path = "/{voucherDeleteItemsPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findByPublicId(@PathVariable String voucherDeleteItemsPublicId) {

        VoucherDeleteItemsApiEntity voucherDeleteItemsApi = voucherDeleteItemsService.findByPublicId(voucherDeleteItemsPublicId);
        if (voucherDeleteItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherDeleteItemsApiDto voucherDeleteItemsApiDto = voucherDeleteItemsApiMapper
                .voucherDeleteItemsApiToVoucherDeleteItemsApiDto(voucherDeleteItemsApi);

        VoucherDeleteItemsApiResponse voucherDeleteItemsApiResponse =
                voucherDeleteItemsApiResponseAssembler.toModel(voucherDeleteItemsApiDto);

        return ResponseEntity.ok(voucherDeleteItemsApiResponse);

    }


    @Operation(
            summary = "Find Voucher Deleted Items by Id Api",
            description = "Search voucher Deleted Items by Id Api",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherDeleteItemsApiEntity.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "voucher not found",
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
    @GetMapping(path = "/lastRecordOrderByIdApi",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findLastInsertedRecord() {

        VoucherDeleteItemsApiEntity voucherDeleteItemsApi = voucherDeleteItemsService.findLastRecordOrderByApiId();
        if (voucherDeleteItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherDeleteItemsApiDto voucherDeleteItemsApiDto = voucherDeleteItemsApiMapper
                .voucherDeleteItemsApiToVoucherDeleteItemsApiDto(voucherDeleteItemsApi);

        VoucherDeleteItemsApiResponse voucherDeleteItemsApiResponse =
                voucherDeleteItemsApiResponseAssembler.toModel(voucherDeleteItemsApiDto);

        return ResponseEntity.ok(voucherDeleteItemsApiResponse);

    }
}
