package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedGroupFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedGroupFastDtoMapper {

    TermPresentedGroupFastDtoMapper INSTANCE = Mappers.getMapper(TermPresentedGroupFastDtoMapper.class);

    @Mappings({
//            @Mapping(source = "assistant.id", target = "assistantId"),
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
    TermPresentedGroupFastDto toTermPresentedGroupFastDto(TermPresentedGroupEntity termPresentedGroupEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedGroupEntity toTermPresentedGroupEntity(TermPresentedGroupFastDto termPresentedGroupFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupEntity> toTermPresentedGroupEntities(List<TermPresentedGroupFastDto> termPresentedGroupFastDtos,
                                                                @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupFastDto> toTermPresentedGroupFastDtos(List<TermPresentedGroupEntity> termPresentedGroupEntities,
                                                                 @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoTermPresentedGroupPublicId(TermPresentedGroupEntity termPresentedGroupEntity,
                                                     @MappingTarget TermPresentedGroupFastDto termPresentedGroupFastDto) {


//        TermPresentedGroup Public Id
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedGroupApi())) {
            termPresentedGroupEntity.setTermPresentedGroupApi(null);
        }
        if (termPresentedGroupEntity.getTermPresentedGroupApi() != null) {
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getTermPresentedGroupPublicId() != null) {
                termPresentedGroupFastDto.setTermPresentedGroupPublicId(termPresentedGroupEntity.getTermPresentedGroupApi()
                        .getTermPresentedGroupPublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getTermPresentedCoursePublicId() != null) {
                termPresentedGroupFastDto.setTermPresentedCoursePublicId(termPresentedGroupEntity.getTermPresentedGroupApi()
                        .getTermPresentedCoursePublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getFieldCoursePublicId() != null) {
                termPresentedGroupFastDto.setFieldCoursePublicId(termPresentedGroupEntity.getTermPresentedGroupApi()
                        .getFieldCoursePublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getPeriodPublicId() != null) {
                termPresentedGroupFastDto.setPeriodPublicId(termPresentedGroupEntity.getTermPresentedGroupApi().getPeriodPublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getTermPublicId() != null) {
                termPresentedGroupFastDto.setTermPublicId(termPresentedGroupEntity.getTermPresentedGroupApi().getTermPublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getProfessorPublicId() != null) {
                termPresentedGroupFastDto.setProfessorPublicId(termPresentedGroupEntity.getTermPresentedGroupApi().getProfessorPublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getCoursePublicId() != null) {
                termPresentedGroupFastDto.setCoursePublicId(termPresentedGroupEntity.getTermPresentedGroupApi().getCoursePublicId());
            }
        }

//      TERM PRESENTED COURSE
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse())) {
            termPresentedGroupEntity.setTermPresentedCourse(null);
        }
        if (termPresentedGroupEntity.getTermPresentedCourse() != null) {
            //        TERM NAME
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getTerm())) {
                termPresentedGroupEntity.getTermPresentedCourse().setTerm(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getTerm() != null) {
                if (termPresentedGroupEntity.getTermPresentedCourse().getTerm().getTermName() != null) {
                    termPresentedGroupFastDto.setTermName(termPresentedGroupEntity.getTermPresentedCourse().getTerm().getTermName());
                }
            }
            //        PERIOD NAME
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getPeriod())) {
                termPresentedGroupEntity.getTermPresentedCourse().setPeriod(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getPeriod() != null) {
                if (termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getName() != null) {
                    termPresentedGroupFastDto.setPeriodName(termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getName());
                }
            }
            //        FIELD COURSE
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse())) {
                termPresentedGroupEntity.getTermPresentedCourse().setFieldCourse(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse() != null) {
                //        COURSE NAME
                if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse())) {
                    termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().setCourse(null);
                }
                if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse() != null) {
                    if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getFname() != null) {
                        termPresentedGroupFastDto.setCourseName(
                                termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getFname());
                    }
                }
            }
        }

//        Professor Full Name;
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getProfessor())) {
            termPresentedGroupEntity.setProfessor(null);
        }
        if (termPresentedGroupEntity.getProfessor() != null) {
            termPresentedGroupFastDto.setProfessorFullName(
                    termPresentedGroupEntity.getProfessor().getFirstName()
                            .concat(" ")
                            .concat(termPresentedGroupEntity.getProfessor().getLastName()));
        }

//  TermPresentedGroup Creator Public Id
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getCreator())) {
            termPresentedGroupEntity.setCreator(null);
        }
        if (termPresentedGroupEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getCreator().getPersonApiEntity())) {
                termPresentedGroupEntity.getCreator().setPersonApiEntity(null);
            }
            if (termPresentedGroupEntity.getCreator().getPersonApiEntity() != null) {
                termPresentedGroupFastDto
                        .setCreatorPublicId(
                                termPresentedGroupEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

        //  TermPresentedGroup Editor Public Id
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getEditor())) {
            termPresentedGroupEntity.setEditor(null);
        }
        if (termPresentedGroupEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getEditor().getPersonApiEntity())) {
                termPresentedGroupEntity.getEditor().setPersonApiEntity(null);
            }
            if (termPresentedGroupEntity.getEditor().getPersonApiEntity() != null) {
                termPresentedGroupFastDto
                        .setEditorPublicId(
                                termPresentedGroupEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
