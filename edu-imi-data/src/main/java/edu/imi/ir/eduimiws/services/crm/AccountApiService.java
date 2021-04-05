package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;

public interface AccountApiService {

    AccountEntity findAccountByAccountPublicId(String accountPublicId);

//    Long findAccountIdByAccountPublicId(String accountPublicId);
}
