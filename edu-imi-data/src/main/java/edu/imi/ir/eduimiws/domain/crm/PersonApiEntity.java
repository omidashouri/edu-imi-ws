package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonApiIdProjection;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;


// add role_ID column

@NamedEntityGraphs({
        @NamedEntityGraph(name = "PersonApiEntity.personWebServiceFastGraph", attributeNodes = {
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
        }),
        @NamedEntityGraph(name = "PersonApiEntity.findPersonApiWithPersonRolePrivilegeSubGraph",
                attributeNodes = {
                        @NamedAttributeNode(value = "person"),
                        @NamedAttributeNode(value = "roles",subgraph = "role-subGraph")
                },
                subgraphs = {
                        @NamedSubgraph(name = "role-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "privileges")
                                }
                        )
                }
        )

})
@SqlResultSetMappings(
  @SqlResultSetMapping(
    name = "personWebServiceIdProjection",
    classes = {
      @ConstructorResult(
        targetClass = PersonApiIdProjection.class,
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

  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
  @Fetch(value = FetchMode.SUBSELECT)
  @JoinTable(schema = "CRM",
          name = "TBL_PERSON_ROLE_API",
  joinColumns=
      @JoinColumn(name = "PERSON_API_ID",referencedColumnName = "ID"),
  inverseJoinColumns =
      @JoinColumn(name = "ROLE_API_ID",referencedColumnName = "ID"))
  private Collection<RoleApiEntity> roles;

  @Column(name = "PERSON_EDIT_DATE",length = 10)
  private String personEditDate;

  @Column(name = "CONTACT_EDIT_DATE",length = 10)
  private String contactEditDate;

  @Column(name = "ACCOUNT_ENABLED")
  private Long accountEnabled;

  @Column(name = "ACCOUNT_NON_EXPIRED")
  private Long accountNonExpired;

  @Column(name = "CREDENTIALS_NON_EXPIRED")
  private Long CredentialsNonExpired;

  @Column(name = "ACCOUNT_NON_LOCKED")
  private Long AccountNonLocked;

}
