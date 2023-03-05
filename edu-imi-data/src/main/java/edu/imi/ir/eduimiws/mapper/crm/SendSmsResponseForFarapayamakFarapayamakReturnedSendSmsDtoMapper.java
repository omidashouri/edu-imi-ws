package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.response.crm.farapayamak.SendSmsResponseForFarapayamak;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import org.mapstruct.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring",
        uses = {CommonUtils.class},
        imports = {Arrays.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SendSmsResponseForFarapayamakFarapayamakReturnedSendSmsDtoMapper {

    @Named("toSendSmsResponseForFarapayamak")
    @Mappings({
            @Mapping(source = "value", target = "values",
                    qualifiedBy = {MappingUtil.CommonUtils.class, MappingUtil.CommaSeparatorStringToListString.class}),
            @Mapping(target = "retStatuses",
                    expression = "java(Arrays.asList(String.valueOf(source.getRetStatus())))"),
            @Mapping(target = "strRetStatuses",
                    expression = "java(Arrays.asList(String.valueOf(source.getStrRetStatus())))")

    })
    @BeanMapping(ignoreByDefault = true)
    SendSmsResponseForFarapayamak toSendSmsResponseForFarapayamak(FarapayamakReturnedSendSmsDto source);


    @IterableMapping(qualifiedByName = "toSendSmsResponseForFarapayamak")
    List<SendSmsResponseForFarapayamak> toSendSmsResponseForFarapayamaks(List<FarapayamakReturnedSendSmsDto> sources);

    default void addNewFarapayamakReturnedSendSmsDto(@MappingTarget SendSmsResponseForFarapayamak  sendSmsResponseForFarapayamak,
                                                     SendSmsResponseForFarapayamak source){

        if(Objects.nonNull(sendSmsResponseForFarapayamak) && Objects.nonNull(sendSmsResponseForFarapayamak.getValues())){
            sendSmsResponseForFarapayamak.getValues().addAll(source.getValues());
            sendSmsResponseForFarapayamak.getRetStatuses().addAll(source.getRetStatuses());
            sendSmsResponseForFarapayamak.getStrRetStatuses().addAll(source.getStrRetStatuses());
        }else{
            sendSmsResponseForFarapayamak.setValues(source.getValues());
            sendSmsResponseForFarapayamak.setRetStatuses(source.getRetStatuses());
            sendSmsResponseForFarapayamak.setStrRetStatuses(source.getStrRetStatuses());
        }
    }
}
