package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;


@NamedEntityGraph(name = "personWebServiceFastGraph", attributeNodes = {
        @NamedAttributeNode("personId"),
        @NamedAttributeNode("personPublicId"),
        @NamedAttributeNode("contactId"),
        @NamedAttributeNode("contactPublicId"),
        @NamedAttributeNode("userName"),
        @NamedAttributeNode("encryptedPassword"),
        @NamedAttributeNode("emailVerificationToken"),
        @NamedAttributeNode("emailVerificationStatus"),
        @NamedAttributeNode("mobileVerificationStatus"),
        @NamedAttributeNode("creatorId"),
        @NamedAttributeNode("createDateTs"),
        @NamedAttributeNode("editorId"),
        @NamedAttributeNode("editDateTs"),
        @NamedAttributeNode("description")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_WEB_SERVICE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON_WEB_SERVICE")
public class PersonWebServiceEntity extends BaseEntity {


  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne
  @JoinColumn(name = "PERSON_ID")
  private PersonEntity person;

  @Column(name="PERSON_ID",insertable = false,updatable = false)
  private Long personId;

  @Transient
  public Long getPersonId() {
    return personId;
  }

  @Column(name="PERSON_PUBLIC_ID")
  private String personPublicId;

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

  @Column(name="CONTACT_PUBLIC_ID")
  private String contactPublicId;

  @Column(name = "USERNAME")
  private String userName;

  @Column(name="ENCRYPTED_PASSWORD")
  private String encryptedPassword;

  @Column(name="EMAIL_VERIFICATION_TOKEN")
  private String emailVerificationToken;

  @Column(name="EMAIL_VERIFICATION_STATUS")
  private Boolean emailVerificationStatus;

  @Column(name="MOBILE_VERIFICATION_STATUS")
  private Boolean mobileVerificationStatus;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATOR_ID")
  private PersonEntity creator;

  @Column(name="CREATOR_ID",insertable = false,updatable = false)
  private Long creatorId;

  @Transient
  public Long getCreatorId() {
    return creatorId;
  }

  @Column(name="CREATE_DATE_TS")
  private java.sql.Timestamp createDateTs;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EDITOR_ID")
  private PersonEntity editor;

  @Column(name="EDITOR_ID",insertable = false,updatable = false)
  private Long editorId;

  @Transient
  public Long getEditorId() {
    return editorId;
  }

  @Column(name="EDIT_DATE_TS")
  private java.sql.Timestamp editDateTs;

  @Column(name="DESCRIPTION")
  private String description;

}
