package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedGroupFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedGroupResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedGroupResponseTermPresentedGroupFastDtoMapper {

    TermPresentedGroupResponseTermPresentedGroupFastDtoMapper INSTANCE = Mappers
            .getMapper(TermPresentedGroupResponseTermPresentedGroupFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "termPresentedGroupPublicId", target = "termPresentedGroupPublicId"),
            @Mapping(source = "termPresentedCoursePublicId", target = "termPresentedCoursePublicId"),
            @Mapping(source = "fieldCoursePublicId", target = "fieldCoursePublicId"),
            @Mapping(source = "coursePublicId", target = "coursePublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "professorPublicId", target = "professorPublicId"),
            @Mapping(source = "termPublicId", target = "termPublicId"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "courseName", target = "courseName"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "professorFullName", target = "professorFullName"),
            @Mapping(source = "termName", target = "termName"),
            @Mapping(source = "capacity", target = "capacity"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "cunit", target = "cunit"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "groupNumber", target = "groupNumber"),
            @Mapping(source = "licenseProfessorId", target = "licenseProfessorId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "startDate", target = "startDate")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedGroupFastDto toTermPresentedGroupFastDto(TermPresentedGroupResponse termPresentedGroupResponse
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedGroupResponse toTermPresentedGroupResponse(TermPresentedGroupFastDto termPresentedGroupFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupResponse> toTermPresentedGroupResponses(List<TermPresentedGroupFastDto> termPresentedGroupFastDtos,
                                                                   @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupFastDto> toTermPresentedGroupFastDtos(List<TermPresentedGroupResponse> termPresentedGroupResponses,
                                                                 @Context CycleAvoidingMappingContext context);

}
