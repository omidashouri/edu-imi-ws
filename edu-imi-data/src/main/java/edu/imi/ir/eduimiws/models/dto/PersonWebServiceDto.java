package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonWebServiceDto implements Serializable {

    private static final long serialVersionUID = 3509814162285417174L;

//    private PersonDto personId;

    private Long personIdT;

    private String personPublicId;

//    private ContactDto contactId;

    private Long contactIdT;

    private String contactPublicId;

    private String userName;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;

    private Boolean mobileVerificationStatus;

//    private PersonDto creatorId;

    private Long creatorIdT;

    private java.sql.Timestamp createDateTs;

//    private PersonDto editorId;

    private Long editorIdT;

    private java.sql.Timestamp editDateTs;

    private String description;

}
