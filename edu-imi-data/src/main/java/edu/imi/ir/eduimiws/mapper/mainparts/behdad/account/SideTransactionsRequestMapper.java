package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.BalanceInfo;
import edu.imi.ir.eduimiws.models.behdad.account.SideTransactionsRequest;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.SideTransactionsRequestDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SideTransactionsRequestMapper {
/*

    @Named("toSideTransactionsRequestDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "transactionId", target = "transactionId")
    })
    @BeanMapping(ignoreByDefault = true)
    SideTransactionsRequestDto toSideTransactionsRequestDto(SideTransactionsRequest sideTransactionsRequest);


    @Named("toSideTransactionsRequest")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "transactionId", target = "transactionId")

    })
    SideTransactionsRequest toSideTransactionsRequest(SideTransactionsRequestDto sideTransactionsRequestDto);

    @IterableMapping(qualifiedByName = "toSideTransactionsRequest")
    List<SideTransactionsRequest> toSideTransactionsRequests(List<SideTransactionsRequestDto> sideTransactionsRequestDtos);

    @IterableMapping(qualifiedByName = "toSideTransactionsRequestDto")
    List<SideTransactionsRequestDto> toSideTransactionsRequestDtos(List<SideTransactionsRequest> sideTransactionsRequests);
*/

}
