package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapperImpl;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.edu.TermApiDto;
import edu.imi.ir.eduimiws.models.dto.edu.TermDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TermDtoMapper {

    TermDtoMapper INSTANCE = Mappers.getMapper(TermDtoMapper.class);

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
    TermDto toTermDto(TermEntity termEntity, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    TermEntity toTermEntity(TermDto termDto, @Context CycleAvoidingMappingContext context);

    List<TermEntity> toTermEntities(List<TermDto> termDtos,
                                    @Context CycleAvoidingMappingContext context);

    List<TermDto> toTermDtos(List<TermEntity> termEntities,
                             @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIdsTermDto(TermEntity termEntity,
                                        @MappingTarget TermDto termDto) {

        if (!Hibernate.isInitialized(termEntity.getTermApi())) {
            termEntity.setTermApi(null);
        }
        if (termEntity.getTermApi() != null) {
            TermApiDto termApiDto = new TermApiDto();
            termApiDto.setId(termEntity.getTermApi().getId());
            termDto.setTermApiDto(termApiDto);
            termDto.setTermPublicId(termApiDto.getTermPublicId());
        }

        if (!Hibernate.isInitialized(termEntity.getCompany())) {
            termEntity.setCompany(null);
        }
        if (termEntity.getCompany() != null) {
            CompanyDto companyDto = new CompanyDto();
            companyDto.setId(termEntity.getCompany().getId());
            termDto.setCompanyDto(companyDto);
//            companyApi not developed yet, so there is no companyPublicId
        }

        if (!Hibernate.isInitialized(termEntity.getCreator())) {
            termEntity.setCreator(null);
        }
        if (termEntity.getCreator() != null) {
            PersonDto creatorDto = new PersonMapperImpl()
                    .personEntityToPersonDto(termEntity.getCreator(), new CycleAvoidingMappingContext());
            termDto.setCreatorDto(creatorDto);
            if (!Hibernate.isInitialized(termEntity.getCreator().getPersonApiEntity())) {
                termEntity.getCreator().setPersonApiEntity(null);
            }
            if (termEntity.getCreator().getPersonApiEntity() != null) {
                termDto.setCreatorPublicId(termEntity.getCreator().getPersonApiEntity().getPersonPublicId());
            }
        }

        if (!Hibernate.isInitialized(termEntity.getEditor())) {
            termEntity.setEditor(null);
        }
        if (termEntity.getEditor() != null) {
            PersonDto editorDto = new PersonMapperImpl()
                    .personEntityToPersonDto(termEntity.getEditor(), new CycleAvoidingMappingContext());
            termDto.setEditorDto(editorDto);
            if (!Hibernate.isInitialized(termEntity.getEditor().getPersonApiEntity())) {
                termEntity.getEditor().setPersonApiEntity(null);
            }
            if (termEntity.getEditor().getPersonApiEntity() != null) {
                termDto.setEditorPublicId(termEntity.getEditor().getPersonApiEntity().getPersonPublicId());
            }
        }

    }
}
