package edu.imi.ir.eduimiws.models.response;

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

    @Schema(
            description = "contact public ID"
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
            description = "user mobile number"
    )
    private String mobilePhone;

    @Schema(
            description = "user email address"
    )
    private String email;

    @Schema(
            description = "user gender"
    )
    private String gender;

    @Schema(
            description = "user birth date"
    )
    private String birthdate;

    @Schema(
            description = "user birth city name"
    )
    private String fromCity;

    @Schema(
            description = "user identification number"
    )
    private String certificateNo;

    @Schema(
            description = "user national code"
    )
    private String nationCode;

    @Schema(
            description = "user father name"
    )
    private String fatherName;

    @Schema(
            description = "description field"
    )
    private String description;

    @Schema(
            description = "user address"
    )
    private String address;

    @Schema(
            description = "user latin first name"
    )
    private String lfirstName;

    @Schema(
            description = "user latin last name"
    )
    private String llastName;

    @Schema(
            description = "user postal code"
    )
    private String postalCode;

    @Schema(
            description = "user latin father name"
    )
    private String lfatherName;

    @Schema(
            description = "user latin birth city name"
    )
    private String lfromCity;

}
