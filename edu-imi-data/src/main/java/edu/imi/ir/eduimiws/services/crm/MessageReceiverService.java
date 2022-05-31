package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverDto;

import java.util.List;

public interface MessageReceiverService {

    List<MessageReceiverDto> saveAll(List<MessageReceiverDto> messageReceiverDtos);

    MessageReceiverDto save(MessageReceiverDto messageReceiverDto);
}
