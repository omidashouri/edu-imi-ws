package edu.imi.ir.eduimiws.models.dto.crm;


import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageReceiverApiDto implements Serializable {

    private static final long serialVersionUID = -3439748306645421857L;

    private Long id;

    private Long messageReceiverId;
    private MessageReceiverDto messageReceiverDto;
    private String messageReceiverPublicId;


    private Long userId;
    private PersonDto userDto;
    private String userPublicId;

    private Long messageId;
    private MessageDto messageDto;
    private String messagePublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private String description;

    private Long deleteMessageReceiverId;

}
