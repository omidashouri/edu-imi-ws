package edu.imi.ir.eduimiws.domain.mainparts;

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
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_REFUND_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_REFUND_API")
public class RefundApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "REFUND_ID")
    private RefundEntity refund;

    @Column(name = "REFUND_PUBLIC_ID", length = 500)
    private String refundPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETED_REFUND_ID")
    private Long deletedRefundId;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
