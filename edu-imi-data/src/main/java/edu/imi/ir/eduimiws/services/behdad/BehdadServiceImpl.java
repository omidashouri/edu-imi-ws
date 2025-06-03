package edu.imi.ir.eduimiws.services.behdad;

import edu.imi.ir.eduimiws.configurations.BehdadAccountServiceContext;
import edu.imi.ir.eduimiws.configurations.BehdadClientCertificate;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.BalanceInfoNewMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BehdadServiceImpl implements BehdadService {
    private final BalanceInfoNewMapper balanceInfoNewMapper;


    private final BehdadAccountServiceContext behdadAccountServiceContext;


    @BehdadClientCertificate
    @Override
    public List<AccountInfo> getAccountNumbers() {
        AccountService accountService = null;

        try {

//            List<AccountInfo> accountNumbers = new AccountServiceImplPortImpl().getAccountNumbers(credential1);

//            List<AccountInfo> accountNumbers = getAccountServicePort().getAccountNumbers(credential1);

            /*AccountServiceImplService accountService1 = new AccountServiceImplService();
            List<AccountInfo> accountNumbers = accountService1.getAccountServiceImplPort()
                                                    .getAccountNumbers(credential1);*/

            return this.getAccountServiceByProxy().getAccountNumbers(getCredential());

//            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


/*        try {
            Credential credential1 = new Credential();
            credential1.setUsername("2210008719");
            credential1.setPassword("Im!@0075175266");

        AccountServiceImplService accountServiceImplService = new AccountServiceImplService();

            AccountService accountService = accountServiceImplService.getAccountServiceImplPort();

            BehdadClientConfig.configureClientCertificate(accountService);

//            return accountService.getAccountNumbers(credential);
            return null;
        } catch (InvalidCredentialException_Exception e) {
            throw new RuntimeException(e);
        } catch (UnableToAuthenticateException_Exception e) {
            throw new RuntimeException(e);
        } catch (PasswordShouldBeChangeException_Exception e) {
            throw new RuntimeException(e);
        } catch (InvalidCertificateException_Exception e) {
            throw new RuntimeException(e);
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new RuntimeException(e);
        } catch (ExpiredOrNotValidCertificateException_Exception e) {
            throw new RuntimeException(e);
        } catch (UnableToGetClientCertificateInfo_Exception e) {
            throw new RuntimeException(e);
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @BehdadClientCertificate
    @Override
    public BalanceInfoDto getAccountBalance(String accountNumber) {

       try{
           AccountService accountService = this.getAccountServiceByProxy();
           AccountInfo accountInfo = new AccountInfo();
           accountInfo.setAccountNumber(accountNumber);
           BalanceInfo balanceInfo = this.getAccountServiceByProxy()
                   .getAccountBalance(getCredential(), accountInfo);
           if (balanceInfo == null) {
               return null;
           }
           return balanceInfoNewMapper.toBalanceInfoDto(balanceInfo);
       } catch (Exception e) {

           throw new RuntimeException("خطا در دریافت مانده حساب از سرویس بهداد", e);
       }
    }

    private AccountService getAccountServiceByProxy() throws Exception {
       return behdadAccountServiceContext.getAccountService();
    }

    private Credential getCredential(){
        Credential credential = new Credential();
        credential.setUsername("2210008719");
        credential.setPassword("Im!@0075175266");
        return credential;
    }
}
