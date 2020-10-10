package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.edu.PeriodCourseProfessorResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseProfessorResponseFastDtoMapper {

    PeriodCourseProfessorResponseFastDtoMapper INSTANCE = Mappers
            .getMapper(PeriodCourseProfessorResponseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "periodCourseCourseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "periodCourseEndDate", target = "endDate"),
            @Mapping(source = "periodCourseInAverage", target = "inAverage"),
            @Mapping(source = "periodCourseProfessorPublicId", target = "periodCourseProfessorPublicId"),
            @Mapping(source = "periodCoursePublicId", target = "periodCoursePublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "professorPublicId", target = "professorPublicId"),
            @Mapping(source = "periodCourseScoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "periodCourseScoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "periodCourseScoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "periodCourseScoreHighBound", target = "scoreLowBound"),
            @Mapping(source = "periodCourseScoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "periodCourseScoringWay", target = "scoringWay"),
            @Mapping(source = "periodCourseSessionNumber", target = "sessionNumber"),
            @Mapping(source = "periodCourseStartDate", target = "startDate"),
            @Mapping(source = "periodCourseTime", target = "time"),
            @Mapping(source = "courseFName", target = "courseFName"),
            @Mapping(source = "professorName", target = "professorName"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "periodOfferNumber", target = "periodOfferNumber"),
            @Mapping(source = "fieldCode", target = "fieldCode"),
            @Mapping(source = "fieldFName", target = "fieldFName")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseProfessorResponse toPeriodCourseProfessorResponse(PeriodCourseProfessorFastDto periodCourseProfessorFastDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseProfessorFastDto toPeriodCourseProfessorFastDto(PeriodCourseProfessorResponse periodCourseProfessorResponse
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorFastDto> toPeriodCourseProfessorFastDtos(List<PeriodCourseProfessorResponse> periodCourseProfessorResponses,
                                                                       @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorResponse> toPeriodCourseProfessorResponses(List<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtos,
                                                                         @Context CycleAvoidingMappingContext context);

}
