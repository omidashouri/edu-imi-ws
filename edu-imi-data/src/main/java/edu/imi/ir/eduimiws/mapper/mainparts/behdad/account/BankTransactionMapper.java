package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BankTransactionDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.BankTransaction;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionMediaType;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionMethod;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionStatusType;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionType;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {TransactionMediaType.class, TransactionMethod.class,
                TransactionStatusType.class, TransactionType.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BankTransactionMapper {

    @Named("toBankTransactionDto")
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
            @Mapping(source = "transactionMediaType", target = "transactionMediaType",
                    qualifiedBy = {MappingUtil.TransactionMediaTypeConverter.class,
                            MappingUtil.TransactionMediaTypeByCode.class}),
            @Mapping(source = "transactionMethod", target = "transactionMethod",
                    qualifiedBy = {MappingUtil.TransactionMethodConverter.class,
                            MappingUtil.TransactionMethodByCode.class}),
            @Mapping(source = "transactionStan", target = "transactionStan"),
            @Mapping(source = "transactionStatusDate", target = "transactionStatusDate"),
            @Mapping(source = "transactionStatusTime", target = "transactionStatusTime"),
            @Mapping(source = "transactionStatusType", target = "transactionStatusType",
                    qualifiedBy = {MappingUtil.TransactionStatusTypeConverter.class,
                            MappingUtil.TransactionStatusTypeByCode.class}),
            @Mapping(source = "transactionTime", target = "transactionTime"),
            @Mapping(source = "transactionType", target = "transactionType",
                    qualifiedBy = {MappingUtil.TransactionTypeConverter.class,
                            MappingUtil.TransactionTypeByCode.class})
    })
    @BeanMapping(ignoreByDefault = true)
    BankTransactionDto toBankTransactionDto(BankTransaction source);

    @IterableMapping(qualifiedByName = "toBankTransactionDto")
    List<BankTransactionDto> toBankTransactionDtos(List<BankTransaction> source);
}


//todo: add converter for enum objects

/*@Mappings({
            @Mapping(source = "fields", target = "accountNumber", qualifiedByName = "extractAccountNumber"),
            @Mapping(source = "fields", target = "amount", qualifiedByName = "extractAmount"),
            @Mapping(source = "fields", target = "balance", qualifiedByName = "extractBalance"),
            @Mapping(source = "fields", target = "cardNumber", qualifiedByName = "extractCardNumber"),
            @Mapping(source = "fields", target = "description", qualifiedByName = "extractDescription"),
            @Mapping(source = "fields", target = "destinationAccountNumber", qualifiedByName = "extractDestinationAccountNumber"),
            @Mapping(source = "fields", target = "iban", qualifiedByName = "extractIban"),
            @Mapping(source = "fields", target = "merchantId", qualifiedByName = "extractMerchantId"),
            @Mapping(source = "fields", target = "sourceAccountNumber", qualifiedByName = "extractSourceAccountNumber"),
            @Mapping(source = "fields", target = "traceNumber", qualifiedByName = "extractNumber"),
            @Mapping(source = "fields", target = "transactionDate", qualifiedByName = "extractTransactionDate"),
            @Mapping(source = "fields", target = "transactionId", qualifiedByName = "extractTransactionId"),
            @Mapping(source = "fields", target = "transactionIdentifier", qualifiedByName = "extractIdentifier"),
            @Mapping(source = "fields", target = "transactionMediaSerial", qualifiedByName = "extractMediaSerial"),
            @Mapping(source = "fields", target = "transactionMediaType", qualifiedByName = "extractTransactionMediaType")
            @Mapping(source = "fields", target = "transactionMethod", qualifiedByName = "extractTransactionMethod"),
            @Mapping(source = "fields", target = "transactionStan", qualifiedByName = "extractStan"),
            @Mapping(source = "fields", target = "transactionStatusDate", qualifiedByName = "extractTransactionStatusDate"),
            @Mapping(source = "fields", target = "transactionStatusTime", qualifiedByName = "extractTransactionStatusTime"),
            @Mapping(source = "fields", target = "transactionStatusType", qualifiedByName = "extractTransactionStatusType"),
            @Mapping(source = "fields", target = "transactionTime", qualifiedByName = "extractTransactionTime"),
            @Mapping(source = "fields", target = "transactionType", qualifiedByName = "extractTransactionType")
    })*/