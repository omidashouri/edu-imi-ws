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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_COMPANY_ID",allocationSize = 1)
@Table(schema = "CRM",name="TBL_COMPANY")
public class CompanyEntity extends BaseEntity {

  @Column(name="NAME_LO")
  private String nameLo;

  @Column(name="PHONE")
  private String phone;

  @Column(name="FAX")
  private String fax;

  @Column(name="WEB_SITE")
  private String webSite;

  @Column(name="EMAIL")
  private String email;

  @Column(name="BILLING_ADDRESS")
  private String billingAddress;

  @Column(name="SHIPPING_ADDRESS")
  private String shippingAddress;

  @Column(name="ANNUAL_REVENUE")
  private String annualRevenue;

  @Column(name="EMPLOYEES")
  private Long employees;

  @Column(name="OWNERSHIP")
  private String ownership;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PAREMETER_ID")
  private ParameterEntity paremeter;

  @Column(name="TERRITORY")
  private String territory;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LANGUAGE_ID")
  private LanguageEntity language;

  @Column(name="CALENDER_TYPE")
  private String calenderType;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MAIN_ACCOUNT_ID")
  private AccountEntity mainAccount;

  @Column(name="IS_MAIN")
  private String isMain;

  @Column(name="LOGO")
  private String logo;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
  private List<PersonEntity> personEntities= new ArrayList<>();

  public void addPerson(PersonEntity person){
    if(null != person){
      if(null == personEntities){
        personEntities = new ArrayList<>();
      }
      person.setCompany(this);
      personEntities.add(person);
    }
  }

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
  private List<ContactEntity> contactEntities= new ArrayList<>();

  public void addContact(ContactEntity contact){
      if (null != contact) {
          if (null == contactEntities) {
              contactEntities = new ArrayList<>();
          }
          contact.setCompany(this);
          contactEntities.add(contact);
      }
  }


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "company", fetch = FetchType.LAZY)
    private CompanyApiEntity companyApi;

}
