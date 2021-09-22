package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import edu.imi.ir.eduimiws.models.response.melli.v1.VerifyResultDataMerchant;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        imports = {Long.class, Boolean.class, String.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VerifyResultDataMerchantMapper {

    @Named("melliVerifyDtoToVerifyResultDataMerchant")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "melliDigitalPaymentId", target = "paymentPublicId"),
            @Mapping(source="succeed", target = "succeed"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "retrivalRefNo", target = "retrivalRefNo"),
            @Mapping(source = "systemTraceNo", target = "systemTraceNo"),
            @Mapping(source = "merchantOrderId", target = "orderId"),
            @Mapping(source = "orderId", target = "apiOrderId")
    })
    @BeanMapping(ignoreByDefault = true)
    VerifyResultDataMerchant melliVerifyDtoToVerifyResultDataMerchant(MelliVerifyDto source);

    @Named("verifyRequestBankToMelliVerifyDto")
    @Mappings({
            @Mapping(target = "succeed", expression = "java(Long.valueOf(String.valueOf(source.getSucceed())))"),
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "melliVerifyDtoToVerifyResultDataMerchant")
    MelliVerifyDto verifyRequestBankToMelliVerifyDto(VerifyResultDataMerchant source);
}
