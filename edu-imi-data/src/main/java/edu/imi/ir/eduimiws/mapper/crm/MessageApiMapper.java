package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.MessageApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.MessageApiDto;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {MessageMapper.class, PersonMapper.class},
        imports = {MessageDto.class, PersonDto.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageApiMapper {

    @Named("toMessageApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "message.id", target = "messageId"),
            @Mapping(source = "message", target = "messageDto", qualifiedByName = "toMessageDto"),
            @Mapping(source = "messagePublicId", target = "messagePublicId"),
            @Mapping(source = "userCreator.id", target = "userCreatorId"),
            @Mapping(source = "userCreator", target = "userCreatorDto", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "userCreatorPublicId", target = "userCreatorPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteMessageId", target = "deleteMessageId")


    })
    @BeanMapping(ignoreByDefault = true)
    MessageApiDto toMessageApiDto(MessageApiEntity MessageApiEntity,
                                  @Context CycleAvoidingMappingContext context);


    @Named("toMessageApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "messageDto", target = "message", qualifiedByName = "toMessageEntity"),
            @Mapping(source = "userCreatorDto", target = "userCreator", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "userCreatorPublicId", target = "userCreatorPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteMessageId", target = "deleteMessageId")

    })
    MessageApiEntity toMessageApiEntity(MessageApiDto MessageApiDto,
                                        @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageApiEntity")
    List<MessageApiEntity> toMessageApiEntities(List<MessageApiDto> MessageApiDtos,
                                                @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMessageApiDto")
    List<MessageApiDto> toMessageApiDtos(List<MessageApiEntity> MessageApiEntities,
                                         @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toMessageApiDto")
    default void handleMessageApiPublicIds(MessageApiEntity MessageApiEntity) {
        new PersistenceUtils().cleanFromProxyByReadMethod(MessageApiEntity);
    }
}
