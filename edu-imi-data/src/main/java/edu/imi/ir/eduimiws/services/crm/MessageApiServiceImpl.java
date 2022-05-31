package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.MessageApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.MessageApiMapper;
import edu.imi.ir.eduimiws.models.dto.crm.MessageApiDto;
import edu.imi.ir.eduimiws.repositories.crm.MessageApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MessageApiServiceImpl implements MessageApiService{

    private final MessageApiRepository messageApiRepository;
    private final MessageApiMapper messageApiMapper;

    @Override
    public MessageApiEntity findEntityByMessageId(Long messageId) {
        return messageApiRepository.findByMessageId(messageId);
    }

    @Override
    public MessageApiDto findDtoByMessageId(Long messageId) {
        MessageApiEntity messageApi = this.findEntityByMessageId(messageId);
        return messageApiMapper.toMessageApiDto(messageApi, new CycleAvoidingMappingContext());

    }

    @Override
    public String findMessageApiPublicIdByMessageId(Long messageId) {
        return this.findEntityByMessageId(messageId).getMessagePublicId();
    }
}
