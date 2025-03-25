package edu.imi.ir.eduimiws.mapper.attendance;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.attendance.MissionRegistrationDataModelDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.MissionRegistrationDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.MissionRegistrationDataModel;
import edu.imi.ir.eduimiws.utilities.attendance.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {DayOfWeek.class, AcceptanceState.class, MissionName.class, SourceType.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MissionRegistrationDataModelMapper {

    @Named("fromMissionRegistrationDataModel")
    @Mappings({
            @Mapping(source = "id", target = "missionRegistrationId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeekInText"),
            @Mapping(source = "beginDateInText", target = "beginDateInText"),
            @Mapping(source = "beginTimeInText", target = "beginTimeInText"),
            @Mapping(source = "endDateInText", target = "endDateInText"),
            @Mapping(source = "endTimeInText", target = "endTimeInText"),
            @Mapping(source = "missionName", target = "missionNameInText"),
            @Mapping(source = "missionTypeInText", target = "missionType", qualifiedByName = "toMissionType"),
            @Mapping(source = "missionTypeInText", target = "missionTypeInText"),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceStateInText"),
            @Mapping(source = "sourceTypeInText", target = "sourceTypeInText"),
            @Mapping(source = "sourceTypeInText", target = "missionSourceType",
                    qualifiedBy = {MappingUtil.SourceTypeConverter.class,
                            MappingUtil.SourceTypeByName.class}),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeek",
                    qualifiedBy = {MappingUtil.DayOfWeekConverter.class,
                            MappingUtil.DayOfWeekByPersianName.class}),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceState",
                    qualifiedBy = {MappingUtil.AcceptanceStateConverter.class,
                            MappingUtil.AcceptanceStateByName.class}),
            @Mapping(source = "missionName", target = "missionName",
                    qualifiedBy = {MappingUtil.MissionNameConverter.class,
                            MappingUtil.MissionNameByName.class}),
    })
    MissionRegistrationDataModelDto fromMissionRegistrationDataModel(MissionRegistrationDataModel source);

    @IterableMapping(qualifiedByName = "fromMissionRegistrationDataModel")
    List<MissionRegistrationDataModelDto> fromMissionRegistrationDataModels(List<MissionRegistrationDataModel> missionRegistrationDataModels);

    @Named("toMissionRegistrationDataModelResponse")
    @Mappings({
            @Mapping(source = "missionRegistrationId", target = "missionRegistrationId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeek", target = "dayOfWeek"),
            @Mapping(source = "beginDateInText", target = "beginDate"),
            @Mapping(source = "beginTimeInText", target = "beginTime"),
            @Mapping(source = "endDateInText", target = "endDate"),
            @Mapping(source = "endTimeInText", target = "endTime"),
            @Mapping(source = "missionName", target = "missionName"),
            @Mapping(source = "missionType", target = "missionType"),
            @Mapping(source = "acceptanceState", target = "acceptanceState"),
            @Mapping(source = "missionSourceType", target = "missionSourceType")
    })
    MissionRegistrationDataModelResponse toMissionRegistrationDataModelResponse(MissionRegistrationDataModelDto source);

    @IterableMapping(qualifiedByName = "toMissionRegistrationDataModelResponse")
    List<MissionRegistrationDataModelResponse> fromMissionRegistrationDataModelResponses(List<MissionRegistrationDataModelDto> missionRegistrationDataModelDtos);

    @Named("toMissionType")
    default MissionType toMissionType(String missionTypeInString) {
        return MissionType.getMissionTypeByName(missionTypeInString);
    }
}
