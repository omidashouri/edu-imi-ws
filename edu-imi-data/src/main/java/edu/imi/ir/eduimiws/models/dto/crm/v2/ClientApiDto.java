package edu.imi.ir.eduimiws.models.dto.crm.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientApiDto {

    private Long id;
    private String clientPublicId;
    private String clientId;
    private String companyName;
    private String description;
    private Long enabled;
    private String personPublicId;
    private Long personApiId;
    private Timestamp createDateTs;
    private Timestamp editDateTs;
    private Timestamp deleteDateTs;

    /** Plaintext secret — populated only on create. Never loaded from DB. */
    private String clientSecret;

    /** Base64(clientId:clientSecret) — populated only on create. */
    private String clientCredentialsBase64;
}
