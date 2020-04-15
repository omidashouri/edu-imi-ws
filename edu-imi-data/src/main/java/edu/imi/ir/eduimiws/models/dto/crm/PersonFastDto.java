package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonFastDto {

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

    private String companyPublicId;

    private String contactPublicId;

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
}
