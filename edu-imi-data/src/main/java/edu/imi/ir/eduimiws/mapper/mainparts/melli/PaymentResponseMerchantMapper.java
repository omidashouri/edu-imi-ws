package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponseMerchant;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentResponseMerchantMapper {

    @Named("paymentResponseMerchantToMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto paymentResponseMerchantToMelliDigitalPaymentDto(PaymentResponseMerchant source);

    @Named("melliDigitalPaymentDtoToPaymentResponseMerchant")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "paymentResponseMerchantToMelliDigitalPaymentDto")
    PaymentResponseMerchant melliDigitalPaymentDtoToPaymentResponseMerchant(MelliDigitalPaymentDto source);


    @IterableMapping(qualifiedByName = "paymentResponseMerchantToMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> paymentResponseMerchantToMelliDigitalPaymentDtoes(List<PaymentResponseMerchant> sources);

    @IterableMapping(qualifiedByName = "melliDigitalPaymentDtoToPaymentResponseMerchant")
    List<PaymentResponseMerchant> melliDigitalPaymentDtoToPaymentResponseMerchants(List<MelliDigitalPaymentDto> sources);
}
