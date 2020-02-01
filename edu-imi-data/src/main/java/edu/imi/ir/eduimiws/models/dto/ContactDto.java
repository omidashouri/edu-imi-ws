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

    private Long id;

    private AccountDto account;

    private Long accountId;

    private ParameterDto salutation;

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

    private ParameterDto currency;

    private String department;

    private String role;

    private ContactDto manager;

    private String managerPhone;

    private ContactDto assistant;

    private String assistantPhone;

    private String gender;

    private String maritalStatus;

    private String partnerName;

    private String birthdate;

    private String anniversary;

    private String description;

    private ContactDto parent;

    private ParameterDto country;

    private ParameterDto state;

    private ParameterDto city;

    private String addressPhone;

    private String address;

    private CompanyDto company;

    private OrganizationDto organization;

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

    private ParameterDto addressType;

    private PersonDto userCreator;

    private String fromCity;

    private String certificateNo;

    private String nationCode;

    private String fatherName;

    private ParameterDto birthCity;

    private String accessType;

    private String image;

    private String lfirstName;

    private String llastName;

    private ParameterDto religion;

    private ParameterDto militaryService;

    private ParameterDto eduLevel;

    private String fieldName;

    private String bankName;

    private String branchName;

    private String bankAccountNumber;

    private String bankAccoountType;

    private String entranceDate;

    private ParameterDto contractType;

    private String university;

    private ParameterDto insuranceKind;

    private ParameterDto insuranceBox;

    private String gender1;

    private String marital1;

    private String military1;

    private String editTempRowFlag;

    private String createTempRowFlag;

    private String verified;

    private String postalCode;

    private String editDate;

    private String createDate;

    private PersonDto userEditor;

    private String convertDateWho;

    private String convertUniq;

    private String lfatherName;

    private String lfromCity;

    private ParameterDto lfromCityEntity;

}
