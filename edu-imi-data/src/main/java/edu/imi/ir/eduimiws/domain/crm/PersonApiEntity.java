package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonWebServiceIdProjection;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


// add role_ID column

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
  @NamedAttributeNode("description")
})
@SqlResultSetMappings(
  @SqlResultSetMapping(
    name = "personWebServiceIdProjection",
    classes = {
      @ConstructorResult(
        targetClass = PersonWebServiceIdProjection.class,
        columns = {
          @ColumnResult(name = "idR", type = Long.class),
          @ColumnResult(name = "personIdR", type = Long.class),
          @ColumnResult(name = "contactIdR", type = Long.class)
        }
      )
    }
  )
)
@NamedNativeQueries({
  @NamedNativeQuery(name = "PersonApiEntity.findAllPersonWebServiceIdProjection",
          query = " select pws.ID as idR, pws.CONTACT_ID as personIdR, pws.CONTACT_ID as contactIdR " +
                  " from CRM.TBL_PERSON_WEB_SERVICE pws ",
          resultSetMapping = "personWebServiceIdProjection"
  )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_WEB_SERVICE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON_WEB_SERVICE")
public class PersonApiEntity extends BaseEntity {


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

  @Column(name="PERSON_PUBLIC_ID",length = 500)
  private String personPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne
  @JoinColumn(name = "CONTACT_ID")
  private ContactEntity contact;

  @Column(name="CONTACT_ID",insertable = false,updatable = false)
  private Long contactId;

  @Transient
  public Long getContactId() {
    return contactId;
  }

  @Column(name="CONTACT_PUBLIC_ID",length = 500)
  private String contactPublicId;

  @Column(name = "USERNAME",length = 500)
  private String userName;

  @Column(name="ENCRYPTED_PASSWORD",length = 500)
  private String encryptedPassword;

  @Column(name="EMAIL_VERIFICATION_TOKEN",length = 500)
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

  @CreatedDate
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

  @LastModifiedDate
  @Column(name="EDIT_DATE_TS")
  private java.sql.Timestamp editDateTs;

  @Column(name="DESCRIPTION",length = 500)
  private String description;

  @Column(name = "AUTHORITY_ID")
  private Long authorityId;

  @Column(name = "PERSON_EDIT_DATE",length = 10)
  private String personEditDate;

  @Column(name = "CONTACT_EDIT_DATE",length = 10)
  private String contactEditDate;

}
