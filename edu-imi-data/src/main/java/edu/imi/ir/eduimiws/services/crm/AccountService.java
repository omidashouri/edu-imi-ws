package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;

public interface AccountService {

    AccountEntity findAccountByAccountPublicId(String accountPublicId);

    AccountDto findAccountDtoByAccountPublicId(String accountPublicId);
}
