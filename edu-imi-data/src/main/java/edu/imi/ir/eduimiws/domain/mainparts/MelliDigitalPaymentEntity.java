package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;


@NamedNativeQueries({
        @NamedNativeQuery(name = "MelliDigitalPaymentEntity.selectOrderIdSequenceNumber",
                query = " select MAINPARTS.SEQ_MELLI_ORDER_ID.nextval from dual "
        )

})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_MELLI_DIGITAL_PAYMENT", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_MELLI_DIGITAL_PAYMENT")
public class MelliDigitalPaymentEntity extends BaseEntity {

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "LOCAL_DATE_TIME")
    private String localDateTime;

    @Column(name = "RETURN_URL")
    private String returnUrl;

    @Column(name = "SIGN_DATA")
    private String signData;

    @Column(name = "ADDITIONAL_DATA")
    private String additionalData;

    @Column(name = "MULTIPLEXING_DATA_ID")
    private String multiplexingDataId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "APPLICATION_NAME")
    private String applicationName;

    @Column(name = "PAN_AUTHENTICATION_TYPE")
    private String panAuthenticationType;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "CARD_HOLDER_IDENTITY")
    private String cardHolderIdentity;

    @Column(name = "RES_CODE")
    private String resCode;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "")
    private String description;

    @Column(name = "CREATOR_ID")
    private String creatorId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDate;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDate;
}