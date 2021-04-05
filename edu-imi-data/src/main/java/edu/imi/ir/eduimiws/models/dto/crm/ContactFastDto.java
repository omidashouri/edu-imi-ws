package edu.imi.ir.eduimiws.models.dto.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactFastDto implements Serializable {

    private static final long serialVersionUID = 2368115116670875150L;

    private Long id;

    private String accountPublicId;
    private Long accountId;
    private AccountDto account;

    private String salutationPublicId;
    private Long salutationId;

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

    private String currencyPublicId;
    private Long currencyId;

    private String department;

    private String role;

    private String managerPublicId;
    private Long managerId;

    private String managerPhone;

    private String assistantPublicId;
    private Long assistantId;

    private String assistantPhone;

    private String gender;

    private String maritalStatus;

    private String partnerName;

    private String birthdate;

    private String anniversary;

    private String description;

    private String parentPublicId;
    private Long parentId;

    private String countryPublicId;
    private Long countryId;
    private ParameterDto country;

    private String statePublicId;
    private Long stateId;
    private ParameterDto state;

    private String cityPublicId;
    private Long cityId;
    private ParameterDto city;

    private String addressPhone;

    private String address;

    private String companyPublicId;
    private Long companyId;
    private CompanyDto company;

    private String organizationPublicId;
    private Long organizationId;
    private OrganizationDto organization;

    private String leadSourcePublicId;
    private Long leadSourceId;

    private String campaignPublicId;
    private Long campaignId;

    private String teamPublicId;
    private Long teamId;

    private String syncOutLook;

    private String preferredContactMethod;

    private String allowEmail;

    private String allowBulkEmail;

    private String allowPhone;

    private String allowFax;

    private String allowMail;

    private String addressTypePublicId;
    private Long addressTypeId;

    private String userCreatorPublicId;
    private Long userCreatorId;

    private String fromCity;

    private String certificateNo;

    private String nationCode;

    private String fatherName;

    private String birthCityPublicId;
    private Long birthCityId;
    private ParameterDto birthCity;

    private String accessType;

    private String image;

    private String lfirstName;

    private String llastName;

    private String religionPublicId;
    private Long religionId;
    private ParameterDto religion;

    private String militaryServicePublicId;
    private Long militaryServiceId;
    private ParameterDto militaryService;

    private String eduLevelPublicId;
    private Long eduLevelId;
    private ParameterDto eduLevel;

    private String fieldName;

    private String bankName;

    private String branchName;

    private String bankAccountNumber;

    private String bankAccoountType;

    private String entranceDate;

    private String contractTypePublicId;
    private Long contractTypeId;

    private String university;

    private String insuranceKindPublicId;
    private Long insuranceKindId;

    private String insuranceBoxPublicId;
    private Long insuranceBoxId;

    private String gender1;

    private String marital1;

    private String military1;

    private String editTempRowFlag;

    private String createTempRowFlag;

    private String verified;

    private String postalCode;

    private String editDate;

    private String createDate;

    private String userEditorPublicId;
    private Long userEditorId;

    private String convertDateWho;

    private String convertUniq;

    private String lfatherName;

    private String lfromCity;

    private String lfromCityEntityPublicId;
    private Long lfromCityEntityId;

    private String contactPublicId;
    private Long contactId;

    private String personPublicId;
    private Long personId;

}
