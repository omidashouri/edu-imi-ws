package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {java.lang.StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodProjectionCustomTwoMapper {

    @Named("periodProjectionCustomTwoToPeriodProjectionCustomTwoDto")
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
            @Mapping(source = "fieldCode", target = "fieldCode"),
            @Mapping(source = "fieldName", target = "fieldFName"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "holdingType", target = "holdingType"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelDescription", target = "levelDescription"),
            @Mapping(source = "maxCapacity", target = "maxCapacity"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "schedule", target = "schedule"),
            @Mapping(source = "totalUnit", target = "totalUnit"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "type", target = "type")

    })
    PeriodProjectionCustomTwoDto periodProjectionCustomTwoToPeriodProjectionCustomTwoDto(PeriodProjectionCustomTwo source);

    @IterableMapping(qualifiedByName = "periodProjectionCustomTwoToPeriodProjectionCustomTwoDto")
    List<PeriodProjectionCustomTwoDto> periodEntitiesToPeriodProjectionCustomTwoDtos(List<PeriodProjectionCustomTwo> sources);
}
