package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto implements Serializable {

    private static final long serialVersionUID = 3145481294256612990L;

    private String nameLo;

    private OrganizationDto parentId;

    private String website;

    private String mainPhone;

    private String otherPhone;

    private String fax;

    private String email;

    private String billAddress;

    private ParameterDto billCity;

    private ParameterDto billState;

    private ParameterDto billCountry;

    private String billZipcode;

    private String shipAddress;

    private ParameterDto shipCity;

    private ParameterDto shipState;

    private ParameterDto shipCountry;

    private String shipZipcode;

    private AccountDto accountId;

    private String isActive;

    private String editDate;
}
