package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Long.class, Integer.class, Timestamp.class, Date.class},
        uses = {PublicIdUtil.class, SecurityUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MelliDigitalPaymentMapper {

    @Named("toMelliDigitalPaymentDto")
    @Mappings({
            @Mapping(source = "additionalData", target = "additionalData"),
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
            @Mapping(source = "requestOrderId", target = "requestOrderId"),
            @Mapping(source = "signData", target = "signData"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "userId", target = "userId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDto toMelliDigitalPaymentDto(MelliDigitalPaymentEntity source, @Context CycleAvoidingMappingContext context);

    @Named("toMelliDigitalPaymentEntity")
    @Mappings({
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
            @Mapping(target = "publicId", qualifiedBy = MappingUtil.GenerateEntityPublicId.class),
            @Mapping(target = "creatorId", qualifiedBy = MappingUtil.CreatorIdFromSecurityContext.class)
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toMelliDigitalPaymentDto")
    MelliDigitalPaymentEntity toMelliDigitalPaymentEntity(MelliDigitalPaymentDto source, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMelliDigitalPaymentDto")
    List<MelliDigitalPaymentDto> toMelliDigitalPaymentDtos(List<MelliDigitalPaymentEntity> melliDigitalPaymentEntities, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toMelliDigitalPaymentEntity")
    List<MelliDigitalPaymentEntity> toMelliDigitalPaymentEntities(List<MelliDigitalPaymentDto> melliDigitalPaymentDtos, @Context CycleAvoidingMappingContext context);

}
