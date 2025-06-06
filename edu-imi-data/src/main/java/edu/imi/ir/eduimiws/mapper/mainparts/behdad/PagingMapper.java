package edu.imi.ir.eduimiws.mapper.mainparts.behdad;

/*import edu.imi.ir.eduimiws.models.behdad.account.PagingRequest;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagingDto;*/

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagingDto;
import edu.imi.ir.eduimiws.models.request.behdad.PagingRequest;
import edu.imi.ir.eduimiws.models.wsdl.behdad.Paging;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PagingMapper {

    @Named("toPagingDtoFromRequest")
    @Mappings({
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "recordCount", target = "recordCount")
    })
    @BeanMapping(ignoreByDefault = true)
    PagingDto toPagingDtoFromRequest(PagingRequest paging);

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

}
