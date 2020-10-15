package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_EVENT_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_EVENT")
public class EventEntity extends BaseEntity {

    @Column(name = "TITLE", length = 1000)
    private String title;

    //    TBL_MENU
    @Column(name = "MENU_ID")
    private Long menuId;
}
