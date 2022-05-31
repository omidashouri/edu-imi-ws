package edu.imi.ir.eduimiws.models.dto.crm;



import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageReceiverDto implements Serializable {

    private static final long serialVersionUID = 9202922836021301698L;

    private Long id;

    private Long messageId;
    private MessageDto messageDto;
    private String messagePublicId;

    private Long userId;
    private PersonDto userDto;
    private String userPublicId;

    private Long userFolderId;

    private String isViewed;

    private String messageType;

    private String isForwarded;

    private String isReplied;

    private String receiveDate;

    private String receiveTime;

    private String receiveNumber;

    private String status;

    private String sendId;

    private String receiver;

    private Long sectionId;

    private String sectionName;

    private String sectionIdName;
}
