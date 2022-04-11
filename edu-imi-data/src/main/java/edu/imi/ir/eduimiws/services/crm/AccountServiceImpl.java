package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountForPaymentCodeProjectionAccountDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.projections.crm.AccountForPaymentCodeProjection;
import edu.imi.ir.eduimiws.repositories.crm.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountForPaymentCodeProjectionAccountDtoMapper accountForPaymentCodeProjectionAccountDtoMapper;
    private final CompanyService companyService;

    @Override
    public AccountEntity findAccountByAccountPublicId(String accountPublicId) {
        return accountRepository.findByAccountApi_AccountPublicId(accountPublicId);
    }

    @Override
    public AccountDto updateAccountForPaymentCode(AccountDto newAccountDto, AccountEntity editableAccount) {

        accountMapper.updateAccountByAccountDtoForPaymentCode(newAccountDto, editableAccount);

        AccountEntity updatedAccount = accountRepository.save(editableAccount);

        return accountMapper.toAccountDto(updatedAccount, new CycleAvoidingMappingContext());
    }

    @Override
    public AccountDto findAccountDtoByAccountPublicId(String accountPublicId) {
        AccountEntity account = this.
                findAccountByAccountPublicId(accountPublicId);
        return accountMapper.
                toAccountDto(account, new CycleAvoidingMappingContext());
    }

    @Override
    public Page<AccountDto> findAccountByEconomicalCodeForPaymentCode(String economicalCode, Pageable pageable) {
        Page<AccountForPaymentCodeProjection> accountForPaymentCodeProjections = accountRepository
                .queryPageableAccountForPaymentCodeProjection(null, null, economicalCode, null,
                        null, null, pageable);

        return accountForPaymentCodeProjections
                .map(accountForPaymentCodeProjectionAccountDtoMapper::accountForPaymentCodeProjectionToAccountDto);
    }

    @Override
    public Page<AccountDto> findAllPageableAccountForPaymentCode(Pageable pageable) {
        Page<AccountForPaymentCodeProjection> accountForPaymentCodeProjections = accountRepository
                .queryPageableAccountForPaymentCodeProjection(null, null, null, null,
                        null, null, pageable);

        return accountForPaymentCodeProjections
                .map(accountForPaymentCodeProjectionAccountDtoMapper::accountForPaymentCodeProjectionToAccountDto);
    }

    @Override
    public AccountEntity findAccountEntityByAccountApiPublicId(String accountPublicId) {
        AccountEntity account = accountRepository
                .readByAccountApi_AccountPublicId(accountPublicId);
        return account;
    }

    @Override
    public AccountDto createAccountForPaymentCode(AccountDto newAccountDto) {
        AccountEntity newAccount = new AccountEntity();

        newAccount =  accountMapper.toAccountEntity(newAccountDto, new CycleAvoidingMappingContext());

        AccountEntity savedAccount = accountRepository.save(newAccount);

        return accountMapper.toAccountDto(savedAccount, new CycleAvoidingMappingContext());
    }

    @Override
    public AccountDto findAccountById(Long id) {
        AccountEntity account = accountRepository.readById(id);
        AccountDto accountDto = Optional.of(account)
                .filter(Objects::nonNull)
                .map(ce -> accountMapper.toAccountDto(ce, new CycleAvoidingMappingContext()))
                .orElse(new AccountDto());
        return accountDto;
    }


}
