package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCertificateSmsApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCertificateSmsApiDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCertificateSmsApiMapper {

    @Named("toPeriodCertificateSmsApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "register.id", target = "registerId"),
            @Mapping(source = "periodCertificate.id", target = "periodCertificateId"),
            @Mapping(source = "messageReceiver.id", target = "messageReceiverId"),
            @Mapping(source = "smsText", target = "smsText"),
            @Mapping(source = "smsStatus", target = "smsStatus"),
            @Mapping(source = "smsCounter", target = "smsCounter"),
            @Mapping(source = "smsDate", target = "smsDate"),
            @Mapping(source = "periodCertificateActivityStatus", target = "periodCertificateActivityStatus"),
            @Mapping(source = "registerFinalStatus", target = "registerFinalStatus"),
            @Mapping(source = "registerFinancialStatus", target = "registerFinancialStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTS"),
            @Mapping(source = "periodCertificateDeliveryDate", target = "periodCertificateDeliveryDate"),
            @Mapping(source = "registerType", target = "registerType")

    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCertificateSmsApiDto toPeriodCertificateSmsApiDto(PeriodCertificateSmsApiEntity source,
                                                            @Context CycleAvoidingMappingContext context);

    @Named("toPeriodCertificateSmsApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCertificateSmsApiEntity toPeriodCertificateSmsApiEntity(PeriodCertificateSmsApiDto source,
                                                                  @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toPeriodCertificateSmsApiDto")
    List<PeriodCertificateSmsApiDto> toPeriodCertificateSmsApiDtos(List<PeriodCertificateSmsApiEntity> sources,
                                                                   @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toPeriodCertificateSmsApiEntity")
    List<PeriodCertificateSmsApiEntity> toPeriodCertificateSmsApiEntities(List<PeriodCertificateSmsApiDto> sources,
                                                                          @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "smsDate", target = "smsDate"),
            @Mapping(source = "smsText", target = "smsText")

    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCertificateSmsApiEntity updatePeriodCertificateSmsApiEntityReadyForDelivery(PeriodCertificateSmsApiDto source,
                                                                  @Context CycleAvoidingMappingContext context);
}


