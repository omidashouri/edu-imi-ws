package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.GetCreditResponseForFarapayamak;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GetCreditForFarapayamakFarapayamakReturnedSendSmsDtoMapper {

    @Named("toGetCreditResponseForFarapayamak")
    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "retStatus", target = "returnStatus"),
            @Mapping(source = "strRetStatus", target = "stringReturnStatus")

    })
    @BeanMapping(ignoreByDefault = true)
    GetCreditResponseForFarapayamak toGetCreditResponseForFarapayamak(FarapayamakReturnedSendSmsDto source);


    @IterableMapping(qualifiedByName = "toGetCreditResponseForFarapayamak")
    List<GetCreditResponseForFarapayamak> toGetCreditResponseForFarapayamak(List<FarapayamakReturnedSendSmsDto> sources);

}
