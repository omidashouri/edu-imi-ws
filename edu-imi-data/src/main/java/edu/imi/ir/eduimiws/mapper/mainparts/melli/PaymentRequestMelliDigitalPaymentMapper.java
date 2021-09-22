package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.models.request.melli.v1.PaymentRequestBank;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {java.sql.Timestamp.class,java.util.Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentRequestMelliDigitalPaymentMapper {

    @Named("paymentRequestToMelliDigitalPaymentEntity")
    @Mappings({
            @Mapping(source = "additionalData", target = "additionalData"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "applicationName", target = "applicationName"),
            @Mapping(source = "cardHolderIdentity", target = "cardHolderIdentity"),
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
            @Mapping(target = "creatorId", expression = "java(securityUtil.getPersonIdFromSecurityContext())"),
            @Mapping(source = "localDateTime", target = "localDateTime"),
//            @Mapping(source = "multiplexingDataId", target = "multiplexingDataId"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(target = "publicId",  expression = "java(publicIdUtil.generateUniquePublicId())"),
            @Mapping(source = "panAuthenticationType", target = "panAuthenticationType"),
            @Mapping(source = "returnUrl", target = "returnUrl"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "userId", target = "userId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentEntity paymentRequestToMelliDigitalPaymentEntity(PaymentRequestBank source,
                                                                        @Context PublicIdUtil publicIdUtil,
                                                                        @Context SecurityUtil securityUtil);


    @IterableMapping(qualifiedByName = "paymentRequestToMelliDigitalPaymentEntity")
    List<MelliDigitalPaymentEntity> paymentRequestToMelliDigitalPaymentEntities(List<PaymentRequestBank> sources,
                                                                                @Context PublicIdUtil publicIdUtil,
                                                                                @Context SecurityUtil securityUtil);

}
