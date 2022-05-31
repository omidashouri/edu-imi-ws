package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto implements Serializable {

    private static final long serialVersionUID = -732749881693611269L;

    private Long id;
    private String messagePublicId;

    private String subject;

    private Long userCreatorId;
    private PersonDto userCreatorDto;
    private String userCreatorPublicId;

    private String senderName;

    private String senderEmail;

    private String sendDate;

    private String sendTime;

    private String sendSms;

    private String sendEmail;

    private String sendTextMessage;

    private String sendFax;

    private String sendIm;

    private String toIm;

    private String messageText;

    private String messageSize;

    private String emailAccount;

    private String status;

    private List<String> statuses;

    private String sectionName;

    private String sectionId;

    private String sectionIdName;

    private String messageType;

    private String isForwarded;

    private String isReplied;

    private String toSms;

    private List<String> toSmses;

    private String toEmail;

    private String toEmailCc;

    private String toEmailBcc;

    private String toFax;
}
