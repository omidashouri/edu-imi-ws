package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedCourseFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedCourseFastDtoMapper {

    TermPresentedCourseFastDtoMapper INSTANCE = Mappers.getMapper(TermPresentedCourseFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "time", target = "time")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedCourseFastDto toTermPresentedCourseFastDto(TermPresentedCourseEntity termPresentedCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedCourseEntity toTermPresentedCourseEntity(TermPresentedCourseFastDto termPresentedCourseFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseEntity> toTermPresentedCourseEntities(List<TermPresentedCourseFastDto> termPresentedCourseFastDtos,
                                                                  @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseFastDto> toTermPresentedCourseFastDtos(List<TermPresentedCourseEntity> termPresentedCourseEntities,
                                                                   @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoTermPresentedCoursePublicId(TermPresentedCourseEntity termPresentedCourseEntity,
                                                      @MappingTarget TermPresentedCourseFastDto termPresentedCourseFastDto) {


//        TermPresentedCourse Public Id
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getTermPresentedCourseApi())) {
            termPresentedCourseEntity.setTermPresentedCourseApi(null);
        }
        if (termPresentedCourseEntity.getTermPresentedCourseApi() != null) {
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getTrmPresentedCoursePublicId() != null) {
                termPresentedCourseFastDto.setTermPresentedCoursePublicId(termPresentedCourseEntity
                        .getTermPresentedCourseApi().getTrmPresentedCoursePublicId());
            }
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getCoursePublicId() != null) {
                termPresentedCourseFastDto.setCoursePublicId(termPresentedCourseEntity
                        .getTermPresentedCourseApi().getCoursePublicId());
            }
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getTermPublicId() != null) {
                termPresentedCourseFastDto.setTermPublicId(termPresentedCourseEntity
                        .getTermPresentedCourseApi().getTermPublicId());
            }
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getFieldCoursePublicId() != null) {
                termPresentedCourseFastDto.setFieldCoursePublicId(termPresentedCourseEntity
                        .getTermPresentedCourseApi().getFieldCoursePublicId());
            }
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getPeriodPublicId() != null) {
                termPresentedCourseFastDto.setPeriodPublicId(termPresentedCourseEntity
                        .getTermPresentedCourseApi().getPeriodPublicId());
            }
        }

//        Course Name
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse())) {
            termPresentedCourseEntity.setFieldCourse(null);
        }
        if (termPresentedCourseEntity.getFieldCourse() != null) {
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse().getCourse())) {
                termPresentedCourseEntity.getFieldCourse().setCourse(null);
            }
            if (termPresentedCourseEntity.getFieldCourse().getCourse() != null) {
                termPresentedCourseFastDto.setCourseName(termPresentedCourseEntity
                        .getFieldCourse().getCourse().getFname());
            }
        }

//        Term Name
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getTerm())) {
            termPresentedCourseEntity.setTerm(null);
        }
        if (termPresentedCourseEntity.getTerm() != null) {
            if (termPresentedCourseEntity.getTerm().getTermName() != null) {
                termPresentedCourseFastDto.setTermName(termPresentedCourseEntity.getTerm().getTermName());
            }
        }

//        Period Name
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getPeriod())) {
            termPresentedCourseEntity.setPeriod(null);
        }
        if (termPresentedCourseEntity.getPeriod() != null) {
            if (termPresentedCourseEntity.getPeriod().getName() != null) {
                termPresentedCourseFastDto.setPeriodName(termPresentedCourseEntity.getPeriod().getName());
            }
        }

//  TermPresentedCourse Creator Public Id
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getCreator())) {
            termPresentedCourseEntity.setCreator(null);
        }
        if (termPresentedCourseEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getCreator().getPersonApiEntity())) {
                termPresentedCourseEntity.getCreator().setPersonApiEntity(null);
            }
            if (termPresentedCourseEntity.getCreator().getPersonApiEntity() != null) {
                termPresentedCourseFastDto
                        .setCreatorPublicId(
                                termPresentedCourseEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

        //  TermPresentedCourse Editor Public Id
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getEditor())) {
            termPresentedCourseEntity.setEditor(null);
        }
        if (termPresentedCourseEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getEditor().getPersonApiEntity())) {
                termPresentedCourseEntity.getEditor().setPersonApiEntity(null);
            }
            if (termPresentedCourseEntity.getEditor().getPersonApiEntity() != null) {
                termPresentedCourseFastDto
                        .setEditorPublicId(
                                termPresentedCourseEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
