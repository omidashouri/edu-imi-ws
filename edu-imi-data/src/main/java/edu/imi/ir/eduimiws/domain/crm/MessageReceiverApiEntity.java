package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_MESSAGE_RECIEVER_API",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_MESSAGE_RECIEVER_API")
public class MessageReceiverApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_RECIEVER_ID")
    private MessageReceiverEntity messageReceiver;

    @Column(name = "MESSAGE_RECIEVER_PUBLIC_ID", length = 500)
    private String messageReceiverPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private PersonEntity user;

    @Column(name = "USER_PUBLIC_ID", length = 500)
    private String userPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_ID")
    private MessageEntity message;

    @Column(name = "MESSAGE_PUBLIC_ID", length = 500)
    private String messagePublicId;

    @Column(name="CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name="DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name="DESCRIPTION", length = 500)
    private String description;

    @Column(name="DELETE_MESSAGE_RECIEVER_ID")
    private Long deleteMessageReceiverId;

}
