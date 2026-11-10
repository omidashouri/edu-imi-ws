package edu.imi.ir.eduimiws.models.request.crm.v2;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "clientToken", description = "B2B client credentials token request")
@JsonRootName(value = "clientToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientTokenRequestModel {

    @Schema(
            title = "Base64 credentials",
            description = "Base64 encoding of clientId:clientSecret (same value returned on client create)",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String credentials;
}
