package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.MessageEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.services.crm.MessageApiService;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Mapper(componentModel = "spring",
        uses = {MessageApiMapper.class, PersonMapper.class, MessageApiService.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageMapper {

    @Named("toMessageDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "id", target = "messagePublicId",
                    qualifiedBy = {MappingUtil.MessageApiUtil.class,
                            MappingUtil.MessageIdToMessagePublicId.class}),
            @Mapping(source = "subject", target = "subject"),
            @Mapping(source = "userCreator", target = "userCreatorDto", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "userCreator.id", target = "userCreatorId"),
            @Mapping(source = "userCreator.personApiEntity.personPublicId", target = "userCreatorPublicId"),
            @Mapping(source = "senderName", target = "senderName"),
            @Mapping(source = "senderEmail", target = "senderEmail"),
            @Mapping(source = "sendDate", target = "sendDate"),
            @Mapping(source = "sendTime", target = "sendTime"),
            @Mapping(source = "sendSms", target = "sendSms"),
            @Mapping(source = "sendEmail", target = "sendEmail"),
            @Mapping(source = "sendTextMessage", target = "sendTextMessage"),
            @Mapping(source = "sendFax", target = "sendFax"),
            @Mapping(source = "sendIm", target = "sendIm"),
            @Mapping(source = "toIm", target = "toIm"),
            @Mapping(source = "messageText", target = "messageText"),
            @Mapping(source = "emailAccount", target = "emailAccount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "sectionName", target = "sectionName"),
            @Mapping(source = "sectionId", target = "sectionId"),
            @Mapping(source = "sectionIdName", target = "sectionIdName"),
            @Mapping(source = "messageType", target = "messageType"),
            @Mapping(source = "isForwarded", target = "isForwarded"),
            @Mapping(source = "isReplied", target = "isReplied"),
            @Mapping(source = "toSms", target = "toSms"),
            @Mapping(source = "toEmail", target = "toEmail"),
            @Mapping(source = "toEmailCc", target = "toEmailCc"),
            @Mapping(source = "toEmailBcc", target = "toEmailBcc"),
            @Mapping(source = "toFax", target = "toFax")
    })
    @BeanMapping(ignoreByDefault = true)
    MessageDto toMessageDto(MessageEntity MessageEntity,
                            @Context CycleAvoidingMappingContext context);


    @Named("toMessageEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "subject", target = "subject"),
            @Mapping(source = "userCreatorDto", target = "userCreator", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "senderName", target = "senderName"),
            @Mapping(source = "senderEmail", target = "senderEmail"),
            @Mapping(source = "sendDate", target = "sendDate"),
            @Mapping(source = "sendTime", target = "sendTime"),
            @Mapping(source = "sendSms", target = "sendSms"),
            @Mapping(source = "sendEmail", target = "sendEmail"),
            @Mapping(source = "sendTextMessage", target = "sendTextMessage"),
            @Mapping(source = "sendFax", target = "sendFax"),
            @Mapping(source = "sendIm", target = "sendIm"),
            @Mapping(source = "toIm", target = "toIm"),
            @Mapping(source = "messageText", target = "messageText"),
            @Mapping(source = "emailAccount", target = "emailAccount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "sectionName", target = "sectionName"),
            @Mapping(source = "sectionId", target = "sectionId"),
            @Mapping(source = "sectionIdName", target = "sectionIdName"),
            @Mapping(source = "messageType", target = "messageType"),
            @Mapping(source = "isForwarded", target = "isForwarded"),
            @Mapping(source = "isReplied", target = "isReplied"),
            @Mapping(source = "toSms", target = "toSms"),
            @Mapping(source = "toEmail", target = "toEmail"),
            @Mapping(source = "toEmailCc", target = "toEmailCc"),
            @Mapping(source = "toEmailBcc", target = "toEmailBcc"),
            @Mapping(source = "toFax", target = "toFax")
    })
    MessageEntity toMessageEntity(MessageDto MessageDto,
                                  @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageEntity")
    List<MessageEntity> toMessageEntities(List<MessageDto> MessageDtos,
                                          @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageDto")
    List<MessageDto> toMessageDtos(List<MessageEntity> MessageEntities,
                                   @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toMessageDto")
    default void handleMessagePublicIds(MessageEntity MessageEntity,
                                        @MappingTarget MessageDto MessageDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(MessageEntity);
    }

    default List<MessageDto> generateMessageDtosForToSmses(MessageDto messageDto) {

        List<MessageDto> messageDtos = new ArrayList<>();

        Map<String, String> toSmsStatuses =
                IntStream.range(0, messageDto.getToSmses().size())
                        .boxed()
                        .collect(Collectors.toMap(i -> messageDto.getStatuses().get(i),
                                i -> messageDto.getToSmses().get(i)));

        toSmsStatuses.entrySet().forEach(kv->{
            MessageDto newMessageDto = this.newInstance(messageDto);
            newMessageDto.setToSms(kv.getValue());
            newMessageDto.setStatus(kv.getKey());
            messageDtos.add(newMessageDto);
        });

        return messageDtos;
    }


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "messagePublicId", target = "messagePublicId"),
            @Mapping(source = "subject", target = "subject"),
            @Mapping(source = "userCreatorId", target = "userCreatorId"),
            @Mapping(source = "userCreatorDto", target = "userCreatorDto"),
            @Mapping(source = "userCreatorPublicId", target = "userCreatorPublicId"),
            @Mapping(source = "senderName", target = "senderName"),
            @Mapping(source = "senderEmail", target = "senderEmail"),
            @Mapping(source = "sendDate", target = "sendDate"),
            @Mapping(source = "sendTime", target = "sendTime"),
            @Mapping(source = "sendSms", target = "sendSms"),
            @Mapping(source = "sendEmail", target = "sendEmail"),
            @Mapping(source = "sendTextMessage", target = "sendTextMessage"),
            @Mapping(source = "sendFax", target = "sendFax"),
            @Mapping(source = "sendIm", target = "sendIm"),
            @Mapping(source = "toIm", target = "toIm"),
            @Mapping(source = "messageText", target = "messageText"),
            @Mapping(source = "messageSize", target = "messageSize"),
            @Mapping(source = "emailAccount", target = "emailAccount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "statuses", target = "statuses"),
            @Mapping(source = "sectionName", target = "sectionName"),
            @Mapping(source = "sectionId", target = "sectionId"),
            @Mapping(source = "sectionIdName", target = "sectionIdName"),
            @Mapping(source = "messageType", target = "messageType"),
            @Mapping(source = "isForwarded", target = "isForwarded"),
            @Mapping(source = "isReplied", target = "isReplied"),
            @Mapping(source = "toSms", target = "toSms"),
            @Mapping(source = "toSmses", target = "toSmses"),
            @Mapping(source = "toEmail", target = "toEmail"),
            @Mapping(source = "toEmailCc", target = "toEmailCc"),
            @Mapping(source = "toEmailBcc", target = "toEmailBcc"),
            @Mapping(source = "toFax", target = "toFax")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MessageDto newInstance(MessageDto source);


}
