package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.MessageReceiverApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {MessageReceiverMapper.class, PersonMapper.class, MessageMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageReceiverApiMapper {

    @Named("toMessageReceiverApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "messageReceiver", target = "messageReceiverDto",
                    qualifiedByName = "toMessageReceiverDto"),
            @Mapping(source = "messageReceiverPublicId", target = "messageReceiverPublicId"),
            @Mapping(source = "user", target = "userDto",
                    qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "userPublicId", target = "userPublicId"),
            @Mapping(source = "message", target = "messageDto",
                    qualifiedByName = "toMessageDto"),
            @Mapping(source = "messagePublicId", target = "messagePublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteMessageReceiverId", target = "deleteMessageReceiverId")
    })
    @BeanMapping(ignoreByDefault = true)
    MessageReceiverApiDto toMessageReceiverApiDto(MessageReceiverApiEntity MessageReceiverApiEntity,
                                                  @Context CycleAvoidingMappingContext context);


    @Named("toMessageReceiverApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "messageReceiverDto", target = "messageReceiver",
                    qualifiedByName = "toMessageReceiverEntity"),
            @Mapping(source = "messageReceiverPublicId", target = "messageReceiverPublicId"),
            @Mapping(source = "userDto", target = "user",
                    qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "userPublicId", target = "userPublicId"),
            @Mapping(source = "messageDto", target = "message",
                    qualifiedByName = "toMessageEntity"),
            @Mapping(source = "messagePublicId", target = "messagePublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteMessageReceiverId", target = "deleteMessageReceiverId")
    })
    MessageReceiverApiEntity toMessageReceiverApiEntity(MessageReceiverApiDto MessageReceiverApiDto,
                                                        @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageReceiverApiEntity")
    List<MessageReceiverApiEntity> toMessageReceiverApiEntities(List<MessageReceiverApiDto> MessageReceiverApiDtos,
                                                                @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageReceiverApiDto")
    List<MessageReceiverApiDto> toMessageReceiverApiDtos(List<MessageReceiverApiEntity> MessageReceiverApiEntities,
                                                         @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toMessageReceiverApiDto")
    default void handleMessageReceiverApiPublicIds(MessageReceiverApiEntity MessageReceiverApiEntity) {
        new PersistenceUtils().cleanFromProxyByReadMethod(MessageReceiverApiEntity);
    }

}
