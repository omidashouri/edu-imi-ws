package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_LANGUAGE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_LANGUAGE")
public class LanguageEntity extends BaseEntity {


  @Column(name="NAME_EN")
  private String nameEn;

  @Column(name="NAME_LO")
  private String nameLo;

  @Column(name="DIRECTION")
  private String direction;

  @Column(name="FLAG_NEW_NAME")
  private String flagNewName;

  @Column(name="FLAG_OLD_NAME")
  private String flagOldName;

  @Column(name="ENCODING")
  private String encoding;

/*  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "selectedLanguage",cascade = CascadeType.PERSIST)
  private List<PersonEntity> personEntities= new ArrayList<>();*/


}
