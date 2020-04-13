package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserContactResponseUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.UserContactFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.crm.UserContactResponse;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import edu.imi.ir.eduimiws.services.crm.PersonService;
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
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Tag(name = "users", description = "The user API")
public class UserController {

    private final PersonService personService;
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

    @Operation(
            summary = "Count new user numbers",
            description = "search for new users that do not have user public id " +
                    "by comparing person id in person entity and person web service entity. ",
            tags = "users",
            security = @SecurityRequirement(name = "imi-security-key")
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
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
    @GetMapping(path = "/count-new-users",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewUserCount() {

        OperationStatus returnValue = new OperationStatus();
        Long userWebserviceCount;
        Long userCount;
        Long newUserCount;

        userWebserviceCount = personWebServiceService.personWebServiceCount();
        userCount = personService.selectPersonLastSequenceNumber();

        if (userCount == null || userCount == 0) {
            this.conflictUserCount();
        }

        if (userWebserviceCount != null) {
            newUserCount = userCount - userWebserviceCount;
        } else {
            newUserCount = userCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newUserCount > 0) {
            returnValue.setDescription(newUserCount + " New Record Found. use 'generate-public-id' link");

            Link link = WebMvcLinkBuilder.linkTo(UserController.class)
                    .slash("generate-public-id")
                    .withRel("generate-public-id");

            returnValue.add(link);
        } else {
            returnValue.setDescription("New Entity Not Found");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            summary = "Generate User Public Id",
            description = "generate public id for new users",
            tags = "users",
            security = @SecurityRequirement(name = "imi-security-key")
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
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
/*    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})*/
    public ResponseEntity<?> createPersonWebServicePublicId() {
//omiddo: later make decision about this method
      /*  OperationStatus returnValue = new OperationStatus();
        Long personWebserviceCount;
        Long personLastSequenceNumber;
        PersonWebServiceEntity personWebServiceLastRecord;
        List<PersonEntity> newPersons;
        List<PersonWebServiceEntity> newPersonWebServices;
        personWebserviceCount = personWebServiceService.personWebServiceCount();

//        newPersonsNotInPersonWebService();

        if (0 != personWebserviceCount) {
            personLastSequenceNumber = personService.selectPersonLastSequenceNumber();
            personWebServiceLastRecord = personWebServiceService.selectLastRecord();
            if(personLastSequenceNumber>personWebServiceLastRecord.getPersonId()){
                newPersons = personService.
                    findPersonUserProjectionsByIdGreaterThan(703484L);
            }else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_RECORDS.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        }else{
            newPersons = personService.findAllPersonUserProjectionOrderById();
        }

        newPersonWebServices = personWebServiceService
                .generatePersonWebServicePublicId(newPersons);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_RECORDS.name());
        returnValue.setDescription(newPersonWebServices.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictPeriodCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "period count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );*/
      return null;
    }


    private ResponseEntity<?> conflictUserCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "user count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private List<PersonEntity> newPersonsNotInPersonWebService(){
    /*    List<PersonEntity> persons;
        List<PersonWebServiceEntity> personWebServices;
        List<PersonEntity> newPersons = new ArrayList<>();

        personWebServices = personWebServiceService.findAllPersonWebServiceIdProjection();
        persons = personService.findAllPersonIdProjection();


        persons.stream().map(newPersons::add);

        persons.size();

         persons
                .stream()
                .map(PersonEntity::getId)
                .filter(
                        personWebServices
                                .stream()
                                .map(PersonWebServiceEntity::getPersonId)
                                .collect(Collectors.toSet())
                ::contains);

        newPersons
                .stream()
                .map(PersonEntity::getId)
                .collect(Collectors.toList())
                .removeAll(
                        personWebServices
                                .stream()
                                .map(PersonWebServiceEntity::getPersonId)
                                .collect(Collectors.toSet()));

        persons.size();
        newPersons.size();
        return persons;*/
    return null;
    }
}
