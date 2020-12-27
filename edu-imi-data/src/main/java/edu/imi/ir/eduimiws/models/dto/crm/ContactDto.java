package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto implements Serializable {

    private static final long serialVersionUID = 7055740784295092359L;

    private Long id;
    private String contactPublicId;

    private AccountDto accountDto;
    private Long accountId;
    private String accountPublicId;

    private ParameterDto salutationDto;
    private Long salutationId;
    private String salutationPublicId;

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

    private ParameterDto currencyDto;
    private Long currencyId;
    private String currencyPublicId;

    private String department;

    private String role;

    private ContactDto managerDto;
    private Long managerId;
    private String managerPublicId;

    private String managerPhone;

    private ContactDto assistantDto;
    private Long assistantId;
    private String assistantPublicId;

    private String assistantPhone;

    private String gender;

    private String maritalStatus;

    private String partnerName;

    private String birthdate;

    private String anniversary;

    private String description;

    private ContactDto parentDto;
    private Long parentId;
    private String parentPublicId;

    private ParameterDto countryDto;
    private Long countryId;
    private String countryPublicId;

    private ParameterDto stateDto;
    private Long stateId;
    private String statePublicId;

    private ParameterDto cityDto;
    private Long cityId;
    private String cityPublicId;

    private String addressPhone;

    private String address;

    private CompanyDto companyDto;
    private Long companyId;
    private String companyPublicId;

    private OrganizationDto organizationDto;
    private Long organizationId;
    private String organizationPublicId;

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

    private ParameterDto addressTypeDto;
    private Long addressTypeId;
    private String addressTypePublicId;

    private PersonDto userCreatorDto;
    private Long userCreatorId;
    private String userCreatorPublicId;

    private String fromCity;

    private String certificateNo;

    private String nationCode;

    private String fatherName;

    private ParameterDto birthCityDto;
    private Long birthCityId;
    private String birthCityPublicId;

    private String accessType;

    private String image;

    private String lfirstName;

    private String llastName;

    private ParameterDto religionDto;
    private Long religionId;
    private String religionPublicId;

    private ParameterDto militaryServiceDto;
    private Long militaryServiceId;
    private String militaryServicePublicId;

    private ParameterDto eduLevelDto;
    private Long eduLevelId;
    private String eduLevelPublicId;

    private String fieldName;

    private String bankName;

    private String branchName;

    private String bankAccountNumber;

    private String bankAccoountType;

    private String entranceDate;

    private ParameterDto contractTypeDto;
    private Long contractTypeId;
    private String contractTypePublicId;

    private String university;

    private ParameterDto insuranceKindDto;
    private Long insuranceKindId;
    private String insuranceKindPublicId;

    private ParameterDto insuranceBoxDto;
    private Long insuranceBoxId;
    private String insuranceBoxPublicId;

    private String gender1;

    private String marital1;

    private String military1;

    private String editTempRowFlag;

    private String createTempRowFlag;

    private String verified;

    private String postalCode;

    private String editDate;

    private String createDate;

    private PersonDto userEditorDto;
    private Long userEditorId;
    private String userEditorPublicId;

    private String convertDateWho;

    private String convertUniq;

    private String lfatherName;

    private String lfromCity;

    private ParameterDto lfromCityEntityDto;
    private Long lfromCityEntityId;
    private String lfromCityEntityPublicId;

    private ContactApiDto contactApiDto;
    private Long contactApiId;


}
