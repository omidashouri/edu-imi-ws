package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.repositories.crm.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountEntity findAccountByAccountPublicId(String accountPublicId) {
        return accountRepository.findByAccountApi_AccountPublicId(accountPublicId);
    }

    @Override
    public AccountDto findAccountDtoByAccountPublicId(String accountPublicId) {
        AccountEntity account = this.
                findAccountByAccountPublicId(accountPublicId);
        return accountMapper.
                toAccountDto(account, new CycleAvoidingMappingContext());
    }


}
