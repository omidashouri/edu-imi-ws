package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;

public interface AccountService {

    AccountEntity findAccountByAccountPublicId(String accountPublicId);
}
