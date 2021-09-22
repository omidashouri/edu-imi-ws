package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentResponseBank;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentResponseMelliDigitalPaymentMapper {

    @Named("paymentResponseBankToMelliDigitalPaymentEntity")
    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentEntity paymentResponseBankToMelliDigitalPaymentEntity(PaymentResponseBank source);


    @IterableMapping(qualifiedByName = "paymentResponseBankToMelliDigitalPaymentEntity")
    List<MelliDigitalPaymentEntity> paymentResponseBankToMelliDigitalPaymentEntities(List<PaymentResponseBank> sources);
}
