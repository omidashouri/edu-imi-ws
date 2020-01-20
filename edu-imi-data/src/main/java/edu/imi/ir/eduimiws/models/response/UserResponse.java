package edu.imi.ir.eduimiws.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


// the old name is UserRest
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends RepresentationModel<UserResponse> {

    private String userPublicId;
    private String firstName;
    private String lastName;
    private String useName;
/*    private PersonResponse personResponse;
    List<ContactResponse> contactResponses;*/
}
