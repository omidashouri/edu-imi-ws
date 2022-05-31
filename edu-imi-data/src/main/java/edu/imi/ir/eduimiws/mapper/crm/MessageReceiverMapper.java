package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.MessageReceiverEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverDto;
import edu.imi.ir.eduimiws.services.crm.MessageApiService;
import edu.imi.ir.eduimiws.services.crm.MessageReceiverService;
import edu.imi.ir.eduimiws.services.crm.PersonApiService;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {MessageMapper.class, MessageReceiverMapper.class,
                PersonMapper.class, PersonApiService.class,
                MessageApiService.class, MessageReceiverService.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageReceiverMapper {

    @Named("toMessageReceiverDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "message.id", target = "messageId"),
            @Mapping(source = "message", target = "messageDto", qualifiedByName = "toMessageDto"),
            @Mapping(source = "message.id", target = "messagePublicId", qualifiedBy = {
                    MappingUtil.MessageApiUtil.class, MappingUtil.MessageIdToMessagePublicId.class
            }),
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "user", target = "userDto", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "user.id", target = "userPublicId", qualifiedBy = {
                    MappingUtil.PersonApiService.class, MappingUtil.PersonIdToPersonPublicId.class
            }),
            @Mapping(source = "userFolderId", target = "userFolderId"),
            @Mapping(source = "isViewed", target = "isViewed"),
            @Mapping(source = "messageType", target = "messageType"),
            @Mapping(source = "isForwarded", target = "isForwarded"),
            @Mapping(source = "isReplied", target = "isReplied"),
            @Mapping(source = "receiveDate", target = "receiveDate"),
            @Mapping(source = "receiveTime", target = "receiveTime"),
            @Mapping(source = "receiveNumber", target = "receiveNumber"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "sendId", target = "sendId"),
            @Mapping(source = "receiver", target = "receiver"),
            @Mapping(source = "sendId", target = "sectionId"),
            @Mapping(source = "sectionName", target = "sectionName"),
            @Mapping(source = "sectionIdName", target = "sectionIdName")
    })
    @BeanMapping(ignoreByDefault = true)
    MessageReceiverDto toMessageReceiverDto(MessageReceiverEntity MessageReceiverEntity,
                                            @Context CycleAvoidingMappingContext context);


    @Named("toMessageReceiverEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "messageDto", target = "message", qualifiedByName = "toMessageEntity"),
            @Mapping(source = "userDto", target = "user", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "userFolderId", target = "userFolderId"),
            @Mapping(source = "isViewed", target = "isViewed"),
            @Mapping(source = "messageType", target = "messageType"),
            @Mapping(source = "isForwarded", target = "isForwarded"),
            @Mapping(source = "isReplied", target = "isReplied"),
            @Mapping(source = "receiveDate", target = "receiveDate"),
            @Mapping(source = "receiveTime", target = "receiveTime"),
            @Mapping(source = "receiveNumber", target = "receiveNumber"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "sendId", target = "sendId"),
            @Mapping(source = "receiver", target = "receiver"),
            @Mapping(source = "sectionId", target = "sectionId"),
            @Mapping(source = "sectionName", target = "sectionName"),
            @Mapping(source = "sectionIdName", target = "sectionIdName")

    })
    MessageReceiverEntity toMessageReceiverEntity(MessageReceiverDto MessageReceiverDto,
                                                  @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageReceiverEntity")
    List<MessageReceiverEntity> toMessageReceiverEntities(List<MessageReceiverDto> MessageReceiverDtos,
                                                          @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageReceiverDto")
    List<MessageReceiverDto> toMessageReceiverDtos(List<MessageReceiverEntity> MessageReceiverEntities,
                                                   @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toMessageReceiverDto")
    default void handleMessageReceiverPublicIds(MessageReceiverEntity MessageReceiverEntity,
                                                @MappingTarget MessageReceiverDto MessageReceiverDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(MessageReceiverEntity);
    }

    @Named("messageReceiverDtoByMessageDtoBeforeSaveSms")
    default MessageReceiverDto messageReceiverDtoByMessageDtoBeforeSaveSms(MessageDto messageDto) {
        MessageReceiverDto messageReceiverDto = new MessageReceiverDto();
        messageReceiverDto.setMessageDto(messageDto);
        messageReceiverDto.setUserDto(messageDto.getUserCreatorDto());
        messageReceiverDto.setIsViewed("y");
        messageReceiverDto.setMessageType("s");
        messageReceiverDto.setIsForwarded("n");
        messageReceiverDto.setIsReplied("n");
        messageReceiverDto.setReceiveNumber(messageDto.getToSms());
        messageReceiverDto.setStatus("99");
        messageReceiverDto.setSendId(messageDto.getStatus());
        return messageReceiverDto;

    }

    @IterableMapping(qualifiedByName = "messageReceiverDtoByMessageDtoBeforeSaveSms")
    List<MessageReceiverDto> messageReceiverDtosByMessageDtosBeForeSaveSms(List<MessageDto> messageDtos);

}
