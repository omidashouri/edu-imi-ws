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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_WEB_SERVICE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON_WEB_SERVICE")
public class PersonWebServiceEntity extends BaseEntity {


  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne
  @JoinColumn(name = "PERSON_ID")
  private PersonEntity personId;

  @Column(name="PERSON_PUBLIC_ID")
  private String personPublicId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne
  @JoinColumn(name = "CONTACT_ID")
  private ContactEntity contactId;

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
  @ManyToOne
  @JoinColumn(name = "CREATOR_ID")
  private PersonEntity creatorId;

  @Column(name="CREATE_DATE_TS")
  private java.sql.Timestamp createDateTs;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "EDITOR_ID")
  private PersonEntity editorId;

  @Column(name="EDIT_DATE_TS")
  private java.sql.Timestamp editDateTs;

  @Column(name="DESCRIPTION")
  private String description;

}
