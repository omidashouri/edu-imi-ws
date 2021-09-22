package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequestBank;
import edu.imi.ir.eduimiws.security.MelliCredential;
import edu.imi.ir.eduimiws.utilities.MelliTripleDesImpl;
import org.mapstruct.*;

import java.util.List;


//  ATTENTION: When editing pay attention to 'MelliDigitalPaymentMapper.toMelliDigitalPaymentEntity' Mappings
@Mapper(componentModel = "spring",
        imports = {java.sql.Timestamp.class,java.util.Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentRequestBankMapper {

//    MultiplexingData Not Implemented

    @Named("paymentRequestBankToMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "additionalData", target = "additionalData"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "applicationName", target = "applicationName"),
            @Mapping(source = "cardHolderIdentity", target = "cardHolderIdentity"),
            @Mapping(source = "localDateTime", target = "localDateTime"),
            @Mapping(source = "merchantId", target = "merchantId"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(source = "panAuthenticationType", target = "panAuthenticationType"),
            @Mapping(source = "returnUrl", target = "returnUrl"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "terminalId", target = "terminalId"),
            @Mapping(source = "userId", target = "userId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto paymentRequestBankToMelliDigitalPaymentDto(PaymentRequestBank source,
                                                                      @Context MelliCredential service,
                                                                      @Context MelliTripleDesImpl service2);

    @Named("melliDigitalPaymentDtoToPaymentRequestBank")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "paymentRequestBankToMelliDigitalPaymentDto")
    PaymentRequestBank melliDigitalPaymentDtoToPaymentRequestBank(MelliDigitalPaymentDto source,
                                                                  @Context MelliCredential service);

    @IterableMapping(qualifiedByName = "paymentRequestBankToMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> toMelliDigitalPaymentDtos(List<PaymentRequestBank> paymentRequestBanks,
                                                           @Context MelliCredential service,
                                                           @Context MelliTripleDesImpl service2);

    @IterableMapping(qualifiedByName = "melliDigitalPaymentDtoToPaymentRequestBank")
    List<PaymentRequestBank> toMelliDigitalPaymentEntities(List<MelliDigitalPaymentDto> melliDigitalPaymentDtos,
                                                           @Context MelliCredential service);


    @AfterMapping
    default void handleToken(@MappingTarget MelliDigitalPaymentDto target, PaymentRequestBank source,
                          @Context MelliCredential service, @Context MelliTripleDesImpl service2) {
        target.setToken(service2.encrypt(String.format("%s;%s;%s", service.getTerminalId(), source.getOrderId(),
                source.getAmount())));
    }


}
