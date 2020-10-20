package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactFastDto implements Serializable {

    private static final long serialVersionUID = 2368115116670875150L;

    private Long id;

    private Long accountPublicId;

    private Long salutationPublicId;

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

    private Long currencyPublicId;

    private String department;

    private String role;

    private Long managerPublicId;

    private String managerPhone;

    private Long assistantPublicId;

    private String assistantPhone;

    private String gender;

    private String maritalStatus;

    private String partnerName;

    private String birthdate;

    private String anniversary;

    private String description;

    private Long parentPublicId;

    private Long countryPublicId;

    private Long statePublicId;

    private Long cityPublicId;

    private String addressPhone;

    private String address;

    private Long companyPublicId;

    private Long organizationPublicId;

    private Long leadSourcePublicId;

    private Long campaignPublicId;

    private Long teamPublicId;

    private String syncOutLook;

    private String preferredContactMethod;

    private String allowEmail;

    private String allowBulkEmail;

    private String allowPhone;

    private String allowFax;

    private String allowMail;

    private Long addressTypePublicId;

    private Long userCreatorPublicId;

    private String fromCity;

    private String certificateNo;

    private String nationCode;

    private String fatherName;

    private Long birthCityPublicId;

    private String accessType;

    private String image;

    private String lfirstName;

    private String llastName;

    private Long religionPublicId;

    private Long militaryServicePublicId;

    private Long eduLevelPublicId;

    private String fieldName;

    private String bankName;

    private String branchName;

    private String bankAccountNumber;

    private String bankAccoountType;

    private String entranceDate;

    private Long contractTypePublicId;

    private String university;

    private Long insuranceKindPublicId;

    private Long insuranceBoxPublicId;

    private String gender1;

    private String marital1;

    private String military1;

    private String editTempRowFlag;

    private String createTempRowFlag;

    private String verified;

    private String postalCode;

    private String editDate;

    private String createDate;

    private Long userEditorPublicId;

    private String convertDateWho;

    private String convertUniq;

    private String lfatherName;

    private String lfromCity;

    private Long lfromCityEntityPublicId;

    private String contactPublicId;

    private String personPublicId;

}
