package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login", description = "Authentication Sample API")
public class AuthenticationController {

    @Operation(
        description = "User Login",
        responses = {
                @ApiResponse(
                        headers = {
                                @Header(
                                        name = "authorization",
                                        description = "IMI <JWT value here>",
                                        schema = @Schema(
                                                type = "String",
                                                accessMode = Schema.AccessMode.READ_ONLY,
                                                format = "uuid"
                                        ),
                                        required = true
                                ),
                                @Header(
                                        name = "userPublicId",
                                        description = "<Public User ID value here>",
                                        schema = @Schema(type = "String")
                                )
                        },
                        responseCode = "200",
                        description = "",
                        content = @Content(
                                schema = @Schema(
                                        implementation = UserLoginRequestModel.class
                                )
                        )
                ),
                @ApiResponse(
                 responseCode = "404",
                 description = "Person with such username doesn't exists"
                )
        }
    )
    @PostMapping("/users/login")
    public void theFakeLogin(@RequestBody UserLoginRequestModel userLoginRequestModel){

//        the reason to throw this exception is that this method should no really execute when calling this controller
//        because spring security override this login
        throw new IllegalStateException("This method should no be called. This method is implemented by spring security.");
    }
}
