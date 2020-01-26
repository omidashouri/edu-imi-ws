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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_CONTACT_WEB_SERVICE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_CONTACT_WEB_SERVICE")
public class ContactWebServiceEntity extends BaseEntity {

  @Column(name="CONTACT_PUBLIC_ID")
  private String contactPublicId;


  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CONTACT_ID")
  private ContactEntity contactId;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CREATOR_ID")
  private PersonEntity creatorId;

  @Column(name="CREATE_DATE_TS")
  private java.sql.Timestamp createDateTs;

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EDITOR_ID")
  private PersonEntity editorId;

  @Column(name="EDIT_DATE_TS")
  private java.sql.Timestamp editDateTs;

}
