package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierInfo;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IdentifierInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IdentifierInfoMapper {

/*

    @Named("toIdentifierInfoDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "toDate", target = "toDate")
    })
    @BeanMapping(ignoreByDefault = true)
    IdentifierInfoDto toIdentifierInfoDto(IdentifierInfo source);


    @Named("toIdentifierInfo")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifier", target = "identifier"),
            @Mapping(source = "toDate", target = "toDate")

    })
    IdentifierInfo toIdentifierInfo(IdentifierInfoDto source);

    @IterableMapping(qualifiedByName = "toIdentifierInfo")
    List<IdentifierInfo> toIdentifierInfos(List<IdentifierInfoDto> sources);

    @IterableMapping(qualifiedByName = "toIdentifierInfoDto")
    List<IdentifierInfoDto> toIdentifierInfoDtos(List<IdentifierInfo> sources);
*/

}
