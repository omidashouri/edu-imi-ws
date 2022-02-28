package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;

import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranDeleted;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Named("HamkaranDeletedVoucherDeleteItemsApiDtoMapper")
@Mapper(componentModel = "spring",
        imports = {SimpleDateFormat.class, Timestamp.class, Date.class, Long.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranDeletedVoucherDeleteItemsApiDtoMapper {

    @Named("hamkaranDeletedToVoucherDeleteItemsApiDto")
    @Mappings({
            @Mapping(source = "deletedVoucherId", target = "idApi"),
            @Mapping(source = "referenceNumber", target = "referenceNumber"),
            @Mapping(source = "voucherNumber", target = "voucherNumber"),
            @Mapping(source = "voucherSequence", target = "voucherSequence"),
            @Mapping(source = "voucherDailyNumber", target = "voucherDailyNumber"),
            @Mapping(source = "fiscalYearRef", target = "fiscalYearRef"),
            @Mapping(source = "voucherDate", target = "voucherDate"),
            @Mapping(target = "voucherDateTs", expression = "java(source.getVoucherDate() !=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss\").parse(source.getVoucherDate()).toInstant()):null)"),
            @Mapping(source = "shamsiVoucherDate", target = "shamsiVoucherDate"),
            @Mapping(source = "voucherCreator", target = "voucherCreator"),
            @Mapping(source = "deleter", target = "deleter"),
            @Mapping(source = "deleterUserName", target = "deleterUserName"),
            @Mapping(source = "dateOfRemoval", target = "dateOfRemoval"),
            @Mapping(target = "dateOfRemovalTs", expression = "java(source.getDateOfRemoval() !=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss\").parse(source.getDateOfRemoval()).toInstant()):null)"),
            @Mapping(source = "shamsiDateOfRemoval", target = "shamsiDateOfRemoval")
    })
    @BeanMapping(ignoreByDefault = true)
    VoucherDeleteItemsApiDto hamkaranDeletedToVoucherDeleteItemsApiDto(HamkaranDeleted source) throws ParseException;;

    @Named("voucherDeleteItemsApiToHamkaranDeleted")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "hamkaranDeletedToVoucherDeleteItemsApiDto")
    HamkaranDeleted voucherDeleteItemsApiToHamkaranDeleted(VoucherDeleteItemsApiDto source);


    @Named("hamkaranDeletedsToVoucherDeleteItemsApiDtoes")
    @IterableMapping(qualifiedByName = "hamkaranDeletedToVoucherDeleteItemsApiDto")
    List<VoucherDeleteItemsApiDto> hamkaranDeletedsToVoucherDeleteItemsApiDtoes(List<HamkaranDeleted> sources) throws ParseException;;

    @Named("voucherDeleteItemsApiToHamkaranDeleteds")
    @IterableMapping(qualifiedByName = "voucherDeleteItemsApiToHamkaranDeleted")
    List<HamkaranDeleted> voucherDeleteItemsApiToHamkaranDeleteds(List<VoucherDeleteItemsApiDto> sources);

}
