package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.BalanceInfo;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BalanceInfoMapper {
/*

    @Named("toBalanceInfoDto")
    @Mappings({
            @Mapping(source = "credit", target = "credit"),
            @Mapping(source = "monetary", target = "monetary"),
            @Mapping(source = "reportDate", target = "reportDate"),
            @Mapping(source = "systemBlock", target = "systemBlock"),
            @Mapping(source = "userBlock", target = "userBlock")
    })
    @BeanMapping(ignoreByDefault = true)
    BalanceInfoDto toBalanceInfoDto(BalanceInfo balanceInfo);


    @Named("toBalanceInfo")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "credit", target = "credit"),
            @Mapping(source = "monetary", target = "monetary"),
            @Mapping(source = "reportDate", target = "reportDate"),
            @Mapping(source = "systemBlock", target = "systemBlock"),
            @Mapping(source = "userBlock", target = "userBlock")

    })
    BalanceInfo toBalanceInfo(BalanceInfoDto balanceInfoDto);

    @IterableMapping(qualifiedByName = "toBalanceInfo")
    List<BalanceInfo> toBalanceInfos(List<BalanceInfoDto> balanceInfoDtos);

    @IterableMapping(qualifiedByName = "toBalanceInfoDto")
    List<BalanceInfoDto> toBalanceInfoDtos(List<BalanceInfo> balanceInfos);
*/

}
