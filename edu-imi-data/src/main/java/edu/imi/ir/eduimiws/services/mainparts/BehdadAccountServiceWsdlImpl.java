package edu.imi.ir.eduimiws.services.mainparts;

//→1 import edu.imi.ir.eduimiws.models.behdad.account.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BehdadAccountServiceWsdlImpl {

}
       /*→1
       implements AccountService {


    private final Credential credentialAccount;
    private final WebServiceTemplate webServiceTemplateBehdadAccount;

    @Override
    public void setAccountControlType(Credential credential, AccountControlCreateModel createModel) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, UnableToGetClientCertificateInfo_Exception, ExpiredOrNotValidCertificateException_Exception, InvalidIdentifierControlTypeException_Exception, InvalidIdentifierTypeException_Exception, InvalidDateException_Exception, PasswordIsNotStrongException_Exception {

    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, UnableToChangePasswordException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, ExpiredOrNotValidCertificateException_Exception, UnableToGetClientCertificateInfo_Exception, PasswordIsNotStrongException_Exception {

    }

    @Override
    public BalanceInfo getAccountBalance(Credential credential, AccountInfo accountInfo) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, ExpiredOrNotValidCertificateException_Exception, UnableToGetClientCertificateInfo_Exception, PasswordIsNotStrongException_Exception {
        Credential credential1 = new Credential();
        credential1.setUsername("4101049330233336");
        credential1.setPassword("473240789615");
        AccountInfo accountInfo1 = new AccountInfo();
        accountInfo1.setAccountNumber("1401049330233336");
        GetAccountBalance getAccountBalance = new GetAccountBalance();
        getAccountBalance.setCredential(credential1);
        getAccountBalance.setAccountInfo(accountInfo1);
        Object o =  webServiceTemplateBehdadAccount.marshalSendAndReceive(new ObjectFactory().createGetAccountBalance(getAccountBalance));

        System.out.println("ssss");

        return null;
    }

    @Override
    public PagedData getPagedDestinationSideTransactions(Credential credential, SideTransactionsRequest sideTransactionsRequest, Paging paging) throws InvalidCredentialException_Exception, PasswordShouldBeChangeException_Exception, PageSizeIsTooMuchException_Exception, InvalidPageNumberException_Exception, UnableToAuthenticateException_Exception, InvalidTransactionTypeException_Exception, InvalidPageSizeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, UnableToGetClientCertificateInfo_Exception, ExpiredOrNotValidCertificateException_Exception, TransactionDoesNotBelongToAccount_Exception, PasswordIsNotStrongException_Exception {
        return null;
    }

    @Override
    public PagedData getBankTransactionsDetails(Credential credential, AccountTransactionFilter filter, Paging paging) throws InvalidCredentialException_Exception, PasswordShouldBeChangeException_Exception, PageSizeIsTooMuchException_Exception, InvalidPageNumberException_Exception, UnableToAuthenticateException_Exception, InvalidPageSizeException_Exception, UnableToGetTransactionsException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, UnableToGetClientCertificateInfo_Exception, ExpiredOrNotValidCertificateException_Exception, InvalidDateException_Exception, PasswordIsNotStrongException_Exception {
        return null;
    }

    @Override
    public PagedData getPagedSourceSideTransactions(Credential credential, SideTransactionsRequest sideTransactionsRequest, Paging paging) throws InvalidCredentialException_Exception, PasswordShouldBeChangeException_Exception, PageSizeIsTooMuchException_Exception, InvalidPageNumberException_Exception, UnableToAuthenticateException_Exception, InvalidTransactionTypeException_Exception, InvalidPageSizeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, UnableToGetClientCertificateInfo_Exception, ExpiredOrNotValidCertificateException_Exception, TransactionDoesNotBelongToAccount_Exception, PasswordIsNotStrongException_Exception {
        return null;
    }

    @Override
    public String getAccountControlType(Credential credential, AccountInfo accountInfo, String identifierType) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, ExpiredOrNotValidCertificateException_Exception, UnableToGetClientCertificateInfo_Exception, InvalidIdentifierTypeException_Exception, PasswordIsNotStrongException_Exception {
        return null;
    }

    @Override
    public PagedData getMultipleAccountTransactionsDetails(Credential credential, MultipleAccountTransactionFilter filter, Paging paging) throws InvalidCredentialException_Exception, PasswordShouldBeChangeException_Exception, TooMuchAccountsException_Exception, PageSizeIsTooMuchException_Exception, InvalidPageNumberException_Exception, UnableToAuthenticateException_Exception, InvalidPageSizeException_Exception, UnableToGetTransactionsException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, UnableToGetClientCertificateInfo_Exception, ExpiredOrNotValidCertificateException_Exception, InvalidDateException_Exception, PasswordIsNotStrongException_Exception {
        return null;
    }

    @Override
    public void clearAccountControlType(Credential credential, AccountInfo accountInfo, String identifierType) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, ExpiredOrNotValidCertificateException_Exception, UnableToGetClientCertificateInfo_Exception, InvalidIdentifierTypeException_Exception, PasswordIsNotStrongException_Exception {

    }

    @Override
    public List<AccountInfo> getAccountNumbers(Credential credential) throws InvalidCredentialException_Exception, UnableToAuthenticateException_Exception, PasswordShouldBeChangeException_Exception, InvalidCertificateException_Exception, UserTemporarilySuspendedException_Exception, ExpiredOrNotValidCertificateException_Exception, UnableToGetClientCertificateInfo_Exception, PasswordIsNotStrongException_Exception {





        return null;
    }
}*/
