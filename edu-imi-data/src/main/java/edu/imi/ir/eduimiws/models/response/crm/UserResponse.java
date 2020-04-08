package edu.imi.ir.eduimiws.models.response.crm;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;


// the old name is UserRest
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends RepresentationModel<UserResponse> {

    @Schema(
            description = "user unique identifier id",
            required = true
    )
    private String userPublicId;

    @Schema(
            description = "contact unique identifier id"
    )
    private String contactPublicId;

    @Schema(
            description = "user first name"
    )
    private String firstName;

    @Schema(
            description = "user last name"
    )
    private String lastName;

    @Schema(
            description = "user name for login"
    )
    private String userName;

    private List<UserContactResponse> userContactResponses = new ArrayList<>();

    public void addUserContactResponse(UserContactResponse userContactResponse){
        if(null != userContactResponse){
            if(null == userContactResponses){
                userContactResponses = new ArrayList<>();
            }
            userContactResponses.add(userContactResponse);
        }
    }
}
