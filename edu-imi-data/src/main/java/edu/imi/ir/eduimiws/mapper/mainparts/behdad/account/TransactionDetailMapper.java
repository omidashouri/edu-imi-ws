package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;


import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.SourceObject;
import edu.imi.ir.eduimiws.models.response.behdad.TransactionDetail;
import org.mapstruct.*;

import java.util.Map;

@Mapper(componentModel = "spring",
        imports = {Map.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TransactionDetailMapper {

    @Named("toTransactionDetail")
    @Mappings({
            @Mapping(source = "fields", target = "accountNumber", qualifiedByName = "extractAccountNumber"),
    })
    @BeanMapping(ignoreByDefault = true)
    TransactionDetail toTransactionDetail(SourceObject  source);

    @Named("extractAccountNumber")
    default String extractAccountNumber(Map<String, Object> fields) {
        return fields != null ? (String) fields.get("accountNumber") : null;
    }
}
