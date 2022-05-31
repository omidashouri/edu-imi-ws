package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.MessageReceiverEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.MessageReceiverMapper;
import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverDto;
import edu.imi.ir.eduimiws.repositories.crm.MessageReceiverRepository;
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
public class MessageReceiverServiceImpl implements MessageReceiverService {

    private final MessageReceiverRepository messageReceiverRepository;
    private final MessageReceiverMapper messageReceiverMapper;

    @Override
    public List<MessageReceiverDto> saveAll(List<MessageReceiverDto> messageReceiverDtos) {

        List<MessageReceiverEntity> newMessageReceivers = messageReceiverMapper
                .toMessageReceiverEntities(messageReceiverDtos, new CycleAvoidingMappingContext());

        Iterable<MessageReceiverEntity> savedMessageReceiversIterable = messageReceiverRepository
                .saveAll(newMessageReceivers);

        List<MessageReceiverEntity> savedMessageReceivers = StreamSupport
                .stream(savedMessageReceiversIterable.spliterator(), false)
                .collect(Collectors.toList());

        return messageReceiverMapper.toMessageReceiverDtos(savedMessageReceivers, new CycleAvoidingMappingContext());
    }

    @Override
    public MessageReceiverDto save(MessageReceiverDto messageReceiverDto) {
        MessageReceiverEntity newMessageReceiver = messageReceiverMapper.toMessageReceiverEntity(messageReceiverDto,
                new CycleAvoidingMappingContext());
        MessageReceiverEntity savedMessageReceiver = messageReceiverRepository.save(newMessageReceiver);
        return messageReceiverMapper.toMessageReceiverDto(savedMessageReceiver, new CycleAvoidingMappingContext());
    }
}
