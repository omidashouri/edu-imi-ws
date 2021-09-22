package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.domain.mainparts.MelliVerifyEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
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
public interface MelliVerifyMapper {

    @Named("toMelliVerifyEntity")
    @Mappings({
            @Mapping(target = "publicId", expression = "java(publicIdUtil.generateUniquePublicId())"),
            @Mapping(source = "succeed", target = "succeed"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "retrivalRefNo", target = "retrivalRefNo"),
            @Mapping(source = "systemTraceNo", target = "systemTraceNo"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(target = "creatorId", expression = "java(securityUtil.getPersonIdFromSecurityContext())"),
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "melliDigitalPaymentId", target = "melliDigitalPaymentId"),
            @Mapping(source = "melliDigitalPaymentPublicId", target = "melliDigitalPaymentPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliVerifyEntity toMelliVerifyEntity(MelliVerifyDto source,
                                          @Context PublicIdUtil publicIdUtil,
                                          @Context SecurityUtil securityUtil);


    @Named("toMelliVerifyDto")
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "creatorId", target = "creatorId"),
            @Mapping(source = "createDateTs", target = "createDateTs")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toMelliVerifyEntity")
    MelliVerifyDto toMelliVerifyDto(MelliVerifyEntity source);

    @IterableMapping(qualifiedByName = "toMelliVerifyDto")
    List<MelliVerifyDto> toMelliVerifyDtos(List<MelliVerifyEntity> melliDigitalPaymentEntities);

    @IterableMapping(qualifiedByName = "toMelliVerifyEntity")
    List<MelliVerifyEntity> toMelliVerifyEntities(List<MelliVerifyDto> melliDigitalPaymentDtos,
                                                  @Context PublicIdUtil publicIdUtil,
                                                  @Context SecurityUtil securityUtil);

    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "creatorId", target = "creatorId"),
            @Mapping(source = "createDateTs", target = "createDateTs")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateMelliVerifyDtoByMelliVerifyEntityAfterSave(@MappingTarget MelliVerifyDto target ,
                                                                MelliVerifyEntity source);

}
