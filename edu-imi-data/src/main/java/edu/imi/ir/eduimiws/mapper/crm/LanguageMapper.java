package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.LanguageEntity;
import edu.imi.ir.eduimiws.models.dto.crm.LanguageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LanguageMapper {


    @Named("languageDtoToLanguageEntity")
    @Mappings({
            @Mapping(source = "nameEn",target = "nameEn"),
            @Mapping(source = "nameLo",target = "nameLo"),
            @Mapping(source = "direction",target = "direction"),
            @Mapping(source = "flagNewName",target = "flagNewName"),
            @Mapping(source = "flagOldName",target = "flagOldName"),
            @Mapping(source = "encoding",target = "encoding")
    })
    @BeanMapping(ignoreByDefault = true)
    LanguageEntity languageDtoToLanguageEntity(LanguageDto languageDto);

    @Named("languageEntityToLanguageDto")
    @InheritInverseConfiguration(name = "languageDtoToLanguageEntity")
    LanguageDto languageEntityToLanguageDto(LanguageEntity languageEntity);

    @IterableMapping(qualifiedByName = "languageDtoToLanguageEntity")
    List<LanguageEntity> languageDtosToLanguageEntities(List<LanguageDto> languageDtos);

    @IterableMapping(qualifiedByName = "languageEntityToLanguageDto")
    List<LanguageDto> languageEntitiesToLanguageDtos(List<LanguageEntity> languageEntities);


}
