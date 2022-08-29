package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.AccountTransactionFilter;
import edu.imi.ir.eduimiws.models.behdad.account.ChangePasswordRequest;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.ChangePasswordRequestDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.AccountTransactionFilterDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountTransactionFilterMapper {
/*
    @Named("toAccountTransactionFilterDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "fromDateTime", target = "fromDateTime"),
            @Mapping(source = "paymentIdentifier", target = "paymentIdentifier"),
            @Mapping(source = "toDateTime", target = "toDateTime")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountTransactionFilterDto toAccountTransactionFilterDto(AccountTransactionFilter AccountTransactionFilter);


    @Named("toAccountTransactionFilter")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "fromDateTime", target = "fromDateTime"),
            @Mapping(source = "paymentIdentifier", target = "paymentIdentifier"),
            @Mapping(source = "toDateTime", target = "toDateTime")

    })
    AccountTransactionFilter toAccountTransactionFilter(AccountTransactionFilterDto AccountTransactionFilterDto);

    @IterableMapping(qualifiedByName = "toAccountTransactionFilter")
    List<AccountTransactionFilter> toAccountTransactionFilters(List<AccountTransactionFilterDto> AccountTransactionFilterDtos);

    @IterableMapping(qualifiedByName = "toAccountTransactionFilterDto")
    List<AccountTransactionFilterDto> toAccountTransactionFilterDtos(List<AccountTransactionFilter> AccountTransactionFilters);
    */
}
