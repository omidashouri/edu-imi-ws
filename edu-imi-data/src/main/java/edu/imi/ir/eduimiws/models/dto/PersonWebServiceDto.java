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

    private PersonDto personId;

    private String personPublicId;

    private ContactDto contactId;

    private String contactPublicId;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;

    private PersonDto creatorId;

    private java.sql.Timestamp createDateTs;

    private PersonDto editorId;

    private java.sql.Timestamp editDateTs;

    private String description;

}
