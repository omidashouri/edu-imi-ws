package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodMapper {

    PeriodMapper INSTANCE = Mappers.getMapper(PeriodMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "field", target = "field"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "creator", target = "creator"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editor", target = "editor"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "presentType", target = "presentType"),
            @Mapping(source = "tempType", target = "tempType"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "minCapacity", target = "minCapacity"),
            @Mapping(source = "organization", target = "organization"),
            @Mapping(source = "executer", target = "executer"),
            @Mapping(source = "academic", target = "academic"),
            @Mapping(source = "planId", target = "planId"),
            @Mapping(source = "account", target = "account"),
            @Mapping(source = "totalUnit", target = "totalUnit"),
            @Mapping(source = "thesisUnit", target = "thesisUnit"),
            @Mapping(source = "tunit", target = "tunit"),
            @Mapping(source = "punit", target = "punit"),
            @Mapping(source = "variableName", target = "variableName"),
            @Mapping(source = "certificateTemplateId", target = "certificateTemplateId"),
            @Mapping(source = "executerCapacity", target = "executerCapacity"),
            @Mapping(source = "feeForeign", target = "feeForeign"),
            @Mapping(source = "currency", target = "currency"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "schedule", target = "schedule"),
            @Mapping(source = "periodOrgFee", target = "periodOrgFee"),
            @Mapping(source = "company", target = "company"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "cardNoPerfix", target = "cardNoPerfix"),
            @Mapping(source = "feeVariable", target = "feeVariable"),
            @Mapping(source = "feeEquivalentFixed", target = "feeEquivalentFixed"),
            @Mapping(source = "feeEquivalentVariable", target = "feeEquivalentVariable"),
            @Mapping(source = "onlineRegCostPercent", target = "onlineRegCostPercent"),
            @Mapping(source = "cardNoPerfixR", target = "cardNoPerfixR"),
            @Mapping(source = "periodHoldingId", target = "periodHoldingId"),
            @Mapping(source = "holdingType", target = "holdingType"),
            @Mapping(source = "holdingLanguage", target = "holdingLanguage"),
            @Mapping(source = "certificateDesc", target = "certificateDesc"),
            @Mapping(source = "allowTerm", target = "allowTerm"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "variableCertificateName", target = "variableCertificateName"),
            @Mapping(source = "periodApi", target = "periodApi")

    })
    @BeanMapping(ignoreByDefault = true)
    PeriodEntity PeriodDtoToPeriodEntity(PeriodDto periodDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodDto PeriodEntityToPeriodDto(PeriodEntity periodEntity, @Context CycleAvoidingMappingContext context);

    @SuppressWarnings("unused")
    List<PeriodDto> PeriodEntitiesToPeriodDtoes(List<PeriodEntity> periodEntities, @Context CycleAvoidingMappingContext context);

    @SuppressWarnings("unused")
    List<PeriodEntity> PeriodDtoesToPeriodEntities(List<PeriodDto> periodDtos, @Context CycleAvoidingMappingContext context);


}