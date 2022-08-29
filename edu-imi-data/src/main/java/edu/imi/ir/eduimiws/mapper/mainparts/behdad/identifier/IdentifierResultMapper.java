package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierResult;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierResultDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierResultMapper {

/*

    @Named("toIdentifierResultDto")
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "result", target = "result")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierResultDto toIdentifierResultDto(IdentifierResult source);


    @Named("toIdentifierResult")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "result", target = "result")

    })
    IdentifierResult toIdentifierResult(IdentifierResultDto source);

    @IterableMapping(qualifiedByName = "toIdentifierResult")
    List<IdentifierResult> toIdentifierResults(List<IdentifierResultDto> sources);

    @IterableMapping(qualifiedByName = "toIdentifierResultDto")
    List<IdentifierResultDto> toIdentifierResultDtos(List<IdentifierResult> sources);
*/

}
