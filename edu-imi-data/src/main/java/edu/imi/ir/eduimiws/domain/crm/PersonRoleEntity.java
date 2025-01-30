package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PERSON_ROLE_API",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PERSON_ROLE_API")
public class PersonRoleEntity extends BaseEntity {
}
