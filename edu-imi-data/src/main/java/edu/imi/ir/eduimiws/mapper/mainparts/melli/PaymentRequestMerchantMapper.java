package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequestMerchant;
import edu.imi.ir.eduimiws.security.MelliCredential;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Long.class, Integer.class, Timestamp.class, Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentRequestMerchantMapper {


    @Named("paymentRequestMerchantToMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "additionalData", target = "additionalData"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "applicationName", target = "applicationName"),
            @Mapping(source = "cardHolderIdentity", target = "cardHolderIdentity"),
            @Mapping(source = "localDateTime", target = "localDateTime"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "merchantOrderId", target = "merchantOrderId"),
            @Mapping(source = "panAuthenticationType", target = "panAuthenticationType"),
            @Mapping(source = "returnUrl", target = "returnUrl"),
            @Mapping(target = "terminalId", expression = "java(service.getTerminalId())"),
            @Mapping(target = "merchantId", expression = "java(service.getMerchantId())"),
//            @Mapping(source = "multiplexingData", target = "multiplexingData"),
            @Mapping(source = "userId", target = "userId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto paymentRequestMerchantToMelliDigitalPaymentDto(PaymentRequestMerchant source,
                                                                  @Context MelliCredential service);

    @Named("melliDigitalPaymentDtoToPaymentRequestMerchant")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "paymentRequestMerchantToMelliDigitalPaymentDto")
    PaymentRequestMerchant melliDigitalPaymentDtoToPaymentRequestMerchant(MelliDigitalPaymentDto source,
                                                          @Context MelliCredential service);

    @IterableMapping(qualifiedByName = "paymentRequestMerchantToMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> paymentRequestMerchantsToMelliDigitalPaymentDtos(List<PaymentRequestMerchant> paymentRequestMerchants,
                                                           @Context MelliCredential service);

    @IterableMapping(qualifiedByName = "melliDigitalPaymentDtoToPaymentRequestMerchant")
    List<PaymentRequestMerchant> melliDigitalPaymentDtosToMelliDigitalPaymentEntities(List<MelliDigitalPaymentDto> melliDigitalPaymentDtos,
                                                       @Context MelliCredential service);
}
