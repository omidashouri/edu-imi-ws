package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.VoucherListItemsApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherListItemsApiDto;
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
public interface VoucherListItemsApiMapper {

    @Named("voucherListItemsApiToVoucherListItemsApiDto")
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
    VoucherListItemsApiDto voucherListItemsApiToVoucherListItemsApiDto(VoucherListItemsApiEntity source);

    @Named("voucherListItemsApiDtoToVoucherListItemsApi")
    @Mappings({
//            @Mapping(target = "publicId", expression = "java(publicIdUtil.generateUniquePublicId())"),
            @Mapping(target = "publicId", qualifiedBy = {MappingUtil.PublicIdUtil.class, MappingUtil.GenerateEntityPublicId.class}),
            @Mapping(target = "createDateTs", expression = "java(new Timestamp(new Date().getTime()))"),
            @Mapping(target = "tarikhMiladiTs", expression = "java(source.getTarikhMiladi()!=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSS\").parse(source.getTarikhMiladi()).toInstant()):null)"),
            @Mapping(target = "lastCreateDateMiladiTs", expression = "java(source.getLastCreateDateMiladi()!=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSS\").parse(source.getLastCreateDateMiladi()).toInstant()):null)"),
            @Mapping(target = "lastEditDateMiladiTs", expression = "java(source.getLastEditDateMiladi()!=null?Timestamp.from(new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSSSSS\").parse(source.getLastEditDateMiladi()).toInstant()):null)")
    })
    @BeanMapping(ignoreByDefault = true)
    VoucherListItemsApiEntity voucherListItemsApiDtoToVoucherListItemsApi(VoucherListItemsApiDto source
//            , @Context PublicIdUtil publicIdUtil
                                                                                ) throws ParseException;


    @IterableMapping(qualifiedByName = "voucherListItemsApiToVoucherListItemsApiDto")
    List<VoucherListItemsApiDto> voucherListItemsApiToVoucherListItemsApiDtoes(List<VoucherListItemsApiEntity> sources);

    @IterableMapping(qualifiedByName = "voucherListItemsApiDtoToVoucherListItemsApi")
    List<VoucherListItemsApiEntity> voucherListItemsApiDtoToVoucherListItemsApis(List<VoucherListItemsApiDto> sources
//            ,@Context PublicIdUtil publicIdUtil
    ) throws ParseException;

    /*@Mappings({
            @Mapping(target = "searchQuery", expression = "java(searchQuery.trim())")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateVoucherListItemsApiDtoBySearchQuery(@MappingTarget VoucherListItemsApiDto target, String searchQuery);

    @Mappings({
            @Mapping(target = "searchQuery", expression = "java(searchQuery.trim())")
    })
    @BeanMapping(ignoreByDefault = true)
    VoucherListItemsApiDto setVoucherListItemsApiDtoBySearchQuery(String searchQuery);*/

}
