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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PARAMETER_CAPTION_ID",allocationSize = 1)
@Table(schema = "CRM",name="TBL_PARAMETER_CAPTION")
public class ParameterCaptionEntity extends BaseEntity {

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "PARAMETER_ID")
  private ParameterEntity parameterId;

  @Column(name="CAPTION",length=130)
  private String caption;

//  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "LANGUAGE_ID")
  private LanguageEntity languageId;

}
