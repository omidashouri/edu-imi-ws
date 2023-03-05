package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.GetUserNumbersResponseForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetUserNumbersForFarapayamakFarapayamakReturnedSendSmsDtoMapper {

    @Named("toGetUserNumbersResponseForFarapayamak")
    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "retStatus", target = "returnStatus"),
            @Mapping(source = "strRetStatus", target = "stringReturnStatus")
    })

    @BeanMapping(ignoreByDefault = true)
    GetUserNumbersResponseForFarapayamak toGetUserNumbersResponseForFarapayamak(FarapayamakReturnedSendSmsDto source);

    @IterableMapping(qualifiedByName = "toGetUserNumbersResponseForFarapayamak")
    List<GetUserNumbersResponseForFarapayamak> toGetUserNumbersResponseForFarapayamaks(List<FarapayamakReturnedSendSmsDto> sources);


}
