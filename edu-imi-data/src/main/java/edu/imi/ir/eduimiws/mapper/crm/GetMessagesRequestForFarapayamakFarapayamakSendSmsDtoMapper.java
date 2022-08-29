package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.request.crm.farapayamak.GetMessagesRequestForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetMessagesRequestForFarapayamakFarapayamakSendSmsDtoMapper {

    @Named("toFarapayamakSendSmsDto")
    @Mappings({
            @Mapping(source = "count", target = "count"),
            @Mapping(source = "from", target = "from"),
            @Mapping(source = "index", target = "index"),
            @Mapping(source = "location", target = "location")

    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakSendSmsDto toFarapayamakSendSmsDto(GetMessagesRequestForFarapayamak source);


    @IterableMapping(qualifiedByName = "toFarapayamakSendSmsDto")
    List<FarapayamakSendSmsDto> toFarapayamakSendSmsDtos(List<GetMessagesRequestForFarapayamak> sources);

}
