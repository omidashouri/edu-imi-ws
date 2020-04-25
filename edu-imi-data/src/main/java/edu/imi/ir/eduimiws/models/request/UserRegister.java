package edu.imi.ir.eduimiws.models.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String nationCode;
    private String tel;
    private String email;
    private String address;


}
