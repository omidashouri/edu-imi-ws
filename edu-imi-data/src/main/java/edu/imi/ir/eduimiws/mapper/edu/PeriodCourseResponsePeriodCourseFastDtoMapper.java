package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseResponsePeriodCourseFastDtoMapper {

    PeriodCourseResponsePeriodCourseFastDtoMapper INSTANCE = Mappers
            .getMapper(PeriodCourseResponsePeriodCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "inAverage", target = "inAverage"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "sessionNumber", target = "sessionNumber"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "periodCoursePublicId", target = "periodCoursePublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "courseName", target = "courseName"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "time", target = "time")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseResponse toPeriodCourseResponse(PeriodCourseFastDto periodCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseFastDto toPeriodCourseFastDto(PeriodCourseResponse periodCourseResponse,
                                              @Context CycleAvoidingMappingContext context);

    List<PeriodCourseFastDto> toPeriodCourseFastDtos(List<PeriodCourseResponse> periodCourseResponses,
                                                     @Context CycleAvoidingMappingContext context);

    List<PeriodCourseResponse> toPeriodCourseResponses(List<PeriodCourseFastDto> periodCourseFastDtos,
                                                       @Context CycleAvoidingMappingContext context);
}
