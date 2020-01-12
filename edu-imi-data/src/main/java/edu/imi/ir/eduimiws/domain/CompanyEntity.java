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
  private String employees;

  @Column(name="OWNERSHIP")
  private String ownership;

  @Column(name="PAREMETER_ID")
  private String paremeterId;

  @Column(name="TERRITORY")
  private String territory;

  @Column(name="LANGUAGE_ID")
  private String languageId;

  @Column(name="CALENDER_TYPE")
  private String calenderType;

  @Column(name="MAIN_ACCOUNT_ID")
  private String mainAccountId;

  @Column(name="IS_MAIN")
  private String isMain;

  @Column(name="LOGO")
  private String logo;


  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "companyId",cascade = CascadeType.PERSIST)   //with cascade when save user the address information also saved
  private List<PersonEntity> personEntities= new ArrayList<>();




}
