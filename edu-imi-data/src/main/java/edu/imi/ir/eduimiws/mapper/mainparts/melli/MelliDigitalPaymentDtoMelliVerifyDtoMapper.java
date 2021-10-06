package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MelliDigitalPaymentDtoMelliVerifyDtoMapper {

    @Named("melliDigitalPaymentDtoToMelliVerifyDto")
    @Mappings({
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "succeed", target = "succeed"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "retrivalRefNo", target = "retrivalRefNo"),
            @Mapping(source = "systemTraceNo", target = "systemTraceNo"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(source = "terminalId", target = "terminalId"),
            @Mapping(source = "verifyCreatorId", target = "creatorId"),
            @Mapping(source = "verifyCreateDateTs", target = "createDateTs"),
            @Mapping(source = "verifyDeleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "id", target = "melliDigitalPaymentId"),
            @Mapping(source = "publicId", target = "melliDigitalPaymentPublicId"),
            @Mapping(source = "merchantOrderId", target = "merchantOrderId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliVerifyDto melliDigitalPaymentDtoToMelliVerifyDto(MelliDigitalPaymentDto source);

    @Named("melliVerifyDtoToMelliDigitalPaymentDto")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "melliDigitalPaymentDtoToMelliVerifyDto")
    MelliDigitalPaymentDto melliVerifyDtoToMelliDigitalPaymentDto(MelliVerifyDto source);

    @Mappings({
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "terminalId", target = "terminalId"),
            @Mapping(source = "merchantOrderId", target = "merchantOrderId")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateMelliVerifyDtoByMelliDigitalPaymentDto(@MappingTarget MelliVerifyDto target ,
                                                      MelliDigitalPaymentDto source);

}
