package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonApiDto implements Serializable {

    private static final long serialVersionUID = 3509814162285417174L;

    private Long id;

    private PersonDto person;

    private Long personId;

    private String personPublicId;

    private ContactDto contact;

    private Long contactId;

    private String contactPublicId;

    private String userName;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;

    private Boolean mobileVerificationStatus;

    private PersonDto creator;

    private Long creatorId;

    private java.sql.Timestamp createDateTs;

    private PersonDto editor;

    private Long editorId;

    private java.sql.Timestamp editDateTs;

    private String description;

}
