package edu.imi.ir.eduimiws.mapper.mainparts.behdad;

/*import edu.imi.ir.eduimiws.models.behdad.account.Paging;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagingDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PagingMapper {
/*

    @Named("toPagingDto")
    @Mappings({
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "recordCount", target = "recordCount")
    })
    @BeanMapping(ignoreByDefault = true)
    PagingDto toPagingDto(Paging paging);


    @Named("toPaging")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "recordCount", target = "recordCount")

    })
    Paging toPaging(PagingDto pagingDto);

    @IterableMapping(qualifiedByName = "toPaging")
    List<Paging> toPagings(List<PagingDto> pagingDtos);

    @IterableMapping(qualifiedByName = "toPagingDto")
    List<PagingDto> toPagingDtos(List<Paging> pagings);
*/

}
