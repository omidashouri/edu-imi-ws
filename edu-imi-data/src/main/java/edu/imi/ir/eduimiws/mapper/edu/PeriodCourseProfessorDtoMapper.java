package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.*;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseProfessorDtoMapper {

    PeriodCourseProfessorDtoMapper INSTANCE = Mappers.getMapper(PeriodCourseProfessorDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "licenseProfessorId", target = "licenseProfessorId"),
            @Mapping(source = "periodCourse.id", target = "periodCourseId"),
            @Mapping(source = "professorContractId", target = "professorContractId"),
            @Mapping(source = "professor.id", target = "professorId")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseProfessorDto toPeriodCourseProfessorDto(PeriodCourseProfessorEntity periodCourseProfessorEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseProfessorEntity toPeriodCourseProfessorEntity(PeriodCourseProfessorDto periodCourseProfessorDto
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorEntity> toPeriodCourseProfessorEntities(List<PeriodCourseProfessorDto> periodCourseProfessorDtos,
                                                                      @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorDto> toPeriodCourseProfessorDtos(List<PeriodCourseProfessorEntity> periodCourseProfessorEntities,
                                                               @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoPeriodCourseProfessorPublicId(PeriodCourseProfessorEntity periodCourseProfessorEntity,
                                                        @MappingTarget PeriodCourseProfessorDto periodCourseProfessorDto) {

        /**
         * @implNote PeriodCourseProfessor Public Id
         */
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourseProfessorApi())) {
            periodCourseProfessorEntity.setPeriodCourseProfessorApi(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourseProfessorApi() != null) {
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getPriodCoursProfesorPublicId() != null) {
                periodCourseProfessorDto.setPeriodCourseProfessorPublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getPriodCoursProfesorPublicId());
            }
        }
/**
 * @implNote PeriodCourseProfessor PeriodCourse Public Id
 */
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse())) {
            periodCourseProfessorEntity.setPeriodCourse(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourse() != null) {
            PeriodCourseDto periodCourseDto = new PeriodCourseDto();
            periodCourseDto.setId(periodCourseProfessorEntity.getPeriodCourse().getId());
            periodCourseProfessorDto.setPeriodCourseDto(periodCourseDto);
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getPeriodCourseApi())) {
                periodCourseProfessorEntity.getPeriodCourse().setPeriodCourseApi(null);
            }
            if (periodCourseProfessorEntity.getPeriodCourse().getPeriodCourseApi() != null) {
                periodCourseProfessorDto
                        .setPeriodCoursePublicId(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriodCourseApi()
                                        .getPeriodCoursePublicId()
                        );
            }
        }

        /**
         * @implNote PeriodCourseProfessor Period Public Id
         */
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getPeriod())) {
            periodCourseProfessorEntity.getPeriodCourse().setPeriod(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourse().getPeriod() != null) {
            PeriodDto periodDto = new PeriodDto();
            periodDto.setId(periodCourseProfessorEntity.getPeriodCourse().getPeriod().getId());
            periodCourseProfessorDto.getPeriodCourseDto().setPeriodDto(periodDto);
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getPeriod().getPeriodApi())) {
                periodCourseProfessorEntity.getPeriodCourse().getPeriod().setPeriodApi(null);
            }
            if (periodCourseProfessorEntity.getPeriodCourse().getPeriod().getPeriodApi() != null) {
                periodCourseProfessorDto
                        .setPeriodPublicId(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getPeriodApi()
                                        .getPeriodPublicId()
                        );
            }
        }


        /**
         * @implNote PeriodCourseProfessor Course Public Id
         */
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getCourse())) {
            periodCourseProfessorEntity.getPeriodCourse().setCourse(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourse().getCourse() != null) {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(periodCourseProfessorEntity.getPeriodCourse().getCourse().getId());
            periodCourseProfessorDto.getPeriodCourseDto().setCourseDto(courseDto);
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getCourse().getCourseApi())) {
                periodCourseProfessorEntity.getPeriodCourse().getCourse().setCourseApi(null);
            }
            if (periodCourseProfessorEntity.getPeriodCourse().getCourse().getCourseApi() != null) {
                periodCourseProfessorDto
                        .setCoursePublicId(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getCourse()
                                        .getCourseApi()
                                        .getCoursePublicId()
                        );
            }
        }


        /**
         * @implNote PeriodCourseProfessor Professor Public Id
         */
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getProfessor())) {
            periodCourseProfessorEntity.setProfessor(null);
        }
        if (periodCourseProfessorEntity.getProfessor() != null) {
            ProfessorDto professorDto = new ProfessorDto();
            professorDto.setId(periodCourseProfessorEntity.getProfessor().getId());
            periodCourseProfessorDto.setProfessorDto(professorDto);
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getProfessor().getProfessorApi())) {
                periodCourseProfessorEntity.getProfessor().setProfessorApi(null);
            }
            if (periodCourseProfessorEntity.getProfessor().getProfessorApi() != null) {
                periodCourseProfessorDto
                        .setProfessorPublicId(
                                periodCourseProfessorEntity
                                        .getProfessor()
                                        .getProfessorApi()
                                        .getProfessorPublicId()
                        );
            }
        }
    }
}
