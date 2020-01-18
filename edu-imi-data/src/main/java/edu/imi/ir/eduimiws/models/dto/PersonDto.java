package edu.imi.ir.eduimiws.models.dto;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1906759965943558749L;

    private String firstName;

    private String lastName;

    private String tel;

    private String address;

    private String email;

    private String website;

    private String username;

    private String password;

    private Long limitationNumber;

    private String signature;

    private String lastlogindate;

    private CompanyDto companyId;

    private ContactDto contactId;

    private String selectedSkin;

    private LanguageDto selectedLanguage;

    private String emailProcessType;

    private String personalCode;

    private String activityStatus;

    private String kind;

    private OrganizationClassDto organizationPositionId;

    private PersonEntity ownerId;

    private OrganizationClassDto organizationClassId;

    private String noeEstekhdam;

    private String pwdp;

    private String signatureImg;

    private PersonInfoCommerceDto commerceAdditionalInfo;

}
