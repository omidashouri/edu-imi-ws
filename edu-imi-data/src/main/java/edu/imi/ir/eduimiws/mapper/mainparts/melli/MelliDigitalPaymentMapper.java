package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.services.mainparts.MelliDigitalPaymentService;
import edu.imi.ir.eduimiws.utilities.MelliTripleDesImpl;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Long.class, Integer.class, Timestamp.class, Date.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MelliDigitalPaymentMapper {

    @Named("toMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "additionalData", target = "additionalData"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "applicationName", target = "applicationName"),
            @Mapping(source = "cardHolderIdentity", target = "cardHolderIdentity"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "creatorId", target = "creatorId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "localDateTime", target = "localDateTime"),
            @Mapping(source = "multiplexingDataId", target = "multiplexingDataId"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "panAuthenticationType", target = "panAuthenticationType"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "returnUrl", target = "returnUrl"),
            @Mapping(source = "merchantOrderId", target = "merchantOrderId"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "userId", target = "userId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto toMelliDigitalPaymentDto(MelliDigitalPaymentEntity source, @Context CycleAvoidingMappingContext context);

    @Named("toMelliDigitalPaymentEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toMelliDigitalPaymentDto")
    MelliDigitalPaymentEntity toMelliDigitalPaymentEntity(MelliDigitalPaymentDto source, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> toMelliDigitalPaymentDtos(List<MelliDigitalPaymentEntity> melliDigitalPaymentEntities, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMelliDigitalPaymentEntity")
    List<MelliDigitalPaymentEntity> toMelliDigitalPaymentEntities(List<MelliDigitalPaymentDto> melliDigitalPaymentDtos, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "orderId", source = "orderId"),
            @Mapping(target = "signData", source = "signData"),
            @Mapping(target = "description", source = "description")
    })
    void updateMelliDigitalPaymentByMelliDigitalPaymentDto_PaymentResponse(@MappingTarget MelliDigitalPaymentEntity target,
                                                                           MelliDigitalPaymentDto source);


    //    @Mappings({
//            @Mapping(target = "orderId", source = "orderId"),
//            @Mapping(target = "signData", source = "signData"),
//            @Mapping(target = "merchantId", expression = "java(service.getMerchantId())"),
//            @Mapping(target = "terminalId", expression = "java(service.getTerminalId())"),
//            @Mapping(target = "token", expression = "java(service2.encrypt(String.format(\"%s;%s;%s\",
//                                              service.getTerminalId(), target.getOrderId(), target.getAmount())))"),
//            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
//            @Mapping(target = "creatorId", expression = "java(securityUtil.getPersonIdFromSecurityContext())"),
//            @Mapping(target = "publicId",  expression = "java(publicIdUtil.generateUniquePublicId())")
//    })
    default void updateMelliDigitalPaymentEntity_BeforeSave(@MappingTarget MelliDigitalPaymentDto target,
                                                            @Context MelliDigitalPaymentService melliDigitalPaymentService,
                                                            @Context PublicIdUtil publicIdUtil,
                                                            @Context SecurityUtil securityUtil,
                                                            @Context MelliTripleDesImpl service2) {

        String orderId = String.valueOf(melliDigitalPaymentService.queryLastOrderId());
        target.setOrderId(Long.valueOf(orderId));
        target.setSignData(service2.encrypt(String.format("%s;%s;%s", target.getTerminalId(), orderId,
                target.getAmount())));
        target.setCreateDateTs(new Timestamp(new Date().getTime()));
        target.setCreatorId(securityUtil.getPersonIdFromSecurityContext());
        target.setPublicId(publicIdUtil.generateUniquePublicId());
    }
}
