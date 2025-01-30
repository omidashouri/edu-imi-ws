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
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_MELLI_DIGITAL_PAYMENT_DATA", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_MELLI_DIGITAL_PAYMENT_DATA")
public class MelliDigitalPaymentDataEntity extends BaseEntity {


    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "HASHED_CARD_NUMBER")
    private String hashedCardNumber;

    @Column(name = "PRIMARY_ACC_NO")
    private String primaryAccNo;

    @Column(name = "SWITCH_RES_CODE")
    private String switchResCode;

    @Column(name = "RES_CODE")
    private Long resCode;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "REQUEST_VERIFICATION_TOKEN")
    private String requestVerificationToken;

    @Column(name = "IS_WALLET_PAYMENT")
    private String isWalletPayment;

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
