package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;

import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranDeletedFinancialResponseDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranDeletedFinancialResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses={HamkaranDeletedVoucherDeleteItemsApiDtoMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranDeletedFinancialResponseMapper {

    @Named("hamkaranDeletedFinancialResponseToHamkaranDeletedFinancialResponseDto")
    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "pagination", target = "pagination"),
            @Mapping(source = "deleteds", target = "voucherDeleteItemsApiDtos",
                    qualifiedByName = {"HamkaranDeletedVoucherDeleteItemsApiDtoMapper", "hamkaranDeletedsToVoucherDeleteItemsApiDtoes"})
    })
    @BeanMapping(ignoreByDefault = true)
    HamkaranDeletedFinancialResponseDto hamkaranDeletedFinancialResponseToHamkaranDeletedFinancialResponseDto(HamkaranDeletedFinancialResponse source);

    @Named("hamkaranDeletedFinancialResponseDtoToHamkaranDeletedFinancialResponse")
    @Mappings({
            @Mapping(source = "voucherDeleteItemsApiDtos", target = "deleteds",
                    qualifiedByName = {"HamkaranDeletedVoucherDeleteItemsApiDtoMapper", "voucherDeleteItemsApiToHamkaranDeleteds"})
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "hamkaranDeletedFinancialResponseToHamkaranDeletedFinancialResponseDto")
    HamkaranDeletedFinancialResponse hamkaranDeletedFinancialResponseDtoToHamkaranDeletedFinancialResponse(HamkaranDeletedFinancialResponseDto source);


    @IterableMapping(qualifiedByName = "hamkaranDeletedFinancialResponseToHamkaranDeletedFinancialResponseDto")
    List<HamkaranDeletedFinancialResponseDto> hamkaranFinancialResponsesToHamkaranDeletedFinancialResponseDtoes(List<HamkaranDeletedFinancialResponse> sources);

    @IterableMapping(qualifiedByName = "hamkaranDeletedFinancialResponseDtoToHamkaranDeletedFinancialResponse")
    List<HamkaranDeletedFinancialResponse> hamkaranDeletedFinancialResponseDtosToHamkaranDeletedFinancialResponses(List<HamkaranDeletedFinancialResponseDto> sources);

    @Mappings({
            @Mapping(target = "searchQuery",expression = "java(searchQuery.trim())")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateHamkaranDeletedFinancialResponseDtoBySearchQuery(@MappingTarget HamkaranDeletedFinancialResponseDto target ,
                                                         String searchQuery);
}
