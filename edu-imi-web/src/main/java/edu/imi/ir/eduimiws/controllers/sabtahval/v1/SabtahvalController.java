package edu.imi.ir.eduimiws.controllers.sabtahval.v1;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.FiledValueNullException;
import edu.imi.ir.eduimiws.exceptions.controllers.NationalCodeNullException;
import edu.imi.ir.eduimiws.mapper.sabtahval.EstelamPersonInfoRequestMapper;
import edu.imi.ir.eduimiws.models.dto.sabtahval.PersonInfoDto;
import edu.imi.ir.eduimiws.models.request.sabtahval.EstelamPersonInfoRequest;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamResultResponse;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamVersionResponse;
import edu.imi.ir.eduimiws.models.sabtahval.GetVersionResponse;
import edu.imi.ir.eduimiws.services.sabtahval.SabtahvalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/api/v1/sabtahval")
@RequiredArgsConstructor
public class SabtahvalController {

    private final EstelamPersonInfoRequestMapper estelamPersonInfoRequestMapper;
    private final SabtahvalService sabtahvalService;


    @GetMapping(path = "/version",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getVersion() {


        GetVersionResponse getVersionResponse = new GetVersionResponse();
        EstelamVersionResponse estelamVersionResponse = new EstelamVersionResponse();
        try {
//            getVersionResponse = soapClientSabtAhvalImpl.callGetVersion();
            estelamVersionResponse = sabtahvalService.getVersion();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return ResponseEntity.ok(estelamVersionResponse);
    }

/*    @GetMapping(path = "/estelam",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getEstelam() {


        GetEstelam3Response getEstelam3Response = new GetEstelam3Response();
        try {
            getEstelam3Response = soapClientSabtAhvalImpl.callGetEstelam3Se();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return ResponseEntity.ok(getEstelam3Response.getReturns());
    }*/


    @Operation(
            summary = "EstelamPersonInfo estelamPersonInfo",
            description = "estelam Person Information Request",
            tags = "sabtahvals",
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
    @GetMapping(path = "/estelam",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> estelamUser(EstelamPersonInfoRequest estelamPersonInfoRequest) {

        PersonInfoDto personInfoDto = new PersonInfoDto();
        EstelamResultResponse estelamResultResponse = new EstelamResultResponse();

        UserResponse returnValue = new UserResponse();
        List<PersonEntity> savedPersons = new ArrayList<>();
        String nationalCode = null;
        Long userCount;

        if (estelamPersonInfoRequest.getNin()==null) {
            throw new NationalCodeNullException("national code is null");
        }

        if (estelamPersonInfoRequest.getBirthDate()==null) {
            throw new FiledValueNullException("Birth Date is null");
        }

        if (estelamPersonInfoRequest.getGender()!=null && estelamPersonInfoRequest.getGender().isEmpty()) {
            estelamPersonInfoRequest.setGender(null);
        }

        if (estelamPersonInfoRequest.getGender()!=null && "string".equalsIgnoreCase(estelamPersonInfoRequest.getGender())) {
            estelamPersonInfoRequest.setGender(null);
        }


        personInfoDto = estelamPersonInfoRequestMapper.toPersonInfoDto(estelamPersonInfoRequest);

        try {
            estelamResultResponse = sabtahvalService.getEstelamResultResponse(personInfoDto);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        return ResponseEntity.ok(estelamResultResponse);
    }

}
