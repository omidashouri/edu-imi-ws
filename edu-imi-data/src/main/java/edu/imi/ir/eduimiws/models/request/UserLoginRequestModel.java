package edu.imi.ir.eduimiws.models.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(name = "Login", description = "Login Information for Authentication")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "Login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestModel {


//    create this for user sign in request

    @Schema(title = "UserName", maxLength=10, example = " ", required = true)
    private String username;

    @Schema(title = "PassWord", maxLength=10, example = " ", required = true)
    private String password;

    @Schema(title = "role", maxLength=10, example = "anonymous")
    private String role;
}
