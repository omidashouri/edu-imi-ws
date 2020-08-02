package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.edu.StudentResponseAssembler;
import edu.imi.ir.eduimiws.domain.edu.StudentApiEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.StudentFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.StudentResponse;
import edu.imi.ir.eduimiws.services.edu.StudentApiService;
import edu.imi.ir.eduimiws.services.edu.StudentService;
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
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Students", description = "The student API")
public class StudentController {


    private final StudentService studentService;
    private final StudentApiService studentApiService;
    private final StudentFastDtoMapper studentFastDtoMapper;
    private final StudentResponseAssembler studentResponseAssembler;
    private final PagedResourcesAssembler<StudentFastDto> studentFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "find All students",
            description = "Search student detail pageable",
            tags = "students",
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
                                            schema = @Schema(implementation = StudentResponse.class)
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
    public ResponseEntity<PagedModel<StudentResponse>> getStudents(@Parameter(hidden = true)
                                                                   @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
                                                                   @PageableDefault(page = 0, size = 10, value = 10)
                                                                           Pageable pageable) {

        Page<StudentEntity> studentPages =
                studentService.findAllByOrderByCreateDateDesc(pageable);

        Page<StudentFastDto> studentFastDtoPage = studentPages
                .map(p -> studentFastDtoMapper
                        .toStudentFastDto(p, new CycleAvoidingMappingContext()));

        PagedModel<StudentResponse> studentResponsePagedModel = studentFastDtoPagedResourcesAssembler
                .toModel(studentFastDtoPage, studentResponseAssembler);

        return ResponseEntity.ok(studentResponsePagedModel);
    }

    @Operation(hidden = true)
    @PageableAsQueryParam
    @GetMapping(path = "/collectionModel",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CollectionModel<StudentResponse>> getAllStudents(
            @Parameter(hidden = true)
            @SortDefault(sort = "createDate", direction = Sort.Direction.DESC)
            @PageableDefault(page = 0, size = 10)
                    Pageable pageable) {

        Page<StudentEntity> studentPages =
                studentService.findAllByOrderByCreateDateDesc(pageable);

        List<StudentEntity> studentEntities = StreamSupport
                .stream(studentPages.spliterator(), false)
                .collect(Collectors.toList());

        List<StudentFastDto> studentFastDtos = studentFastDtoMapper
                .toStudentFastDtos(studentEntities, new CycleAvoidingMappingContext());

        CollectionModel<StudentResponse> studentResponseCollectionModel =
                studentResponseAssembler.toCollectionModel(studentFastDtos);

        return ResponseEntity.ok(studentResponseCollectionModel);
    }


    @Operation(
            summary = "Find Student by public ID",
            description = "Search student by the public id",
            tags = "students",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = StudentResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "student not found",
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
    @GetMapping(path = "/{studentPublicId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getStudentByStudentPublicId(@PathVariable String studentPublicId) {

        try {
            StudentEntity student = studentService.findByStudentPublicIdOrderByCreateDateDesc(studentPublicId);
            if (student == null) {
                return this.studentNotFound();
            }

            StudentFastDto studentFastDto = studentFastDtoMapper
                    .toStudentFastDto(student, new CycleAvoidingMappingContext());

            StudentResponse studentResponse =
                    studentResponseAssembler.toModel(studentFastDto);

            return ResponseEntity.ok(studentResponse);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @Operation(
            summary = "Find new student numbers",
            description = "search for new students that do not have student public id " +
                    "by comparing max id student and student web service entity. ",
            tags = "students",
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
    public ResponseEntity<?> getNewStudentCount() {

        OperationStatus returnValue = new OperationStatus();
        Long studentApiCount;
        Long studentCount;
        Long newStudentCount;

        studentApiCount = studentApiService.studentApiCount();
        Long studentSequenceNumber = studentService.selectStudentLastSequenceNumber();
        studentCount = studentService.countStudentByIdLessThanEqual(studentSequenceNumber);

        if (studentCount == null || studentCount == 0) {
            this.conflictStudentCount();
        }

        if (studentApiCount != null) {
            newStudentCount = studentCount - studentApiCount;
        } else {
            newStudentCount = studentCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_ENTITIES.name());

        if (newStudentCount > 0) {
            returnValue.setDescription(newStudentCount + " New Record Found. use 'new public id' link");

            Link link = WebMvcLinkBuilder
                    .linkTo(methodOn(StudentController.class)
                            .createStudentApiPublicId())
                    .withRel("new public id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            summary = "Generate Student Public Id",
            description = "generate public id for new students",
            tags = "students",
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
    @PostMapping(path = "/new/publicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createStudentApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long studentApiCount;
        StudentApiEntity studentApiLastRecord;
        StudentEntity studentLastRecord;
        List<StudentEntity> newStudents = new ArrayList<>();
        List<StudentApiEntity> newStudentApi = new ArrayList<>();

        studentApiCount = studentApiService.studentApiCount();

        if (0 != studentApiCount) {
            Long studentSequenceNumber = studentService.selectStudentLastSequenceNumber();
            studentApiLastRecord = studentApiService.selectLastRecord();
            studentLastRecord = studentService.findFirstByIdLessThanOrderByIdDesc(studentSequenceNumber);
            if (studentLastRecord.getId() > studentApiLastRecord.getStudentId()) {
                Long studentApiStudentIdPlusOne = studentApiLastRecord.getStudentId() + 1;
                newStudents = studentService.findAllStudentOnlyByIdBetween(studentApiStudentIdPlusOne,studentLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newStudents = studentService.selectAllStudentOnly();
        }

        newStudentApi = studentApiService.generateStudentApiPublicId(newStudents);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newStudentApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

    private ResponseEntity<?> conflictStudentCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "student count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ResponseEntity<?> studentNotFound() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.NOT_FOUND.toString()
                        , "requested student not found")
                , HttpStatus.NOT_FOUND
        );
    }


}
