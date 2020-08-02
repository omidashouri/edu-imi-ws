package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface PeriodResponsePeriodFastDtoMapper {

    PeriodResponsePeriodFastDtoMapper INSTANCE = Mappers.getMapper(PeriodResponsePeriodFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "executorPublicId", target = "executorPublicId"),
//            for Descriptive (begin):
            @Mapping(source = "fieldFName", target = "fieldFName"),
            @Mapping(source = "fieldLName", target = "fieldLName"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "eduCategoryTitle", target = "eduCategoryTitle"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelDescription", target = "levelDescription"),
//            for Descriptive (end):
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "executorFullName", target = "executorFullName"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "holdingLanguage", target = "holdingLanguage"),
            @Mapping(source = "holdingType", target = "holdingType"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "minCapacity", target = "minCapacity"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "offerNumber", target = "offerNumber")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodResponse toPeriodResponse(PeriodFastDto PeriodFastDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodFastDto toPeriodFastDto(PeriodResponse PeriodResponse, @Context CycleAvoidingMappingContext context);

    List<PeriodResponse> toPeriodResponses(List<PeriodFastDto> PeriodFastDtos, @Context CycleAvoidingMappingContext context);

    List<PeriodFastDto> toPeriodFastDtos(List<PeriodResponse> PeriodResponses, @Context CycleAvoidingMappingContext context);

}
