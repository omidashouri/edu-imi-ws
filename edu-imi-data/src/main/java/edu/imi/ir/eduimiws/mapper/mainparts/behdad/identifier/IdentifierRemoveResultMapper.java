package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierRemoveResult;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierRemoveResultDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierRemoveResultMapper {

/*

    @Named("toIdentifierRemoveResultDto")
    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "result", target = "result")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierRemoveResultDto toIdentifierRemoveResultDto(IdentifierRemoveResult source);


    @Named("toIdentifierRemoveResult")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "result", target = "result")

    })
    IdentifierRemoveResult toIdentifierRemoveResult(IdentifierRemoveResultDto source);

    @IterableMapping(qualifiedByName = "toIdentifierRemoveResult")
    List<IdentifierRemoveResult> toIdentifierRemoveResults(List<IdentifierRemoveResultDto> sources);

    @IterableMapping(qualifiedByName = "toIdentifierRemoveResultDto")
    List<IdentifierRemoveResultDto> toIdentifierRemoveResultDtos(List<IdentifierRemoveResult> sources);
*/

}
