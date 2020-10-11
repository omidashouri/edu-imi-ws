package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.edu.RegisterResponseRegisterDtoAssembler;
import edu.imi.ir.eduimiws.assemblers.edu.RegisterResponseRegisterFastDtoAssembler;
import edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.RegisterFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterDto;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import edu.imi.ir.eduimiws.services.edu.RegisterApiService;
import edu.imi.ir.eduimiws.services.edu.RegisterService;
import edu.imi.ir.eduimiws.utilities.DisableMethod;
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
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/registers")
@RequiredArgsConstructor
@Tag(name = "Registers", description = "The register API")
public class RegisterController {

    private final RegisterService registerService;
    private final RegisterApiService registerApiService;
    private final RegisterDtoMapper registerDtoMapper;
    private final RegisterFastDtoMapper registerFastDtoMapper;
    private final RegisterResponseRegisterDtoAssembler registerResponseRegisterDtoAssembler;
    private final RegisterResponseRegisterFastDtoAssembler registerResponseRegisterFastDtoAssembler;
    private final PagedResourcesAssembler<RegisterDto> registerDtoPagedResourcesAssembler;
    private final PagedResourcesAssembler<RegisterFastDto> registerFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All registers",
            description = "Search register detail pageable",
            tags = "registers",
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
                                            schema = @Schema(implementation = RegisterResponse.class)
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
    public ResponseEntity<PagedModel<RegisterResponse>> getRegisters(@Parameter(hidden = true)
                                                                     @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                     @PageableDefault(page = 0, size = 10, value = 10)
                                                                             Pageable pageable) {

        Page<RegisterEntity> registerPages =
                registerService.findAllByOrderPageable(pageable);

        Page<RegisterFastDto> registerFastDtoPage = registerPages
                .map(p -> registerFastDtoMapper
                        .toRegisterFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<RegisterResponse> registerResponsePagedModel = registerFastDtoPagedResourcesAssembler
                .toModel(registerFastDtoPage, registerResponseRegisterFastDtoAssembler);

        return ResponseEntity.ok(registerResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<RegisterResponse>> getAllRegisters(
            @Parameter(hidden = true)
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<RegisterEntity> registerPages =
                registerService.findAllByOrderPageable(pageable);

        List<RegisterEntity> registerEntities = StreamSupport
                .stream(registerPages.spliterator(), false)
                .collect(Collectors.toList());

        List<RegisterFastDto> registerFastDtos = registerFastDtoMapper
                .toRegisterFastDtos(registerEntities, new CycleAvoidingMappingContext());

        CollectionModel<RegisterResponse> registerResponseCollectionModel =
                registerResponseRegisterFastDtoAssembler.toCollectionModel(registerFastDtos);

        return ResponseEntity.ok(registerResponseCollectionModel);
    }

    @Operation(
            summary = "Find Register by public ID",
            description = "Search register by the public id",
            tags = "registers",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = RegisterResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "register not found",
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
    @GetMapping(path = "/{registerPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRegisterByRegisterPublicId(@PathVariable String registerPublicId) {

        try {
            RegisterEntity register = registerService.findByRegisterPublicId(registerPublicId);
            if (register == null) {
                return this.registerNotFound();
            }

            RegisterFastDto registerFastDto = registerFastDtoMapper
                    .toRegisterFastDto(register, new CycleAvoidingMappingContext());

            RegisterResponse registerResponse =
                    registerResponseRegisterFastDtoAssembler.toModel(registerFastDto);

            return ResponseEntity.ok(registerResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "find All registers with student and period name",
            description = "Search register detail pageable with student and period name",
            tags = "registers",
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
                                            schema = @Schema(implementation = RegisterResponse.class)
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
    @GetMapping(path = "/descriptive",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<RegisterResponse>> getRegistersWithStudentPeriodName(@Parameter(hidden = true)
                                                                     @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                     @PageableDefault(page = 0, size = 10, value = 10)
                                                                             Pageable pageable) {

        Page<RegisterEntity> registerPages =
                registerService.findAllWithStudentPeriodNameByOrderPageable(pageable);

        Page<RegisterDto> registerDtoPage = registerPages
                .map(p -> registerDtoMapper
                        .toRegisterDto(p, new CycleAvoidingMappingContext()));

        PagedModel<RegisterResponse> registerResponsePagedModel = registerDtoPagedResourcesAssembler
                .toModel(registerDtoPage, registerResponseRegisterDtoAssembler);

        return ResponseEntity.ok(registerResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel/descriptive",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<RegisterResponse>> getAllRegistersWithStudentPeriodName(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<RegisterEntity> registerPages =
                registerService.findAllWithStudentPeriodNameByOrderPageable(pageable);

        List<RegisterEntity> registerEntities = StreamSupport
                .stream(registerPages.spliterator(), false)
                .collect(Collectors.toList());

        List<RegisterDto> registerDtos = registerDtoMapper
                .toRegisterDtos(registerEntities, new CycleAvoidingMappingContext());

        CollectionModel<RegisterResponse> registerResponseCollectionModel =
                registerResponseRegisterDtoAssembler.toCollectionModel(registerDtos);

        return ResponseEntity.ok(registerResponseCollectionModel);
    }

    @Operation(
            summary = "Find Register by public ID with student and period name",
            description = "Search register by the public id with student and period name",
            tags = "registers",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = RegisterResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "register not found",
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
    @GetMapping(path = "/descriptive/{registerPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRegisterWithStudentPeriodNameByRegisterPublicId(@PathVariable String registerPublicId) {

        try {
            RegisterEntity register = registerService
                    .findWithStudentPeriodNameByRegisterPublicId(registerPublicId);
            if (register == null) {
                return this.registerNotFound();
            }

            RegisterDto registerDto = registerDtoMapper
                    .toRegisterDto(register, new CycleAvoidingMappingContext());

            RegisterResponse registerResponse =
                    registerResponseRegisterDtoAssembler.toModel(registerDto);

            return ResponseEntity.ok(registerResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }


    @Operation(
            summary = "Find new register numbers",
            description = "search for new registers that do not have register public id " +
                    "by comparing max id register and register web service entity. ",
            tags = "registers",
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
    @GetMapping(path = "/new/count",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewRegisterCount() {

        OperationStatus returnValue = new OperationStatus();
        Long registerApiCount;
        Long registerCount;
        Long newRegisterCount;

        registerApiCount = registerApiService.registerApiCount();
        Long registerSequenceNumber = registerService.selectRegisterLastSequenceNumber();
        registerCount = registerService.countRegisterByIdLessThanEqual(registerSequenceNumber);

        if (registerCount == null || registerCount == 0) {
            this.conflictRegisterCount();
        }

        if (registerApiCount != null) {
            newRegisterCount = registerCount - registerApiCount;
        } else {
            newRegisterCount = registerCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newRegisterCount > 0) {
            returnValue.setDescription(newRegisterCount + " New Record Found. use 'new public id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(RegisterController.class)
                            .createRegisterApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }

    @Operation(
            hidden = true,
            summary = "Generate Register Public Id",
            description = "generate public id for new registers",
            tags = "registers",
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
    @PostMapping(path = "/new/publicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createRegisterApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long registerApiCount;
        RegisterApiEntity registerApiLastRecord;
        RegisterEntity registerLastRecord;
        List<RegisterEntity> newRegisters = new ArrayList<>();
        List<RegisterApiEntity> newRegisterApi = new ArrayList<>();

        registerApiCount = registerApiService.registerApiCount();

        if (0 != registerApiCount) {
            Long registerSequenceNumber = registerService.selectRegisterLastSequenceNumber();
            registerApiLastRecord = registerApiService.selectLastRecord();
            registerLastRecord = registerService.findFirstByIdLessThanOrderByIdDesc(registerSequenceNumber);
            if (registerLastRecord.getId() > registerApiLastRecord.getRegisterId()) {
                Long registerApiRegisterIdPlusOne = registerApiLastRecord.getRegisterId() + 1;
                newRegisters = registerService.findAllRegisterOnlyByIdBetween(registerApiRegisterIdPlusOne, registerLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newRegisters = registerService.selectAllRegisterOnly();
        }

        newRegisterApi = registerApiService.generateRegisterApiPublicId(newRegisters);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newRegisterApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictRegisterCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "register count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ResponseEntity<?> registerNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested register not found")
                , HttpStatus.NOT_FOUND
        );
    }
}
