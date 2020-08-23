package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldCourseDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodDto;
import edu.imi.ir.eduimiws.models.dto.edu.TermDto;
import edu.imi.ir.eduimiws.models.dto.edu.TermPresentedCourseDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermPresentedCourseDtoMapper {

    TermPresentedCourseDtoMapper INSTANCE = Mappers.getMapper(TermPresentedCourseDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "fieldCourse.id", target = "fieldCourseId"),
            @Mapping(source = "period.id", target = "periodId"),
            @Mapping(source = "term.id", target = "termId"),
            @Mapping(source = "time", target = "time")
    })
    @BeanMapping(ignoreByDefault = true)
    TermPresentedCourseDto toTermPresentedCourseDto(TermPresentedCourseEntity termPresentedCourseEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermPresentedCourseEntity toTermPresentedCourseEntity(TermPresentedCourseDto termPresentedCourseDto
            , @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseEntity> toTermPresentedCourseEntities(List<TermPresentedCourseDto> termPresentedCourseDtos,
                                                                  @Context CycleAvoidingMappingContext context);

    List<TermPresentedCourseDto> toTermPresentedCourseDtos(List<TermPresentedCourseEntity> termPresentedCourseEntities,
                                                           @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoTermPresentedCoursePublicId(TermPresentedCourseEntity termPresentedCourseEntity,
                                                      @MappingTarget TermPresentedCourseDto termPresentedCourseDto) {

        /**
         * @implNote TermPresentedCourse Public Id
         */
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getTermPresentedCourseApi())) {
            termPresentedCourseEntity.setTermPresentedCourseApi(null);
        }
        if (termPresentedCourseEntity.getTermPresentedCourseApi() != null) {
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getTrmPresentedCoursePublicId() != null) {
                termPresentedCourseDto.setTermPresentedCoursePublicId(termPresentedCourseEntity.getTermPresentedCourseApi().getTrmPresentedCoursePublicId());
            }
            if (termPresentedCourseEntity.getTermPresentedCourseApi().getId() != null) {
                termPresentedCourseDto.setTermPresentedCourseApiId(termPresentedCourseEntity.getTermPresentedCourseApi().getId());
            }
        }

/**
 * @implNote TermPresentedCourse Term Public Id
 */
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getTerm())) {
            termPresentedCourseEntity.setTerm(null);
        }
        if (termPresentedCourseEntity.getTerm() != null) {
            TermDto termDto = new TermDto();
            termDto.setId(termPresentedCourseEntity.getTerm().getId());
            termDto.setTermName(termPresentedCourseEntity.getTerm().getTermName());
            termPresentedCourseDto.setTermDto(termDto);
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getTerm().getTermApi())) {
                termPresentedCourseEntity.getTerm().setTermApi(null);
            }
            if (termPresentedCourseEntity.getTerm().getTermApi() != null) {
                termPresentedCourseDto
                        .setTermPublicId(
                                termPresentedCourseEntity
                                        .getTerm()
                                        .getTermApi()
                                        .getTermPublicId()
                        );
            }
        }

        /**
         * @implNote TermPresentedCourse FieldCourse Public Id
         */
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse())) {
            termPresentedCourseEntity.setFieldCourse(null);
        }
        if (termPresentedCourseEntity.getFieldCourse() != null) {
            FieldCourseDto fieldCourseDto = new FieldCourseDto();
            fieldCourseDto.setId(termPresentedCourseEntity.getFieldCourse().getId());
            termPresentedCourseDto.setFieldCourseDto(fieldCourseDto);
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse().getFieldCourseApi())) {
                termPresentedCourseEntity.getFieldCourse().setFieldCourseApi(null);
            }
            if (termPresentedCourseEntity.getFieldCourse().getFieldCourseApi() != null) {
                termPresentedCourseDto
                        .setFieldCoursePublicId(
                                termPresentedCourseEntity
                                        .getFieldCourse()
                                        .getFieldCourseApi()
                                        .getFieldCoursePublicId()
                        );
            }

            /**
             * @implNote TermPresentedCourse -> FieldCourse -> Course Public Id
             */
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse().getCourse())) {
                termPresentedCourseEntity.getFieldCourse().setCourse(null);
            }
            if (termPresentedCourseEntity.getFieldCourse().getCourse() != null) {
                if (!Hibernate.isInitialized(termPresentedCourseEntity.getFieldCourse().getCourse().getCourseApi())) {
                    termPresentedCourseEntity.getFieldCourse().getCourse().setCourseApi(null);
                }
                if (termPresentedCourseEntity.getFieldCourse().getCourse().getCourseApi() != null) {
                    termPresentedCourseDto
                            .setCoursePublicId(
                                    termPresentedCourseEntity
                                            .getFieldCourse()
                                            .getCourse()
                                            .getCourseApi()
                                            .getCoursePublicId()
                            );
                }
            }
        }

        /**
         * @implNote TermPresentedCourse Period Public Id
         */
        if (!Hibernate.isInitialized(termPresentedCourseEntity.getPeriod())) {
            termPresentedCourseEntity.setPeriod(null);
        }
        if (termPresentedCourseEntity.getPeriod() != null) {
            PeriodDto periodDto = new PeriodDto();
            periodDto.setId(termPresentedCourseEntity.getPeriod().getId());
            periodDto.setName(termPresentedCourseEntity.getPeriod().getName());
            termPresentedCourseDto.setPeriodDto(periodDto);
            if (!Hibernate.isInitialized(termPresentedCourseEntity.getPeriod().getPeriodApi())) {
                termPresentedCourseEntity.getPeriod().setPeriodApi(null);
            }
            if (termPresentedCourseEntity.getPeriod().getPeriodApi() != null) {
                termPresentedCourseDto
                        .setPeriodPublicId(
                                termPresentedCourseEntity
                                        .getPeriod()
                                        .getPeriodApi()
                                        .getPeriodPublicId()
                        );
            }
        }
    }
}
