package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1906759965943558749L;

    private Long id;

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

    private CompanyDto company;

    private ContactDto contact;

    private String selectedSkin;

    private LanguageDto selectedLanguage;

    private String emailProcessType;

    private String personalCode;

    private String activityStatus;

    private String kind;

    private OrganizationClassDto organizationPosition;

    private PersonDto owner;

    private OrganizationClassDto organizationClass;

    private String noeEstekhdam;

    private String pwdp;

    private String signatureImg;

    private PersonInfoCommerceDto commerceAdditionalInfo;

}
