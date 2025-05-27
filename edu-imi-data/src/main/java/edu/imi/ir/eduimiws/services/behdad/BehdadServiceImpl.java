package edu.imi.ir.eduimiws.services.behdad;

import edu.imi.ir.eduimiws.configurations.BehdadClientConfig;
import edu.imi.ir.eduimiws.configurations.UseClientCertificate;
import edu.imi.ir.eduimiws.models.wsdl.behdad.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BehdadServiceImpl implements BehdadService {


    // Expose the CXF port
/*    public AccountService getAccountServicePort() {
        AccountServiceImplService accountServiceImplService = new AccountServiceImplService();
        return accountServiceImplService.getAccountServiceImplPort();
    }*/

    @Override
//    @UseClientCertificate
    public List<AccountInfo> getAccountNumbers(Credential credential) {
        AccountService accountService = null;
        Credential credential1 = new Credential();
        credential1.setUsername("2210008719");
        credential1.setPassword("Im!@0075175266");
        try {

//            List<AccountInfo> accountNumbers = new AccountServiceImplPortImpl().getAccountNumbers(credential1);

//            List<AccountInfo> accountNumbers = getAccountServicePort().getAccountNumbers(credential1);

            /*AccountServiceImplService accountService1 = new AccountServiceImplService();
            List<AccountInfo> accountNumbers = accountService1.getAccountServiceImplPort()
                                                    .getAccountNumbers(credential1);*/

            accountService = this.getAccountServiceByProxy();
            return accountService.getAccountNumbers(credential1);

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


    private AccountService getAccountServiceByProxy() throws Exception {
       return BehdadClientConfig.createAccountServiceProxy();
    }
}
