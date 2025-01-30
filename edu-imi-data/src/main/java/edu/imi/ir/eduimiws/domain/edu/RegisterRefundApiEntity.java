package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.mainparts.RefundEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_REGISTER_REFUND_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER_REFUND_API")
public class RegisterRefundApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "REGISTER_REFUND_ID")
    private RegisterRefundEntity registerRefund;

    @Column(name = "REGISTER_REFUND_PUBLIC_ID", length = 500)
    private String registerRefundPublicId;

    @Column(name = "DELETED_REGISTER_REFUND_ID")
    private Long deletedRegisterRefundId;

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
    @JoinColumn(name = "REFUND_ID")
    private RefundEntity refund;

    @Column(name = "REFUND_PUBLIC_ID", length = 500)
    private String refundPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;
}
