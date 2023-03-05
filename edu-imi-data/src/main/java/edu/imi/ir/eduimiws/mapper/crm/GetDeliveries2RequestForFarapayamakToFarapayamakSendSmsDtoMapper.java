package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.request.crm.farapayamak.GetDeliveries2RequestForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetDeliveries2RequestForFarapayamakToFarapayamakSendSmsDtoMapper {

    @Named("toFarapayamakSendSmsDto")
    @Mappings({
            @Mapping(source = "recID", target = "recId")
    })

    @BeanMapping(ignoreByDefault = true)
    FarapayamakSendSmsDto toFarapayamakSendSmsDto(GetDeliveries2RequestForFarapayamak source);

    @IterableMapping(qualifiedByName = "toFarapayamakSendSmsDto")
    List<FarapayamakSendSmsDto> toFarapayamakSendSmsDto(List<GetDeliveries2RequestForFarapayamak> source);
}

