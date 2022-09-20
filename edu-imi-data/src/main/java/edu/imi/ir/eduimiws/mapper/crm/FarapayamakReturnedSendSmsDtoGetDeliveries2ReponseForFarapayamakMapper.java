package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.GetDeliveries2ResponseForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FarapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamakMapper {


    @Named("farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamak")
    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "retStatus", target = "returnStatus"),
            @Mapping(source = "strRetStatus", target = "stringReturnStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    GetDeliveries2ResponseForFarapayamak farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamak(FarapayamakReturnedSendSmsDto source);

    @IterableMapping(qualifiedByName = "farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamak")
    List<GetDeliveries2ResponseForFarapayamak> farapayamakReturnedSendSmsDtoGetDeliveries2ReponseForFarapayamak(List<FarapayamakReturnedSendSmsDto> source);
}


