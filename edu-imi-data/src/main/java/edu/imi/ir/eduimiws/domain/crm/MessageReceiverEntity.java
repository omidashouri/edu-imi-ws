package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_MESSAGE_RECIEVER_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_MESSAGE_RECIEVER")
public class MessageReceiverEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID")
    private MessageEntity message;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private PersonEntity user;

    @Column(name = "USER_FOLDER_ID")
    private Long userFolderId;

    @Column(name = "IS_VIEWED", length = 1)
    private String isViewed;

    @Column(name = "MESSAGE_TYPE", length = 1)
    private String messageType;

    @Column(name = "IS_FORWARDED", length = 1)
    private String isForwarded;

    @Column(name = "IS_REPLIED", length = 1)
    private String isReplied;

    @Column(name = "RECEIVE_DATE", length = 100)
    private String receiveDate;

    @Column(name = "RECEIVE_TIME", length = 80)
    private String receiveTime;

    @Column(name = "RECEIVE_NUMBER", length = 50)
    private String receiveNumber;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "SEND_ID", length = 20)
    private String sendId;

    @Column(name = "RECEIVER", length = 100)
    private String receiver;

    @Column(name = "SECTION_ID")
    private Long sectionId;

    @Column(name = "SECTION_NAME", length = 20)
    private String sectionName;

    @Column(name = "SECTION_ID_NAME", length = 300)
    private String sectionIdName;

}
