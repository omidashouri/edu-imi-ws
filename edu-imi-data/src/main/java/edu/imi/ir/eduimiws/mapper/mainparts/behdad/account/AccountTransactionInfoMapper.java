package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.AccountTransactionInfo;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.AccountTransactionInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountTransactionInfoMapper{
/*

    @Named("toAccountTransactionInfoDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "transactionId", target = "transactionId"),
            @Mapping(source = "transactionIdentifier", target = "transactionIdentifier")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountTransactionInfoDto toAccountTransactionInfoDto(AccountTransactionInfo accountTransactionInfo);


    @Named("toAccountTransactionInfo")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "transactionId", target = "transactionId"),
            @Mapping(source = "transactionIdentifier", target = "transactionIdentifier")

    })
    AccountTransactionInfo toAccountTransactionInfo(AccountTransactionInfoDto accountTransactionInfoDto);

    @IterableMapping(qualifiedByName = "toAccountTransactionInfo")
    List<AccountTransactionInfo> toAccountTransactionInfos(List<AccountTransactionInfoDto> accountTransactionInfoDtos);

    @IterableMapping(qualifiedByName = "toAccountTransactionInfoDto")
    List<AccountTransactionInfoDto> toAccountTransactionInfoDtos(List<AccountTransactionInfo> accountTransactionInfos);

*/

}
