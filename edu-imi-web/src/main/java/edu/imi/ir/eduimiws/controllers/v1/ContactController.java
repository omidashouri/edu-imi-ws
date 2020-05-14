package edu.imi.ir.eduimiws.controllers.v1;


import edu.imi.ir.eduimiws.assemblers.crm.ContactResponseAssembler;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.ContactResponseContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponse;
import edu.imi.ir.eduimiws.services.crm.ContactService;
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

@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/v1/contacts")
@RequiredArgsConstructor
@Tag(name = "contacts", description = "The contact API")
public class ContactController {

    private final ContactService contactService;
    private final ContactResponseContactFastDtoMapper contactResponseContactFastDtoMapper;
    private final ContactFastDtoMapper contactFastDtoMapper;
    private final ContactResponseAssembler contactResponseAssembler;
    private final PagedResourcesAssembler<ContactFastDto> contactPagedResourcesAssembler;

    @Operation(
            summary = "find All contacts",
            description = "Search contact detail pageable",
            tags = "contacts",
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
                                            schema = @Schema(implementation = ContactResponse.class)
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
    public ResponseEntity<PagedModel<ContactResponse>> getContacts(@Parameter(hidden = true)
                                                                 @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                 @PageableDefault(page = 0, size= 10,value = 10)
                                                                         Pageable pageable ){

        Page<ContactEntity> contactPages =
                contactService.findAllContactEntityPages (pageable);

        Page<ContactFastDto> contactFastDtoPage = contactPages
                .map(cp->contactFastDtoMapper
                        .toContactFastDto(cp,new CycleAvoidingMappingContext()));

        PagedModel<ContactResponse> contactResponsePagedModel = contactPagedResourcesAssembler
                .toModel(contactFastDtoPage,contactResponseAssembler);

        return ResponseEntity.ok(contactResponsePagedModel);
    }


    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<ContactResponse>> getAllContacts(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate",direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size= 10)
                    Pageable pageable){

        Page<ContactEntity> contactPages =
                contactService.findAllContactEntityPages(pageable);

        List<ContactEntity> contactEntities = StreamSupport
                .stream(contactPages.spliterator(),false)
                .collect(Collectors.toList());

        List<ContactFastDto> contactFastDtos = contactFastDtoMapper
                .toContactFastDtos(contactEntities,new CycleAvoidingMappingContext());

        CollectionModel<ContactResponse> contactResponseCollectionModel =
                contactResponseAssembler.toCollectionModel(contactFastDtos);

        return ResponseEntity.ok(contactResponseCollectionModel);
    }


    @Operation(
            summary = "Find Contact by public ID",
            description = "Search contact by the public id",
            tags = "contacts",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = ContactResponse.class)
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
    @GetMapping(path = "/{contactPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getContactByContactPublicId(@PathVariable String contactPublicId) {

        try {
            ContactEntity contact = contactService.findContactEntityByContactApiPublicId(contactPublicId);
            if (contact == null) {
                return this.contactNotFound();
            }

            ContactFastDto contactFastDto =
                    contactFastDtoMapper.toContactFastDto(contact,new CycleAvoidingMappingContext());

            ContactResponse contactResponse =
                    contactResponseAssembler.toModel(contactFastDto);

            return ResponseEntity.ok(contactResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "Find Contact count by National Code",
            description = "search contact by the national code"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User not found",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Do not have Permission",
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
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/{nationalCode}/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getContactCountByNationalCode(@PathVariable String nationalCode) {

        Long contactCount;
        OperationStatus returnValue = new OperationStatus();
        contactCount = contactService.getContactNumberByNationalCode(nationalCode);

        if (contactCount > 0) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
            returnValue.setOperationName(RequestOperationName.COUNT_ENTITY.name());
            returnValue.setDescription(contactCount + " Entity Found For " + nationalCode);
        } else {
            returnValue.setOperationResult(RequestOperationStatus.NO_CONTENT.name());
            returnValue.setOperationName(RequestOperationName.COUNT_ENTITY.name());
            returnValue.setDescription("No Entity Found");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            summary = "Find Contact by national Code",
            description = "Search contact by the national Code",
            tags = "contacts",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                        schema = @Schema(implementation = ContactResponse.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Contact not found",
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
    @GetMapping(path = "/nationalCode/{nationalCode}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getContactByNationalCode(@PathVariable String nationalCode) {

        List<ContactFastDto> contactFastDtos = contactService.findContactByNationalCode(nationalCode);

        if(contactFastDtos==null || contactFastDtos.size() == 0){
            return this.contactNotFound();
        }

        CollectionModel<ContactResponse> contactResponseCollectionModel =
                contactResponseAssembler.toCollectionModel(contactFastDtos);

        return ResponseEntity.ok(contactResponseCollectionModel);
    }

    private ResponseEntity<?> contactNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested contact not found")
                , HttpStatus.NOT_FOUND
        );
    }

}
