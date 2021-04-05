package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountApiEntity;
import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.repositories.crm.AccountApiRepository;
import edu.imi.ir.eduimiws.repositories.crm.ContactApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountApiServiceImpl implements AccountApiService{

    private final AccountApiRepository accountApiRepository;



    @Override
    public AccountEntity findAccountByAccountPublicId(String accountPublicId) {
        return accountApiRepository
                .findByAccountPublicId(accountPublicId)
                .map(AccountApiEntity::getAccount)
                .orElse(new AccountEntity());
    }

/*    @Override
    public Long findAccountIdByAccountPublicId(String accountPublicId) {
        return Optional
                .of(this.findByAccountPublicId(accountPublicId))
                .filter(Objects::nonNull)
                .map(AccountEntity::getId)
                .orElse(null);
    }*/
}
