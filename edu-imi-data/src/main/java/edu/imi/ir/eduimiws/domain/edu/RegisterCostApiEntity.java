package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_REGISTER_COST_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER_COST_API")
public class RegisterCostApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "REGISTER_COST_ID")
    private RegisterCostEntity registerCost;

    @Column(name = "DELETED_REGISTER_COST_ID")
    private Long deletedRegisterCostId;

    @Column(name = "REGISTER_COST_PUBLIC_ID", length = 500)
    private String registerCostPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "REGISTER_PUBLIC_ID", length = 500)
    private String registerPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_TERM_ID")
    private TermPeriodEntity termPeriodEntity;

    @Column(name = "PERIOD_TERM_PUBLIC_ID", length = 500)
    private String periodTermPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
