package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {

    private static final long serialVersionUID = 1907555625339107890L;

    private String companyPublicId;
    private Long companyApiId;
    private CompanyApiDto companyApi;

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

    private ParameterDto parameter;
    private String parameterPublicId;
    private Long parameterId;

    private String territory;

    private LanguageDto language;
    //    not created
    private String languagePublicId;
    private Long languageId;

    private String calenderType;

    private AccountDto mainAccount;
    private String mainAccountPublicId;
    private Long mainAccountId;

    private String isMain;

    private String logo;


    private List<ContactDto> contactEntities;

    private List<PersonDto> personEntities;

}
