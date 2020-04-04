package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserContactResponseUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.UserContactFastDto;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import edu.imi.ir.eduimiws.models.response.UserResponse;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Tag(name = "users", description = "The user API")
public class UserController {

    private final PersonWebServiceService personWebServiceService;
    private final PersonWebServiceUserContactFastDtoMapper personWebServiceUserContactFastDtoMapper;
    private final UserContactResponseUserContactFastDtoMapper userContactResponseUserContactFastDtoMapper;


    // http://localhost:8080/edu-imi-ws/v1/users/aLIRVt88hdQ858q5AMURm1QI6DC3Je
    // in header add Accept : application/xml or application/json

    @Operation(
            summary = "Find user by public ID",
            description = "search member by the public id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = UserContactResponse.class
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
    @GetMapping(path = "/{userPublicId}",
//            make response as XML or JSON
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUser(@PathVariable String userPublicId) {

        UserResponse returnValue = new UserResponse();

        PersonWebServiceEntity user = personWebServiceService.findPersonWebServiceEntityByUserPublicId(userPublicId);

        UserContactFastDto userContactFastDto = personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDto(user, new CycleAvoidingMappingContext());

        UserContactResponse userContactResponse = userContactResponseUserContactFastDtoMapper.UserContactFastDtoToUserContactResponse(userContactFastDto, new CycleAvoidingMappingContext());

        return ResponseEntity.ok(userContactResponse);
    }

    @Operation(
            summary = "find All users",
            description = "Search user detail",
            tags = "users",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            headers = {@Header(name = "authorization", description = "authorization description"), @Header(name = "userPublicId")},
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = UserContactResponse.class)
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
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUsers(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue) {

        List<UserContactResponse> userContactResponses;

        List<PersonWebServiceEntity> users =
                personWebServiceService
                        .findAllListByPageAndSize(pageValue, limitValue);

        List<UserContactFastDto> userContactFastDtos =
                personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDtoes(users, new CycleAvoidingMappingContext());


        userContactResponses =
                userContactResponseUserContactFastDtoMapper
                        .UserContactFastDtoToUserContactResponses(userContactFastDtos, new CycleAvoidingMappingContext());

        return ResponseEntity.ok(userContactResponses);
    }
}
