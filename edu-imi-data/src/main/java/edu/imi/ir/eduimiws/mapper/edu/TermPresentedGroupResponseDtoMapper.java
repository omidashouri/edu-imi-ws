package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedGroupDto;
import edu.imi.ir.eduimiws.models.response.edu.TermPresentedGroupResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedGroupResponseDtoMapper {

    TermPresentedGroupResponseDtoMapper INSTANCE = Mappers.getMapper(TermPresentedGroupResponseDtoMapper.class);

    @Mappings({
//            @Mapping(expression = "java(termPresentedGroupDto.getFirstName() + \" \" + termPresentedGroupDto.getLastName())", target = "assistantName"),
            @Mapping(source = "capacity", target = "capacity"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "cunit", target = "cunit"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "groupNumber", target = "groupNumber"),
            @Mapping(source = "professorPublicId", target = "professorPublicId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "termPresentedCoursePublicId", target = "termPresentedCoursePublicId"),
            @Mapping(source = "termPresentedGroupPublicId", target = "termPresentedGroupPublicId"),
            @Mapping(source = "termPublicId", target = "termPublicId"),
            @Mapping(source = "termDto.termName", target = "termName"),
            @Mapping(source = "assistantPublicId", target = "assistantPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedGroupResponse toTermPresentedGroupResponse(TermPresentedGroupDto termPresentedGroupDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedGroupDto toTermPresentedGroupDto(TermPresentedGroupResponse termPresentedGroupResponse
            , @Context CycleAvoidingMappingContext context);

    @SuppressWarnings("unused")
    List<TermPresentedGroupResponse> toTermPresentedGroupResponses(List<TermPresentedGroupDto> termPresentedGroupDtos,
                                                                   @Context CycleAvoidingMappingContext context);

    @SuppressWarnings("unused")
    List<TermPresentedGroupDto> toTermPresentedGroupDtos(List<TermPresentedGroupResponse> termPresentedGroupResponses,
                                                         @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleTermPresentedGroupResponseNames(TermPresentedGroupDto termPresentedGroupDto,
                                                       @MappingTarget TermPresentedGroupResponse termPresentedGroupResponse) {
//  Professor Name
        if (termPresentedGroupDto.getProfessorDto() != null) {
            termPresentedGroupResponse
                    .setProfessorFullName(
                            termPresentedGroupDto
                                    .getProfessorDto().getFirstName()
                                    + ' ' +
                                    termPresentedGroupDto
                                            .getProfessorDto().getLastName());
            termPresentedGroupResponse
                    .setProfessorPublicId(
                            termPresentedGroupDto.getProfessorPublicId());
        }
//  Assistant Name & Assistant Public Id
        if (termPresentedGroupDto.getAssistantDto() != null) {
            termPresentedGroupResponse
                    .setAssistantName(
                            termPresentedGroupDto
                                    .getAssistantDto().getFirstName()
                                    + ' ' +
                                    termPresentedGroupDto
                                            .getAssistantDto().getLastName());
            termPresentedGroupResponse
                    .setAssistantPublicId(
                            termPresentedGroupDto
                                    .getAssistantDto()
                                    .getProfessorPublicId());
        }
//  Term Name
        if (termPresentedGroupDto.getTermPresentedCourseDto() != null) {
            if (termPresentedGroupDto.getTermPresentedCourseDto().getTermDto() != null) {
                termPresentedGroupResponse
                        .setTermName(
                                termPresentedGroupDto
                                        .getTermPresentedCourseDto()
                                        .getTermDto()
                                        .getTermName()
                        );
                termPresentedGroupResponse
                        .setTermPublicId(
                                termPresentedGroupDto
                                        .getTermDto()
                                        .getTermPublicId()
                        );
            }
//  Period Name
            if (termPresentedGroupDto.getTermPresentedCourseDto().getPeriodDto() != null) {
                termPresentedGroupResponse
                        .setPeriodName(
                                termPresentedGroupDto
                                        .getTermPresentedCourseDto()
                                        .getPeriodDto()
                                        .getName()
                        );
                termPresentedGroupResponse.setPeriodPublicId(
                        termPresentedGroupDto
                                .getPeriodPublicId());
            }
//  FieldCourse -> Course Name
            if (termPresentedGroupDto.getTermPresentedCourseDto().getFieldCourseDto() != null) {
                termPresentedGroupResponse
                        .setFieldCoursePublicId(
                                termPresentedGroupDto
                                        .getFieldCourseDto()
                                        .getFieldCoursePublicId()
                        );
                if (termPresentedGroupDto.getTermPresentedCourseDto().getFieldCourseDto().getCourseDto() != null) {
                    termPresentedGroupResponse
                            .setCourseName(
                                    termPresentedGroupDto
                                            .getTermPresentedCourseDto()
                                            .getFieldCourseDto()
                                            .getCourseDto()
                                            .getFname()
                            );
                    termPresentedGroupResponse
                            .setCoursePublicId(
                                    termPresentedGroupDto
                                            .getTermPresentedCourseDto()
                                            .getFieldCourseDto()
                                            .getCourseDto()
                                            .getCoursePublicId()
                            );
                }//close course
            }//close termPresentedFieldCourse
        }//close termPresentedCourse
    }//close @AfterMapping
}
