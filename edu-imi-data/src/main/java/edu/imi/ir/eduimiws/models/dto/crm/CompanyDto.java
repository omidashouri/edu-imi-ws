package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private static final long serialVersionUID = 1907555625339107890L;

    //    later complete this
    private String companyPublicId;

    private Long id;

    private String nameLo;

    private String phone;

    private String fax;

    private String webSite;

    private String email;

    private String billingAddress;

    private String shippingAddress;

    private String annualRevenue;

    private Long employees;

    private String ownership;

    private ParameterDto paremeterId;

    private String territory;

    private LanguageDto languageId;

    private String calenderType;

    private AccountDto mainAccountId;

    private String isMain;

    private String logo;
}
