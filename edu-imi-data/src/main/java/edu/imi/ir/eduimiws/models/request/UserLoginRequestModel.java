package edu.imi.ir.eduimiws.models.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestModel {

//    create this for user sign in request

    private String username;
    private String password;
    private String role;
}
