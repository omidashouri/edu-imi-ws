package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.domain.mainparts.MelliDigitalPaymentDataEntity;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliDigitalPaymentDto;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;

@Mapper(componentModel = "spring",
        imports = {Timestamp.class, Date.class},
        uses = {PublicIdUtil.class, SecurityUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MelliDigitalPaymentDataMapper {

    @Named("toMelliDigitalPaymentDataEntity")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(target = "publicId", expression = "java(publicIdUtil.generateUniquePublicId())"),
            @Mapping(source = "orderId", target = "orderId"),
            @Mapping(source = "hashedCardNumber", target = "hashedCardNumber"),
            @Mapping(source = "primaryAccNo", target = "primaryAccNo"),
            @Mapping(source = "switchResCode", target = "switchResCode"),
            @Mapping(source = "resCode", target = "resCode"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "requestVerificationToken", target = "requestVerificationToken"),
            @Mapping(source = "isWalletPayment", target = "isWalletPayment"),
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
//            @Mapping(target = "creatorId", expression = "java(securityUtil.getPersonIdFromSecurityContext())"), //exception call back is anonymous
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "melliDigitalPaymentId", target = "melliDigitalPaymentId"),
            @Mapping(source = "melliDigitalPaymentPublicId", target = "melliDigitalPaymentPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    MelliDigitalPaymentDataEntity toMelliDigitalPaymentDataEntity(MelliDigitalPaymentDataDto source,
                                                            @Context PublicIdUtil publicIdUtil,
                                                            @Context SecurityUtil securityUtil);

    @Named("toMelliDigitalPaymentDataDto")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "creatorId", target = "creatorId")
    })
    @InheritInverseConfiguration(name = "toMelliDigitalPaymentDataEntity")
    MelliDigitalPaymentDataDto toMelliDigitalPaymentDataDto(MelliDigitalPaymentDataEntity source,
                                                            @Context PublicIdUtil publicIdUtil,
                                                            @Context SecurityUtil securityUtil);

    @Mappings({
            @Mapping(target = "id", source = "id")
    })
    void updateMelliDigitalPaymentDataDto_Id(@MappingTarget MelliDigitalPaymentDataDto target,
                                                                           MelliDigitalPaymentDataEntity source);


    @Mappings({
            @Mapping(target = "merchantOrderId", source = "merchantOrderId")
    })
    void updateMelliDigitalPaymentDataDtoMelliDigitalPaymentDto_MerchantOrderId(@MappingTarget MelliDigitalPaymentDataDto target,
                                                          MelliDigitalPaymentDto source);


}
