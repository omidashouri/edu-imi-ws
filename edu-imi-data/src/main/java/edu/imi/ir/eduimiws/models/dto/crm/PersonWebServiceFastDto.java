package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonWebServiceFastDto implements Serializable {

    private static final long serialVersionUID = 6161377157056013811L;

    private Long personId;

    private String personPublicId;

    private Long contactId;

    private String contactPublicId;

    private String userName;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;

    private Boolean mobileVerificationStatus;

    private Long creatorId;

    private java.sql.Timestamp createDateTs;

    private Long editorId;

    private java.sql.Timestamp editDateTs;

    private String description;
}
