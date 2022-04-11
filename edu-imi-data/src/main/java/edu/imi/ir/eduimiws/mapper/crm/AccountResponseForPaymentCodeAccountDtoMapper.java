package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.response.crm.AccountResponseForPaymentCode;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountResponseForPaymentCodeAccountDtoMapper {

    @Named("accountDtoToAccountResponseForPaymentCode")
    @Mappings({
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "economicalCode", target = "economicalCode"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "mainPhone", target = "mainPhone"),
            @Mapping(source = "otherPhone", target = "otherPhone")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountResponseForPaymentCode accountDtoToAccountResponseForPaymentCode(AccountDto source);

    @IterableMapping(qualifiedByName = "accountDtoToAccountResponseForPaymentCode")
    List<AccountResponseForPaymentCode> accountResponseForPaymentCodeToAccountDtos(List<AccountDto> sources);
}
