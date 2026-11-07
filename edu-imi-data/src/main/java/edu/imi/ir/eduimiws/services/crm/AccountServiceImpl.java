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
        log.info("AccountService.findAccountByAccountPublicId - accountPublicId: {}", accountPublicId);
        AccountEntity result = accountRepository.findByAccountApi_AccountPublicId(accountPublicId);
        log.info("AccountService.findAccountByAccountPublicId - result: {}", result);
        return result;
    }

    @Override
    public AccountDto updateAccountForPaymentCode(AccountDto newAccountDto, AccountEntity editableAccount) {
        log.info("AccountService.updateAccountForPaymentCode - newAccountDto: {}, editableAccount: {}",
                newAccountDto, editableAccount);

        accountMapper.updateAccountByAccountDtoForPaymentCode(newAccountDto, editableAccount);

        AccountEntity updatedAccount = accountRepository.save(editableAccount);

        AccountDto result = accountMapper.toAccountDto(updatedAccount, new CycleAvoidingMappingContext());
        log.info("AccountService.updateAccountForPaymentCode - result: {}", result);
        return result;
    }

    @Override
    public AccountDto findAccountDtoByAccountPublicId(String accountPublicId) {
        log.info("AccountService.findAccountDtoByAccountPublicId - accountPublicId: {}", accountPublicId);
        AccountEntity account = this.
                findAccountByAccountPublicId(accountPublicId);
        AccountDto result = accountMapper.
                toAccountDto(account, new CycleAvoidingMappingContext());
        log.info("AccountService.findAccountDtoByAccountPublicId - result: {}", result);
        return result;
    }

    @Override
    public Page<AccountDto> findAccountByEconomicalCodeForPaymentCode(String economicalCode, Pageable pageable) {
        log.info("AccountService.findAccountByEconomicalCodeForPaymentCode - economicalCode: {}, pageable: {}",
                economicalCode, pageable);
        Page<AccountForPaymentCodeProjection> accountForPaymentCodeProjections = accountRepository
                .queryPageableAccountForPaymentCodeProjection(null, null, economicalCode, null,
                        null, null, pageable);

        Page<AccountDto> result = accountForPaymentCodeProjections
                .map(accountForPaymentCodeProjectionAccountDtoMapper::accountForPaymentCodeProjectionToAccountDto);
        log.info("AccountService.findAccountByEconomicalCodeForPaymentCode - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<AccountDto> findAllPageableAccountForPaymentCode(Pageable pageable) {
        log.info("AccountService.findAllPageableAccountForPaymentCode - pageable: {}", pageable);
        Page<AccountForPaymentCodeProjection> accountForPaymentCodeProjections = accountRepository
                .queryPageableAccountForPaymentCodeProjection(null, null, null, null,
                        null, null, pageable);

        Page<AccountDto> result = accountForPaymentCodeProjections
                .map(accountForPaymentCodeProjectionAccountDtoMapper::accountForPaymentCodeProjectionToAccountDto);
        log.info("AccountService.findAllPageableAccountForPaymentCode - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public AccountEntity findAccountEntityByAccountApiPublicId(String accountPublicId) {
        log.info("AccountService.findAccountEntityByAccountApiPublicId - accountPublicId: {}", accountPublicId);
        AccountEntity account = accountRepository
                .readByAccountApi_AccountPublicId(accountPublicId);
        log.info("AccountService.findAccountEntityByAccountApiPublicId - result: {}", account);
        return account;
    }

    @Override
    public AccountDto createAccountForPaymentCode(AccountDto newAccountDto) {
        log.info("AccountService.createAccountForPaymentCode - newAccountDto: {}", newAccountDto);
        AccountEntity newAccount = new AccountEntity();

        newAccount =  accountMapper.toAccountEntity(newAccountDto, new CycleAvoidingMappingContext());

        AccountEntity savedAccount = accountRepository.save(newAccount);

        AccountDto result = accountMapper.toAccountDto(savedAccount, new CycleAvoidingMappingContext());
        log.info("AccountService.createAccountForPaymentCode - result: {}", result);
        return result;
    }

    @Override
    public AccountDto findAccountById(Long id) {
        log.info("AccountService.findAccountById - id: {}", id);
        AccountEntity account = accountRepository.readById(id);
        AccountDto accountDto = Optional.of(account)
                .filter(Objects::nonNull)
                .map(ce -> accountMapper.toAccountDto(ce, new CycleAvoidingMappingContext()))
                .orElse(new AccountDto());
        log.info("AccountService.findAccountById - result: {}", accountDto);
        return accountDto;
    }


}
