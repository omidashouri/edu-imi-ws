package edu.imi.ir.eduimiws.controllers.attendance.v1;


import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.attendance.response.EmployeeResponse;
import edu.imi.ir.eduimiws.models.response.attendance.response.IoRecordDataModelResponse;
import edu.imi.ir.eduimiws.models.response.attendance.response.MissionRegistrationDataModelResponse;
import edu.imi.ir.eduimiws.models.response.attendance.response.OrganizationChartDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.*;
import edu.imi.ir.eduimiws.services.attendance.*;
import edu.imi.ir.eduimiws.validators.JalaliDateValidation;
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

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
@Tag(name = "Attendance", description = "Attendance API")
public class AttendanceController {

    private final EmployeeService employeeService;
    private final IoRecordDataModelEtsService ioRecordDataModelEtsService;
    private final MissionRegistrationDataModelEtsService missionRegistrationDataModelEtsService;
    private final VacationRegistrationDataModelEtsService vacationRegistrationDataModelEtsService;
    private final OrganizationChartDataModelEtsService organizationChartDataModelEtsService;
    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final FunctionalityListService functionalityListService;

    @Operation(
            summary = "get All Employees",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = EmployeeResponse.class)
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
    @GetMapping(path = "/getAllEmployees",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(
            summary = "get All Employees Info",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = ArrayOfEmployeeInfo.class)
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
    @GetMapping(path = "/getAllEmployeesInfo",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllEmployeesInfo() {
        return ResponseEntity.ok(employeeService.getAllEmployeesInfo());

    }


    @Operation(
            summary = "update All Employees Info",
            description = " ",
            tags = "attendance",
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
                                    schema = @Schema(implementation = String.class)
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
    @PutMapping(path = "/updateAllEmployeesInfo",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> updateAllEmployeesInfo() {
        employeeService.updateAllEmployeeInfo();
        return ResponseEntity.ok("successful operation");
    }

    @Operation(
            summary = "get Io Record Per Date Range",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = IoRecordDataModelResponse.class)
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
    @GetMapping(path = "/getIoRecordPerDateRange",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getIoRecordByDateRange(@RequestParam String fromDate,@RequestParam String toDate) {
        return ResponseEntity.ok(ioRecordDataModelEtsService.getIoRecordByDateRange(fromDate,toDate));
    }

    @Operation(
            summary = "get All Io Records By Date",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = IoRecordDataModelResponse.class)
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
    @GetMapping(path = "/getAllIoRecordsByDate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllIoRecordsByDate(@RequestParam String date) {
        return ResponseEntity.ok(ioRecordDataModelEtsService.getAllIoRecordsFromApiByDate(date));
    }

    @Operation(
            summary = "get All Mission Registrations By Date",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = MissionRegistrationDataModelResponse.class)
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
    @GetMapping(path = "getllMissionRegistrationsByDate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getMissionRegistrationsByDate(@RequestParam @JalaliDateValidation String date) {
        return ResponseEntity.ok(missionRegistrationDataModelEtsService.getAllMissonRegistrationFromApiByDate(date));

    }

    @Operation(
            summary = "get All Vacation Registrations By Date",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = ArrayOfVacationRegistrationDataModel.class)
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
    @GetMapping(path = "/getAllVacationRegistrationsByDate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getVacationRegistrationsByDate(@RequestParam @JalaliDateValidation String date) {
        return ResponseEntity.ok(vacationRegistrationDataModelEtsService.getAllVacationRegistrationFromApiByDate(date));
    }


    @Operation(
            summary = "get All Organization Chart List",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = OrganizationChartDataModelResponse.class)
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
    @GetMapping(path = "/getAllOrganizationChartList",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllOrganizationChartList() {
        return ResponseEntity.ok(organizationChartDataModelEtsService.getAllOrganizationChart());

    }

    @Operation(
            summary = "get All Currently Employees Result",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = ArrayOfEmployeeDataModel.class)
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
    @GetMapping(path = "/getAllCurrentlyEmployeesResult",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllCurrentlyEmployeesResult() {
        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfEmployeeDataModel employees = soap.getAllCurrentlyEmployees();

        // Process the result
        return ResponseEntity.ok(employees);
    }

    @Operation(
            summary = "get Functionality List",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = ArrayList.class)
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
    @GetMapping(path = "/getFunctionalityList",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getFunctionalityList(@RequestParam String employeeCode, @RequestParam LocalDateTime fromDate, @RequestParam LocalDateTime toDate ) {
        return ResponseEntity.ok(functionalityListService.getFunctionalityList(employeeCode, fromDate, toDate));
    }

    @Operation(
            summary = "get All Currently Employees",
            description = " ",
            tags = "attendance",
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
                                            schema = @Schema(implementation = EmployeeResponse.class)
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
    @GetMapping(path = "/getAllCurrentlyEmployees",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllCurrentlyEmployees() {
        return ResponseEntity.ok(employeeService.getAllCurrentlyEmployees());
    }
}
