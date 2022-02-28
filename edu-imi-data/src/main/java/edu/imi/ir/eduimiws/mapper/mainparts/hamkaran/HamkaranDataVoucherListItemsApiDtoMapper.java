package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;


import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherListItemsApiDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranData;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Named("HamkaranDataVoucherListItemsApiDtoMapper")
@Mapper(componentModel = "spring",
        imports = {SimpleDateFormat.class, Timestamp.class, Date.class, Long.class},
        uses = {PublicIdUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranDataVoucherListItemsApiDtoMapper {


    @Named("hamkaranDataToVoucherListItemsApiDto")
    @Mappings({
            @Mapping(source = "id", target = "idApi"),
            @Mapping(source = "tarh", target = "tarh"),
            @Mapping(source = "sanad", target = "sanad"),
            @Mapping(source = "atf", target = "atf"),
            @Mapping(source = "moeein", target = "moein"),
            @Mapping(source = "codtafsil", target = "codeTafzil"),
            @Mapping(source = "dl6", target = "dl6"),
            @Mapping(source = "sharh", target = "sharh"),
            @Mapping(target = "bestankar", expression = "java(source.getBestankar()!=null?Long.valueOf(source.getBestankar().split(\"\\\\.\")[0]):null)"),
            @Mapping(target = "bedehkar", expression = "java(source.getBestankar()!=null?Long.valueOf(source.getBestankar().split(\"\\\\.\")[0]):null)"),
            @Mapping(source = "tarikhSanad", target = "tarikhSanad"),
            @Mapping(source = "tarikhMiladi", target = "tarikhMiladi"),
            @Mapping(source = "eslahiHazfi", target = "eslahiHazfi", qualifiedByName = "eslahiHazfiStringToLongConvertor"),
            @Mapping(source = "saderKonande", target = "saderKonande"),
            @Mapping(source = "akharinVirayeshKonande", target = "akharinVirayeshConande"),
            @Mapping(source = "saleMali", target = "saleMali"),
            @Mapping(source = "lastCreateDate", target = "lastCreateDate"),
            @Mapping(source = "lastEdiDate", target = "lastEditDate"),
            @Mapping(source = "lastCreateDateMiladi", target = "lastCreateDateMiladi"),
            @Mapping(source = "lastEditDateMiladi", target = "lastEditDateMiladi"),
            @Mapping(source = "voucherNumber", target = "voucherNumber"),
            @Mapping(source = "voucherSequence", target = "voucherSequence"),
            @Mapping(source = "voucherDailyNumber", target = "voucherDailyNumber"),
            @Mapping(source = "fiscalYearRef", target = "fiscalYearRef"),
            @Mapping(source = "fiscalYear", target = "fiscalYear")
    })
    @BeanMapping(ignoreByDefault = true)
    VoucherListItemsApiDto hamkaranDataToVoucherListItemsApiDto(HamkaranData source);

    @Named("voucherListItemsApiToHamkaranData")
    @Mappings({
            @Mapping(source = "eslahiHazfi", target = "eslahiHazfi", qualifiedByName = "eslahiHazfiLongToStringConvertor"),
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "hamkaranDataToVoucherListItemsApiDto")
    HamkaranData voucherListItemsApiToHamkaranData(VoucherListItemsApiDto source);


    @Named("hamkaranDatasToVoucherListItemsApiDtoes")
    @IterableMapping(qualifiedByName = "hamkaranDataToVoucherListItemsApiDto")
    List<VoucherListItemsApiDto> hamkaranDatasToVoucherListItemsApiDtoes(List<HamkaranData> sources);

    @Named("voucherListItemsApiToHamkaranDatas")
    @IterableMapping(qualifiedByName = "voucherListItemsApiToHamkaranData")
    List<HamkaranData> voucherListItemsApiToHamkaranDatas(List<VoucherListItemsApiDto> sources);


    @Named("eslahiHazfiStringToLongConvertor")
    default Long eslahiHazfiStringToLongConvertor(String input) {
        if (input.equalsIgnoreCase("خیر"))
            return 0L;
        else return 1L;
    }

    @Named("eslahiHazfiLongToStringConvertor")
    default String eslahiHazfiSttingToLongConvertor(Long input) {
        if (input.equals(0))
            return "خیر";
        else return "بلی";
    }


}
