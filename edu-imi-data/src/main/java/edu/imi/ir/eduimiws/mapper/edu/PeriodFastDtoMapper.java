package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeriodFastDtoMapper {

    PeriodFastDtoMapper INSTANCE = Mappers.getMapper(PeriodFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "fieldId", target = "field.id"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "creatorId", target = "creator.id"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editorId", target = "editor.id"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "presentType", target = "presentType"),
            @Mapping(source = "tempType", target = "tempType"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "minCapacity", target = "minCapacity"),
            @Mapping(source = "organizationId", target = "organization.id"),
            @Mapping(source = "executerId", target = "executer.id"),
            @Mapping(source = "academicId", target = "academic.id"),
            @Mapping(source = "planId", target = "planId"),
            @Mapping(source = "accountId", target = "account.id"),
            @Mapping(source = "totalUnit", target = "totalUnit"),
            @Mapping(source = "thesisUnit", target = "thesisUnit"),
            @Mapping(source = "tunit", target = "tunit"),
            @Mapping(source = "punit", target = "punit"),
            @Mapping(source = "variableName", target = "variableName"),
            @Mapping(source = "certificateTemplateId", target = "certificateTemplateId"),
            @Mapping(source = "executerCapacity", target = "executerCapacity"),
            @Mapping(source = "feeForeign", target = "feeForeign"),
            @Mapping(source = "currencyId", target = "currency.id"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "schedule", target = "schedule"),
            @Mapping(source = "periodOrgFee", target = "periodOrgFee"),
            @Mapping(source = "companyId", target = "company.id"),
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
            @Mapping(source = "cityId", target = "city.id"),
            @Mapping(source = "variableCertificateName", target = "variableCertificateName")
    })
    PeriodEntity PeriodFastDtoToPeriodEntity(PeriodFastDto periodFastDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PeriodFastDto PeriodEntityToPeriodFastDto(PeriodEntity periodEntity, @Context CycleAvoidingMappingContext context);

    List<PeriodFastDto> PeriodEntitiesToPeriodFastDtoes(List<PeriodEntity> periodEntities, @Context CycleAvoidingMappingContext context);

    List<PeriodEntity> PeriodFastDtoesToPeriodEntities(List<PeriodFastDto> periodFastDtos, @Context CycleAvoidingMappingContext context);
}
