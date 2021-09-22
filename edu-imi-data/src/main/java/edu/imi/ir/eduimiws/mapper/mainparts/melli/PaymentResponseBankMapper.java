package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponseBank;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentResponseBankMapper {

    @Named("paymentResponseBankToMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto paymentResponseBankToMelliDigitalPaymentDto(PaymentResponseBank source);


    @IterableMapping(qualifiedByName = "paymentResponseBankToMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> paymentResponseBankToMelliDigitalPaymentDtoes(List<PaymentResponseBank> sources);

    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateMelliDigitalPaymentDtoByPaymentResponseBank(@MappingTarget MelliDigitalPaymentDto target ,
                                                           PaymentResponseBank source);
}
