package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "RefreshToken", description = "Refresh token request")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "RefreshToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenRequestModel {

    @Schema(title = "Refresh Token", requiredMode = Schema.RequiredMode.REQUIRED)
    private String refreshToken;
}
