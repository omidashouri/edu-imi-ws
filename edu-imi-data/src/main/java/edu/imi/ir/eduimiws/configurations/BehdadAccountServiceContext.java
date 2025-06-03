package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountService;
import org.springframework.stereotype.Component;

@Component
public class BehdadAccountServiceContext {

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public boolean hasAccountService() {
        return accountService != null;
    }
}
