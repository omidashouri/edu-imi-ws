package edu.imi.ir.eduimiws.controllers.attendance.v1;


import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.wsdl.attendance.*;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
@Tag(name = "Attendance", description = "Attendance API")
public class AttendanceController {


    private final EtsGeneralDataProviderService etsGeneralDataProviderService;

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
    @GetMapping(path = "/getAllEmployees",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllEmployees() {


        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfEmployeeDataModel employees = soap.getAllEmployees();

        // Process the result
        return ResponseEntity.ok(employees);

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


        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfEmployeeInfo allEmployeesInfo = soap.getAllEmployeesInfo();

        // Process the result
        return ResponseEntity.ok(allEmployeesInfo);

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
                                            schema = @Schema(implementation = ArrayOfIoRecordDataModel.class)
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
    public ResponseEntity<?> getIoRecordsByDate(@PathVariable String date) {
        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfIoRecordDataModel allIoRecordDataModel = soap.getAllIoRecordsByDate(date);

        // Process the result
        return ResponseEntity.ok(allIoRecordDataModel);

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
                                            schema = @Schema(implementation = ArrayOfMissionRegistrationDataModel.class)
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
    @GetMapping(path = "/getAllMissionRegistrationsByDate",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getMissionRegistrationsByDate(@PathVariable String date) {
        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfMissionRegistrationDataModel allMissionRegistrationsByDate = soap.getAllMissionRegistrationsByDate(date);

        // Process the result
        return ResponseEntity.ok(allMissionRegistrationsByDate);

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
    public ResponseEntity<?> getAllVacationRegistrationsByDate(@PathVariable String date) {
        // Get the SOAP interface
        EtsGeneralDataProviderServiceSoap soap = etsGeneralDataProviderService
                .getEtsGeneralDataProviderServiceSoap();

        // Call the `getAllCurrentlyEmployees` method
        ArrayOfVacationRegistrationDataModel VacationRegistrationsByDate = soap.getAllVacationRegistrationsByDate(date);

        // Process the result
        return ResponseEntity.ok(VacationRegistrationsByDate);
    }
}
