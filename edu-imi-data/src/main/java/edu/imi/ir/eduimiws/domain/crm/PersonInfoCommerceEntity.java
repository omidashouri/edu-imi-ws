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
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_INFO_COMMERCE",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON_INFO_COMMERCE")
public class PersonInfoCommerceEntity extends BaseEntity {

  @Column(name="FILTER_REQUESTER")
  private String filterRequester;

  @Column(name="FILTER_PLACE")
  private String filterPlace;

  @Column(name="FILTER_CITY")
  private String filterCity;

  @Column(name="FILTER_REQUNIT")
  private String filterRequnit;

}
