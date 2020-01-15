package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @ApiOperation("User Login")
    @ApiResponses({
            @ApiResponse(code = 200,
            message = "Response Headers",
            responseHeaders = {
                    @ResponseHeader(name = "authorization",
                    description = "Bearer <JWT value here>",
                    response = String.class),
                    @ResponseHeader(name = "userID",
                    description = "<Public User ID value here>",
                    response = String.class)
            })
    })
    @PostMapping("/users/login")
    public void theFakeLogin(@RequestBody UserLoginRequestModel userLoginRequestModel){

//        the reason to throw this exception is that this method should no really execute when calling this controller
//        because spring security override this login
        throw new IllegalStateException("This method should no be called. This method is implemented by spring security.");
    }
}
