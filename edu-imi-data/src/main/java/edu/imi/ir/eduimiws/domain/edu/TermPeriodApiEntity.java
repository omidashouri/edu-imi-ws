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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_TERM_PERIOD_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_TERM_PERIOD_API")
public class TermPeriodApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "TERM_PERIOD_ID")
    private TermPeriodEntity termPeriod;

    @Column(name = "TERM_PERIOD_PUBLIC_ID")
    private String termPeriodPublicId;

    @Column(name = "DELETED_TERM_PERIOD_ID")
    private Long deletedTermPeriodId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_ID")
    private TermEntity term;

    @Column(name = "TERM_PUBLIC_ID", length = 500)
    private String termPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @Column(name = "PERIOD_PUBLIC_ID", length = 500)
    private String periodPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
