package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {

    private static final long serialVersionUID = -7634450278509108686L;

    private Long id;

    private CompanyDto company;

    private AccountDto parentAccount;

    private ContactDto primaryContact;

    private Long relationTypeId;

    private LanguageDto language;

    private ParameterDto currency;

    private String accountName;

    private String accountNumber;

    private String ownership;

    private String accountType;

    private String mainPhone;

    private String otherPhone;

    private String faxNumber;

    private String webSite;

    private String email;

    private String tickerSymbol;

    private String employees;

    private String annualRevenue;

    private ParameterDto country;

    private ParameterDto state;

    private ParameterDto city;

    private String addressPhone;

    private String address;

    private String description;

    private Long industryId;

    private ParameterDto addressType;

    private String accountLogo;

    private String printLogo;

    private String printTitle1;

    private String printTitle2;

    private String printTitle3;

    private String printAddressTitle;

    private ParameterDto region;

    private PersonDto userCreator;

    private String createDate;

    private PersonDto userLastEditor;

    private String lastEditDate;

    private ContactDto userFollower;

    private String generalCode;

    private String specificCode;

    private String detailedCode;

    private String primarySalesManId;

    private String secondarySalesManId;

    private String pathId;

    private String accessType;

    private String verified;

    private Long accountAdditionalInfoId;

    private String address2;

    private String address3;

    private String accountEnName;

    private String stockType;

    private String isHolding;

    private Long orgTypeId;

    private String typeOfActivity;

    private String isInStock;

    private String utilizationYear;

    private String sitePhone;

    private String siteFax;

    private String siteAddress;

    private String stockHolders;

    private Long inpeaAdditionalInfo;

    private String subSys;

    private String ibmcAdditionalInfo;

    private ParameterDto siteCity;

    private String siteStateId;

    private String stockOtherType;

    private String postCode;

    private String prePhone;

    private String economicalCode;

    private String orgNationalCode;

    private ParameterDto employee;

    private ParameterDto annualRevenueEntity;
}
