package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.GetBasePriceResponseForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetBasePriceForFarapayamakFarapayamakReturnedSendSmsDtoMapper {

    @Named("toGetBasePriceResponseForFarapayamak")
    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "retStatus", target = "returnStatus"),
            @Mapping(source = "strRetStatus", target = "stringReturnStatus")

    })
    @BeanMapping(ignoreByDefault = true)
    GetBasePriceResponseForFarapayamak toGetBasePriceResponseForFarapayamak(FarapayamakReturnedSendSmsDto source);


    @IterableMapping(qualifiedByName = "toGetBasePriceResponseForFarapayamak")
    List<GetBasePriceResponseForFarapayamak> toGetBasePriceResponseForFarapayamaks(List<FarapayamakReturnedSendSmsDto> sources);

}
