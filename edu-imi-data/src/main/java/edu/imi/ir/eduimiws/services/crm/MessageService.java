package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;

import java.util.List;

public interface MessageService {

    List<MessageDto> saveAllMessages(List<MessageDto> messageDtos);

    MessageDto saveMessage(MessageDto messageDto);

    MessageDto saveMessageAsync(MessageDto messageDto);

}
