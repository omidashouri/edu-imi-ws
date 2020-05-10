package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.models.request.PrivilegeForm;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.PrivilegeResponse;
import edu.imi.ir.eduimiws.services.crm.PrivilegeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/privileges")
@RequiredArgsConstructor
@Tag(name = "privileges", description = "The privilege API")
public class PrivilegeController {

    private final PrivilegeApiService privilegeApiService;


    @Operation(
            summary = "Create Privilege",
            description = "Privilege ",
            tags = "privileges",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PrivilegeResponse.class
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
    @PostMapping(path = "/new",
            consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPrivilege(@RequestBody PrivilegeForm privilegeForm) {

        PrivilegeResponse returnValue = new PrivilegeResponse();
        PrivilegeApiEntity savedPrivilege = new PrivilegeApiEntity();

        String privilegeName = privilegeForm.getPrivilegeName();

        savedPrivilege = privilegeApiService.createPrivilegeByName(privilegeName);

        returnValue.setPrivilegePublicId(savedPrivilege.getPrivilegePublicId());
        returnValue.setName(savedPrivilege.getName());

        return ResponseEntity.ok(returnValue);
    }
}
