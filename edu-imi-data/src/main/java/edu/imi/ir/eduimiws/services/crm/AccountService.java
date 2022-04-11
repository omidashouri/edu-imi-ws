package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@MappingUtil.AccountService
public interface AccountService {

    AccountEntity findAccountByAccountPublicId(String accountPublicId);

    AccountDto updateAccountForPaymentCode(AccountDto newAccountDto, AccountEntity editableAccount);

    @MappingUtil.AccountPublicIdToAccountDto
    AccountDto findAccountDtoByAccountPublicId(String accountPublicId);

    Page<AccountDto> findAccountByEconomicalCodeForPaymentCode(String economicalCode, Pageable pageable);

    Page<AccountDto> findAllPageableAccountForPaymentCode(Pageable pageable);

    AccountEntity findAccountEntityByAccountApiPublicId(String accountPublicId);

    AccountDto createAccountForPaymentCode(AccountDto newAccountDto);

    AccountDto findAccountById(Long id);
}
