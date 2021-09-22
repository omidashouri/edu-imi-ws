package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import edu.imi.ir.eduimiws.models.response.melli.v1.VerifyResultDataBank;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        imports = {Long.class, Boolean.class, String.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VerifyResultDataBankMapper {

    @Named("melliVerifyDtoToVerifyResultDataBank")
    @Mappings({
//            @Mapping(target = "succeed", expression = "java(Boolean.valueOf(String.valueOf(source.getSucceed())))"),
            @Mapping(source = "succeed", target = "succeed"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "retrivalRefNo", target = "retrivalRefNo"),
            @Mapping(source = "systemTraceNo", target = "systemTraceNo"),
            @Mapping(source = "orderId", target = "orderId")
    })
    @BeanMapping(ignoreByDefault = true)
    VerifyResultDataBank melliVerifyDtoToVerifyResultDataBank(MelliVerifyDto source);

    @Named("verifyRequestBankToMelliVerifyDto")
    @Mappings({
            @Mapping(target = "succeed", expression = "java(Long.valueOf(String.valueOf(source.getSucceed())))"),
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "melliVerifyDtoToVerifyResultDataBank")
    MelliVerifyDto verifyRequestBankToMelliVerifyDto(VerifyResultDataBank source);

    @Mappings({
            @Mapping(source = "succeed", target = "succeed"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "retrivalRefNo", target = "retrivalRefNo"),
            @Mapping(source = "systemTraceNo", target = "systemTraceNo"),
            @Mapping(source = "orderId", target = "orderId")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateMelliVerifyDtoByVerifyResultDataBank(@MappingTarget MelliVerifyDto target ,
                                      VerifyResultDataBank source);
}
