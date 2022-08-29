package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.IsVerhoeffRequest;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.IsVerhoeffRequestDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IsVerhoeffRequestMapper {
/*

    @Named("toIsVerhoeffRequestDto")
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifierCode", target = "identifierCode")
    })
    @BeanMapping(ignoreByDefault = true)
    IsVerhoeffRequestDto toIsVerhoeffRequestDto(IsVerhoeffRequest isVerhoeffRequest);


    @Named("toIsVerhoeffRequest")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "identifierCode", target = "identifierCode")

    })
    IsVerhoeffRequest toIsVerhoeffRequest(IsVerhoeffRequestDto isVerhoeffRequestDto);

    @IterableMapping(qualifiedByName = "toIsVerhoeffRequest")
    List<IsVerhoeffRequest> toIsVerhoeffRequests(List<IsVerhoeffRequestDto> isVerhoeffRequestDtos);

    @IterableMapping(qualifiedByName = "toIsVerhoeffRequestDto")
    List<IsVerhoeffRequestDto> toIsVerhoeffRequestDtos(List<IsVerhoeffRequest> isVerhoeffRequests);
*/


}
