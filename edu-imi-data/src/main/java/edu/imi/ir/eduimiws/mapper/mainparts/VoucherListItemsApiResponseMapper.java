package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherListItemsApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.VoucherListItemsApiResponse;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {SimpleDateFormat.class, Timestamp.class, Date.class},
        uses = {PublicIdUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VoucherListItemsApiResponseMapper {

    @Named("voucherListItemsApiResponseToVoucherListItemsApiDto")
    @Mappings({
            @Mapping(source = "idApi", target = "idApi"),
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "tarh", target = "tarh"),
            @Mapping(source = "sanad", target = "sanad"),
            @Mapping(source = "atf", target = "atf"),
            @Mapping(source = "moein", target = "moein"),
            @Mapping(source = "codeTafzil", target = "codeTafzil"),
            @Mapping(source = "dl6", target = "dl6"),
            @Mapping(source = "sharh", target = "sharh"),
            @Mapping(source = "bestankar", target = "bestankar"),
            @Mapping(source = "bedehkar", target = "bedehkar"),
            @Mapping(source = "tarikhSanad", target = "tarikhSanad"),
            @Mapping(source = "tarikhMiladi", target = "tarikhMiladi"),
            @Mapping(source = "tarikhMiladiTs", target = "tarikhMiladiTs"),
            @Mapping(source = "eslahiHazfi", target = "eslahiHazfi"),
            @Mapping(source = "saderKonande", target = "saderKonande"),
            @Mapping(source = "akharinVirayeshConande", target = "akharinVirayeshConande"),
            @Mapping(source = "saleMali", target = "saleMali"),
            @Mapping(source = "lastCreateDate", target = "lastCreateDate"),
            @Mapping(source = "lastEditDate", target = "lastEditDate"),
            @Mapping(source = "lastCreateDateMiladi", target = "lastCreateDateMiladi"),
            @Mapping(source = "lastCreateDateMiladiTs", target = "lastCreateDateMiladiTs"),
            @Mapping(source = "lastEditDateMiladi", target = "lastEditDateMiladi"),
            @Mapping(source = "lastEditDateMiladiTs", target = "lastEditDateMiladiTs"),
            @Mapping(source = "voucherNumber", target = "voucherNumber"),
            @Mapping(source = "voucherSequence", target = "voucherSequence"),
            @Mapping(source = "voucherDailyNumber", target = "voucherDailyNumber"),
            @Mapping(source = "fiscalYearRef", target = "fiscalYearRef"),
            @Mapping(source = "fiscalYear", target = "fiscalYear"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "voucherDeleteItemsId", target = "voucherDeleteItemsId"),
            @Mapping(source = "recordStatus", target = "recordStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritConfiguration(name = "hamkaranPaginationToVoucherListItemsApiDto")
    VoucherListItemsApiDto voucherListItemsApiResponseToVoucherListItemsApiDto(VoucherListItemsApiResponse source);

    @Named("voucherListItemsApiDtoToVoucherListItemsApiResponse")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "voucherListItemsApiResponseToVoucherListItemsApiDto")
    VoucherListItemsApiResponse voucherListItemsApiDtoToVoucherListItemsApiResponse(VoucherListItemsApiDto source);


    @IterableMapping(qualifiedByName = "voucherListItemsApiResponseToVoucherListItemsApiDto")
    List<VoucherListItemsApiDto> voucherListItemsApiToVoucherListItemsApiDtoes(List<VoucherListItemsApiResponse> sources);

    @IterableMapping(qualifiedByName = "voucherListItemsApiDtoToVoucherListItemsApiResponse")
    List<VoucherListItemsApiResponse> voucherListItemsApiDtoToVoucherListItemsApis(List<VoucherListItemsApiDto> sources);
}
