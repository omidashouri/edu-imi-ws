package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;

@MappingUtil.AccountService
public interface AccountService {

    AccountEntity findAccountByAccountPublicId(String accountPublicId);

    @MappingUtil.AccountPublicIdToAccountDto
    AccountDto findAccountDtoByAccountPublicId(String accountPublicId);
}
