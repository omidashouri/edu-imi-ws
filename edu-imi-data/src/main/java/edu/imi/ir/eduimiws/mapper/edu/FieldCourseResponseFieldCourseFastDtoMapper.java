package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseFastDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldCourseResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FieldCourseResponseFieldCourseFastDtoMapper {

    FieldCourseResponseFieldCourseFastDtoMapper INSTANCE = Mappers.getMapper(FieldCourseResponseFieldCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "fieldCoursePublicId", target = "fieldCoursePublicId"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "creatorPublicID", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "courseName", target = "courseName"),
            @Mapping(source = "fieldName", target = "fieldName"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "courseTypeId", target = "courseTypeId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "tunit", target = "tunit")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldCourseFastDto toFieldCourseFastDto(FieldCourseResponse fieldCourseResponse
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldCourseResponse toFieldCourseResponse(FieldCourseFastDto fieldCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<FieldCourseResponse> toFieldCourseResponses(List<FieldCourseFastDto> fieldCourseFastDtos,
                                                     @Context CycleAvoidingMappingContext context);

    List<FieldCourseFastDto> toFieldCourseFastDtos(List<FieldCourseResponse> fieldCourseResponses,
                                                   @Context CycleAvoidingMappingContext context);

}
