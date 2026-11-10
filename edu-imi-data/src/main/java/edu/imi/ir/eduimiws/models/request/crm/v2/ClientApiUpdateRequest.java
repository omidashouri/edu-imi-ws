package edu.imi.ir.eduimiws.models.request.crm.v2;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "clientApiUpdate", description = "Partial update for a B2B API client. Null/blank fields are left unchanged.")
@JsonRootName(value = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientApiUpdateRequest {

    @Schema(title = "Client ID", maxLength = 100)
    private String clientId;

    @Schema(title = "Client secret (plaintext). Re-hashed when provided", maxLength = 200)
    private String clientSecret;

    @Schema(title = "Linked Person API public ID", maxLength = 500)
    private String personPublicId;

    @Schema(title = "Company name", maxLength = 200)
    private String companyName;

    @Schema(title = "Description", maxLength = 500)
    private String description;

    @Schema(title = "Enabled flag (0 or 1)")
    private Long enabled;
}
