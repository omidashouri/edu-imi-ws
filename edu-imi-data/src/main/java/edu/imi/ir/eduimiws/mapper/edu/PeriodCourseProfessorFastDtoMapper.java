package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCourseProfessorFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeriodCourseProfessorFastDtoMapper {

    PeriodCourseProfessorFastDtoMapper INSTANCE = Mappers.getMapper(PeriodCourseProfessorFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "licenseProfessorId", target = "licenseProfessorId"),
            @Mapping(source = "professorContractId", target = "professorContractId")
    })
    @BeanMapping(ignoreByDefault = true)
    PeriodCourseProfessorFastDto toPeriodCourseProfessorFastDto(PeriodCourseProfessorEntity periodCourseProfessorEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PeriodCourseProfessorEntity toPeriodCourseProfessorEntity(PeriodCourseProfessorFastDto periodCourseProfessorFastDto
            , @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorEntity> toPeriodCourseProfessorEntities(List<PeriodCourseProfessorFastDto> periodCourseProfessorFastDtos,
                                                                      @Context CycleAvoidingMappingContext context);

    List<PeriodCourseProfessorFastDto> toPeriodCourseProfessorFastDtos(List<PeriodCourseProfessorEntity> periodCourseProfessorEntities,
                                                                       @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleFastDtoPeriodCourseProfessorPublicId(PeriodCourseProfessorEntity periodCourseProfessorEntity,
                                                            @MappingTarget PeriodCourseProfessorFastDto periodCourseProfessorFastDto) {


        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourseProfessorApi())) {
            periodCourseProfessorEntity.setPeriodCourseProfessorApi(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourseProfessorApi() != null) {
            //  PeriodCourseProfessor Public Id
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getPriodCoursProfesorPublicId() != null) {
                periodCourseProfessorFastDto.setPeriodCourseProfessorPublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getPriodCoursProfesorPublicId());
            }
            //  PeriodCourse Public Id
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getPeriodCoursePublicId() != null) {
                periodCourseProfessorFastDto.setPeriodCoursePublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getPeriodCoursePublicId());
            }
//            Period Public Id
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getPeriodPublicId() != null) {
                periodCourseProfessorFastDto.setPeriodPublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getPeriodPublicId());
            }
//            Course Public Id
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getCoursePublicId() != null) {
                periodCourseProfessorFastDto.setCoursePublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getCoursePublicId());
            }
//            Professor Public Id
            if (periodCourseProfessorEntity.getPeriodCourseProfessorApi().getProfessorPublicId() != null) {
                periodCourseProfessorFastDto.setProfessorPublicId(
                        periodCourseProfessorEntity
                                .getPeriodCourseProfessorApi()
                                .getProfessorPublicId());
            }
        }

//      Descriptive Values

//      PeriodCourseProfessor > PeriodCourse Descriptive
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse())) {
            periodCourseProfessorEntity.setPeriodCourse(null);
        }
        if (periodCourseProfessorEntity.getPeriodCourse() != null) {
            periodCourseProfessorFastDto
                    .setPeriodCourseStartDate(
                            periodCourseProfessorEntity
                                    .getPeriodCourse()
                                    .getStartDate()
                    );
            periodCourseProfessorFastDto
                    .setPeriodCourseEndDate(
                            periodCourseProfessorEntity
                                    .getPeriodCourse()
                                    .getEndDate()
                    );
            periodCourseProfessorFastDto
                    .setPeriodCourseTime(
                            periodCourseProfessorEntity
                                    .getPeriodCourse()
                                    .getTime()
                    );
            periodCourseProfessorFastDto
                    .setPeriodCourseSessionNumber(
                            periodCourseProfessorEntity
                                    .getPeriodCourse()
                                    .getSessionNumber()
                    );
//            periodCourseProfessorFastDto

//          PeriodCourseProfessor > periodCourse > Course Descriptive
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getCourse())) {
                periodCourseProfessorEntity.getPeriodCourse().setCourse(null);
            }
            if (periodCourseProfessorEntity.getPeriodCourse().getCourse() != null) {
                periodCourseProfessorFastDto
                        .setCourseFName(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getCourse()
                                        .getFname()
                        );
            }//END COURSE

//          PeriodCourseProfessor > periodCourse > Period Descriptive
            if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getPeriod())) {
                periodCourseProfessorEntity.getPeriodCourse().setPeriod(null);
            }
            if (periodCourseProfessorEntity.getPeriodCourse().getPeriod() != null) {
                periodCourseProfessorFastDto
                        .setPeriodName(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getName()
                        );
                periodCourseProfessorFastDto
                        .setPeriodStartDate(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getStartDate()
                        );
                periodCourseProfessorFastDto
                        .setPeriodEndDate(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getEndDate()
                        );
                periodCourseProfessorFastDto
                        .setPeriodOfferNumber(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getOfferNumber()
                        );
                periodCourseProfessorFastDto
                        .setPeriodActivityStatus(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getActivityStatus()
                        );
                periodCourseProfessorFastDto
                        .setPeriodDeleteStatus(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getDeleteStatus()
                        );
                periodCourseProfessorFastDto
                        .setPeriodCanRegisterOnLine(
                                periodCourseProfessorEntity
                                        .getPeriodCourse()
                                        .getPeriod()
                                        .getCanRegisterOnline()
                        );

//       PeriodCourseProfessor > periodCourse >  period > Field Descriptive
                if (!Hibernate.isInitialized(periodCourseProfessorEntity.getPeriodCourse().getPeriod().getField())) {
                    periodCourseProfessorEntity.getPeriodCourse().getPeriod().setField(null);
                }
                if (periodCourseProfessorEntity.getPeriodCourse().getPeriod().getField() != null) {
                    periodCourseProfessorFastDto
                            .setFieldCode(
                                    periodCourseProfessorEntity
                                            .getPeriodCourse()
                                            .getPeriod()
                                            .getField()
                                            .getCode()
                            );
                    periodCourseProfessorFastDto
                            .setFieldFName(
                                    periodCourseProfessorEntity
                                            .getPeriodCourse()
                                            .getPeriod()
                                            .getField()
                                            .getFname()
                            );
                }//END FIELD
            }//END PERIOD
        }//END PeriodCourse

//          PeriodCourseProfessor > Professor Descriptive
        if (!Hibernate.isInitialized(periodCourseProfessorEntity.getProfessor())) {
            periodCourseProfessorEntity.setProfessor(null);
        }
        if (periodCourseProfessorEntity.getProfessor() != null) {
            periodCourseProfessorFastDto
                    .setProfessorName(
                            periodCourseProfessorEntity
                                    .getProfessor()
                                    .getFirstName()
                                    .concat(" ") +
                                    periodCourseProfessorEntity
                                            .getProfessor()
                                            .getLastName()
                    );
        }//END PROCESSOR
    }//END AFTER MAPPING
}
