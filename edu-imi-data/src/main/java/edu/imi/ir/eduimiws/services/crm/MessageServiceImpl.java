package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.MessageEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.MessageMapper;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.repositories.crm.MessageRepository;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final SecurityUtil securityUtil;

    @Override
    public List<MessageDto> saveAllMessages(List<MessageDto> messageDtos) {
        List<MessageEntity> newMessages = messageMapper
                .toMessageEntities(messageDtos, new CycleAvoidingMappingContext());

        newMessages.forEach(newMessage->{
            newMessage.setUserCreator(securityUtil.getPersonEntityFromSecurityContext());
        });

        Iterable<MessageEntity> messageIterable =  messageRepository.saveAll(newMessages);

        List<MessageEntity> savedMessages = StreamSupport
                .stream(messageIterable.spliterator(), false)
                .collect(Collectors.toList());

        return messageMapper.toMessageDtos(savedMessages, new CycleAvoidingMappingContext());

    }

    @Override
    public MessageDto saveMessage(MessageDto messageDto) {
        MessageEntity newMessage = messageMapper.toMessageEntity(messageDto, new CycleAvoidingMappingContext());
        newMessage.setUserCreator(securityUtil.getPersonEntityFromSecurityContext());
        MessageEntity savedMessage = messageRepository.save(newMessage);
        MessageDto savedMessageDto = messageMapper.toMessageDto(savedMessage, new CycleAvoidingMappingContext());
        return savedMessageDto;
    }

    @Override
    public MessageDto saveMessageAsync(MessageDto messageDto) {
        MessageEntity newMessage = messageMapper.toMessageEntity(messageDto, new CycleAvoidingMappingContext());
        MessageEntity savedMessage = messageRepository.save(newMessage);
        MessageDto savedMessageDto = messageMapper.toMessageDto(savedMessage, new CycleAvoidingMappingContext());
        return savedMessageDto;
    }

}
