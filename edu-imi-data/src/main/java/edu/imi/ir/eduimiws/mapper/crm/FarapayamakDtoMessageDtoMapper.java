package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakDto;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.utilities.DateConvertor;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {LocalDateTime.class, DateTimeFormatter.class},
        uses = {SecurityUtil.class, DateConvertor.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL
        , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FarapayamakDtoMessageDtoMapper {

    @Named("farapayamakDtoToMessageDto")
    @Mappings({
            @Mapping(source = "fakeLong", target = "userCreatorId",
//                    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
                    qualifiedBy = {MappingUtil.SecurityUtil.class,
                            MappingUtil.CreatorIdFromSecurityContext.class}),//100160
            @Mapping(source = "fakeString", target = "senderName",
                    qualifiedBy = {MappingUtil.SecurityUtil.class,
                            MappingUtil.CreatorFullNameFromSecurityContext.class}),//اميد عاشوري
            @Mapping(source = "from", target = "senderEmail"),//3000550
            @Mapping(source = "localDateTimeNow", target = "sendDate",
                    qualifiedBy = {MappingUtil.DateConvertor.class,
                            MappingUtil.JalaliDateFromLocalDateTime.class}),//1401/02/04
            @Mapping(source = "localDateTimeNow", target = "sendTime",
                    qualifiedBy = {MappingUtil.DateConvertor.class,
                            MappingUtil.TimeFromLocalDateTime.class}),//11:53:30
            @Mapping(target = "sendSms", constant = "y"),//y
            @Mapping(source = "text", target = "messageText"),//متن پیام
            @Mapping(source = "value", target = "status"),//code20digit
            @Mapping(source = "values", target = "statuses"),//
            @Mapping(target = "sectionName",constant = "farapayamakApi"),//farapayamakApi
            @Mapping(source = "to", target = "toSms"),//09126607350
            @Mapping(source = "toes", target = "toSmses")//
    })
    @BeanMapping(ignoreByDefault = true)
    MessageDto farapayamakDtoToMessageDto(FarapayamakDto farapayamakDto);


    @IterableMapping(qualifiedByName = "farapayamakDtoToMessageDto")
    List<MessageDto> farapayamakDtosToMessageDtos(List<FarapayamakDto> farapayamakDtos);


    @Named("farapayamakDtoToMessageDtoAsync")
    @Mappings({
            @Mapping(source = "creatorId", target = "userCreatorId"),//100160
            @Mapping(source = "creatorFullName", target = "senderName"),//اميد عاشوري
            @Mapping(source = "creatorId", target = "userCreatorDto",
            qualifiedByName = "generateCreatorDto"),
            @Mapping(source = "from", target = "senderEmail"),//3000550
            @Mapping(source = "localDateTimeNow", target = "sendDate",
                    qualifiedBy = {MappingUtil.DateConvertor.class,
                            MappingUtil.JalaliDateFromLocalDateTime.class}),//1401/02/04
            @Mapping(source = "localDateTimeNow", target = "sendTime",
                    qualifiedBy = {MappingUtil.DateConvertor.class,
                            MappingUtil.TimeFromLocalDateTime.class}),//11:53:30
            @Mapping(target = "sendSms", constant = "y"),//y
            @Mapping(source = "text", target = "messageText"),//متن پیام
            @Mapping(source = "value", target = "status"),//code20digit
            @Mapping(source = "values", target = "statuses"),//
            @Mapping(target = "sectionName",constant = "farapayamakApi"),//farapayamakApi
            @Mapping(source = "to", target = "toSms"),//09126607350
            @Mapping(source = "toes", target = "toSmses")//
    })
    @BeanMapping(ignoreByDefault = true)
    MessageDto farapayamakDtoToMessageDtoAsync(FarapayamakDto farapayamakDto);



    @Named("generateCreatorDto")
    default PersonDto generateCreatorDto(Long creatorId) {
        PersonDto creator = new PersonDto();
        creator.setId(creatorId);
        return creator;
    }
}
