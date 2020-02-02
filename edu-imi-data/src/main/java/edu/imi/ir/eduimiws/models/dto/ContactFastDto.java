package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactFastDto implements Serializable {

    private static final long serialVersionUID = 2198116635025433135L;

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
