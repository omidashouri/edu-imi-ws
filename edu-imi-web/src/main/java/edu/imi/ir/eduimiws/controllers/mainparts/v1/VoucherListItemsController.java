package edu.imi.ir.eduimiws.controllers.mainparts.v1;


import edu.imi.ir.eduimiws.assemblers.mainparts.VoucherListItemsApiResponseAssembler;
import edu.imi.ir.eduimiws.domain.mainparts.VoucherListItemsApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.mainparts.VoucherListItemsApiMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.VoucherListItemsApiResponseMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherListItemsApiDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.mainparts.VoucherListItemsApiResponse;
import edu.imi.ir.eduimiws.services.mainparts.VoucherListItemsService;
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
@RequestMapping("/api/v1/voucherListItems")
@RequiredArgsConstructor
@Tag(name = "VoucherListItems", description = "The Voucher List Items API")
public class VoucherListItemsController {


    private final VoucherListItemsService voucherListItemsService;
    private final VoucherListItemsApiMapper voucherListItemsApiMapper;
    private final VoucherListItemsApiResponseMapper voucherListItemsApiResponseMapper;
    private final VoucherListItemsApiResponseAssembler voucherListItemsApiResponseAssembler;
    private final PagedResourcesAssembler<VoucherListItemsApiDto> voucherListItemsApiDtoPagedResourcesAssembler;




    @Operation(
            summary = "find All voucherListItems",
            description = "Search voucherListItems detail pageable",
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
                                            schema = @Schema(implementation = VoucherListItemsApiResponse.class)
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
    public ResponseEntity<PagedModel<VoucherListItemsApiResponse>> getVoucherListItems(@Parameter(hidden = true)
                                                                                       @SortDefault(sort = "lastCreateDateMiladi", direction = Sort.Direction.DESC)
                                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                                               Pageable pageable) {

        Page<VoucherListItemsApiEntity> voucherListItemsPages =
                voucherListItemsService.findAllByDeleteStatusIsNull(pageable);

        Page<VoucherListItemsApiDto> voucherListItemsApiDtoPage = voucherListItemsPages
                .map(voucherListItemsApiMapper::voucherListItemsApiToVoucherListItemsApiDto);

        PagedModel<VoucherListItemsApiResponse> voucherListItemsResponsePagedModel = voucherListItemsApiDtoPagedResourcesAssembler
                .toModel(voucherListItemsApiDtoPage, voucherListItemsApiResponseAssembler);

        return ResponseEntity.ok(voucherListItemsResponsePagedModel);
    }

    @Operation(
            summary = "Find Voucher List Items by public ID",
            description = "Search voucher List items by the public id",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherListItemsApiResponse.class)
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
    @GetMapping(path = "/{voucherListItemsPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findByPublicId(@PathVariable String voucherListItemsPublicId) {

        VoucherListItemsApiEntity voucherListItemsApi = voucherListItemsService.findByPublicId(voucherListItemsPublicId);
        if (voucherListItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherListItemsApiDto voucherListItemsApiDto = voucherListItemsApiMapper
                .voucherListItemsApiToVoucherListItemsApiDto(voucherListItemsApi);

        VoucherListItemsApiResponse voucherListItemsApiResponse =
                voucherListItemsApiResponseAssembler.toModel(voucherListItemsApiDto);

        return ResponseEntity.ok(voucherListItemsApiResponse);

    }


    @Operation(
            summary = "Find Last Created Voucher Items",
            description = "Search  Last Created Voucher Items",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherListItemsApiResponse.class)
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
    @GetMapping(path = "/lastCreatedRecord",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findLastCreatedRecord() {

        VoucherListItemsApiEntity voucherListItemsApi = voucherListItemsService.findLastRecordOrderByCreateDate();
        if (voucherListItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherListItemsApiDto voucherListItemsApiDto = voucherListItemsApiMapper
                .voucherListItemsApiToVoucherListItemsApiDto(voucherListItemsApi);

        VoucherListItemsApiResponse voucherListItemsApiResponse =
                voucherListItemsApiResponseAssembler.toModel(voucherListItemsApiDto);

        return ResponseEntity.ok(voucherListItemsApiResponse);
    }



    @Operation(
            summary = "Find Last Edited Voucher Items",
            description = "Search  Last Edited Voucher Items",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherListItemsApiResponse.class)
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
    @GetMapping(path = "/lastEditedRecord",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findLastEditedRecord() {

        VoucherListItemsApiEntity voucherListItemsApi = voucherListItemsService.findLastRecordOrderByEditDate();
        if (voucherListItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherListItemsApiDto voucherListItemsApiDto = voucherListItemsApiMapper
                .voucherListItemsApiToVoucherListItemsApiDto(voucherListItemsApi);

        VoucherListItemsApiResponse voucherListItemsApiResponse =
                voucherListItemsApiResponseAssembler.toModel(voucherListItemsApiDto);

        return ResponseEntity.ok(voucherListItemsApiResponse);
    }



    @Operation(
            summary = "Find Last Deleted Voucher Items",
            description = "Search Last Deleted Voucher Items",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = VoucherListItemsApiResponse.class)
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
    @GetMapping(path = "/lastDeletedRecord",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findLastDeletedRecord() {

        VoucherListItemsApiEntity voucherListItemsApi = voucherListItemsService.findLastRecordOrderByDeleteDateTs();
        if (voucherListItemsApi == null) {
            throw new NotFoundException("requested voucher list item not found");
        }

        VoucherListItemsApiDto voucherListItemsApiDto = voucherListItemsApiMapper
                .voucherListItemsApiToVoucherListItemsApiDto(voucherListItemsApi);

        VoucherListItemsApiResponse voucherListItemsApiResponse =
                voucherListItemsApiResponseAssembler.toModel(voucherListItemsApiDto);

        return ResponseEntity.ok(voucherListItemsApiResponse);
    }




}
