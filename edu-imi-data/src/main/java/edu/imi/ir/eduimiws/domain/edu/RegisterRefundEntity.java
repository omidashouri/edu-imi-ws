package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.mainparts.RefundEntity;
import lombok.*;

import jakarta.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_REGISTER_REFUND", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER_REFUND")
public class RegisterRefundEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "RETURN_FEE")
    private Long returnFee;

    @Column(name = "RETURN_PERCENT")
    private Long returnPercent;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "PAYMENT_STATUS", precision = 5, scale = 0)
    private Long paymentStatus;

    @Column(name = "REDUCE_FEE")
    private Long reduceFee;

    @Column(name = "REDUCE_PERCENT")
    private Long reducePercent;

    @Column(name = "CANCEL_DATE", length = 10)
    private String cancelDate;

    @Column(name = "CANCEL_TYPE", length = 10)
    private String cancelType;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFUND_ID")
    private RefundEntity refund;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "registerRefund", fetch = FetchType.LAZY)
    private RegisterRefundApiEntity registerRefundApi;
}
