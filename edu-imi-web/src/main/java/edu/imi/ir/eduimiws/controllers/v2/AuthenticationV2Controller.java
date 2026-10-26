package edu.imi.ir.eduimiws.controllers.v2;

import edu.imi.ir.eduimiws.mapper.crm.AuthTokenResponseMapper;
import edu.imi.ir.eduimiws.models.request.RefreshTokenRequestModel;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.crm.AuthTokenResponse;
import edu.imi.ir.eduimiws.services.AuthTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication V2", description = "Login and refresh token API")
public class AuthenticationV2Controller {

    private final AuthTokenService authTokenService;
    private final AuthTokenResponseMapper authTokenResponseMapper;

    @Operation(
            summary = "Login and get access and refresh tokens",
            description = "Authenticate with username and password. Returns a JWT access token "
                    + "and a refresh token. Access tokens work with the existing Authorization header."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = AuthTokenResponse.class)
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
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            })
    @PostMapping(path = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AuthTokenResponse> login(@RequestBody UserLoginRequestModel loginRequest) {
        return ResponseEntity.ok(
                authTokenResponseMapper.toAuthTokenResponse(authTokenService.login(loginRequest)));
    }

    @Operation(
            summary = "Refresh access token",
            description = "Exchange a valid refresh token for a new access token and a new refresh token."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(implementation = AuthTokenResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            })
    @PostMapping(path = "/refresh",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<AuthTokenResponse> refresh(@RequestBody RefreshTokenRequestModel refreshTokenRequest) {
        return ResponseEntity.ok(
                authTokenResponseMapper.toAuthTokenResponse(authTokenService.refresh(refreshTokenRequest)));
    }
}
