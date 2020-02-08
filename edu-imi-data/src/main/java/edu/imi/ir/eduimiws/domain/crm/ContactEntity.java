package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
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

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ACCOUNT_ID")
  private AccountEntity account;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SALUTATION_ID")
  private ParameterEntity salutation;

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

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CURRENCY_ID")
  private ParameterEntity currency;

  @Column(name="DEPARTMENT")
  private String department;

  @Column(name="ROLE")
  private String role;

  @OneToOne(optional = true)
  @JoinColumn(name = "MANAGER_ID")
  private ContactEntity manager;

  @Column(name="MANAGER_PHONE")
  private String managerPhone;

  @OneToOne(optional = true)
  @JoinColumn(name = "ASSISTANT_ID")
  private ContactEntity assistant;

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

  @OneToOne(optional = true)
  @JoinColumn(name = "PARENT_ID")
  private ContactEntity parent;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COUNTRY_ID")
  private ParameterEntity country;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STATE_ID")
  private ParameterEntity state;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CITY_ID")
  private ParameterEntity city;

  @Column(name="ADDRESS_PHONE")
  private String addressPhone;

  @Column(name="ADDRESS")
  private String address;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COMPANY_ID")
  private CompanyEntity company;


//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORGANIZATION_ID")
  private OrganizationEntity organization;

//  TBL_LEAD
  @Column(name="LEAD_SOURCE_ID")
  private Long leadSourceId;

//  TBL_CAMPAIGNS
  @Column(name="CAMPAIGN_ID")
  private Long campaignId;

  @Column(name="TEAM_ID")
  private Long teamId;

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

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ADDRESS_TYPE_ID")
  private ParameterEntity addressType;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_CREATOR_ID")
  private PersonEntity userCreator;

  @Column(name="FROM_CITY")
  private String fromCity;

  @Column(name="CERTIFICATE_NO")
  private String certificateNo;

  @Column(name="NATION_CODE")
  private String nationCode;

  @Column(name="FATHER_NAME")
  private String fatherName;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BIRTH_CITY_ID")
  private ParameterEntity birthCity;

  @Column(name="ACCESS_TYPE")
  private String accessType;

  @Column(name="IMAGE")
  private String image;

  @Column(name="LFIRST_NAME")
  private String lfirstName;

  @Column(name="LLAST_NAME")
  private String llastName;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RELIGION_ID")
  private ParameterEntity religion;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MILITARY_SERVICE_ID")
  private ParameterEntity militaryService;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EDU_LEVEL_ID")
  private ParameterEntity eduLevel;

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

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CONTRACT_TYPE_ID")
  private ParameterEntity contractType;

  @Column(name="UNIVERSITY")
  private String university;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "INSURANCE_KIND_ID")
  private ParameterEntity insuranceKind;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "INSURANCE_BOX_ID")
  private ParameterEntity insuranceBox;

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

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_EDITOR_ID")
  private PersonEntity userEditor;

  @Column(name="CONVERT_DATE_WHO")
  private String convertDateWho;

  @Column(name="CONVERT_UNIQ")
  private String convertUniq;

  @Column(name="LFATHER_NAME")
  private String lfatherName;


  @Column(name="LFROM_CITY")
  private String lfromCity;

  //  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LFROM_CITY_ID")
  private ParameterEntity lfromCityEntity;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "contact",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
  private List<PersonEntity> persons = new ArrayList<>();

/*  @OneToOne(mappedBy="contact")
  private PersonWebServiceEntity personWebServiceEntity;*/

  public void addPerson(PersonEntity person){
      if(null != person){
        if(null == persons){
          persons = new ArrayList<>();
        }
        person.setContact(this);
        persons.add(person);
      }
  }



}
