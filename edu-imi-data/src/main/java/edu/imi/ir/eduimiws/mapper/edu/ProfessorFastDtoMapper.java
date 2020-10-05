package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.ProfessorFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProfessorFastDtoMapper {

    ProfessorFastDtoMapper INSTANCE = Mappers.getMapper(ProfessorFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "acceptedHour", target = "acceptedHour"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "dutyHour", target = "dutyHour"),
            @Mapping(source = "dutyHourMonth", target = "dutyHourMonth"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "finalScore", target = "finalScore"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "isInner", target = "isInner"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "professorType", target = "professorType"),
            @Mapping(source = "startYear", target = "startYear")
    })
    @BeanMapping(ignoreByDefault = true)
    ProfessorFastDto toProfessorFastDto(ProfessorEntity professorEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProfessorEntity toProfessorEntity(ProfessorFastDto professorDto
            , @Context CycleAvoidingMappingContext context);

    List<ProfessorEntity> toProfessorEntities(List<ProfessorFastDto> professorDtos,
                                              @Context CycleAvoidingMappingContext context);

    List<ProfessorFastDto> toProfessorFastDtos(List<ProfessorEntity> professorEntities,
                                               @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoProfessorPublicId(ProfessorEntity professorEntity,
                                            @MappingTarget ProfessorFastDto professorFastDto) {

//        Professor Public Id
        if (!Hibernate.isInitialized(professorEntity.getProfessorApi())) {
            professorEntity.setProfessorApi(null);
        }
        if (professorEntity.getProfessorApi() != null) {
            if (professorEntity.getProfessorApi().getProfessorPublicId() != null) {
                professorFastDto.setProfessorPublicId(professorEntity.getProfessorApi().getProfessorPublicId());
            }
            if (professorEntity.getProfessorApi().getPersonPublicId() != null) {
                professorFastDto.setPersonPublicId(professorEntity.getProfessorApi().getPersonPublicId());
            }
        }

//  PeriodCourse Creator Public Id
        if (!Hibernate.isInitialized(professorEntity.getCreator())) {
            professorEntity.setCreator(null);
        }
        if (professorEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(professorEntity.getCreator().getPersonApiEntity())) {
                professorEntity.getCreator().setPersonApiEntity(null);
            }
            if (professorEntity.getCreator().getPersonApiEntity() != null) {
                professorFastDto
                        .setCreatorPublicId(
                                professorEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

//  PeriodCourse Editor Public Id
        if (!Hibernate.isInitialized(professorEntity.getEditor())) {
            professorEntity.setEditor(null);
        }
        if (professorEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(professorEntity.getEditor().getPersonApiEntity())) {
                professorEntity.getEditor().setPersonApiEntity(null);
            }
            if (professorEntity.getEditor().getPersonApiEntity() != null) {
                professorFastDto
                        .setEditorPublicId(
                                professorEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
