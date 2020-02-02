package edu.imi.ir.eduimiws.models.response;

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

    private String userPublicId;
    private String contactPublicId;

    private String firstName;
    private String lastName;
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
