package edu.imi.ir.eduimiws.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto implements Serializable {

    private static final long serialVersionUID = -1531319631086735618L;

    @JsonProperty("user_public_id")
    private String personPublicId;

    @JsonProperty("contact_public_id")
    private String contactPublicId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("telephone")
    private String tel;

    @JsonProperty("email")
    private String email;

    private String password;

    @JsonProperty("encrypted_password")
    private String encryptedPassword;

    @JsonProperty("email_verification_token")
    private String emailVerificationToken;

    @JsonProperty("email_verification_status")
    private Boolean emailVerificationStatus = false;


}
