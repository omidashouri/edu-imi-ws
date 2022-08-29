package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierDetail;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierDetailDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierDetailMapper {

/*

    @Named("toIdentifierDetailDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "lastUpdate", target = "lastUpdate"),
            @Mapping(source = "startDate", target = "startDate")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierDetailDto toIdentifierDetailDto(IdentifierDetail source);


    @Named("toIdentifierDetail")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "lastUpdate", target = "lastUpdate"),
            @Mapping(source = "startDate", target = "startDate")

    })
    IdentifierDetail toIdentifierDetail(IdentifierDetailDto source);

    @IterableMapping(qualifiedByName = "toIdentifierDetail")
    List<IdentifierDetail> toIdentifierDetails(List<IdentifierDetailDto> sources);

    @IterableMapping(qualifiedByName = "toIdentifierDetailDto")
    List<IdentifierDetailDto> toIdentifierDetailDtos(List<IdentifierDetail> sources);
*/

}
