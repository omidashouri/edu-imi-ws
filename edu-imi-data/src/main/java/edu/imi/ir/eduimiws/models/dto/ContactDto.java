package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto implements Serializable {

    private static final long serialVersionUID = 7055740784295092359L;

    private AccountDto accountId;

    private ParameterDto salutationId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String jobTitle;

    private String businessPhone;

    private String homePhone;

    private String mobilePhone;

    private String faxNumber;

    private String pagerNumber;

    private String email;

    private ParameterDto currencyId;

    private String department;

    private String role;

    private ContactDto managerId;

    private String managerPhone;

    private ContactDto assistantId;

    private String assistantPhone;

    private String gender;

    private String maritalStatus;

    private String partnerName;

    private String birthdate;

    private String anniversary;

    private String description;

    private ContactDto parentId;

    private ParameterDto countryId;

    private ParameterDto stateId;

    private ParameterDto cityId;

    private String addressPhone;

    private String address;

    private CompanyDto companyId;

    private OrganizationDto organizationId;

    private Long leadSourceId;

    private Long campaignId;

    private Long teamId;

    private String syncOutLook;

    private String preferredContactMethod;

    private String allowEmail;

    private String allowBulkEmail;

    private String allowPhone;

    private String allowFax;

    private String allowMail;

    private ParameterDto addressTypeId;

    private PersonDto userCreatorId;

    private String fromCity;

    private String certificateNo;

    private String nationCode;

    private String fatherName;

    private ParameterDto birthCityId;

    private String accessType;

    private String image;

    private String lfirstName;

    private String llastName;

    private ParameterDto religionId;

    private ParameterDto militaryServiceId;

    private ParameterDto eduLevelId;

    private String fieldName;

    private String bankName;

    private String branchName;

    private String bankAccountNumber;

    private String bankAccoountType;

    private String entranceDate;

    private ParameterDto contractTypeId;

    private String university;

    private ParameterDto insuranceKindId;

    private ParameterDto insuranceBoxId;

    private String gender1;

    private String marital1;

    private String military1;

    private String editTempRowFlag;

    private String createTempRowFlag;

    private String verified;

    private String postalCode;

    private String editDate;

    private String createDate;

    private PersonDto userEditorId;

    private String convertDateWho;

    private String convertUniq;

    private String lfatherName;

    private String lfromCity;

    private ParameterDto lfromCityId;

}
