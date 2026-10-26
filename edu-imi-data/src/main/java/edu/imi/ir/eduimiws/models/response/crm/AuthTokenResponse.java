package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "AuthToken", description = "Access and refresh token pair")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "AuthToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenResponse {

    @Schema(description = "JWT access token")
    private String accessToken;

    @Schema(description = "JWT refresh token")
    private String refreshToken;

    @Schema(description = "Public user id")
    private String userPublicId;

    @Schema(description = "Token type prefix, e.g. Bearer or IMI")
    private String tokenType;

    @Schema(description = "Access token lifetime in milliseconds")
    private Long accessTokenExpiresIn;

    @Schema(description = "Refresh token lifetime in milliseconds")
    private Long refreshTokenExpiresIn;
}
