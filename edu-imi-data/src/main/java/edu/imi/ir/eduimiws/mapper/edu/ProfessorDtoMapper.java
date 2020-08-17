package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.edu.ProfessorDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProfessorDtoMapper {

    ProfessorDtoMapper INSTANCE = Mappers.getMapper(ProfessorDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "acceptedHour", target = "acceptedHour"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "dutyHour", target = "dutyHour"),
            @Mapping(source = "dutyHourMonth", target = "dutyHourMonth"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "finalScore", target = "finalScore"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "isInner", target = "isInner"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "person.id", target = "personId"),
            @Mapping(source = "professorType", target = "professorType"),
            @Mapping(source = "startYear", target = "startYear")
    })
    @BeanMapping(ignoreByDefault = true)
    ProfessorDto toProfessorDto(ProfessorEntity professorEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    ProfessorEntity toProfessorEntity(ProfessorDto professorDto
            , @Context CycleAvoidingMappingContext context);

    List<ProfessorEntity> toProfessorEntities(List<ProfessorDto> professorDtos,
                                              @Context CycleAvoidingMappingContext context);

    List<ProfessorDto> toProfessorDtos(List<ProfessorEntity> professorEntities,
                                       @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoProfessorPublicId(ProfessorEntity professorEntity,
                                            @MappingTarget ProfessorDto professorDto) {

        /**
         * @implNote Professor Public Id
         */
        if (!Hibernate.isInitialized(professorEntity.getProfessorApi())) {
            professorEntity.setProfessorApi(null);
        }
        if (professorEntity.getProfessorApi() != null) {
            if (professorEntity.getProfessorApi().getProfessorPublicId() != null) {
                professorDto.setProfessorPublicId(professorEntity.getProfessorApi().getProfessorPublicId());
            }
        }
/**
 * @implNote Professor Person Public Id
 */
        if (!Hibernate.isInitialized(professorEntity.getPerson())) {
            professorEntity.setPerson(null);
        }
        if (professorEntity.getPerson() != null) {
            PersonDto personDto = new PersonDto();
            personDto.setId(professorEntity.getPerson().getId());
            professorDto.setPersonDto(personDto);
            if (!Hibernate.isInitialized(professorEntity.getPerson().getPersonApiEntity())) {
                professorEntity.getPerson().setPersonApiEntity(null);
            }
            if (professorEntity.getPerson().getPersonApiEntity() != null) {
                professorDto
                        .setPersonPublicId(
                                professorEntity
                                        .getPerson()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
