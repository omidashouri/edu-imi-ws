package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_EVENT_RAISE_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_EVENT_RAISE_API")
public class EventRaiseApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "EVENT_RAISE_ID")
    private EventRaiseEntity eventRaise;

    @Column(name = "EVENT_RAISE_PUBLIC_ID", length = 500)
    private String eventRaisePublicId;

    @Column(name = "DELETED_EVENT_RAISE_ID")
    private Long deletedEventRaiseId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private EventEntity event;

    @Column(name = "EVENT_PUBLIC_ID", length = 500)
    private String eventPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
