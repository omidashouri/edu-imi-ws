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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_CONTRACT_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_CONTRACT_API")
public class PeriodContractApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "PERIOD_CONTRACT_ID")
    private PeriodContractEntity periodContract;

    @Column(name = "DELETED_PERIOD_CONTRACT_ID")
    private Long deletedPeriodContractId;

    @Column(name = "PERIOD_CONTRACT_PUBLIC_ID", length = 500)
    private String periodContractPublicId;

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
