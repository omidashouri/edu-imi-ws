package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.FarapayamakDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring",
        uses = {CommonUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FarapayamakSendSmsDtoFarapayamakDtoMapper {

    @Named("farapayamakSendSmsDtoToFarapayamakDto")
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "to", target = "to"),
            @Mapping(source = "to", target = "toes",
                    qualifiedBy = {MappingUtil.CommonUtils.class, MappingUtil.CommaSeparatorStringToListString.class}),
            @Mapping(source = "from", target = "from"),
            @Mapping(source = "text", target = "text"),
            @Mapping(source = "isFlash", target = "isFlash")
    })
    @BeanMapping(ignoreByDefault = true)
    FarapayamakDto farapayamakSendSmsDtoToFarapayamakDto(FarapayamakSendSmsDto source);


    @IterableMapping(qualifiedByName = "farapayamakSendSmsDtoToFarapayamakDto")
    List<FarapayamakDto> farapayamakSendSmsDtosToFarapayamakDtos(List<FarapayamakSendSmsDto> sources);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "to", target = "to"),
            @Mapping(source = "to", target = "toes",
                    qualifiedBy = {MappingUtil.CommonUtils.class, MappingUtil.CommaSeparatorStringToListString.class}),
            @Mapping(source = "from", target = "from"),
            @Mapping(source = "text", target = "text"),
            @Mapping(source = "isFlash", target = "isFlash")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFarapayamakDtoByFarapayamakSendSmsDto(FarapayamakSendSmsDto farapayamakSendSmsDto,
                                                 @MappingTarget FarapayamakDto farapayamakDto);


    @Mappings({
            @Mapping(source = "creatorId", target = "creatorId"),
            @Mapping(source = "creatorFullName", target = "creatorFullName")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFarapayamakDtoByFarapayamakSendSmsDtoAsync(FarapayamakSendSmsDto farapayamakSendSmsDto,
                                                     @MappingTarget FarapayamakDto farapayamakDto);

}
