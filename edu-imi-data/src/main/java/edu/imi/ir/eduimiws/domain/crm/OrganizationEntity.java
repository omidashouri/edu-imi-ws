package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_ORGANIZATION_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_ORGANIZATION")
public class OrganizationEntity extends BaseEntity {


  @Column(name="NAME_LO")
  private String nameLo;

  @OneToOne(optional = true)
  @JoinColumn(name = "PARENT_ID")
  private OrganizationEntity parentId;

  @Column(name="WEBSITE")
  private String website;

  @Column(name="MAIN_PHONE")
  private String mainPhone;

  @Column(name="OTHER_PHONE")
  private String otherPhone;

  @Column(name="FAX")
  private String fax;

  @Column(name="EMAIL")
  private String email;

  @Column(name="BILL_ADDRESS")
  private String billAddress;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "BILL_CITY")
  private ParameterEntity billCity;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "BILL_STATE")
  private ParameterEntity billState;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "BILL_COUNTRY")
  private ParameterEntity billCountry;

  @Column(name="BILL_ZIPCODE")
  private String billZipcode;

  @Column(name="SHIP_ADDRESS")
  private String shipAddress;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "SHIP_CITY")
  private ParameterEntity shipCity;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "SHIP_STATE")
  private ParameterEntity shipState;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "SHIP_COUNTRY")
  private ParameterEntity shipCountry;

  @Column(name="SHIP_ZIPCODE")
  private String shipZipcode;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "ACCOUNT_ID")
  private AccountEntity accountId;

  @Column(name="IS_ACTIVE")
  private String isActive;

  @Column(name="EDIT_DATE")
  private String editDate;

}
