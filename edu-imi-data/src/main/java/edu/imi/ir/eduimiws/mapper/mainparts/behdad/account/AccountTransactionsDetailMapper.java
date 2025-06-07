package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.AccountTransactionsDetailDto;
import edu.imi.ir.eduimiws.models.response.behdad.AccountTransactionsDetail;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountTransactionsDetailMapper {

    @Named("toAccountTransactionsDetail")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "balance", target = "balance"),
            @Mapping(source = "cardNumber", target = "cardNumber"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "destinationAccountNumber", target = "destinationAccountNumber"),
            @Mapping(source = "groupTransfer", target = "groupTransfer"),
            @Mapping(source = "iban", target = "iban"),
            @Mapping(source = "merchantId", target = "merchantId"),
            @Mapping(source = "sourceAccountNumber", target = "sourceAccountNumber"),
            @Mapping(source = "traceNumber", target = "traceNumber"),
            @Mapping(source = "transactionDate", target = "transactionDate"),
            @Mapping(source = "transactionId", target = "transactionId"),
            @Mapping(source = "transactionIdentifier", target = "transactionIdentifier"),
            @Mapping(source = "transactionMediaSerial", target = "transactionMediaSerial"),
            @Mapping(source = "transactionMethod", target = "transactionMethod"),
            @Mapping(source = "transactionStan", target = "transactionStan"),
            @Mapping(source = "transactionStatusDate", target = "transactionStatusDate"),
            @Mapping(source = "transactionStatusTime", target = "transactionStatusTime"),
            @Mapping(source = "transactionStatusType", target = "transactionStatusType"),
            @Mapping(source = "transactionTime", target = "transactionTime"),
            @Mapping(source = "transactionType", target = "transactionType")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountTransactionsDetail toAccountTransactionsDetail(AccountTransactionsDetailDto source);
}
