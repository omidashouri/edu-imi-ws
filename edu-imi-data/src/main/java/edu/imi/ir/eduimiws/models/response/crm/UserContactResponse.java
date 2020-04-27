package edu.imi.ir.eduimiws.models.response.crm;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(title = "contact public ID",maxLength = 36)
    private String contactPublicId;

    @Schema(title = "User First Name",maxLength = 500)
    private String firstName;

    @Schema(title = "User Last Name",maxLength = 100)
    private String lastName;

    @Schema(title = "user mobile number",maxLength = 50)
    private String mobilePhone;

    @Schema(title = "User Email Address",maxLength = 100)
    private String email;

    @Schema(title= "User Gender",maxLength = 3)
    private String gender;

    @Schema(title = "User Birth Date",maxLength = 20)
    private String birthdate;

    @Schema(title = "User Birth City Name",maxLength = 100)
    private String fromCity;

    @Schema(title= "User Identification Number",maxLength = 100)
    private String certificateNo;

    @Schema(title= "User National Code",maxLength = 20)
    private String nationCode;

    @Schema(title= "User Father Name",maxLength = 100)
    private String fatherName;

    @Schema(title= "Description Field",maxLength = 4000)
    private String description;

    @Schema(title= "User Address",maxLength = 500)
    private String address;

    @Schema(title = "User Latin First Name",maxLength = 50)
    private String lfirstName;

    @Schema(title = "User Latin Last Name",maxLength = 50)
    private String llastName;

    @Schema(title = "User Postal Code",maxLength = 20)
    private String postalCode;

    @Schema(title= "User Latin Father Name",maxLength = 50)
    private String lfatherName;

    @Schema(title= "User Latin Birth City Name",maxLength = 100)
    private String lfromCity;

}
