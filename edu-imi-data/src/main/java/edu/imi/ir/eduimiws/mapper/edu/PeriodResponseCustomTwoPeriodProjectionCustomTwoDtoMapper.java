package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodProjectionCustomTwoDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseCustomTwo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {String.class, Long.class},
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
            @Mapping(target = "periodFee",
                    expression = "java(" +
                            "(source.getType()!=null && source.getType().equalsIgnoreCase(\"termic\")) ? Long.sum(" +
                            "source.getFeeEquivalentFixed(),source.getFeeEquivalentVariable()) : source.getFee())"),
            @Mapping(source = "onlineRegCostPercent", target = "periodDiscount"),
            @Mapping(source = "fieldCode", target = "fieldCode"),
            @Mapping(source = "fieldFName", target = "fieldName"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "holdingType", target = "periodHoldingType"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "levelDescription", target = "levelTitle"),
            @Mapping(source = "maxCapacity", target = "periodMaxCapacity"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(target = "periodName", expression = "java((source.getName()!=null && source.getName().contains(\" نام نوبت \"))?source.getName().replace(\" نام نوبت \",\" نوبت \"):(source.getName()!=null && source.getName().contains(\" نام  نوبت \"))?source.getName().replace(\" نام  نوبت \",\" نوبت \"):source.getName())"),
            @Mapping(source = "offerNumber", target = "offerNumber"),
            @Mapping(source = "regEndDate", target = "registerEndDate"),
            @Mapping(source = "regStartDate", target = "registerStartDate"),
            @Mapping(source = "startDate", target = "periodStartDate"),
            @Mapping(source = "schedule", target = "periodSchedule"),
            @Mapping(source = "totalUnit", target = "periodTotalUnit"),
            @Mapping(source = "periodId", target = "periodId"),
            @Mapping(source = "type", target = "periodType")

    })
    PeriodResponseCustomTwo periodProjectionCustomTwoToPeriodResponseCustomTwoDto(PeriodProjectionCustomTwoDto source);

    @IterableMapping(qualifiedByName = "PeriodProjectionCustomTwoToPeriodProjectionCustomTwoDto")
    List<PeriodResponseCustomTwo> periodEntitiesToPeriodResponseCustomTwoDtos(List<PeriodProjectionCustomTwoDto> sources);

    @AfterMapping
    default void handlePeriodFeeDiscount(@MappingTarget PeriodResponseCustomTwo target, PeriodProjectionCustomTwoDto source) {
        if (source.getOnlineRegCostPercent() != null && source.getOnlineRegCostPercent() > 0 && source.getOnlineRegCostPercent() <= 100) {
            if (target.getPeriodFee() != null && target.getPeriodFee() > 0)
                target.setPeriodDiscountFee(target.getPeriodFee().doubleValue() * (1-(source.getOnlineRegCostPercent().doubleValue()/100)));
        }
    }
}
