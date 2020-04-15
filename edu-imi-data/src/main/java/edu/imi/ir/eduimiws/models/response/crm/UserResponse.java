package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "users", description = "Class representing a user in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "user")
@Relation(collectionRelation = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends RepresentationModel<UserResponse> {

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
