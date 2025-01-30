package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_MELLI_DIGITAL_VERIFY", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_MELLI_DIGITAL_VERIFY")
public class MelliVerifyEntity extends BaseEntity {


    @Column(name = "PUBLIC_ID")
    public String publicId;

    @Column(name = "SUCCEED")
    public Long succeed;

    @Column(name = "RES_CODE")
    public Long resCode;

    @Column(name = "DESCRIPTION")
    public String description;

    @Column(name = "AMOUNT")
    public Long amount;

    @Column(name = "RETRIVAL_REF_NO")
    public String retrivalRefNo;

    @Column(name = "SYSTEM_TRACE_NO")
    public String systemTraceNo;

    @Column(name = "ORDER_ID")
    public Long orderId;

    @Column(name = "CREATOR_ID")
    private Long creatorId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "M_DIGITAL_PAYMENT_ID")
    private Long melliDigitalPaymentId;

    @Column(name = "M_DIGITAL_PAYMENT_PUBLIC_ID")
    private String melliDigitalPaymentPublicId;
}
