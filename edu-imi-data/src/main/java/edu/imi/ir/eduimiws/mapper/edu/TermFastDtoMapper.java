package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.TermFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermFastDtoMapper {

    TermFastDtoMapper INSTANCE = Mappers.getMapper(TermFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "currentTerm", target = "currentTerm"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "regEndDate", target = "regEndDate"),
            @Mapping(source = "regStartDate", target = "regStartDate"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "termName", target = "termName"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "year", target = "year")
    })
    @BeanMapping(ignoreByDefault = true)
    TermFastDto toTermFastDto(TermEntity termEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermEntity toTermEntity(TermFastDto termFastDto
            , @Context CycleAvoidingMappingContext context);

    List<TermEntity> toTermEntities(List<TermFastDto> termFastDtos,
                                    @Context CycleAvoidingMappingContext context);

    List<TermFastDto> toTermFastDtos(List<TermEntity> termEntities,
                                     @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleDtoTermPublicId(TermEntity termEntity,
                                       @MappingTarget TermFastDto termFastDto) {


//        Term Public Id
        if (!Hibernate.isInitialized(termEntity.getTermApi())) {
            termEntity.setTermApi(null);
        }
        if (termEntity.getTermApi() != null) {
            if (termEntity.getTermApi().getTermPublicId() != null) {
                termFastDto.setTermPublicId(termEntity.getTermApi().getTermPublicId());
            }
        }

//  Term Creator Public Id
        if (!Hibernate.isInitialized(termEntity.getCreator())) {
            termEntity.setCreator(null);
        }
        if (termEntity.getCreator() != null) {
            if (!Hibernate.isInitialized(termEntity.getCreator().getPersonApiEntity())) {
                termEntity.getCreator().setPersonApiEntity(null);
            }
            if (termEntity.getCreator().getPersonApiEntity() != null) {
                termFastDto
                        .setCreatorPublicId(
                                termEntity
                                        .getCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

//  Term Editor Public Id
        if (!Hibernate.isInitialized(termEntity.getEditor())) {
            termEntity.setEditor(null);
        }
        if (termEntity.getEditor() != null) {
            if (!Hibernate.isInitialized(termEntity.getEditor().getPersonApiEntity())) {
                termEntity.getEditor().setPersonApiEntity(null);
            }
            if (termEntity.getEditor().getPersonApiEntity() != null) {
                termFastDto
                        .setEditorPublicId(
                                termEntity
                                        .getEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}
