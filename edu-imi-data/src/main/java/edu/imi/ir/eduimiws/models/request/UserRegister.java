package edu.imi.ir.eduimiws.models.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "register user",description = "Register user in application")
@JsonRootName(value = "register")
@Relation(collectionRelation = "registers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {

    @Schema(title = "National Code",
            description = "value use as USERNAME for login",maxLength = 20)
    private String nationCode;

    @Schema(title = "Password",maxLength = 100)
    private String password;

    @Schema(title = "First Name",maxLength = 100)
    private String firstName;

    @Schema(title = "Last Name",maxLength = 100)
    private String lastName;

    @Schema(title = "Mobile Phone",maxLength = 50)
    private String tel;

    @Schema(title = "Email Address",maxLength = 100)
    private String email;

    @Schema(title = "Address",maxLength = 1000)
    private String address;


}
