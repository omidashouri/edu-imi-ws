package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import jakarta.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_MESSAGE_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_MESSAGE")
public class MessageEntity  extends BaseEntity {


    @Column(name="SUBJECT",length = 300)
    private String subject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_CREATOR_ID")
    private PersonEntity userCreator;

    @Column(name="SENDER_NAME",length = 200)
    private String senderName;

    @Column(name="SENDER_EMAIL",length = 100)
    private String senderEmail;

    @Column(name="SEND_DATE",length = 100)
    private String sendDate;

    @Column(name="SEND_TIME",length = 80)
    private String sendTime;

    @Column(name="SEND_SMS",length = 1)
    private String sendSms;

    @Column(name="SEND_EMAIL",length = 1)
    private String sendEmail;

    @Column(name="SEND_TEXT_MESSAGE",length = 1)
    private String sendTextMessage;

    @Column(name="SEND_FAX",length = 1)
    private String sendFax;

    @Column(name="SEND_IM",length = 1)
    private String sendIm;

    @Column(name="TO_IM",length = 4000)
    private String toIm;

    @Lob
    @Column(name = "MESSAGE_TEXT")
    private String messageText;

    @Column(name="MESSAGE_SIZE")
    private String messageSize;

    @Column(name="EMAIL_ACCOUNT",length = 200)
    private String emailAccount;

    @Column(name="STATUS",length = 20)
    private String status;

    @Column(name="SECTION_NAME",length = 20)
    private String sectionName;

    @Column(name="SECTION_ID")
    private String sectionId;

    @Column(name="SECTION_ID_NAME",length = 400)
    private String sectionIdName;

    @Column(name="MESSAGE_TYPE",length = 1)
    private String messageType;

    @Column(name="IS_FORWARDED",length = 1)
    private String isForwarded;

    @Column(name="IS_REPLIED",length = 1)
    private String isReplied;

    @Lob
    @Column(name = "TO_SMS")
    private String toSms;

    @Lob
    @Column(name = "TO_EMAIL")
    private String toEmail;

    @Lob
    @Column(name = "TO_EMAIL_CC")
    private String toEmailCc;

    @Lob
    @Column(name = "TO_EMAIL_BCC")
    private String toEmailBcc;

    @Lob
    @Column(name = "TO_FAX")
    private String toFax;


}
