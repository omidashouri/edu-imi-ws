package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@NamedEntityGraph(name = "contactWebServiceUserGraph", attributeNodes = {
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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_CONTACT_WEB_SERVICE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_CONTACT_WEB_SERVICE")
public class ContactWebServiceEntity extends BaseEntity {

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

}
