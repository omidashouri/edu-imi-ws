package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.GenerateIdentifierByOrganRequest;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.GenerateIdentifierByOrganRequestDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {IdentifierPartsMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GenerateIdentifierByOrganRequestMapper {

/*
    @Named("toGenerateIdentifierByOrganRequestDto")
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifierParts", target = "identifierPartsDto", qualifiedByName = "toIdentifierPartsDto")
    })
    @BeanMapping(ignoreByDefault = true)
    GenerateIdentifierByOrganRequestDto toGenerateIdentifierByOrganRequestDto(GenerateIdentifierByOrganRequest source);


    @Named("toGenerateIdentifierByOrganRequest")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifierPartsDto", target = "identifierParts", qualifiedByName = "toIdentifierParts")

    })
    GenerateIdentifierByOrganRequest toGenerateIdentifierByOrganRequest(GenerateIdentifierByOrganRequestDto source);

    @IterableMapping(qualifiedByName = "toGenerateIdentifierByOrganRequest")
    List<GenerateIdentifierByOrganRequest> toGenerateIdentifierByOrganRequests(List<GenerateIdentifierByOrganRequestDto> sources);

    @IterableMapping(qualifiedByName = "toGenerateIdentifierByOrganRequestDto")
    List<GenerateIdentifierByOrganRequestDto> toGenerateIdentifierByOrganRequestDtos(List<GenerateIdentifierByOrganRequest> sources);
*/

}
