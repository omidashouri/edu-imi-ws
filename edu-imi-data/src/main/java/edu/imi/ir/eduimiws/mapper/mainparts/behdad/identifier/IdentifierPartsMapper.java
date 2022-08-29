package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierParts;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierPartsDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierPartsMapper {


  /*
    @Named("toIdentifierPartsDto")
    @Mappings({
            @Mapping(source = "baseCode", target = "baseCode"),
            @Mapping(source = "identifierPrefix", target = "identifierPrefix"),
            @Mapping(source = "incomeIndexCode", target = "incomeIndexCode"),
            @Mapping(source = "incomeSubsidiaryCode", target = "incomeSubsidiaryCode"),
            @Mapping(source = "organCustomCode", target = "organCustomCode")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierPartsDto toIdentifierPartsDto(IdentifierParts source);


    @Named("toIdentifierParts")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "baseCode", target = "baseCode"),
            @Mapping(source = "identifierPrefix", target = "identifierPrefix"),
            @Mapping(source = "incomeIndexCode", target = "incomeIndexCode"),
            @Mapping(source = "incomeSubsidiaryCode", target = "incomeSubsidiaryCode"),
            @Mapping(source = "organCustomCode", target = "organCustomCode")

    })
    IdentifierParts toIdentifierParts(IdentifierPartsDto source);

    @IterableMapping(qualifiedByName = "toIdentifierParts")
    List<IdentifierParts> toIdentifierPartses(List<IdentifierPartsDto> sources);

    @IterableMapping(qualifiedByName = "toIdentifierPartsDto")
    List<IdentifierPartsDto> toIdentifierPartsDtos(List<IdentifierParts> sources);
*/
}
