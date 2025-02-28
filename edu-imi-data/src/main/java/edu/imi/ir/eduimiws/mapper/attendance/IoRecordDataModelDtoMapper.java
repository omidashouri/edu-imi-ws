package edu.imi.ir.eduimiws.mapper.attendance;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.attendance.IoRecordDataModelDto;
import edu.imi.ir.eduimiws.models.response.attendance.response.IoRecordDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.IoRecordDataModel;
import edu.imi.ir.eduimiws.utilities.attendance.AcceptanceState;
import edu.imi.ir.eduimiws.utilities.attendance.DayOfWeek;
import edu.imi.ir.eduimiws.utilities.attendance.IoSourceType;
import edu.imi.ir.eduimiws.utilities.attendance.RecordIoType;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {DayOfWeek.class, RecordIoType.class, AcceptanceState.class, IoSourceType.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IoRecordDataModelDtoMapper {

    @Named("fromIoRecordDataModel")
    @Mappings({
            @Mapping(source = "id", target = "ioRecordId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeekInText"),
            @Mapping(source = "finalDateInText", target = "finalDateInText"),
            @Mapping(source = "finalTimeInText", target = "finalTimeInText"),
            @Mapping(source = "finalRecordIoTypeInText", target = "finalRecordIoTypeInText"),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceStateInText"),
            @Mapping(source = "ioSourceTypeInText", target = "ioSourceTypeInText"),
            @Mapping(source = "dayOfWeekInText", target = "dayOfWeek",
                    qualifiedBy = {MappingUtil.DayOfWeekConverter.class,
                            MappingUtil.DayOfWeekByPersianName.class}),
            @Mapping(source = "finalRecordIoTypeInText", target = "recordIoType",
                    qualifiedBy = {MappingUtil.RecordIoTypeConverter.class,
                            MappingUtil.RecordIoTypeByName.class}),
            @Mapping(source = "acceptanceStateInText", target = "acceptanceState",
                    qualifiedBy = {MappingUtil.AcceptanceStateConverter.class,
                            MappingUtil.AcceptanceStateByName.class}),
            @Mapping(source = "ioSourceTypeInText", target = "ioSourceType",
                    qualifiedBy = {MappingUtil.IoSourceTypeConverter.class,
                            MappingUtil.IoSourceTypeByName.class}),
    })
    IoRecordDataModelDto fromIoRecordDataModel(IoRecordDataModel source);

    @IterableMapping(qualifiedByName = "fromIoRecordDataModel")
    List<IoRecordDataModelDto> fromIoRecordDataModels(List<IoRecordDataModel> ioRecordDataModels);

    @Named("toIoRecordDataModelResponse")
    @Mappings({
            @Mapping(source = "ioRecordId", target = "ioRecordId"),
            @Mapping(source = "employeeCode", target = "employeeCode"),
            @Mapping(source = "businessPartnerId", target = "businessPartnerId"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "dayOfWeek", target = "dayOfWeek"),
            @Mapping(source = "finalDateInText", target = "jalaliDate"),
            @Mapping(source = "finalTimeInText", target = "time"),
            @Mapping(source = "recordIoType", target = "recordIoType"),
            @Mapping(source = "acceptanceState", target = "acceptanceState"),
            @Mapping(source = "ioSourceType", target = "ioSourceType")
    })
    IoRecordDataModelResponse toIoRecordDataModelResponse(IoRecordDataModelDto source);

    @IterableMapping(qualifiedByName = "toIoRecordDataModelResponse")
    List<IoRecordDataModelResponse> fromIoRecordDataModelResponses(List<IoRecordDataModelDto> IoRecordDataModelDtos);
}
