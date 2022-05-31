package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.mapper.crm.*;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeApiDtoFarapayamakSendSmsDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.*;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class FarapayamakServiceAsync {

    private final FarapayamakCredential farapayamakCredential;
    private final RestTemplate restTemplate;
    private final MessageService messageService;
    private final MessageReceiverService messageReceiverService;
    private final FarapayamakSendSmsDtoFarapayamakDtoMapper farapayamakSendSmsDtoFarapayamakDtoMapper;
    private final FarapayamakReturnedSendSmsDtoFarapayamakDtoMapper farapayamakReturnedSendSmsDtoFarapayamakDtoMapper;
    private final FarapayamakDtoMessageDtoMapper farapayamakDtoMessageDtoMapper;
    private final MessageMapper messageMapper;
    private final MessageReceiverMapper messageReceiverMapper;
    private final CommonUtils commonUtils;
    private final PaymentCodeApiDtoFarapayamakSendSmsDtoMapper paymentCodeApiDtoFarapayamakSendSmsDtoMapper;


    @Async("asyncExecutor")
    public List<FarapayamakReturnedSendSmsDto> sendSMS(FarapayamakSendSmsDto farapayamakSendSmsDto) {

        Collection<List<String>> collectionList = commonUtils
                .partitionBasedOnSize(Arrays.asList(farapayamakSendSmsDto.getTo()), 99);

        List<List<String>> listList = commonUtils.convertCollectionListToListList(collectionList);

        List<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDtos = new ArrayList<>();

        listList.forEach(list -> {

            paymentCodeApiDtoFarapayamakSendSmsDtoMapper.updateToByListNumbers(list, farapayamakSendSmsDto);

            String completeFinancialUri = String.format(farapayamakCredential.getSendSmsUrl());

            ResponseEntity<FarapayamakReturnedSendSmsDto> hamkaranFinancialResponseEntity =
                    restTemplate.exchange(completeFinancialUri,
                            HttpMethod.POST, this.requestHttpEntity(farapayamakSendSmsDto),
                            FarapayamakReturnedSendSmsDto.class);

            FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = hamkaranFinancialResponseEntity.getBody();

            FarapayamakDto farapayamakDto = farapayamakSendSmsDtoFarapayamakDtoMapper
                    .farapayamakSendSmsDtoToFarapayamakDto(farapayamakSendSmsDto);

            //        add creator and creator full name
            farapayamakSendSmsDtoFarapayamakDtoMapper
                    .updateFarapayamakDtoByFarapayamakSendSmsDtoAsync(farapayamakSendSmsDto, farapayamakDto);

            farapayamakReturnedSendSmsDtoFarapayamakDtoMapper
                    .updateFarapayamakDtoByFarapayamakReturnedSendSmsDto(farapayamakReturnedSendSmsDto, farapayamakDto);

            //      do not get creator and creator full name from context
            MessageDto messageDto = farapayamakDtoMessageDtoMapper
                    .farapayamakDtoToMessageDtoAsync(farapayamakDto);

            if (Objects.nonNull(messageDto.getToSmses()) && messageDto.getToSmses().size() > 1) {
                List<MessageDto> messageDtos = messageMapper.generateMessageDtosForToSmses(messageDto);
                List<MessageDto> savedMessageDtos = messageService.saveAllMessages(messageDtos);
                List<MessageReceiverDto> newMessageReceiverDtos =
                        messageReceiverMapper.messageReceiverDtosByMessageDtosBeForeSaveSms(savedMessageDtos);
                messageReceiverService.saveAll(newMessageReceiverDtos);
            } else {
                MessageDto savedMessageDto = messageService.saveMessageAsync(messageDto);
                MessageReceiverDto newMessageReceiverDto = messageReceiverMapper.
                        messageReceiverDtoByMessageDtoBeforeSaveSms(savedMessageDto);
                messageReceiverService.save(newMessageReceiverDto);
            }
                farapayamakReturnedSendSmsDtos.add(farapayamakReturnedSendSmsDto);
        });

        return farapayamakReturnedSendSmsDtos;
    }

    protected HttpEntity<?> requestHttpEntity(FarapayamakSendSmsDto farapayamakSendSmsDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<?> requestHttpEntity = new HttpEntity<>(farapayamakSendSmsDto, headers);
        return requestHttpEntity;
    }
}
