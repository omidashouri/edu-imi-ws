package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.VoucherDeleteItemsApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring",
        imports = {SimpleDateFormat.class, Timestamp.class, Date.class},
        uses = {PublicIdUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VoucherDeleteItemsApiMapper {

    @Named("voucherDeleteItemsApiToVoucherDeleteItemsApiDto")
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
    VoucherDeleteItemsApiDto voucherDeleteItemsApiToVoucherDeleteItemsApiDto(VoucherDeleteItemsApiEntity source);

    @Named("voucherDeleteItemsApiDtoToVoucherDeleteItemsApi")
    @Mappings({
            @Mapping(target = "publicId", qualifiedBy = {MappingUtil.PublicIdUtil.class, MappingUtil.GenerateEntityPublicId.class}),
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
            @Mapping(target = "voucherDateTs", expression = "java(source.getVoucherDate()!=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSS\").parse(source.getVoucherDate()).toInstant()):null)")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "voucherDeleteItemsApiToVoucherDeleteItemsApiDto")
    VoucherDeleteItemsApiEntity voucherDeleteItemsApiDtoToVoucherDeleteItemsApi(VoucherDeleteItemsApiDto source) throws ParseException;


    @IterableMapping(qualifiedByName = "voucherDeleteItemsApiToVoucherDeleteItemsApiDto")
    List<VoucherDeleteItemsApiDto> voucherDeleteItemsApiToVoucherDeleteItemsApiDtoes(List<VoucherDeleteItemsApiEntity> sources);

    @IterableMapping(qualifiedByName = "voucherDeleteItemsApiDtoToVoucherDeleteItemsApi")
    List<VoucherDeleteItemsApiEntity> voucherDeleteItemsApiDtoToVoucherDeleteItemsApis(List<VoucherDeleteItemsApiDto> sources) throws ParseException;

}
