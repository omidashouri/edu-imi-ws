package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierAmountPair;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierAmountPairDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierAmountPairMapper {

/*

    @Named("toIdentifierAmountPairDto")
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifier", target = "identifier")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierAmountPairDto toIdentifierAmountPairDto(IdentifierAmountPair source);


    @Named("toIdentifierAmountPair")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifier", target = "identifier")

    })
    IdentifierAmountPair toIdentifierAmountPair(IdentifierAmountPairDto source);

    @Named("toIdentifierAmountPairs")
    @IterableMapping(qualifiedByName = "toIdentifierAmountPair")
    List<IdentifierAmountPair> toIdentifierAmountPairs(List<IdentifierAmountPairDto> sources);

    @Named("toIdentifierAmountPairDtos")
    @IterableMapping(qualifiedByName = "toIdentifierAmountPairDto")
    List<IdentifierAmountPairDto> toIdentifierAmountPairDtos(List<IdentifierAmountPair> sources);
*/

}
