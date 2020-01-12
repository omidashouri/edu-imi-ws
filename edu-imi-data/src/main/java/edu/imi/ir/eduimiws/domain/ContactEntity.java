package edu.imi.ir.eduimiws.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_CONTACT_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_CONTACT")
public class ContactEntity extends BaseEntity {

  @Column(name="ACCOUNT_ID")
  private String accountId;

  @Column(name="SALUTATION_ID")
  private String salutationId;

  @Column(name="FIRST_NAME")
  private String firstName;

  @Column(name="MIDDLE_NAME")
  private String middleName;

  @Column(name="LAST_NAME")
  private String lastName;

  @Column(name="JOB_TITLE")
  private String jobTitle;

  @Column(name="BUSINESS_PHONE")
  private String businessPhone;

  @Column(name="HOME_PHONE")
  private String homePhone;

  @Column(name="MOBILE_PHONE")
  private String mobilePhone;

  @Column(name="FAX_NUMBER")
  private String faxNumber;

  @Column(name="PAGER_NUMBER")
  private String pagerNumber;

  @Column(name="EMAIL")
  private String email;

  @Column(name="CURRENCY_ID")
  private String currencyId;

  @Column(name="DEPARTMENT")
  private String department;

  @Column(name="ROLE")
  private String role;

  @Column(name="MANAGER_ID")
  private String managerId;

  @Column(name="MANAGER_PHONE")
  private String managerPhone;

  @Column(name="ASSISTANT_ID")
  private String assistantId;

  @Column(name="ASSISTANT_PHONE")
  private String assistantPhone;

  @Column(name="GENDER")
  private String gender;

  @Column(name="MARITAL_STATUS")
  private String maritalStatus;

  @Column(name="PARTNER_NAME")
  private String partnerName;

  @Column(name="BIRTHDATE")
  private String birthdate;

  @Column(name="ANNIVERSARY")
  private String anniversary;

  @Column(name="DESCRIPTION")
  private String description;

  @Column(name="PARENT_ID")
  private String parentId;

  @Column(name="COUNTRY_ID")
  private String countryId;

  @Column(name="STATE_ID")
  private String stateId;

  @Column(name="CITY_ID")
  private String cityId;

  @Column(name="ADDRESS_PHONE")
  private String addressPhone;

  @Column(name="ADDRESS")
  private String address;

  @Column(name="COMPANY_ID")
  private String companyId;

  @Column(name="ORGANIZATION_ID")
  private String organizationId;

  @Column(name="LEAD_SOURCE_ID")
  private String leadSourceId;

  @Column(name="CAMPAIGN_ID")
  private String campaignId;

  @Column(name="TEAM_ID")
  private String teamId;

  @Column(name="SYNC_OUT_LOOK")
  private String syncOutLook;

  @Column(name="PREFERRED_CONTACT_METHOD")
  private String preferredContactMethod;

  @Column(name="ALLOW_EMAIL")
  private String allowEmail;

  @Column(name="ALLOW_BULK_EMAIL")
  private String allowBulkEmail;

  @Column(name="ALLOW_PHONE")
  private String allowPhone;

  @Column(name="ALLOW_FAX")
  private String allowFax;

  @Column(name="ALLOW_MAIL")
  private String allowMail;

  @Column(name="ADDRESS_TYPE_ID")
  private String addressTypeId;

  @Column(name="USER_CREATOR_ID")
  private String userCreatorId;

  @Column(name="FROM_CITY")
  private String fromCity;

  @Column(name="CERTIFICATE_NO")
  private String certificateNo;

  @Column(name="NATION_CODE")
  private String nationCode;

  @Column(name="FATHER_NAME")
  private String fatherName;

  @Column(name="BIRTH_CITY_ID")
  private String birthCityId;

  @Column(name="ACCESS_TYPE")
  private String accessType;

  @Column(name="IMAGE")
  private String image;

  @Column(name="LFIRST_NAME")
  private String lfirstName;

  @Column(name="LLAST_NAME")
  private String llastName;

  @Column(name="RELIGION_ID")
  private String religionId;

  @Column(name="MILITARY_SERVICE_ID")
  private String militaryServiceId;

  @Column(name="EDU_LEVEL_ID")
  private String eduLevelId;

  @Column(name="FIELD_NAME")
  private String fieldName;

  @Column(name="BANK_NAME")
  private String bankName;

  @Column(name="BRANCH_NAME")
  private String branchName;

  @Column(name="BANK_ACCOUNT_NUMBER")
  private String bankAccountNumber;

  @Column(name="BANK_ACCOOUNT_TYPE")
  private String bankAccoountType;

  @Column(name="ENTRANCE_DATE")
  private String entranceDate;

  @Column(name="CONTRACT_TYPE_ID")
  private String contractTypeId;

  @Column(name="UNIVERSITY")
  private String university;

  @Column(name="INSURANCE_KIND_ID")
  private String insuranceKindId;

  @Column(name="INSURANCE_BOX_ID")
  private String insuranceBoxId;

  @Column(name="GENDER1")
  private String gender1;

  @Column(name="MARITAL1")
  private String marital1;

  @Column(name="MILITARY1")
  private String military1;

  @Column(name="EDIT_TEMP_ROW_FLAG")
  private String editTempRowFlag;

  @Column(name="CREATE_TEMP_ROW_FLAG")
  private String createTempRowFlag;

  @Column(name="VERIFIED")
  private String verified;

  @Column(name="POSTAL_CODE")
  private String postalCode;

  @Column(name="EDIT_DATE")
  private String editDate;

  @Column(name="CREATE_DATE")
  private String createDate;

  @Column(name="USER_EDITOR_ID")
  private String userEditorId;

  @Column(name="CONVERT_DATE_WHO")
  private String convertDateWho;

  @Column(name="CONVERT_UNIQ")
  private String convertUniq;

  @Column(name="LFATHER_NAME")
  private String lfatherName;

  @Column(name="LFROM_CITY")
  private String lfromCity;

  @Column(name="LFROM_CITY_ID")
  private String lfromCityId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "contactId",cascade = CascadeType.PERSIST)   //with cascade when save user the address information also saved
  private List<PersonEntity> personEntities= new ArrayList<>();


}
