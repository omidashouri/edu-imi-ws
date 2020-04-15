package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

//User is PersonEntity plus PersonWebServiceEntity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFastDto {

    private Long id;

    private String personPublicId;

    private String contactPublicId;

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

    private String companyPublicId;

    private String selectedSkin;

    private String selectedLanguagePublicId;

    private String emailProcessType;

    private String personalCode;

    private String activityStatus;

    private String kind;

    private String organizationPositionPublicId;

    private String ownerPublicId;

    private String organizationClassPublicId;

    private String noeEstekhdam;

    private String pwdp;

    private String signatureImg;

    private String commerceAdditionalInfoPublicId;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus;

    private Boolean mobileVerificationStatus;

    private String description;

    private String authorityPublicId;

}
