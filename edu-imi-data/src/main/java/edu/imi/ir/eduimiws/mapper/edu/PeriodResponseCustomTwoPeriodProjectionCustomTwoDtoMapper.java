package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomTwo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodResponseCustomTwoPeriodProjectionCustomTwoDtoMapper {

    @Named("PeriodProjectionCustomTwoToPeriodProjectionCustomTwoDto")
    @Mappings({
            @Mapping(source = "activityStatus", target = "periodActivityStatus"),
            @Mapping(source = "canRegisterOnline", target = "periodCanRegisterOnline"),
            @Mapping(source = "deleteStatus", target = "periodDeleteStatus"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "eduCategoryTitle", target = "eduCategoryTitle"),
            @Mapping(source = "endDate", target = "periodEndDate"),
            @Mapping(source = "executorFirstName", target = "executorFirstName"),
            @Mapping(source = "executorLastName", target = "executorLastName"),
            @Mapping(source = "executorFullName", target = "executorFullName"),
            @Mapping(source = "fee", target = "periodFee"),
            @Mapping(source = "fieldCode", target = "fieldCode"),
            @Mapping(source = "fieldFName", target = "fieldName"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "holdingType", target = "periodHoldingType"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelDescription", target = "levelTitle"),
            @Mapping(source = "maxCapacity", target = "periodMaxCapacity"),
            @Mapping(source = "name", target = "periodName"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "registerEndDate"),
            @Mapping(source = "regStartDate", target = "registerStartDate"),
            @Mapping(source = "startDate", target = "periodStartDate"),
            @Mapping(source = "schedule", target = "periodSchedule"),
            @Mapping(source = "totalUnit", target = "periodTotalUnit"),
            @Mapping(source = "type", target = "periodType")

    })
    PeriodResponseCustomTwo periodProjectionCustomTwoToPeriodResponseCustomTwoDto(PeriodProjectionCustomTwoDto source);

    @IterableMapping(qualifiedByName = "PeriodProjectionCustomTwoToPeriodProjectionCustomTwoDto")
    List<PeriodResponseCustomTwo> periodEntitiesToPeriodResponseCustomTwoDtos(List<PeriodProjectionCustomTwoDto> sources);
}
