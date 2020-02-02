package edu.imi.ir.eduimiws.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContactResponse extends RepresentationModel<UserContactResponse> {

    private String contactPublicId;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String gender;
    private String birthdate;
    private String fromCity;
    private String certificateNo;
    private String nationCode;
    private String fatherName;
    private String description;
    private String address;
    private String lfirstName;
    private String llastName;
    private String postalCode;
    private String lfatherName;
    private String lfromCity;

}
