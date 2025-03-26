package edu.imi.ir.eduimiws.mapper.attendance;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.attendance.VacationRegistrationDataModelDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.VacationRegistrationDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.VacationRegistrationDataModel;
import edu.imi.ir.eduimiws.utilities.attendance.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {DayOfWeek.class, AcceptanceState.class, VacationName.class, SourceType.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VacationRegistrationDataModelMapper {

    @Named("fromVacationRegistrationDataModel")
    @Mappings({
            @Mapping(source = "id", target = "vacationRegistrationId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeekInText"),
            @Mapping(source = "beginDateInText", target = "beginDateInText"),
            @Mapping(source = "endDateInText", target = "endDateInText"),
            @Mapping(source = "endTimeInText", target = "endTimeInText"),
            @Mapping(source = "vacationName", target = "vacationNameInText"),
            @Mapping(source = "vacationTypeInText", target = "vacationType", qualifiedByName = "toVacationType"),
            @Mapping(source = "vacationTypeInText", target = "vacationTypeInText"),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceStateInText"),
            @Mapping(source = "sourceTypeInText", target = "sourceTypeInText"),
            @Mapping(source = "sourceTypeInText", target = "vacationSourceType",
                    qualifiedBy = {MappingUtil.SourceTypeConverter.class,
                            MappingUtil.SourceTypeByName.class}),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeek",
                    qualifiedBy = {MappingUtil.DayOfWeekConverter.class,
                            MappingUtil.DayOfWeekByPersianName.class}),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceState",
                    qualifiedBy = {MappingUtil.AcceptanceStateConverter.class,
                            MappingUtil.AcceptanceStateByName.class}),
            @Mapping(source = "vacationName", target = "vacationName",
                    qualifiedBy = {MappingUtil.VacationNameConverter.class,
                            MappingUtil.VacationNameByName.class})
    })
    VacationRegistrationDataModelDto fromVacationRegistrationDataModel(VacationRegistrationDataModel source);

    @IterableMapping(qualifiedByName = "fromVacationRegistrationDataModel")
    List<VacationRegistrationDataModelDto> fromVacationRegistrationDataModels(List<VacationRegistrationDataModel> vacationRegistrationDataModels);

    @Named("toVacationRegistrationDataModelResponse")
    @Mappings({
            @Mapping(source = "vacationRegistrationId", target = "vacationRegistrationId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeek", target = "dayOfWeek"),
            @Mapping(source = "beginDateInText", target = "beginDate"),
            @Mapping(source = "beginTimeInText", target = "beginTime"),
            @Mapping(source = "endDateInText", target = "endDate"),
            @Mapping(source = "endTimeInText", target = "endTime"),
            @Mapping(source = "vacationName", target = "vacationName"),
            @Mapping(source = "vacationType", target = "vacationType"),
            @Mapping(source = "acceptanceState", target = "acceptanceState"),
            @Mapping(source = "vacationSourceType", target = "vacationSourceType")
    })
    VacationRegistrationDataModelResponse toVacationRegistrationDataModelResponse(VacationRegistrationDataModelDto source);

    @IterableMapping(qualifiedByName = "toVacationRegistrationDataModelResponse")
    List<VacationRegistrationDataModelResponse> fromVacationRegistrationDataModelResponses(List<VacationRegistrationDataModelDto> vacationRegistrationDataModelDtos);

    @Named("toVacationType")
    default VacationType toVacationType(String vacationTypeInString) {
        return VacationType.getVacationTypeByName(vacationTypeInString);
    }
}
