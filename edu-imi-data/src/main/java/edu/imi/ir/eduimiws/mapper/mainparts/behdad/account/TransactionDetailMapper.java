package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;


import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.SourceObject;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;
import edu.imi.ir.eduimiws.models.response.behdad.TransactionDetail;
import edu.imi.ir.eduimiws.models.wsdl.behdad.BalanceInfo;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionMediaType;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring",
        imports = {Map.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TransactionDetailMapper {

    @Named("toTransactionDetail")
    @Mappings({
            @Mapping(source = "fields", target = "accountNumber", qualifiedByName = "extractAccountNumber"),
            @Mapping(source = "fields", target = "amount", qualifiedByName = "extractAmount"),
            /*@Mapping(source = "fields", target = "balance", qualifiedByName = "extractBalance"),
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
            @Mapping(source = "fields", target = "transactionMediaSerial", qualifiedByName = "extractMediaSerial"),*/
            @Mapping(source = "fields", target = "transactionMediaType", qualifiedByName = "extractTransactionMediaType")
/*            @Mapping(source = "fields", target = "transactionMethod", qualifiedByName = "extractTransactionMethod"),
            @Mapping(source = "fields", target = "transactionStan", qualifiedByName = "extractStan"),
            @Mapping(source = "fields", target = "transactionStatusDate", qualifiedByName = "extractTransactionStatusDate"),
            @Mapping(source = "fields", target = "transactionStatusTime", qualifiedByName = "extractTransactionStatusTime"),
            @Mapping(source = "fields", target = "transactionStatusType", qualifiedByName = "extractTransactionStatusType"),
            @Mapping(source = "fields", target = "transactionTime", qualifiedByName = "extractTransactionTime"),
            @Mapping(source = "fields", target = "transactionType", qualifiedByName = "extractTransactionType")*/
    })
    @BeanMapping(ignoreByDefault = true)
    TransactionDetail toTransactionDetail(SourceObject  source);

    @Named("extractAccountNumber")
    default String extractAccountNumber(Map<String, Object> fields) {
        return fields != null ? (String) fields.get("accountNumber") : null;
    }

    @Named("extractAmount")
    default BigDecimal extractExtractAmount(Map<String, Object> fields) {
        return fields != null ? (BigDecimal) fields.get("amount") : null;
    }

    @Named("extractTransactionMediaType")
    default TransactionMediaType extractTransactionMediaType(Map<String, Object> fields) {
        return fields != null ? TransactionMediaType.valueOf((String) fields.get("TransactionMediaType")) : null;
    }

    @IterableMapping(qualifiedByName = "toTransactionDetail")
    List<TransactionDetail> toTransactionDetails(List<SourceObject> sources);
}
