package edu.imi.ir.eduimiws.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @OneToMany(mappedBy = "selectedLanguage",cascade = CascadeType.PERSIST)   //with cascade when save user the address information also saved
  private List<PersonEntity> personEntities= new ArrayList<>();


}
