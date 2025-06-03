package edu.imi.ir.eduimiws.services.behdad;

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountInfo;
import edu.imi.ir.eduimiws.models.wsdl.behdad.Credential;

import java.util.List;

public interface BehdadService {
    List<AccountInfo> getAccountNumbers();

    BalanceInfoDto getAccountBalance(String accountNumber) ;
}
