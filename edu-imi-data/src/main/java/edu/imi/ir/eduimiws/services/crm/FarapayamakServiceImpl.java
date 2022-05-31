package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.mapper.crm.*;
import edu.imi.ir.eduimiws.models.dto.crm.*;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FarapayamakServiceImpl implements FarapayamakService {

    private final FarapayamakCredential farapayamakCredential;
    private final RestTemplate restTemplate;
    private final MessageService messageService;
    private final MessageReceiverService messageReceiverService;
    private final FarapayamakSendSmsDtoFarapayamakDtoMapper farapayamakSendSmsDtoFarapayamakDtoMapper;
    private final FarapayamakReturnedSendSmsDtoFarapayamakDtoMapper farapayamakReturnedSendSmsDtoFarapayamakDtoMapper;
    private final FarapayamakDtoMessageDtoMapper farapayamakDtoMessageDtoMapper;
    private final MessageMapper messageMapper;
    private final MessageReceiverMapper messageReceiverMapper;
    private final FarapayamakServiceAsync farapayamakServiceAsync;

    @Override
    public FarapayamakCredential getFarapayamakCredential() {
        return farapayamakCredential;
    }

    @Override
    public FarapayamakReturnedSendSmsDto sendSMS(FarapayamakSendSmsDto farapayamakSendSmsDto) {

        String completeFinancialUri = String.format(farapayamakCredential.getSendSmsUrl());

        ResponseEntity<FarapayamakReturnedSendSmsDto> hamkaranFinancialResponseEntity =
                restTemplate.exchange(completeFinancialUri,
                        HttpMethod.POST, this.requestHttpEntity(farapayamakSendSmsDto),
                        FarapayamakReturnedSendSmsDto.class);

        FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = hamkaranFinancialResponseEntity.getBody();

        FarapayamakDto farapayamakDto = farapayamakSendSmsDtoFarapayamakDtoMapper
                .farapayamakSendSmsDtoToFarapayamakDto(farapayamakSendSmsDto);

        farapayamakReturnedSendSmsDtoFarapayamakDtoMapper
                .updateFarapayamakDtoByFarapayamakReturnedSendSmsDto(farapayamakReturnedSendSmsDto, farapayamakDto);

        MessageDto messageDto = farapayamakDtoMessageDtoMapper
                .farapayamakDtoToMessageDto(farapayamakDto);

        if (Objects.nonNull(messageDto.getToSmses()) && messageDto.getToSmses().size() > 1) {
            List<MessageDto> messageDtos = messageMapper.generateMessageDtosForToSmses(messageDto);
            List<MessageDto> savedMessageDtos = messageService.saveAllMessages(messageDtos);
            List<MessageReceiverDto> newMessageReceiverDtos =
                    messageReceiverMapper.messageReceiverDtosByMessageDtosBeForeSaveSms(savedMessageDtos);
            messageReceiverService.saveAll(newMessageReceiverDtos);
        }else{
            MessageDto savedMessageDto =  messageService.saveMessage(messageDto);
            MessageReceiverDto newMessageReceiverDto =  messageReceiverMapper.
                    messageReceiverDtoByMessageDtoBeforeSaveSms(savedMessageDto);
            messageReceiverService.save(newMessageReceiverDto);
        }

        return farapayamakReturnedSendSmsDto;
    }

/*    @Override
    public List<FarapayamakReturnedSendSmsDto> sendSmsAsync(SendSmsRequestForFarapayamak sendSmsRequestForFarapayamak) {
        return farapayamakServiceAsync.sendSmsBySendSmsRequestForFarapayamak(sendSmsRequestForFarapayamak);
    }*/

    protected HttpEntity<?> requestHttpEntity(FarapayamakSendSmsDto farapayamakSendSmsDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<?> requestHttpEntity = new HttpEntity<>(farapayamakSendSmsDto, headers);
        return requestHttpEntity;
    }
}
