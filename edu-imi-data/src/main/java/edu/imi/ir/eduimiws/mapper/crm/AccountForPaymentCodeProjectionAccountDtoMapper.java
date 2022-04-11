package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.projections.crm.AccountForPaymentCodeProjection;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountForPaymentCodeProjectionAccountDtoMapper {

    @Named("accountForPaymentCodeProjectionToAccountDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "economicalCode", target = "economicalCode"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "mainPhone", target = "mainPhone"),
            @Mapping(source = "otherPhone", target = "otherPhone")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountDto accountForPaymentCodeProjectionToAccountDto(AccountForPaymentCodeProjection source);

    @IterableMapping(qualifiedByName = "accountForPaymentCodeProjectionToAccountDto")
    List<AccountDto> accountForPaymentCodeProjectionToAccountDtos(List<AccountForPaymentCodeProjection> sources);

}
