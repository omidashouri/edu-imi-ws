package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.VoucherDeleteItemsApiResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VoucherDeleteItemsApiResponseMapper {

    @Named("voucherDeleteItemsApiResponseToVoucherDeleteItemsApiDto")
    @Mappings({
            @Mapping(source = "idApi", target = "idApi"),
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "referenceNumber", target = "referenceNumber"),
            @Mapping(source = "voucherNumber", target = "voucherNumber"),
            @Mapping(source = "voucherSequence", target = "voucherSequence"),
            @Mapping(source = "voucherDailyNumber", target = "voucherDailyNumber"),
            @Mapping(source = "fiscalYearRef", target = "fiscalYearRef"),
            @Mapping(source = "fiscalYear", target = "fiscalYear"),
            @Mapping(source = "voucherDate", target = "voucherDate"),
            @Mapping(source = "voucherDateTs", target = "voucherDateTs"),
            @Mapping(source = "shamsiVoucherDate", target = "shamsiVoucherDate"),
            @Mapping(source = "voucherCreator", target = "voucherCreator"),
            @Mapping(source = "deleter", target = "deleter"),
            @Mapping(source = "deleterUserName", target = "deleterUserName"),
            @Mapping(source = "dateOfRemoval", target = "dateOfRemoval"),
            @Mapping(source = "dateOfRemovalTs", target = "dateOfRemovalTs"),
            @Mapping(source = "shamsiDateOfRemoval", target = "shamsiDateOfRemoval"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "recordStatus", target = "recordStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    VoucherDeleteItemsApiDto voucherDeleteItemsApiResponseToVoucherDeleteItemsApiDto(VoucherDeleteItemsApiResponse source);

    @Named("voucherDeleteItemsApiDtoToVoucherDeleteItemsApiResponse")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "voucherDeleteItemsApiResponseToVoucherDeleteItemsApiDto")
    VoucherDeleteItemsApiResponse voucherDeleteItemsApiDtoToVoucherDeleteItemsApiResponse(VoucherDeleteItemsApiDto source);


    @IterableMapping(qualifiedByName = "voucherDeleteItemsApiResponseToVoucherDeleteItemsApiDto")
    List<VoucherDeleteItemsApiDto> voucherDeleteItemsApiResponseToVoucherDeleteItemsApiDtoes(List<VoucherDeleteItemsApiResponse> sources);

    @IterableMapping(qualifiedByName = "voucherDeleteItemsApiDtoToVoucherDeleteItemsApiResponse")
    List<VoucherDeleteItemsApiResponse> voucherDeleteItemsApiDtoToVoucherDeleteItemsApiResponses(List<VoucherDeleteItemsApiDto> sources);

}
