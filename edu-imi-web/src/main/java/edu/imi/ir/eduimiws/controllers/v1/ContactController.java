package edu.imi.ir.eduimiws.controllers.v1;


import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import edu.imi.ir.eduimiws.services.crm.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/contacts")
@RequiredArgsConstructor
@Tag(name = "contacts", description = "The contact API")
public class ContactController {

    private final ContactService contactService;

    private final ContactMapper contactMapper;

//    IMI eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MDU3IiwiZXhwIjoxNTg3NjI0MDE1fQ.qJgwCKe2XWNRiT7w2kEZ65WDxlNWK0mn6qUM0u_90Ha-S1qshM5npIk0T71VbVkY1e5mPA_yILbHC9Th5iU1Og


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
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
    @GetMapping(path = "/{nationalCode}/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getContactCountByNationalCode(@PathVariable String nationalCode) {

        Long contactCount;
        OperationStatus returnValue = new OperationStatus();
        contactCount = contactService.getContactNumberByNationalCode(nationalCode);

        if(contactCount > 0) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
            returnValue.setOperationName(RequestOperationName.COUNT_ENTITY.name());
            returnValue.setDescription(contactCount + " Entity Found For " + nationalCode);
        }else{
            returnValue.setOperationResult(RequestOperationStatus.NO_CONTENT.name());
            returnValue.setOperationName(RequestOperationName.COUNT_ENTITY.name());
            returnValue.setDescription("No Entity Found");
        }
    return ResponseEntity.ok(returnValue);
    }


        @GetMapping(path = "/{nationalCode}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getContactByNationalCode(@PathVariable String nationalCode) {

        UserResponse returnValue = new UserResponse();

        List<ContactDto> contactDto = contactService.findContactByNationalCode(nationalCode);


//            List<UserContactResponse> userContactResponses = UserC
/*
                UserContactFastDto userContactFastDto = personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDto(user, new CycleAvoidingMappingContext());

        UserContactResponse userContactResponse = userContactResponseUserContactFastDtoMapper.UserContactFastDtoToUserContactResponse(userContactFastDto, new CycleAvoidingMappingContext());
*/

        return ResponseEntity.ok(null);
    }

}
