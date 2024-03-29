package edu.imi.ir.eduimiws.controllers.crm.v1;

import edu.imi.ir.eduimiws.assemblers.crm.UserResponseAssembler;
import edu.imi.ir.eduimiws.assemblers.crm.UserRolePrivilegeResponseAssembler;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.exceptions.controllers.InternalServerErrorException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonApiUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserRegisterUserFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.request.UserRegister;
import edu.imi.ir.eduimiws.models.request.UserRolePrivilege;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import edu.imi.ir.eduimiws.models.response.crm.UserRolePrivilegeResponse;
import edu.imi.ir.eduimiws.proxies.crm.CrmServiceProxy;
import edu.imi.ir.eduimiws.security.ActiveUserService2;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.crm.PersonApiService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "users", description = "The user API")
public class UserController {

    private final CrmServiceProxy crmServiceProxy;
    private final PersonService personService;
    private final PersonApiService personApiService;
    private final UserService userService;
    private final PersonApiUserContactFastDtoMapper personApiUserContactFastDtoMapper;
    private final UserFastDtoMapper userFastDtoMapper;
    private final UserResponseAssembler userResponseAssembler;
    private final UserRolePrivilegeResponseAssembler userRolePrivilegeResponseAssembler;
    private final PagedResourcesAssembler<UserFastDto> userPagedResourcesAssembler;
    private final ActiveUserService2 activeUserService;
    private final UserRegisterUserFastDtoMapper userRegisterUserFastDtoMapper;

    // http://localhost:8080/edu-imi-ws/v1/users/aLIRVt88hdQ858q5AMURm1QI6DC3Je
    // in header add Accept : application/xml or application/json

    @GetMapping(path = "/active",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<UserResponse>> getAllActive() {

        List<String> activeUserNames = activeUserService.getAllActiveUserNames();

        List<UserResponse> userResponses =
                activeUserNames
                        .stream()
                        .map(u -> new UserResponse(u))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(userResponses);
       /* Page<PersonEntity> personPages =
                personService.findAllPersonEntityPagesByUserName(pageable,username);

        List<PersonEntity> personEntities = StreamSupport
                .stream(personPages.spliterator(),false)
                .collect(Collectors.toList());

        List<UserFastDto> userFastDtos = userFastDtoMapper
                .toUserFastDtos(personEntities,new CycleAvoidingMappingContext());

        CollectionModel<UserResponse> userResponseCollectionModel =
                userResponseAssembler.toCollectionModel(userFastDtos);

        return ResponseEntity.ok(userResponseCollectionModel);*/
    }


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
                                            implementation = UserResponse.class
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
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUserByUserPublicId(@PathVariable String userPublicId) {

//            PersonEntity person = personService.findPersonEntityByPersonApiPublicId(userPublicId);
            PersonEntity person = crmServiceProxy.
                    createPersonServiceProxyInstance().
                    findPersonEntityByPersonApiPublicId(userPublicId);


            if (person == null) {
                throw new NotFoundException("requested user not found");
            }

            UserFastDto userFastDto =
                    userFastDtoMapper.toUserFastDto(person, new CycleAvoidingMappingContext());

            UserResponse userResponse =
                    userResponseAssembler.toModel(userFastDto);

            return ResponseEntity.ok(userResponse);
    }


    @Operation(
            summary = "find All users",
            description = "Search user detail pageable",
            tags = "users",
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
                                            schema = @Schema(implementation = UserResponse.class)
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
    public ResponseEntity<PagedModel<UserResponse>> getUsers(@Parameter(hidden = true)
                                                             @SortDefault(sort = "personalCode",
                                                                     direction = Sort.Direction.DESC)
                                                             @PageableDefault(page = 0, size = 10, value = 10)
                                                                     Pageable pageable) {

        Page<PersonEntity> personPages =
                personService.findAllPersonEntityPages(pageable);

        Page<UserFastDto> userFastDtoPage = personPages
                .map(pp -> userFastDtoMapper
                        .toUserFastDto(pp, new CycleAvoidingMappingContext()));

        PagedModel<UserResponse> userResponsePagedModel = userPagedResourcesAssembler
                .toModel(userFastDtoPage, userResponseAssembler);

        return ResponseEntity.ok(userResponsePagedModel);
    }

    @Operation(
            hidden = true,
            summary = "find All persons",
            description = "Search persons detail pageable",
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
                                            schema = @Schema(implementation = PersonEntity.class)
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
    @DisableMethod
    @GetMapping(path = "/specification",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getPersonQuerySpecification(@RequestParam(value = "firstName", required = false)String  firstName,
                                         @RequestParam Optional<String> lastName,
                                         @Parameter(hidden = true)
                                                                   @SortDefault(sort = "id",
                                                                           direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {


        Specification<PersonEntity> personSpecification = personService
                .getPersonQuerySpecification(firstName, lastName.orElse(null));

        Page<PersonEntity> personPages = personService
                .findAllPersonEntitySpecificationPages(pageable, personSpecification);

        Page<UserFastDto> userFastDtoPage = personPages
                .map(pp -> userFastDtoMapper
                        .toUserFastDto(pp, new CycleAvoidingMappingContext()));

        PagedModel<UserResponse> userResponsePagedModel = userPagedResourcesAssembler
                .toModel(userFastDtoPage, userResponseAssembler);

        return ResponseEntity.ok(userResponsePagedModel);
    }


    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<UserResponse>> getAllUsers(
            @Parameter(hidden = true)
            @SortDefault(sort = "personalCode", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<PersonEntity> personPages =
                personService.findAllPersonEntityPages(pageable);

        List<PersonEntity> personEntities = StreamSupport
                .stream(personPages.spliterator(), false)
                .collect(Collectors.toList());

        List<UserFastDto> userFastDtos = userFastDtoMapper
                .toUserFastDtos(personEntities, new CycleAvoidingMappingContext());

        CollectionModel<UserResponse> userResponseCollectionModel =
                userResponseAssembler.toCollectionModel(userFastDtos);

        return ResponseEntity.ok(userResponseCollectionModel);
    }


    @Operation(
            summary = "find All users by username",
            description = "Search user by username pageable",
            tags = "users",
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
                                            schema = @Schema(implementation = UserResponse.class)
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
    @GetMapping(path = "/username/{username}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<UserResponse>> getUsersByUserName(@PathVariable String username,
                                                                       @Parameter(hidden = true)
                                                                       @SortDefault(sort = "personalCode",
                                                                               direction = Sort.Direction.DESC)
                                                                       @PageableDefault(page = 0, size = 10, value = 10)
                                                                               Pageable pageable) {

        Page<PersonEntity> personPages =
                personService.findAllPersonEntityPagesByUserName(pageable, username);

        Page<UserFastDto> userFastDtoPage = personPages
                .map(pp -> userFastDtoMapper
                        .toUserFastDto(pp, new CycleAvoidingMappingContext()));

        PagedModel<UserResponse> userResponsePagedModel = userPagedResourcesAssembler
                .toModel(userFastDtoPage, userResponseAssembler);

        return ResponseEntity.ok(userResponsePagedModel);
    }

    @Operation(hidden = true)
    @SwaggerUtil.PageableAsQueryParam
    @GetMapping(path = "/username/{username}/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<UserResponse>> getAllUsersByUserName(@PathVariable String username,
                                                                               @Parameter(hidden = true)
                                                                               @SortDefault(sort = "personalCode", direction = Sort.Direction.DESC)
                                                                               @PageableDefault(page = 0, size = 10)
                                                                                       Pageable pageable) {

        Page<PersonEntity> personPages =
                personService.findAllPersonEntityPagesByUserName(pageable, username);

        List<PersonEntity> personEntities = StreamSupport
                .stream(personPages.spliterator(), false)
                .collect(Collectors.toList());

        List<UserFastDto> userFastDtos = userFastDtoMapper
                .toUserFastDtos(personEntities, new CycleAvoidingMappingContext());

        CollectionModel<UserResponse> userResponseCollectionModel =
                userResponseAssembler.toCollectionModel(userFastDtos);

        return ResponseEntity.ok(userResponseCollectionModel);
    }

//    ----------------------------------------------------------------------

    @Operation(
            hidden = true,
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
    @DisableMethod
    @GetMapping(path = "/new/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewUserCount() {

        OperationStatus returnValue = new OperationStatus();
        Long userWebserviceCount;
        Long userCount;
        Long newUserCount;

        userWebserviceCount = personApiService.personApiCount();
        userCount = personService.selectPersonLastSequenceNumber();

        if (userCount == null || userCount == 0) {
            throw new InternalServerErrorException("user count is null or zero");
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
            summary = "Find user by national Code",
            description = "Search user by the national Code",
            tags = "users",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = UserResponse.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Person not found",
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
    public ResponseEntity<?> getUserByNationalCode(@PathVariable String nationalCode) {

        List<PersonEntity> persons = personService.findPersonsByNationalCode(nationalCode);

        List<UserFastDto> userFastDtos = userFastDtoMapper
                .toUserFastDtos(persons, new CycleAvoidingMappingContext());

        if (userFastDtos == null || userFastDtos.size() == 0) {
            throw new NotFoundException("requested user not found");
        }

        CollectionModel<UserResponse> userResponseCollectionModel =
                userResponseAssembler.toCollectionModel(userFastDtos);

        return ResponseEntity.ok(userResponseCollectionModel);
    }


    @Operation(
            hidden = true,
            summary = "Register User",
            description = "register User",
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
                                            implementation = UserResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Not Acceptable",
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
    @DisableMethod
    @PostMapping(path = "/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createUser(@RequestBody UserRegister userRegister) {

        UserResponse returnValue = new UserResponse();
        List<PersonEntity> savedPersons = new ArrayList<>();
        String nationalCode = null;
        Long userCount;

        if (userRegister.getNationCode().isEmpty()) {
            throw new BadRequestException("national code is null");
        } else {
            nationalCode = userRegister.getNationCode();
        }

        List<PersonEntity> duplicatePersons = personService
                .findPersonsByNationalCode(nationalCode);


        if (duplicatePersons.size() > 0) {
            throw new NotAcceptableException("national code is redundant");
        }

        UserFastDto userFastDto = userRegisterUserFastDtoMapper
                .toUserFastDto(userRegister, new CycleAvoidingMappingContext());

        PersonEntity newPerson = userService
                .saveUserByUserFastDto(userFastDto);

//        with new trigger, no more need to this
/*        savedPersons = userService
                .generateContactPersonPublicIdByPersons(Arrays.asList(newPerson));*/

        List<UserFastDto> savedUserFastDto = userFastDtoMapper
                .toUserFastDtos(savedPersons, new CycleAvoidingMappingContext());

        CollectionModel<UserResponse> userResponseCollectionModel =
                userResponseAssembler.toCollectionModel(savedUserFastDto);

        return ResponseEntity.ok(userResponseCollectionModel);
    }


    @Operation(
            summary = "Find user role by public ID",
            description = "search user role by the public id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = UserResponse.class
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
    @GetMapping(path = "/{userPublicId}/role",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUserRoleByUserPublicId(@PathVariable String userPublicId) {


            PersonEntity person = personApiService
                    .findByPersonPublicIdWithPersonAndRole(userPublicId)
                    .getPerson();
            if (person == null) {
                throw new NotFoundException("requested user not found");
            }

            UserFastDto userFastDto =
                    userFastDtoMapper.toUserFastDto(person, new CycleAvoidingMappingContext());

            UserRolePrivilegeResponse userRolePrivilegeResponse =
                    userRolePrivilegeResponseAssembler.toModel(userFastDto);

            return ResponseEntity.ok(userRolePrivilegeResponse);

    }


    @Operation(
            hidden = true,
            summary = "Role User",
            description = "role User",
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
                                            implementation = UserRolePrivilege.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Not Acceptable",
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
    @DisableMethod
    @PostMapping(path = "/{userPublicId}/role",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createUserRole(@PathVariable String userPublicId,
                                            @RequestBody UserRolePrivilege userRolePrivilege) {

        List<String> rolePublicIds = null;

        if (userRolePrivilege.getRolePublicId().isEmpty() || userRolePrivilege.getRolePublicId().size() == 0) {

           throw new BadRequestException("Role Public Id is Empty");
        } else {
            rolePublicIds = userRolePrivilege.getRolePublicId();
        }

        PersonEntity person = personService.findPersonEntityByPersonApiPublicId(userPublicId);

        PersonApiEntity savedPersonApi = personApiService
                .updateByPersonApiAndRoleName(person.getPersonApiEntity(), rolePublicIds);

        PersonEntity savedPerson = personService
                .findPersonEntityByPersonApiPublicId(savedPersonApi.getPersonPublicId());

        UserFastDto userFastDto = userFastDtoMapper
                .toUserFastDto(savedPerson, new CycleAvoidingMappingContext());

        UserRolePrivilegeResponse userRolePrivilegeResponse =
                userRolePrivilegeResponseAssembler.toModel(userFastDto);

        return ResponseEntity.ok(userRolePrivilegeResponse);
    }
}
