package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCertificateSmsApiDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodCertificateSmsApiProjection;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCertificateSmsApiProjectionMapper {

    @Named("toPeriodCertificateSmsApiProjectionDto")
    @Mappings({
            @Mapping(source = "pcsaId", target = "id"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "activityStatus", target = "periodCertificateActivityStatus"),
            @Mapping(source = "deliveryDate", target = "periodCertificateDeliveryDate"),
            @Mapping(source = "financialStatus", target = "registerFinancialStatus"),
            @Mapping(source = "finalStatus", target = "registerFinalStatus"),
            @Mapping(source = "registerType", target = "registerType")


    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCertificateSmsApiDto toPeriodCertificateSmsApiProjectionDto(PeriodCertificateSmsApiProjection source,
                                                                      @Context CycleAvoidingMappingContext context);


    @IterableMapping(qualifiedByName = "toPeriodCertificateSmsApiProjectionDto")
    List<PeriodCertificateSmsApiDto> toPeriodCertificateSmsApiProjectionDtos(List<PeriodCertificateSmsApiProjection> sources,
                                                                             @Context CycleAvoidingMappingContext context);


}
