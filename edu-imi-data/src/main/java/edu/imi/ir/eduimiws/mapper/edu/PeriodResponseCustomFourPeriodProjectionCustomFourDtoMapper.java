package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomFourDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomFour;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomFour;
import org.mapstruct.*;

import java.util.List;
//___periodfour
@Mapper(componentModel = "spring",
        imports = {StringBuilder.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodResponseCustomFourPeriodProjectionCustomFourDtoMapper {

    @Named("periodProjectionCustomFourDtoToPeriodResponseCustomFour")
    @Mappings({
            @Mapping(source = "activityStatus", target = "periodActivityStatus"),
            @Mapping(source = "canRegisterOnline", target = "periodCanRegisterOnline"),
            @Mapping(source = "deleteStatus", target = "periodDeleteStatus"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "eduCategoryTitle", target = "eduCategoryTitle"),
            @Mapping(source = "endDate", target = "periodEndDate"),
            @Mapping(source = "executorFirstName", target = "executorFirstName"),
            @Mapping(source = "executorLastName", target = "executorLastName"),
            @Mapping(target = "executorFullName",
                    expression = "java((new StringBuilder()).append(source.getExecutorFirstName()).append(' ').append(" +
                            "source.getExecutorLastName()).toString())"),
            @Mapping(source = "fee", target = "periodFee"),
            @Mapping(source = "onlineRegCostPercent", target = "periodDiscountFee"),
//            @Mapping(source = "feeEquivalentFixed", target = "feeEquivalentFixed"),
//            @Mapping(source = "feeEquivalentVariable", target = "feeEquivalentVariable"),
            @Mapping(source = "fieldCode", target = "fieldCode"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "holdingType", target = "periodHoldingType"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelTitle", target = "levelTitle"),
            @Mapping(source = "maxCapacity", target = "periodMaxCapacity"),
            @Mapping(source = "name", target = "periodName"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "registerEndDate"),
            @Mapping(source = "regStartDate", target = "registerStartDate"),
            @Mapping(source = "startDate", target = "periodStartDate"),
            @Mapping(source = "schedule", target = "periodSchedule"),
            @Mapping(source = "totalUnit", target = "periodTotalUnit"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "type", target = "periodType"),
            @Mapping(source = "planId", target = "planId"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "depositPublicId", target = "depositPublicId"),


    })
    @BeanMapping(ignoreByDefault = true)
    PeriodResponseCustomFour periodProjectionCustomFourDtoToPeriodResponseCustomFour(PeriodProjectionCustomFourDto source);

    @IterableMapping(qualifiedByName = "periodProjectionCustomFourDtoToPeriodResponseCustomFour")
    List<PeriodResponseCustomFour> periodProjectionCustomFourDtoToPeriodResponseCustomFours(List<PeriodProjectionCustomFourDto> sources);
}
