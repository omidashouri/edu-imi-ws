package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomFourDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomFour;
import org.mapstruct.*;

import java.util.List;
//___periodfour
@Mapper(componentModel = "spring",
        imports = {StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodProjectionCustomFourMapper {

    @Named("periodProjectionCustomFourToPeriodProjectionCustomFourDto")
    @Mappings({
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "canRegisterOnline", target = "canRegisterOnline"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "eduCategoryTitle", target = "eduCategoryTitle"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "executorFirstName", target = "executorFirstName"),
            @Mapping(source = "executorLastName", target = "executorLastName"),
            @Mapping(target = "executorFullName",
                    expression = "java((new StringBuilder()).append(source.getExecutorFirstName()).append(' ').append(" +
                            "source.getExecutorLastName()).toString())"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "onlineRegCostPercent", target = "onlineRegCostPercent"),
            @Mapping(source = "feeEquivalentFixed", target = "feeEquivalentFixed"),
            @Mapping(source = "feeEquivalentVariable", target = "feeEquivalentVariable"),
            @Mapping(source = "code", target = "fieldCode"),
            @Mapping(source = "FName", target = "fieldName"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "holdingType", target = "holdingType"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelTitle", target = "levelTitle"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "schedule", target = "schedule"),
            @Mapping(source = "totalUnit", target = "totalUnit"),
            @Mapping(source = "id", target = "periodId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "publicId", target = "depositPublicId"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "planId", target = "planId")

    })
    PeriodProjectionCustomFourDto periodProjectionCustomFourToPeriodProjectionCustomFourDto(PeriodProjectionCustomFour source);

    @IterableMapping(qualifiedByName = "periodProjectionCustomFourToPeriodProjectionCustomFourDto")
    List<PeriodProjectionCustomFourDto> periodProjectionCustomFourToPeriodProjectionCustomFourDtos(List<PeriodProjectionCustomFour> sources);
}
