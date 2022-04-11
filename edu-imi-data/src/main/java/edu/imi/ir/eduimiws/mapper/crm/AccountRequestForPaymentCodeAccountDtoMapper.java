package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.LanguageEntity;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.LanguageDto;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.models.request.crm.AccountRequestForPaymentCode;
import edu.imi.ir.eduimiws.services.crm.CompanyService;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountRequestForPaymentCodeAccountDtoMapper {

    @Named("accountRequestForPaymentCodeToAccountDto")
    @Mappings({
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "economicalCode", target = "economicalCode"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "mainPhone", target = "mainPhone"),
            @Mapping(source = "otherPhone", target = "otherPhone")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountDto accountRequestForPaymentCodeToAccountDto(AccountRequestForPaymentCode source);

    @IterableMapping(qualifiedByName = "accountRequestForPaymentCodeToAccountDto")
    List<AccountDto> accountResponseForPaymentCodesToAccountDtos(List<AccountRequestForPaymentCode> sources);



    default void setDefaultCompanyForَUpdateAccountEntity(@MappingTarget AccountEntity account,
                                                          @Context DefaultValues defaultValues) {

        if(account.getLanguage()==null){
            LanguageEntity persianLanguage = new LanguageEntity();
            persianLanguage.setId(defaultValues.getPersianLanguageId());
            account.setLanguage(persianLanguage);
        }

        if(account.getCompany()==null){
            CompanyEntity imICompany = new CompanyEntity();
            imICompany.setId(defaultValues.getImiCompanyId());
            account.setCompany(imICompany);
        }
    }

    /**
     * Just for create From AccountForPaymentCode
     * @param accountDto
     * @param companyService
     */
     default void setDefaultCompanyForCreateAccountDto(@MappingTarget AccountDto accountDto, @Context CompanyService companyService) {
        LanguageDto persianLanguageDto = new LanguageDto();
        persianLanguageDto.setId(1L);
        accountDto.setLanguage(persianLanguageDto);
        accountDto.setLanguageId(1L);
        accountDto.setCompanyPublicId(companyService.getImiCompanyPublicId());
        accountDto.setCompany(companyService.getImiCompanyDtoById());
    }
}
