package edu.imi.ir.eduimiws.mapper.mainparts.behdad;

/*import edu.imi.ir.eduimiws.models.behdad.account.BalanceInfo;
import edu.imi.ir.eduimiws.models.behdad.account.PagedData;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;*/

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.PagedData;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PagedDataMapper {


    @Named("toPagedDataDto")
    @Mappings({
            @Mapping(source = "currentPageData", target = "currentPageData"),
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "pageSize", target = "pageSize"),
            @Mapping(source = "totalCount", target = "totalCount")
    })
    @BeanMapping(ignoreByDefault = true)
    PagedDataDto toPagedDataDto(PagedData pagedData);


    @Named("toPagedData")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "currentPageData", target = "currentPageData"),
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "pageSize", target = "pageSize"),
            @Mapping(source = "totalCount", target = "totalCount")
    })
    PagedData toPagedData(PagedDataDto pagedDataDto);

    @IterableMapping(qualifiedByName = "toPagedData")
    List<PagedData> toPagedDatas(List<PagedDataDto> pagedDataDtos);

    @IterableMapping(qualifiedByName = "toPagedDataDto")
    List<PagedDataDto> toPagedDataDtos(List<PagedData> pagedDataes);



}
