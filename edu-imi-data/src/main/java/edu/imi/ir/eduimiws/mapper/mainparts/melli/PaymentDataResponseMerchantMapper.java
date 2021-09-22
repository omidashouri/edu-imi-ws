package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.models.response.melli.v1.PaymentDataResponseMerchant;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentDataResponseMerchantMapper {

    @Named("toPaymentDataResponseMerchant")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "melliDigitalPaymentPublicId", target = "paymentRequestPublicId"),
            @Mapping(source = "merchantOrderId", target = "orderId"),
            @Mapping(source = "orderId", target = "apiOrderId"),
            @Mapping(source = "hashedCardNumber", target = "hashedCardNumber"),
            @Mapping(source = "primaryAccNo", target = "primaryAccNo"),
            @Mapping(source = "switchResCode", target = "switchResCode"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "requestVerificationToken", target = "requestVerificationToken"),
            @Mapping(source = "isWalletPayment", target = "isWalletPayment")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentDataResponseMerchant toPaymentDataResponseMerchant(MelliDigitalPaymentDataDto source);

    @Named("toMelliDigitalPaymentDataDto")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toPaymentDataResponseMerchant")
    MelliDigitalPaymentDataDto toMelliDigitalPaymentDataDto(PaymentDataResponseMerchant source);


}
