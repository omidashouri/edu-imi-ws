package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto implements Serializable {

    private static final long serialVersionUID = 3145481294256612990L;

    private Long id;

    private String nameLo;

    private OrganizationDto parent;
    private Long parentId;
    private String parentPublicId;

    private String website;

    private String mainPhone;

    private String otherPhone;

    private String fax;

    private String email;

    private String billAddress;

    private ParameterDto billCity;
    private Long billCityId;
    private String billCityPublicId;

    private ParameterDto billState;
    private Long billStateId;
    private String billStatePublicId;

    private ParameterDto billCountry;
    private Long billCountryId;
    private String billCountryPublicId;

    private String billZipcode;

    private String shipAddress;

    private ParameterDto shipCity;
    private Long shipCityId;
    private String shipCityPublicId;

    private ParameterDto shipState;
    private Long shipStateId;
    private String shipStatePublicId;

    private ParameterDto shipCountry;
    private Long shipCountryId;
    private String shipCountryPublicId;

    private String shipZipcode;

    private AccountDto account;
    private Long accountId;
    private String accountPublicId;

    private String isActive;

    private String editDate;
}
