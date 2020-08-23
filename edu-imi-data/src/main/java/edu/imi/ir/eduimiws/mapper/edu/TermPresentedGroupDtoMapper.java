package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.*;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedGroupDtoMapper {

    TermPresentedGroupDtoMapper INSTANCE = Mappers.getMapper(TermPresentedGroupDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "assistant.id", target = "assistantId"),
            @Mapping(source = "capacity", target = "capacity"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "ctime", target = "ctime"),
            @Mapping(source = "cunit", target = "cunit"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "groupNumber", target = "groupNumber"),
            @Mapping(source = "licenseProfessorId", target = "licenseProfessorId"),
            @Mapping(source = "professor.id", target = "professorId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "termPresentedCourse.id", target = "termPresentedCourseId")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedGroupDto toTermPresentedGroupDto(TermPresentedGroupEntity termPresentedGroupEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedGroupEntity toTermPresentedGroupEntity(TermPresentedGroupDto termPresentedGroupDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupEntity> toTermPresentedGroupEntities(List<TermPresentedGroupDto> termPresentedGroupDtos,
                                                                @Context CycleAvoidingMappingContext context);

    List<TermPresentedGroupDto> toTermPresentedGroupDtos(List<TermPresentedGroupEntity> termPresentedGroupEntities,
                                                         @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoTermPresentedGroupPublicId(TermPresentedGroupEntity termPresentedGroupEntity,
                                                     @MappingTarget TermPresentedGroupDto termPresentedGroupDto) {

        /**
         * @implNote TermPresentedGroup Public Id
         */
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedGroupApi())) {
            termPresentedGroupEntity.setTermPresentedGroupApi(null);
        }
        if (termPresentedGroupEntity.getTermPresentedGroupApi() != null) {
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getTermPresentedGroupPublicId() != null) {
                termPresentedGroupDto.setTermPresentedGroupPublicId(
                        termPresentedGroupEntity.
                                getTermPresentedGroupApi().
                                getTermPresentedGroupPublicId());
            }
            if (termPresentedGroupEntity.getTermPresentedGroupApi().getId() != null) {
                termPresentedGroupDto.setTermPresentedGroupApiId(
                        termPresentedGroupEntity.
                                getTermPresentedGroupApi().
                                getId());
            }
        }
/**
 * @implNote TermPresentedGroup Professor Public Id
 */

        if (!Hibernate.isInitialized(termPresentedGroupEntity.getProfessor())) {
            termPresentedGroupEntity.setProfessor(null);
        }
        if (termPresentedGroupEntity.getProfessor() != null) {
            ProfessorDto professorDto = new ProfessorDto();
            professorDto.setId(termPresentedGroupEntity.getProfessor().getId());
            professorDto.setFirstName(termPresentedGroupEntity.getProfessor().getFirstName());
            professorDto.setLastName(termPresentedGroupEntity.getProfessor().getLastName());
            termPresentedGroupDto.setProfessorDto(professorDto);
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getProfessor().getProfessorApi())) {
                termPresentedGroupEntity.getProfessor().setProfessorApi(null);
            }
            if (termPresentedGroupEntity.getProfessor().getProfessorApi() != null) {
                termPresentedGroupDto
                        .setProfessorPublicId(
                                termPresentedGroupEntity
                                        .getProfessor()
                                        .getProfessorApi()
                                        .getProfessorPublicId()
                        );
            }
        }

/**
 * @implNote TermPresentedGroup Presented Course Public Id
 */
        if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse())) {
            termPresentedGroupEntity.setTermPresentedCourse(null);
        }
        if (termPresentedGroupEntity.getTermPresentedCourse() != null) {
            TermPresentedCourseDto termPresentedCourseDto = new TermPresentedCourseDto();
            termPresentedCourseDto.setId(termPresentedGroupEntity.getTermPresentedCourse().getId());
            termPresentedGroupDto.setTermPresentedCourseDto(termPresentedCourseDto);
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getTermPresentedCourseApi())) {
                termPresentedGroupEntity.getTermPresentedCourse().setTermPresentedCourseApi(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getTermPresentedCourseApi() != null) {
                termPresentedGroupDto
                        .setTermPresentedCoursePublicId(
                                termPresentedGroupEntity
                                        .getTermPresentedCourse()
                                        .getTermPresentedCourseApi()
                                        .getTrmPresentedCoursePublicId()
                        );
            }


            /**
             * @implNote TermPresentedCourse -> Term Public Id
             */
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getTerm())) {
                termPresentedGroupEntity.getTermPresentedCourse().setTerm(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getTerm() != null) {
                TermDto termDto = new TermDto();
                termDto.setId(termPresentedGroupEntity.getTermPresentedCourse().getTerm().getId());
                termDto.setTermName(termPresentedGroupEntity.getTermPresentedCourse().getTerm().getTermName());
                termPresentedGroupDto.setTermDto(termDto);
                termPresentedGroupDto.setTermId(termDto.getId());

                if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getTerm().getTermApi())) {
                    termPresentedGroupEntity.getTermPresentedCourse().getTerm().setTermApi(null);
                }
                if (termPresentedGroupEntity.getTermPresentedCourse().getTerm().getTermApi() != null) {
                    termPresentedGroupDto
                            .setTermPublicId(
                                    termPresentedGroupEntity
                                            .getTermPresentedCourse()
                                            .getTerm()
                                            .getTermApi()
                                            .getTermPublicId()
                            );
                }
            }


            /**
             * @implNote TermPresentedCourse -> Period Public Id
             */
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getPeriod())) {
                termPresentedGroupEntity.getTermPresentedCourse().setPeriod(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getPeriod() != null) {
                PeriodDto periodDto = new PeriodDto();
                periodDto.setId(termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getId());
                periodDto.setName(termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getName());
                termPresentedGroupDto.setPeriodDto(periodDto);
                termPresentedGroupDto.setPeriodId(periodDto.getId());

                if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getPeriodApi())) {
                    termPresentedGroupEntity.getTermPresentedCourse().getPeriod().setPeriodApi(null);
                }
                if (termPresentedGroupEntity.getTermPresentedCourse().getPeriod().getPeriodApi() != null) {
                    termPresentedGroupDto
                            .setTermPublicId(
                                    termPresentedGroupEntity
                                            .getTermPresentedCourse()
                                            .getPeriod()
                                            .getPeriodApi()
                                            .getPeriodPublicId()
                            );
                }
            }

            /**
             * @implNote TermPresentedCourse -> FieldCourse Public Id
             */
            if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse())) {
                termPresentedGroupEntity.getTermPresentedCourse().setFieldCourse(null);
            }
            if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse() != null) {
                FieldCourseDto fieldCourseDto = new FieldCourseDto();
                fieldCourseDto.setId(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getId());
                termPresentedGroupDto.setFieldCourseDto(fieldCourseDto);
                termPresentedGroupDto.setPeriodId(fieldCourseDto.getId());

                if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getFieldCourseApi())) {
                    termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().setFieldCourseApi(null);
                }
                if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getFieldCourseApi() != null) {
                    termPresentedGroupDto
                            .setTermPublicId(
                                    termPresentedGroupEntity
                                            .getTermPresentedCourse()
                                            .getFieldCourse()
                                            .getFieldCourseApi()
                                            .getFieldCoursePublicId()
                            );
                }

                /**
                 * @implNote TermPresentedCourse -> FieldCourse -> Course Public Id
                 */
                if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse())) {
                    termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().setCourse(null);
                }
                if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse() != null) {
                    CourseDto courseDto = new CourseDto();
                    courseDto.setId(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getId());
                    courseDto.setFname(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getFname());
                    termPresentedGroupDto.setCourseDto(courseDto);
                    termPresentedGroupDto.setCourseId(courseDto.getId());

                    if (!Hibernate.isInitialized(termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getCourseApi())) {
                        termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().setCourseApi(null);
                    }
                    if (termPresentedGroupEntity.getTermPresentedCourse().getFieldCourse().getCourse().getCourseApi() != null) {
                        termPresentedGroupDto
                                .setCoursePublicId(
                                        termPresentedGroupEntity
                                                .getTermPresentedCourse()
                                                .getFieldCourse()
                                                .getCourse()
                                                .getCourseApi()
                                                .getCoursePublicId()
                                );
                    }
                }// close course
            }//close fieldCourse
        }//close termPresentedCourse
    }//close @AfterMapping
}
