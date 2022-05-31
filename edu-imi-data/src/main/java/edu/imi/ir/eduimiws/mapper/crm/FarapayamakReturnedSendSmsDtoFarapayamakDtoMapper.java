package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakDto;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FarapayamakReturnedSendSmsDtoFarapayamakDtoMapper {

    @Named("farapayamakReturnedSendSmsDtoToFarapayamakDto")
    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "value", target = "values",
                    qualifiedBy = {MappingUtil.CommonUtils.class,
                            MappingUtil.CommaSeparatorStringToListString.class}),
            @Mapping(source = "retStatus", target = "retStatus"),
            @Mapping(source = "strRetStatus", target = "strRetStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakDto farapayamakReturnedSendSmsDtoToFarapayamakDto(FarapayamakReturnedSendSmsDto source);


    @IterableMapping(qualifiedByName = "farapayamakReturnedSendSmsDtoToFarapayamakDto")
    List<FarapayamakDto> farapayamakReturnedSendSmsDtostoFarapayamakDtos(List<FarapayamakReturnedSendSmsDto> sources);

    @Mappings({
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "value", target = "values",
                    qualifiedBy = {MappingUtil.CommonUtils.class,
                            MappingUtil.CommaSeparatorStringToListString.class}),
            @Mapping(source = "retStatus", target = "retStatus"),
            @Mapping(source = "strRetStatus", target = "strRetStatus")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFarapayamakDtoByFarapayamakReturnedSendSmsDto(FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto,
                                                     @MappingTarget FarapayamakDto farapayamakDto);

}
