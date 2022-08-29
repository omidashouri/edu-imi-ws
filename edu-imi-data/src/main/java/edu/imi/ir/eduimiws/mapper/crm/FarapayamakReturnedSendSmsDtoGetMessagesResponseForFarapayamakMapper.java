package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.GetMessagesResponseForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FarapayamakReturnedSendSmsDtoGetMessagesResponseForFarapayamakMapper {

    @Named("farapayamakReturnedSendSmsDtoToGetMessagesForFarapayamak")
    @Mappings({
            @Mapping(source = "myBaseDto", target = "myBaseDto"),
            @Mapping(source = "dataDtos",target = "dataDtos")

    })

    @BeanMapping(ignoreByDefault = true)
    GetMessagesResponseForFarapayamak farapayamakReturnedSendSmsDtoToGetMessagesResponseForFarapayamak(FarapayamakReturnedSendSmsDto source);

    @IterableMapping(qualifiedByName = "farapayamakReturnedSendSmsDtoToGetMessagesForFarapayamak")
    List<GetMessagesResponseForFarapayamak> farapayamakReturnedSendSmsDtoToGetMessagesForFarapayamak(List<FarapayamakReturnedSendSmsDto> source);
}
