package edu.imi.ir.eduimiws.models.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "clientApiCreate", description = "Create a B2B API client")
@JsonRootName(value = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientApiCreateRequest {

    @Schema(title = "Client ID", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 100)
    private String clientId;

    @Schema(title = "Client secret (plaintext)", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 200)
    private String clientSecret;

    @Schema(title = "Linked Person API public ID", requiredMode = Schema.RequiredMode.REQUIRED, maxLength = 500)
    private String personPublicId;

    @Schema(title = "Company name", maxLength = 200)
    private String companyName;

    @Schema(title = "Description", maxLength = 500)
    private String description;

    @Schema(title = "Enabled flag (0 or 1). Defaults to 1 when omitted")
    private Long enabled;
}
