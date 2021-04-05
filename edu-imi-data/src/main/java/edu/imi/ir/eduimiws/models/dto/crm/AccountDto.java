package edu.imi.ir.eduimiws.models.dto.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountApiEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements Serializable {

    private static final long serialVersionUID = -7634450278509108686L;

    private Long id;
    private String accountPublicId;

    private CompanyDto company;
    private Long companyId;
    private String companyPublicId;

    private AccountDto parentAccount;
    private Long parentAccountId;
    private String parentAccountPublicId;

    private ContactDto primaryContact;
    private Long primaryContactId;
    private String primaryContactPublicId;

    private Long relationTypeId;

    private LanguageDto language;
    private Long languageId;
    private String languagePublicId;

    private ParameterDto currency;
    private Long currencyId;
    private String currencyPublicId;

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
    private Long countryId;
    private String countryPublicId;

    private ParameterDto state;
    private Long stateId;
    private String statePublicId;

    private ParameterDto city;
    private Long cityId;
    private String cityPublicId;

    private String addressPhone;

    private String address;

    private String description;

    private Long industryId;

    private ParameterDto addressType;
    private Long addressTypeId;
    private String addressTypePublicId;

    private String accountLogo;

    private String printLogo;

    private String printTitle1;

    private String printTitle2;

    private String printTitle3;

    private String printAddressTitle;

    private ParameterDto region;
    private Long regionId;
    private String regionPublicId;

    private PersonDto userCreator;
    private Long userCreatorId;
    private String userCreatorPublicId;

    private String createDate;

    private PersonDto userLastEditor;
    private Long userLastEditorId;
    private String userLastEditorPublicId;

    private String lastEditDate;

    private ContactDto userFollower;
    private Long userFollowerId;
    private String userFollowerPublicId;

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
    private Long siteCityId;
    private String siteCityPublicId;

    private String siteStateId;

    private String stockOtherType;

    private String postCode;

    private String prePhone;

    private String economicalCode;

    private String orgNationalCode;

    private ParameterDto employee;
    private Long employeeId;
    private String employeePublicId;

    private ParameterDto annualRevenueEntity;
    private Long annualRevenueEntityId;
    private String annualRevenueEntityPublicId;

    private AccountApiDto accountApi;
    private Long accountApiId;
}
