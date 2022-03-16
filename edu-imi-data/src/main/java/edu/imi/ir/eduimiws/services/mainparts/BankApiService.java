package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.BankApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.BankApiDto;

@MappingUtil.BankService
public interface BankApiService {

    BankApiEntity findByBankPublicId(String bankPublicId);

    @MappingUtil.BankPublicIdToBankDto
    BankApiDto findBankDtoByBankPublicId(String bankPublicId);
}
