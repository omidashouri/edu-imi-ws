package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_ROLE_PRIVILEGE_API", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_ROLE_PRIVILEGE_API")
public class RolePrivilegeApiEntity extends BaseEntity {

    @Column(name = "ROLE_API_ID")
    private Long roleApiId;

    @Column(name = "PRIVILEGE_API_ID")
    private Long privilegeApiId;

}
