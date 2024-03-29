package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@NamedEntityGraphs({
      @NamedEntityGraph(name = "ContactEntity.findContactSubGraphPersonsPersonApiAndContactApi",
              attributeNodes = {
                      @NamedAttributeNode(value = "persons",subgraph = "persons-subGraph"),
                      @NamedAttributeNode(value = "contactWebService")
              },
              subgraphs = {
                      @NamedSubgraph(name = "persons-subGraph",
                              attributeNodes = {
                                      @NamedAttributeNode(value = "personApiEntity")
                              },type = PersonApiEntity.class
                      )
              }
      ),
    @NamedEntityGraph(name = "ContactEntity.findContactSubGraphPersonsPersonApi",
        attributeNodes = {
              @NamedAttributeNode(value = "persons",subgraph = "persons-subGraph")
        },
        subgraphs = {
                @NamedSubgraph(name = "persons-subGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "personApiEntity")
                        },type = PersonApiEntity.class
                )
        }
    ),
      @NamedEntityGraph(name = "ContactEntity.findContactAccount",
              attributeNodes = {
                      @NamedAttributeNode(value = "account")
              }
    ),
        @NamedEntityGraph(name = "ContactEntity.findContactContactApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "contactWebService")
                }
        )
})

@NamedQueries({
        @NamedQuery(name = "ContactEntity.queryPageablePaymentCodeApiProjection",
                query = " select " +
                        " con.id as id,"+
                        " cona.contactPublicId as contactPublicId,"+
                        " con.nationCode as nationCode, " +
                        " con.firstName as firstName, " +
                        " con.middleName as middleName," +
                        " con.lastName as lastName," +
                        " con.mobilePhone as mobilePhone," +
                        " con.birthdate as birthdate " +
                        " from " +
                        " ContactEntity con " +
                        " left join con.contactWebService cona " +
                        " where " +
                        " ( :id is null or con.id = :id ) AND " +
                        " ( :contactPublicId is null or cona.contactPublicId = :contactPublicId ) AND " +
                        " ( :nationalCode is null or con.nationCode = :nationalCode ) AND " +
                        " ( :firstName is null or con.firstName like concat('%',:firstName,'%') ) AND " +
                        " ( :middleName is null or con.middleName like concat('%',:middleName,'%') ) AND " +
                        " ( :lastName is null or con.lastName like concat('%',:lastName,'%') ) AND " +
                        " ( :mobilePhone is null or con.mobilePhone like concat('%',:mobilePhone,'%') ) AND " +
                        " ( :birthDate is null or con.birthdate like concat('%',:birthDate,'%') ) AND " +
                        " ( :fullName is null or concat(con.firstName,' ',con.middleName,' ',con.lastName)  like concat('%',:fullName,'%') ) "
                /*       " ORDER BY con.lastName desc NULLS LAST "
                hints =  {
                        @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                        @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                        @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
                },
                lockMode = LockModeType.READ*/
        )
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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

  @Column(name="FIRST_NAME",length = 500)
  private String firstName;

  @Column(name="MIDDLE_NAME",length = 100)
  private String middleName;

  @Column(name="LAST_NAME",length = 100)
  private String lastName;

  @Column(name="JOB_TITLE",length = 250)
  private String jobTitle;

  @Column(name="BUSINESS_PHONE",length = 50)
  private String businessPhone;

  @Column(name="HOME_PHONE",length = 50)
  private String homePhone;

  @Column(name="MOBILE_PHONE",length = 50)
  private String mobilePhone;

  @Column(name="FAX_NUMBER",length = 50)
  private String faxNumber;

  @Column(name="PAGER_NUMBER",length = 50)
  private String pagerNumber;

  @Column(name="EMAIL",length = 100)
  private String email;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CURRENCY_ID")
  private ParameterEntity currency;

  @Column(name="DEPARTMENT",length = 100)
  private String department;

  @Column(name="ROLE",length = 100)
  private String role;

  @OneToOne(optional = true)
  @JoinColumn(name = "MANAGER_ID")
  private ContactEntity manager;

  @Column(name="MANAGER_PHONE",length = 50)
  private String managerPhone;

  @OneToOne(optional = true)
  @JoinColumn(name = "ASSISTANT_ID")
  private ContactEntity assistant;

  @Column(name="ASSISTANT_PHONE",length = 50)
  private String assistantPhone;

  @Column(name="GENDER",length = 3)
  private String gender;

  @Column(name="MARITAL_STATUS",length = 1)
  private String maritalStatus;

  @Column(name="PARTNER_NAME",length = 200)
  private String partnerName;

  @Column(name="BIRTHDATE",length = 20)
  private String birthdate;

  @Column(name="ANNIVERSARY",length = 20)
  private String anniversary;

  @Column(name="DESCRIPTION",length = 4000)
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

  @Column(name="ADDRESS_PHONE",length = 500)
  private String addressPhone;

  @Column(name="ADDRESS",length = 500)
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

  @Column(name="SYNC_OUT_LOOK",length = 1)
  private String syncOutLook;

  @Column(name="PREFERRED_CONTACT_METHOD",length = 1)
  private String preferredContactMethod;

  @Column(name="ALLOW_EMAIL",length = 1)
  private String allowEmail;

  @Column(name="ALLOW_BULK_EMAIL",length = 1)
  private String allowBulkEmail;

  @Column(name="ALLOW_PHONE",length = 1)
  private String allowPhone;

  @Column(name="ALLOW_FAX",length = 1)
  private String allowFax;

  @Column(name="ALLOW_MAIL",length = 1)
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

  @Column(name="FROM_CITY",length = 100)
  private String fromCity;

  @Column(name="CERTIFICATE_NO",length = 100)
  private String certificateNo;

  @Column(name="NATION_CODE",length = 20)
  private String nationCode;

  @Column(name="FATHER_NAME",length = 100)
  private String fatherName;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BIRTH_CITY_ID")
  private ParameterEntity birthCity;

  @Column(name="ACCESS_TYPE",length = 10)
  private String accessType;

  @Column(name="IMAGE",length = 200)
  private String image;

  @Column(name="LFIRST_NAME",length = 50)
  private String lfirstName;

  @Column(name="LLAST_NAME",length = 50)
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

  @Column(name="FIELD_NAME",length = 200)
  private String fieldName;

  @Column(name="BANK_NAME",length = 50)
  private String bankName;

  @Column(name="BRANCH_NAME",length = 50)
  private String branchName;

  @Column(name="BANK_ACCOUNT_NUMBER",length = 30)
  private String bankAccountNumber;

  @Column(name="BANK_ACCOOUNT_TYPE",length = 50)
  private String bankAccoountType;

  @Column(name="ENTRANCE_DATE",length = 10)
  private String entranceDate;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CONTRACT_TYPE_ID")
  private ParameterEntity contractType;

  @Column(name="UNIVERSITY",length = 300)
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

  @Column(name="GENDER1",length = 10)
  private String gender1;

  @Column(name="MARITAL1",length = 10)
  private String marital1;

  @Column(name="MILITARY1",length = 50)
  private String military1;

  @Column(name="EDIT_TEMP_ROW_FLAG",length = 1)
  private String editTempRowFlag;

  @Column(name="CREATE_TEMP_ROW_FLAG",length = 1)
  private String createTempRowFlag;

  @Column(name="VERIFIED",length = 1)
  private String verified;

  @Column(name="POSTAL_CODE",length = 20)
  private String postalCode;

  @Column(name="EDIT_DATE",length = 10)
  private String editDate;

  @Column(name="CREATE_DATE",length = 10)
  private String createDate;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_EDITOR_ID")
  private PersonEntity userEditor;

  @Column(name="CONVERT_DATE_WHO",length = 30)
  private String convertDateWho;

  @Column(name="CONVERT_UNIQ",length = 20)
  private String convertUniq;

  @Column(name="LFATHER_NAME",length = 50)
  private String lfatherName;


  @Column(name="LFROM_CITY",length = 100)
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

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne(mappedBy="contact",fetch = FetchType.LAZY)
  private ContactApiEntity contactWebService;

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
