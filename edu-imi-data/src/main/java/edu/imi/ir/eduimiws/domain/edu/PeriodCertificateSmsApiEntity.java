package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.MessageReceiverEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;


@NamedQueries(value = {
        @NamedQuery(name = "PeriodCertificateSmsApiEntity.queryByPeriodCertificateSmsApi",
                query = " select " +
                        " pcsa.id as pcsaId, " +
                        " concat(prs.firstName,' ',prs.lastName) as fullName, " +
                        " cnt.mobilePhone as phone, " +
                        " fld.fname as fieldName, " +
                        " prd.name as periodName, " +
                        " pcsa.periodCertificateActivityStatus as activityStatus, " +
                        " pcsa.periodCertificateDeliveryDate as deliveryDate, " +
                        " pcsa.registerFinancialStatus as financialStatus, " +
                        " pcsa.registerFinalStatus as finalStatus, " +
                        " pcsa.registerType as registerType " +
                        " from PeriodCertificateSmsApiEntity pcsa " +
                        " left join pcsa.register reg " +
                        " left join reg.student std " +
                        " left join std.person prs " +
                        " left join prs.contact cnt " +
                        " left join pcsa.register regp " +
                        " left join regp.period prd " +
                        " left join prd.field fld " +
                        " where " +
                        " :periodCertificateActivityStatus is null or pcsa.periodCertificateActivityStatus=:periodCertificateActivityStatus AND " +
                        " :registerFinalStatus is null or pcsa.registerFinalStatus like concat('%',:registerFinalStatus,'%') AND " +
                        " reg.registerType like concat('%',:registerType,'%') AND " +
                        " :registerFinancialStatus is null or pcsa.registerFinancialStatus=:registerFinancialStatus AND " +
                        " pcsa.periodCertificateDeliveryDate is null "
        )
})



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_CERTIFICATE_SMS_API_ID", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_CERTIFICATE_SMS_API")
public class PeriodCertificateSmsApiEntity extends BaseEntity {

    @Column(name = "PUBLIC_ID", length = 500)
    private String publicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_CERTIFICATE_ID")
    private PeriodCertificateEntity periodCertificate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_RECIEVER_ID")
    private MessageReceiverEntity messageReceiver;

    @Column(name = "SMS_TEXT")
    private String smsText;

    @Column(name = "SMS_STATUS")
    private Long smsStatus;

    @Column(name = "SMS_COUNTER")
    private Long smsCounter;

    @Column(name = "SMS_DATE")
    private String smsDate;

    @Column(name = "P_C_ACTIVITY_STATUS")
    private Long periodCertificateActivityStatus;

    @Column(name = "REGISTER_FINAL_STATUS")
    private String registerFinalStatus;

    @Column(name = "REGISTER_FINANCIAL_STATUS")
    private Long registerFinancialStatus;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "P_C_DELIVERY_DATE")
    private String periodCertificateDeliveryDate;

    @Column(name = "REGISTER_REGISTER_TYPE")
    private String registerType;

}


