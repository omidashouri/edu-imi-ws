package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageApiDto implements Serializable {

    private static final long serialVersionUID = -6014502147883589290L;

    private Long id;

    private Long messageId;
    private MessageDto messageDto;
    private String messagePublicId;

    private Long userCreatorId;
    private PersonDto userCreatorDto;
    private String userCreatorPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private String description;

    private Long deleteMessageId;

}
