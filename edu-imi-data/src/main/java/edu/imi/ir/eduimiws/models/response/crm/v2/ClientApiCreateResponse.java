package edu.imi.ir.eduimiws.models.response.crm.v2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Schema(name = "clientCreate", description = "B2B API client create response")
@JsonRootName(value = "client")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ClientApiCreateResponse extends BaseResponseDto {

    @Schema(title = "Client public ID")
    private String clientPublicId;

    @Schema(title = "Client ID")
    private String clientId;

    @Schema(title = "Company name")
    private String companyName;

    @Schema(title = "Description")
    private String description;

    @Schema(title = "Enabled (0 or 1)")
    private Long enabled;

    @Schema(title = "Linked Person API public ID")
    private String personPublicId;

    @Schema(title = "Create timestamp")
    private Timestamp createDateTs;

    @Schema(title = "Edit timestamp")
    private Timestamp editDateTs;

    @Schema(title = "Plaintext client secret (only on create)")
    private String clientSecret;

    @Schema(title = "Base64(clientId:clientSecret) for token API (only on create)")
    private String clientCredentialsBase64;
}
