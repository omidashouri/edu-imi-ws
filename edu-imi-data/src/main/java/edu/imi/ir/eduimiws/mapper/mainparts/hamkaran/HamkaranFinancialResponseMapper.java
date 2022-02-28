package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;


import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranFinancialResponseDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranFinancialResponse;
import org.mapstruct.*;

import java.util.List;


/*qualifiedByName:
    1-uses={SOURCE_MAPPER.class} for importing the source mapper interface that its method used in qualifiedByName
    2-use @Named for the interface in the source mapper interface
    3-use @Named for the method in the source mapper interface
    4-@Mapping(source="propertyName", target="propertyName", qualifiedByName={"@Named_NameDefinedForInterface","@Named_NameDefinedInsideForMethod"} {

 */

@Mapper(componentModel = "spring",
        uses={HamkaranDataVoucherListItemsApiDtoMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranFinancialResponseMapper {

    @Named("hamkaranFinancialResponseToHamkaranFinancialResponseDto")
    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "pagination", target = "pagination"),
            @Mapping(source = "headers", target = "headers"),
            @Mapping(source = "data", target = "voucherListItemsApiDtos",
                    qualifiedByName = {"HamkaranDataVoucherListItemsApiDtoMapper", "hamkaranDatasToVoucherListItemsApiDtoes"})
    })
    @BeanMapping(ignoreByDefault = true)
    HamkaranFinancialResponseDto hamkaranFinancialResponseToHamkaranFinancialResponseDto(HamkaranFinancialResponse source);

    @Named("hamkaranFinancialResponseDtoToHamkaranFinancialResponse")
    @Mappings({
            @Mapping(source = "voucherListItemsApiDtos", target = "data",
                    qualifiedByName = {"HamkaranDataVoucherListItemsApiDtoMapper", "voucherListItemsApiToHamkaranDatas"})
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "hamkaranFinancialResponseToHamkaranFinancialResponseDto")
    HamkaranFinancialResponse hamkaranFinancialResponseDtoToHamkaranFinancialResponse(HamkaranFinancialResponseDto source);


    @IterableMapping(qualifiedByName = "hamkaranFinancialResponseToHamkaranFinancialResponseDto")
    List<HamkaranFinancialResponseDto> hamkaranFinancialResponsesToHamkaranFinancialResponseDtoes(List<HamkaranFinancialResponse> sources);

    @IterableMapping(qualifiedByName = "hamkaranFinancialResponseDtoToHamkaranFinancialResponse")
    List<HamkaranFinancialResponse> hamkaranFinancialResponseDtosToHamkaranFinancialResponsees(List<HamkaranFinancialResponseDto> sources);

    @Mappings({
            @Mapping(target = "searchQuery",expression = "java(searchQuery.trim())")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateHamkaranFinancialResponseDtoBySearchQuery(@MappingTarget HamkaranFinancialResponseDto target ,
                                                     String searchQuery);
}
