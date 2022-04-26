package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;


import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranHumanResourceResponseDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranHumanResourceResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses={HamkaranHumanResourceDataMapper.class,HamkaranPaginationMapper.class,HamkaranStatusMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranHumanResourceResponseMapper {

    @Named("toHamkaranHumanResourceResponseDto")
    @Mappings({
            @Mapping(source = "status", target = "statusDto", qualifiedByName = "hamkaranStatusToHamkaranStatusDto"),
            @Mapping(source = "pagination", target = "paginationDto", qualifiedByName = {"hamkaranPaginationToHamkaranPaginationDto"}),
            @Mapping(source = "headers.apiKey", target = "headersDto.apiKey"),
            @Mapping(source = "data", target = "dataDto",  qualifiedByName = {"toHamkaranHumanResourceDataDtoes"})
    })
    @BeanMapping(ignoreByDefault = true)
    HamkaranHumanResourceResponseDto toHamkaranHumanResourceResponseDto(HamkaranHumanResourceResponse source);

    @Named("toHamkaranHumanResourceResponse")
    @Mappings({
            @Mapping(source = "statusDto", target = "status", qualifiedByName = "hamkaranStatusDtoToHamkaranStatus"),
            @Mapping(source = "paginationDto", target = "pagination", qualifiedByName = {"hamkaranPaginationDtoToHamkaranPagination"}),
            @Mapping(source = "headersDto.apiKey", target = "headers.apiKey"),
            @Mapping(source = "dataDto", target = "data",  qualifiedByName = {"toHamkaranHumanResourceDatas"})
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toHamkaranHumanResourceResponseDto")
    HamkaranHumanResourceResponse toHamkaranHumanResourceResponse(HamkaranHumanResourceResponseDto source);


    @IterableMapping(qualifiedByName = "toHamkaranHumanResourceResponseDto")
    List<HamkaranHumanResourceResponseDto> toHamkaranHumanResourceResponseDtoes(List<HamkaranHumanResourceResponse> sources);

    @IterableMapping(qualifiedByName = "toHamkaranHumanResourceResponse")
    List<HamkaranHumanResourceResponse> toHamkaranHumanResourceResponses(List<HamkaranHumanResourceResponseDto> sources);


    @Mappings({
            @Mapping(target = "searchQuery",expression = "java(searchQuery.trim())")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateHamkaranHumanResourceResponseDtoBySearchQuery(@MappingTarget HamkaranHumanResourceResponseDto target ,
                                                         String searchQuery);
}
