package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@NamedEntityGraph(name = "contactApiUserGraph", attributeNodes = {
        @NamedAttributeNode("contactPublicId"),
        @NamedAttributeNode("contactId"),
        @NamedAttributeNode("createDateTs"),
        @NamedAttributeNode("editDateTs")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_CONTACT_API_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_CONTACT_API")
public class ContactApiEntity extends BaseEntity {

  @Column(name="CONTACT_PUBLIC_ID")
  private String contactPublicId;


  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CONTACT_ID")
  private ContactEntity contact;

  @Column(name="CONTACT_ID",insertable = false,updatable = false)
  private Long contactId;

  @Transient
  public Long getContactId() {
    return contactId;
  }

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATOR_ID")
  private PersonEntity creator;

  @CreatedDate
  @Column(name="CREATE_DATE_TS")
  private java.sql.Timestamp createDateTs;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EDITOR_ID")
  private PersonEntity editor;

  @LastModifiedDate
  @Column(name="EDIT_DATE_TS")
  private java.sql.Timestamp editDateTs;

  @Column(name = "CONTACT_EDIT_DATE")
  private String contactEditDate;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COMPANY_ID")
  private CompanyEntity company;

  @Column(name="COMPANY_PUBLIC_ID")
  private String companyPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ACCOUNT_ID")
  private AccountEntity account;

  @Column(name="ACCOUNT_PUBLIC_ID")
  private String accountPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORGANIZATION_ID")
  private OrganizationEntity organization;

  @Column(name="ORGANIZATION_PUBLIC_ID")
  private String organizationPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COUNTRY_ID")
  private ParameterEntity country;

  @Column(name="COUNTRY_PUBLIC_ID")
  private String countryPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "STATE_ID")
  private ParameterEntity state;

  @Column(name="STATE_PUBLIC_ID")
  private String statePublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CITY_ID")
  private ParameterEntity city;

  @Column(name="CITY_PUBLIC_ID")
  private String cityPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BIRTH_CITY_ID")
  private ParameterEntity birthCity;

  @Column(name="BIRTH_CITY_PUBLIC_ID")
  private String birthCityPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RELIGION_ID")
  private ParameterEntity religion;

  @Column(name="RELIGION_PUBLIC_ID")
  private String religionPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EDU_LEVEL_ID")
  private ParameterEntity eduLevel;

  @Column(name="EDU_LEVEL_PUBLIC_ID")
  private String eduLevelPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MILITARY_SERVICE_ID")
  private ParameterEntity militaryService;

  @Column(name="MILITARY_SERVICE_PUBLIC_ID")
  private String militaryServicePublicId;
}
