package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.mapper.crm.*;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakDto;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.*;

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
        log.info("FarapayamakService.getFarapayamakCredential - start");
        FarapayamakCredential result = farapayamakCredential;
        log.info("FarapayamakService.getFarapayamakCredential - result: [REDACTED]");
        return result;
    }

    @Override
    public FarapayamakReturnedSendSmsDto sendSMS(FarapayamakSendSmsDto farapayamakSendSmsDto) {
        log.info("FarapayamakService.sendSMS - farapayamakSendSmsDto: [REDACTED], to: {}, from: {}",
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getTo() : null,
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getFrom() : null);

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

        log.info("FarapayamakService.sendSMS - result: {}", farapayamakReturnedSendSmsDto);
        return farapayamakReturnedSendSmsDto;
    }

    @Override
    public FarapayamakReturnedSendSmsDto getBasePrice() {
        log.info("FarapayamakService.getBasePrice - start");
        String completeGetBasePriceUri = String.format(farapayamakCredential.getGetBasePriceUrl());

        HttpEntity<?> userNamePasswordRequestEntity = getUserNamePasswordRequestEntity();

        ResponseEntity<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDto =
                restTemplate.exchange(completeGetBasePriceUri,
                        HttpMethod.POST, userNamePasswordRequestEntity,
                        FarapayamakReturnedSendSmsDto.class);

        FarapayamakReturnedSendSmsDto result = farapayamakReturnedSendSmsDto.getBody();
        log.info("FarapayamakService.getBasePrice - result: {}", result);
        return result;
    }

    @Override
    public FarapayamakReturnedSendSmsDto getCredit() {
        log.info("FarapayamakService.getCredit - start");
        String completeGetCreditUri = String.format(farapayamakCredential.getGetCreditUrl());

        HttpEntity<?> userNamePasswordRequestEntity = getUserNamePasswordRequestEntity();

        ResponseEntity<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDto =
                restTemplate.exchange(completeGetCreditUri,
                        HttpMethod.POST, userNamePasswordRequestEntity,
                        FarapayamakReturnedSendSmsDto.class);

        FarapayamakReturnedSendSmsDto result = farapayamakReturnedSendSmsDto.getBody();
        log.info("FarapayamakService.getCredit - result: {}", result);
        return result;
    }

    @Override
    public FarapayamakReturnedSendSmsDto getUserNumbers() {
        log.info("FarapayamakService.getUserNumbers - start");
        String completeGetUserNumbersUri = String.format(farapayamakCredential.getGetCreditUrl());

        HttpEntity<?> userNamePasswordRequestEntity = getUserNamePasswordRequestEntity();

        ResponseEntity<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDto =
                restTemplate.exchange(completeGetUserNumbersUri,
                        HttpMethod.POST, userNamePasswordRequestEntity,
                        FarapayamakReturnedSendSmsDto.class);

        FarapayamakReturnedSendSmsDto result = farapayamakReturnedSendSmsDto.getBody();
        log.info("FarapayamakService.getUserNumbers - result: {}", result);
        return result;
    }

    @Override
    public FarapayamakReturnedSendSmsDto getMessagesFromFarapayamak(FarapayamakSendSmsDto farapayamakSendSmsDto) {
        log.info("FarapayamakService.getMessagesFromFarapayamak - farapayamakSendSmsDto: [REDACTED], location: {}, index: {}, count: {}",
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getLocation() : null,
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getIndex() : null,
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getCount() : null);
        String completeGetMessagesUri = String.format(farapayamakCredential.getGetMessagesUrl());


/*        Map requestBody = new HashMap();
        requestBody.put("username", "imiedu");
        requestBody.put("password", "Im!@3517");
        requestBody.put("location", 2);
        requestBody.put("from", "3000550");
        requestBody.put("index", 0);
        requestBody.put("count", "20");
        HttpEntity httpEntity = new HttpEntity(requestBody);*/


        Map responseBody = new HashMap();

        ResponseEntity<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDto =
                restTemplate.exchange(completeGetMessagesUri,
                        HttpMethod.POST, this.requestHttpEntity(farapayamakSendSmsDto),
                        FarapayamakReturnedSendSmsDto.class);


        farapayamakReturnedSendSmsDto.toString();

        FarapayamakReturnedSendSmsDto result = farapayamakReturnedSendSmsDto.getBody();
        log.info("FarapayamakService.getMessagesFromFarapayamak - result: {}", result);
        return result;
    }

    @Override
    public FarapayamakReturnedSendSmsDto getDeliveries2(FarapayamakSendSmsDto farapayamakSendSmsDto) {
        log.info("FarapayamakService.getDeliveries2 - farapayamakSendSmsDto: [REDACTED], recId: {}",
                farapayamakSendSmsDto != null ? farapayamakSendSmsDto.getRecId() : null);
        String completeGetDeliveries2Uri = String.format(farapayamakCredential.getGetDeliveries2Url());

        HttpEntity<?> userNamePasswordRequestEntity = getUserNamePasswordRequestEntity();

        Map responseBody = new HashMap();
        ResponseEntity<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDto =
                restTemplate.exchange(completeGetDeliveries2Uri,
                        HttpMethod.POST, this.requestHttpEntity(farapayamakSendSmsDto),
                        FarapayamakReturnedSendSmsDto.class);
        /* farapayamakReturnedSendSmsDto.toString();*/
        FarapayamakReturnedSendSmsDto result = farapayamakReturnedSendSmsDto.getBody();
        log.info("FarapayamakService.getDeliveries2 - result: {}", result);
        return result;

    }


/*    @Override
    public List<FarapayamakReturnedSendSmsDto> sendSmsAsync(SendSmsRequestForFarapayamak sendSmsRequestForFarapayamak) {
        return farapayamakServiceAsync.sendSmsBySendSmsRequestForFarapayamak(sendSmsRequestForFarapayamak);
    }*/

    protected HttpEntity<?> requestHttpEntity(FarapayamakSendSmsDto farapayamakSendSmsDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<?> requestHttpEntity = new HttpEntity<>(farapayamakSendSmsDto, headers);
        return requestHttpEntity;
    }

    protected HttpEntity<?> getUserNamePasswordRequestEntity() {
        Map<String, String> farpayamakUserPassRequestObject = new HashMap<>();
        farpayamakUserPassRequestObject.put("UserName", farapayamakCredential.getUsername());
        farpayamakUserPassRequestObject.put("PassWord", farapayamakCredential.getPassword());

        HttpHeaders httpRequestHeaders = new HttpHeaders();
        httpRequestHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpRequestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpRequestHeaders.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));

        HttpEntity<?> userNamePasswordRequestEntity =
                new HttpEntity<>(farpayamakUserPassRequestObject, httpRequestHeaders);
        return userNamePasswordRequestEntity;
    }
}
