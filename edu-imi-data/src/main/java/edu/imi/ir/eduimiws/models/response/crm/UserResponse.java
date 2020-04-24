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


    public UserResponse(String username){
        this.username = username;
    }

    @Schema(title = "Person Public ID",maxLength = 36)
    private String personPublicId;

    @Schema(title = "Contact Public ID",maxLength = 36)
    private String contactPublicId;

    @Schema(title = "First Name", maxLength = 100)
    private String firstName;

    @Schema(title = "Last Name", maxLength = 100)
    private String lastName;

    @Schema(title = "Last Name", maxLength = 20)
    private String nationCode;

    @Schema(title = "User Telephone", maxLength = 50)
    private String tel;

    @Schema(title = "User Address", maxLength = 1000)
    private String address;

    @Schema(title = "User Email", maxLength = 100)
    private String email;

    @Schema(title = "User WebSite", maxLength = 50)
    private String website;

    @Schema(title = "USERNAME", maxLength = 100)
    private String username;

    @Schema(title = "PASSWORD", maxLength = 100)
    private String password;

    @Schema(title = "User Login Limitation Number", type = "number")
    private Long limitationNumber;

    @Schema(title = "User Signature", maxLength = 20)
    private String signature;

    @Schema(title = "User Last Login Date", maxLength = 10)
    private String lastlogindate;

    @Schema(title = "User Company Public Id", maxLength = 36,
    description = "Entity is not ready")
    private String companyPublicId;

    @Schema(title = "User Interface Skin", maxLength = 50)
    private String selectedSkin;

    @Schema(title = "User Language", maxLength = 36,
            description = "Entity is not ready")
    private String selectedLanguagePublicId;

    @Schema(title = "User Mail Sending Type ", maxLength = 15)
    private String emailProcessType;

    @Schema(title = "User PERSONAL CODE", maxLength = 15)
    private String personalCode;

    @Schema(title = "User Activity Status", maxLength = 1)
    private String activityStatus;

    @Schema(title = "User Kind", maxLength = 20)
    private String kind;

    @Schema(title = "User Organization Position Public ID", maxLength = 36,
            description = "Entity is not ready")
    private String organizationPositionPublicId;

    @Schema(title = "User Owner Public ID", maxLength = 36,
            description = "Entity is not ready")
    private String ownerPublicId;

    @Schema(title = "User Organization Class Public ID", maxLength = 36,
            description = "Entity is not ready")
    private String organizationClassPublicId;

    @Schema(title = "User Recruitment Type", maxLength = 50)
    private String noeEstekhdam;

    @Schema(title = "َUser Pure Password", maxLength = 50)
    private String pwdp;

    @Schema(title = "user Signature Type", maxLength = 1)
    private String signatureImg;

    @Schema(title = "User Commercial Additional Information Public ID", maxLength = 36,
            description = "Entity is not ready")
    private String commerceAdditionalInfoPublicId;

    @Schema(title = "User Encrypted Password", maxLength = 500)
    private String encryptedPassword;

    @Schema(title = "User Email Verification Token", maxLength = 500)
    private String emailVerificationToken;

    @Schema(title = "User Email Verification Status", type = "boolean")
    private Boolean emailVerificationStatus;

    @Schema(title = "User Mobile Verification Status", type = "boolean")
    private Boolean mobileVerificationStatus;

    @Schema(title = "User Description", maxLength = 500)
    private String description;

    @Schema(title = "User Authority (ROLE) Public ID", maxLength = 36 )
    private String authorityPublicId;
}

