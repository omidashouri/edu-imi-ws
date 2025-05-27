
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.imi.ir.eduimiws.models.wsdl.behdad package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChangePassword_QNAME = new QName("com.misc.bis.behdad.service", "changePassword");
    private final static QName _ChangePasswordResponse_QNAME = new QName("com.misc.bis.behdad.service", "changePasswordResponse");
    private final static QName _ClearAccountControlType_QNAME = new QName("com.misc.bis.behdad.service", "clearAccountControlType");
    private final static QName _ClearAccountControlTypeResponse_QNAME = new QName("com.misc.bis.behdad.service", "clearAccountControlTypeResponse");
    private final static QName _GetAccountBalance_QNAME = new QName("com.misc.bis.behdad.service", "getAccountBalance");
    private final static QName _GetAccountBalanceResponse_QNAME = new QName("com.misc.bis.behdad.service", "getAccountBalanceResponse");
    private final static QName _GetAccountControlType_QNAME = new QName("com.misc.bis.behdad.service", "getAccountControlType");
    private final static QName _GetAccountControlTypeResponse_QNAME = new QName("com.misc.bis.behdad.service", "getAccountControlTypeResponse");
    private final static QName _GetAccountNumbers_QNAME = new QName("com.misc.bis.behdad.service", "getAccountNumbers");
    private final static QName _GetAccountNumbersResponse_QNAME = new QName("com.misc.bis.behdad.service", "getAccountNumbersResponse");
    private final static QName _GetBankTransactionsDetails_QNAME = new QName("com.misc.bis.behdad.service", "getBankTransactionsDetails");
    private final static QName _GetBankTransactionsDetailsResponse_QNAME = new QName("com.misc.bis.behdad.service", "getBankTransactionsDetailsResponse");
    private final static QName _GetMultipleAccountTransactionsDetails_QNAME = new QName("com.misc.bis.behdad.service", "getMultipleAccountTransactionsDetails");
    private final static QName _GetMultipleAccountTransactionsDetailsResponse_QNAME = new QName("com.misc.bis.behdad.service", "getMultipleAccountTransactionsDetailsResponse");
    private final static QName _GetPagedDestinationSideTransactions_QNAME = new QName("com.misc.bis.behdad.service", "getPagedDestinationSideTransactions");
    private final static QName _GetPagedDestinationSideTransactionsResponse_QNAME = new QName("com.misc.bis.behdad.service", "getPagedDestinationSideTransactionsResponse");
    private final static QName _GetPagedSourceSideTransactions_QNAME = new QName("com.misc.bis.behdad.service", "getPagedSourceSideTransactions");
    private final static QName _GetPagedSourceSideTransactionsResponse_QNAME = new QName("com.misc.bis.behdad.service", "getPagedSourceSideTransactionsResponse");
    private final static QName _SetAccountControlType_QNAME = new QName("com.misc.bis.behdad.service", "setAccountControlType");
    private final static QName _SetAccountControlTypeResponse_QNAME = new QName("com.misc.bis.behdad.service", "setAccountControlTypeResponse");
    private final static QName _InvalidCredentialException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidCredentialException");
    private final static QName _UnableToAuthenticateException_QNAME = new QName("com.misc.bis.behdad.service", "UnableToAuthenticateException");
    private final static QName _PasswordShouldBeChangeException_QNAME = new QName("com.misc.bis.behdad.service", "PasswordShouldBeChangeException");
    private final static QName _InvalidCertificateException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidCertificateException");
    private final static QName _UserTemporarilySuspendedException_QNAME = new QName("com.misc.bis.behdad.service", "UserTemporarilySuspendedException");
    private final static QName _UnableToGetClientCertificateInfo_QNAME = new QName("com.misc.bis.behdad.service", "UnableToGetClientCertificateInfo");
    private final static QName _ExpiredOrNotValidCertificateException_QNAME = new QName("com.misc.bis.behdad.service", "ExpiredOrNotValidCertificateException");
    private final static QName _InvalidIdentifierControlTypeException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidIdentifierControlTypeException");
    private final static QName _InvalidIdentifierTypeException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidIdentifierTypeException");
    private final static QName _InvalidDateException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidDateException");
    private final static QName _PasswordIsNotStrongException_QNAME = new QName("com.misc.bis.behdad.service", "PasswordIsNotStrongException");
    private final static QName _UnableToChangePasswordException_QNAME = new QName("com.misc.bis.behdad.service", "UnableToChangePasswordException");
    private final static QName _PageSizeIsTooMuchException_QNAME = new QName("com.misc.bis.behdad.service", "PageSizeIsTooMuchException");
    private final static QName _InvalidPageNumberException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidPageNumberException");
    private final static QName _InvalidTransactionTypeException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidTransactionTypeException");
    private final static QName _InvalidPageSizeException_QNAME = new QName("com.misc.bis.behdad.service", "InvalidPageSizeException");
    private final static QName _TransactionDoesNotBelongToAccount_QNAME = new QName("com.misc.bis.behdad.service", "TransactionDoesNotBelongToAccount");
    private final static QName _UnableToGetTransactionsException_QNAME = new QName("com.misc.bis.behdad.service", "UnableToGetTransactionsException");
    private final static QName _TooMuchAccountsException_QNAME = new QName("com.misc.bis.behdad.service", "TooMuchAccountsException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.imi.ir.eduimiws.models.wsdl.behdad
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link ClearAccountControlType }
     * 
     */
    public ClearAccountControlType createClearAccountControlType() {
        return new ClearAccountControlType();
    }

    /**
     * Create an instance of {@link ClearAccountControlTypeResponse }
     * 
     */
    public ClearAccountControlTypeResponse createClearAccountControlTypeResponse() {
        return new ClearAccountControlTypeResponse();
    }

    /**
     * Create an instance of {@link GetAccountBalance }
     * 
     */
    public GetAccountBalance createGetAccountBalance() {
        return new GetAccountBalance();
    }

    /**
     * Create an instance of {@link GetAccountBalanceResponse }
     * 
     */
    public GetAccountBalanceResponse createGetAccountBalanceResponse() {
        return new GetAccountBalanceResponse();
    }

    /**
     * Create an instance of {@link GetAccountControlType }
     * 
     */
    public GetAccountControlType createGetAccountControlType() {
        return new GetAccountControlType();
    }

    /**
     * Create an instance of {@link GetAccountControlTypeResponse }
     * 
     */
    public GetAccountControlTypeResponse createGetAccountControlTypeResponse() {
        return new GetAccountControlTypeResponse();
    }

    /**
     * Create an instance of {@link GetAccountNumbers }
     * 
     */
    public GetAccountNumbers createGetAccountNumbers() {
        return new GetAccountNumbers();
    }

    /**
     * Create an instance of {@link GetAccountNumbersResponse }
     * 
     */
    public GetAccountNumbersResponse createGetAccountNumbersResponse() {
        return new GetAccountNumbersResponse();
    }

    /**
     * Create an instance of {@link GetBankTransactionsDetails }
     * 
     */
    public GetBankTransactionsDetails createGetBankTransactionsDetails() {
        return new GetBankTransactionsDetails();
    }

    /**
     * Create an instance of {@link GetBankTransactionsDetailsResponse }
     * 
     */
    public GetBankTransactionsDetailsResponse createGetBankTransactionsDetailsResponse() {
        return new GetBankTransactionsDetailsResponse();
    }

    /**
     * Create an instance of {@link GetMultipleAccountTransactionsDetails }
     * 
     */
    public GetMultipleAccountTransactionsDetails createGetMultipleAccountTransactionsDetails() {
        return new GetMultipleAccountTransactionsDetails();
    }

    /**
     * Create an instance of {@link GetMultipleAccountTransactionsDetailsResponse }
     * 
     */
    public GetMultipleAccountTransactionsDetailsResponse createGetMultipleAccountTransactionsDetailsResponse() {
        return new GetMultipleAccountTransactionsDetailsResponse();
    }

    /**
     * Create an instance of {@link GetPagedDestinationSideTransactions }
     * 
     */
    public GetPagedDestinationSideTransactions createGetPagedDestinationSideTransactions() {
        return new GetPagedDestinationSideTransactions();
    }

    /**
     * Create an instance of {@link GetPagedDestinationSideTransactionsResponse }
     * 
     */
    public GetPagedDestinationSideTransactionsResponse createGetPagedDestinationSideTransactionsResponse() {
        return new GetPagedDestinationSideTransactionsResponse();
    }

    /**
     * Create an instance of {@link GetPagedSourceSideTransactions }
     * 
     */
    public GetPagedSourceSideTransactions createGetPagedSourceSideTransactions() {
        return new GetPagedSourceSideTransactions();
    }

    /**
     * Create an instance of {@link GetPagedSourceSideTransactionsResponse }
     * 
     */
    public GetPagedSourceSideTransactionsResponse createGetPagedSourceSideTransactionsResponse() {
        return new GetPagedSourceSideTransactionsResponse();
    }

    /**
     * Create an instance of {@link SetAccountControlType }
     * 
     */
    public SetAccountControlType createSetAccountControlType() {
        return new SetAccountControlType();
    }

    /**
     * Create an instance of {@link SetAccountControlTypeResponse }
     * 
     */
    public SetAccountControlTypeResponse createSetAccountControlTypeResponse() {
        return new SetAccountControlTypeResponse();
    }

    /**
     * Create an instance of {@link InvalidCredentialException }
     * 
     */
    public InvalidCredentialException createInvalidCredentialException() {
        return new InvalidCredentialException();
    }

    /**
     * Create an instance of {@link UnableToAuthenticateException }
     * 
     */
    public UnableToAuthenticateException createUnableToAuthenticateException() {
        return new UnableToAuthenticateException();
    }

    /**
     * Create an instance of {@link PasswordShouldBeChangeException }
     * 
     */
    public PasswordShouldBeChangeException createPasswordShouldBeChangeException() {
        return new PasswordShouldBeChangeException();
    }

    /**
     * Create an instance of {@link InvalidCertificateException }
     * 
     */
    public InvalidCertificateException createInvalidCertificateException() {
        return new InvalidCertificateException();
    }

    /**
     * Create an instance of {@link UserTemporarilySuspendedException }
     * 
     */
    public UserTemporarilySuspendedException createUserTemporarilySuspendedException() {
        return new UserTemporarilySuspendedException();
    }

    /**
     * Create an instance of {@link UnableToGetClientCertificateInfo }
     * 
     */
    public UnableToGetClientCertificateInfo createUnableToGetClientCertificateInfo() {
        return new UnableToGetClientCertificateInfo();
    }

    /**
     * Create an instance of {@link ExpiredOrNotValidCertificateException }
     * 
     */
    public ExpiredOrNotValidCertificateException createExpiredOrNotValidCertificateException() {
        return new ExpiredOrNotValidCertificateException();
    }

    /**
     * Create an instance of {@link InvalidIdentifierControlTypeException }
     * 
     */
    public InvalidIdentifierControlTypeException createInvalidIdentifierControlTypeException() {
        return new InvalidIdentifierControlTypeException();
    }

    /**
     * Create an instance of {@link InvalidIdentifierTypeException }
     * 
     */
    public InvalidIdentifierTypeException createInvalidIdentifierTypeException() {
        return new InvalidIdentifierTypeException();
    }

    /**
     * Create an instance of {@link InvalidDateException }
     * 
     */
    public InvalidDateException createInvalidDateException() {
        return new InvalidDateException();
    }

    /**
     * Create an instance of {@link PasswordIsNotStrongException }
     * 
     */
    public PasswordIsNotStrongException createPasswordIsNotStrongException() {
        return new PasswordIsNotStrongException();
    }

    /**
     * Create an instance of {@link UnableToChangePasswordException }
     * 
     */
    public UnableToChangePasswordException createUnableToChangePasswordException() {
        return new UnableToChangePasswordException();
    }

    /**
     * Create an instance of {@link PageSizeIsTooMuchException }
     * 
     */
    public PageSizeIsTooMuchException createPageSizeIsTooMuchException() {
        return new PageSizeIsTooMuchException();
    }

    /**
     * Create an instance of {@link InvalidPageNumberException }
     * 
     */
    public InvalidPageNumberException createInvalidPageNumberException() {
        return new InvalidPageNumberException();
    }

    /**
     * Create an instance of {@link InvalidTransactionTypeException }
     * 
     */
    public InvalidTransactionTypeException createInvalidTransactionTypeException() {
        return new InvalidTransactionTypeException();
    }

    /**
     * Create an instance of {@link InvalidPageSizeException }
     * 
     */
    public InvalidPageSizeException createInvalidPageSizeException() {
        return new InvalidPageSizeException();
    }

    /**
     * Create an instance of {@link TransactionDoesNotBelongToAccount }
     * 
     */
    public TransactionDoesNotBelongToAccount createTransactionDoesNotBelongToAccount() {
        return new TransactionDoesNotBelongToAccount();
    }

    /**
     * Create an instance of {@link UnableToGetTransactionsException }
     * 
     */
    public UnableToGetTransactionsException createUnableToGetTransactionsException() {
        return new UnableToGetTransactionsException();
    }

    /**
     * Create an instance of {@link TooMuchAccountsException }
     * 
     */
    public TooMuchAccountsException createTooMuchAccountsException() {
        return new TooMuchAccountsException();
    }

    /**
     * Create an instance of {@link Credential }
     * 
     */
    public Credential createCredential() {
        return new Credential();
    }

    /**
     * Create an instance of {@link AccountControlCreateModel }
     * 
     */
    public AccountControlCreateModel createAccountControlCreateModel() {
        return new AccountControlCreateModel();
    }

    /**
     * Create an instance of {@link ChangePasswordRequest }
     * 
     */
    public ChangePasswordRequest createChangePasswordRequest() {
        return new ChangePasswordRequest();
    }

    /**
     * Create an instance of {@link AccountInfo }
     * 
     */
    public AccountInfo createAccountInfo() {
        return new AccountInfo();
    }

    /**
     * Create an instance of {@link BalanceInfo }
     * 
     */
    public BalanceInfo createBalanceInfo() {
        return new BalanceInfo();
    }

    /**
     * Create an instance of {@link SideTransactionsRequest }
     * 
     */
    public SideTransactionsRequest createSideTransactionsRequest() {
        return new SideTransactionsRequest();
    }

    /**
     * Create an instance of {@link Paging }
     * 
     */
    public Paging createPaging() {
        return new Paging();
    }

    /**
     * Create an instance of {@link PagedData }
     * 
     */
    public PagedData createPagedData() {
        return new PagedData();
    }

    /**
     * Create an instance of {@link AccountTransactionInfo }
     * 
     */
    public AccountTransactionInfo createAccountTransactionInfo() {
        return new AccountTransactionInfo();
    }

    /**
     * Create an instance of {@link AccountTransactionFilter }
     * 
     */
    public AccountTransactionFilter createAccountTransactionFilter() {
        return new AccountTransactionFilter();
    }

    /**
     * Create an instance of {@link BankTransaction }
     * 
     */
    public BankTransaction createBankTransaction() {
        return new BankTransaction();
    }

    /**
     * Create an instance of {@link MultipleAccountTransactionFilter }
     * 
     */
    public MultipleAccountTransactionFilter createMultipleAccountTransactionFilter() {
        return new MultipleAccountTransactionFilter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearAccountControlType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClearAccountControlType }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "clearAccountControlType")
    public JAXBElement<ClearAccountControlType> createClearAccountControlType(ClearAccountControlType value) {
        return new JAXBElement<ClearAccountControlType>(_ClearAccountControlType_QNAME, ClearAccountControlType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearAccountControlTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClearAccountControlTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "clearAccountControlTypeResponse")
    public JAXBElement<ClearAccountControlTypeResponse> createClearAccountControlTypeResponse(ClearAccountControlTypeResponse value) {
        return new JAXBElement<ClearAccountControlTypeResponse>(_ClearAccountControlTypeResponse_QNAME, ClearAccountControlTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBalance }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountBalance }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountBalance")
    public JAXBElement<GetAccountBalance> createGetAccountBalance(GetAccountBalance value) {
        return new JAXBElement<GetAccountBalance>(_GetAccountBalance_QNAME, GetAccountBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountBalanceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountBalanceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountBalanceResponse")
    public JAXBElement<GetAccountBalanceResponse> createGetAccountBalanceResponse(GetAccountBalanceResponse value) {
        return new JAXBElement<GetAccountBalanceResponse>(_GetAccountBalanceResponse_QNAME, GetAccountBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountControlType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountControlType }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountControlType")
    public JAXBElement<GetAccountControlType> createGetAccountControlType(GetAccountControlType value) {
        return new JAXBElement<GetAccountControlType>(_GetAccountControlType_QNAME, GetAccountControlType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountControlTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountControlTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountControlTypeResponse")
    public JAXBElement<GetAccountControlTypeResponse> createGetAccountControlTypeResponse(GetAccountControlTypeResponse value) {
        return new JAXBElement<GetAccountControlTypeResponse>(_GetAccountControlTypeResponse_QNAME, GetAccountControlTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountNumbers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountNumbers }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountNumbers")
    public JAXBElement<GetAccountNumbers> createGetAccountNumbers(GetAccountNumbers value) {
        return new JAXBElement<GetAccountNumbers>(_GetAccountNumbers_QNAME, GetAccountNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountNumbersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAccountNumbersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getAccountNumbersResponse")
    public JAXBElement<GetAccountNumbersResponse> createGetAccountNumbersResponse(GetAccountNumbersResponse value) {
        return new JAXBElement<GetAccountNumbersResponse>(_GetAccountNumbersResponse_QNAME, GetAccountNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankTransactionsDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBankTransactionsDetails }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getBankTransactionsDetails")
    public JAXBElement<GetBankTransactionsDetails> createGetBankTransactionsDetails(GetBankTransactionsDetails value) {
        return new JAXBElement<GetBankTransactionsDetails>(_GetBankTransactionsDetails_QNAME, GetBankTransactionsDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankTransactionsDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBankTransactionsDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getBankTransactionsDetailsResponse")
    public JAXBElement<GetBankTransactionsDetailsResponse> createGetBankTransactionsDetailsResponse(GetBankTransactionsDetailsResponse value) {
        return new JAXBElement<GetBankTransactionsDetailsResponse>(_GetBankTransactionsDetailsResponse_QNAME, GetBankTransactionsDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultipleAccountTransactionsDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMultipleAccountTransactionsDetails }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getMultipleAccountTransactionsDetails")
    public JAXBElement<GetMultipleAccountTransactionsDetails> createGetMultipleAccountTransactionsDetails(GetMultipleAccountTransactionsDetails value) {
        return new JAXBElement<GetMultipleAccountTransactionsDetails>(_GetMultipleAccountTransactionsDetails_QNAME, GetMultipleAccountTransactionsDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultipleAccountTransactionsDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMultipleAccountTransactionsDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getMultipleAccountTransactionsDetailsResponse")
    public JAXBElement<GetMultipleAccountTransactionsDetailsResponse> createGetMultipleAccountTransactionsDetailsResponse(GetMultipleAccountTransactionsDetailsResponse value) {
        return new JAXBElement<GetMultipleAccountTransactionsDetailsResponse>(_GetMultipleAccountTransactionsDetailsResponse_QNAME, GetMultipleAccountTransactionsDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagedDestinationSideTransactions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPagedDestinationSideTransactions }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getPagedDestinationSideTransactions")
    public JAXBElement<GetPagedDestinationSideTransactions> createGetPagedDestinationSideTransactions(GetPagedDestinationSideTransactions value) {
        return new JAXBElement<GetPagedDestinationSideTransactions>(_GetPagedDestinationSideTransactions_QNAME, GetPagedDestinationSideTransactions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagedDestinationSideTransactionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPagedDestinationSideTransactionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getPagedDestinationSideTransactionsResponse")
    public JAXBElement<GetPagedDestinationSideTransactionsResponse> createGetPagedDestinationSideTransactionsResponse(GetPagedDestinationSideTransactionsResponse value) {
        return new JAXBElement<GetPagedDestinationSideTransactionsResponse>(_GetPagedDestinationSideTransactionsResponse_QNAME, GetPagedDestinationSideTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagedSourceSideTransactions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPagedSourceSideTransactions }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getPagedSourceSideTransactions")
    public JAXBElement<GetPagedSourceSideTransactions> createGetPagedSourceSideTransactions(GetPagedSourceSideTransactions value) {
        return new JAXBElement<GetPagedSourceSideTransactions>(_GetPagedSourceSideTransactions_QNAME, GetPagedSourceSideTransactions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPagedSourceSideTransactionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPagedSourceSideTransactionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "getPagedSourceSideTransactionsResponse")
    public JAXBElement<GetPagedSourceSideTransactionsResponse> createGetPagedSourceSideTransactionsResponse(GetPagedSourceSideTransactionsResponse value) {
        return new JAXBElement<GetPagedSourceSideTransactionsResponse>(_GetPagedSourceSideTransactionsResponse_QNAME, GetPagedSourceSideTransactionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAccountControlType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetAccountControlType }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "setAccountControlType")
    public JAXBElement<SetAccountControlType> createSetAccountControlType(SetAccountControlType value) {
        return new JAXBElement<SetAccountControlType>(_SetAccountControlType_QNAME, SetAccountControlType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAccountControlTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetAccountControlTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "setAccountControlTypeResponse")
    public JAXBElement<SetAccountControlTypeResponse> createSetAccountControlTypeResponse(SetAccountControlTypeResponse value) {
        return new JAXBElement<SetAccountControlTypeResponse>(_SetAccountControlTypeResponse_QNAME, SetAccountControlTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCredentialException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidCredentialException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidCredentialException")
    public JAXBElement<InvalidCredentialException> createInvalidCredentialException(InvalidCredentialException value) {
        return new JAXBElement<InvalidCredentialException>(_InvalidCredentialException_QNAME, InvalidCredentialException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToAuthenticateException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToAuthenticateException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "UnableToAuthenticateException")
    public JAXBElement<UnableToAuthenticateException> createUnableToAuthenticateException(UnableToAuthenticateException value) {
        return new JAXBElement<UnableToAuthenticateException>(_UnableToAuthenticateException_QNAME, UnableToAuthenticateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordShouldBeChangeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PasswordShouldBeChangeException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "PasswordShouldBeChangeException")
    public JAXBElement<PasswordShouldBeChangeException> createPasswordShouldBeChangeException(PasswordShouldBeChangeException value) {
        return new JAXBElement<PasswordShouldBeChangeException>(_PasswordShouldBeChangeException_QNAME, PasswordShouldBeChangeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCertificateException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidCertificateException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidCertificateException")
    public JAXBElement<InvalidCertificateException> createInvalidCertificateException(InvalidCertificateException value) {
        return new JAXBElement<InvalidCertificateException>(_InvalidCertificateException_QNAME, InvalidCertificateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserTemporarilySuspendedException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserTemporarilySuspendedException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "UserTemporarilySuspendedException")
    public JAXBElement<UserTemporarilySuspendedException> createUserTemporarilySuspendedException(UserTemporarilySuspendedException value) {
        return new JAXBElement<UserTemporarilySuspendedException>(_UserTemporarilySuspendedException_QNAME, UserTemporarilySuspendedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToGetClientCertificateInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToGetClientCertificateInfo }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "UnableToGetClientCertificateInfo")
    public JAXBElement<UnableToGetClientCertificateInfo> createUnableToGetClientCertificateInfo(UnableToGetClientCertificateInfo value) {
        return new JAXBElement<UnableToGetClientCertificateInfo>(_UnableToGetClientCertificateInfo_QNAME, UnableToGetClientCertificateInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpiredOrNotValidCertificateException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExpiredOrNotValidCertificateException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "ExpiredOrNotValidCertificateException")
    public JAXBElement<ExpiredOrNotValidCertificateException> createExpiredOrNotValidCertificateException(ExpiredOrNotValidCertificateException value) {
        return new JAXBElement<ExpiredOrNotValidCertificateException>(_ExpiredOrNotValidCertificateException_QNAME, ExpiredOrNotValidCertificateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidIdentifierControlTypeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidIdentifierControlTypeException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidIdentifierControlTypeException")
    public JAXBElement<InvalidIdentifierControlTypeException> createInvalidIdentifierControlTypeException(InvalidIdentifierControlTypeException value) {
        return new JAXBElement<InvalidIdentifierControlTypeException>(_InvalidIdentifierControlTypeException_QNAME, InvalidIdentifierControlTypeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidIdentifierTypeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidIdentifierTypeException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidIdentifierTypeException")
    public JAXBElement<InvalidIdentifierTypeException> createInvalidIdentifierTypeException(InvalidIdentifierTypeException value) {
        return new JAXBElement<InvalidIdentifierTypeException>(_InvalidIdentifierTypeException_QNAME, InvalidIdentifierTypeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidDateException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidDateException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidDateException")
    public JAXBElement<InvalidDateException> createInvalidDateException(InvalidDateException value) {
        return new JAXBElement<InvalidDateException>(_InvalidDateException_QNAME, InvalidDateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordIsNotStrongException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PasswordIsNotStrongException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "PasswordIsNotStrongException")
    public JAXBElement<PasswordIsNotStrongException> createPasswordIsNotStrongException(PasswordIsNotStrongException value) {
        return new JAXBElement<PasswordIsNotStrongException>(_PasswordIsNotStrongException_QNAME, PasswordIsNotStrongException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToChangePasswordException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToChangePasswordException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "UnableToChangePasswordException")
    public JAXBElement<UnableToChangePasswordException> createUnableToChangePasswordException(UnableToChangePasswordException value) {
        return new JAXBElement<UnableToChangePasswordException>(_UnableToChangePasswordException_QNAME, UnableToChangePasswordException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PageSizeIsTooMuchException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PageSizeIsTooMuchException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "PageSizeIsTooMuchException")
    public JAXBElement<PageSizeIsTooMuchException> createPageSizeIsTooMuchException(PageSizeIsTooMuchException value) {
        return new JAXBElement<PageSizeIsTooMuchException>(_PageSizeIsTooMuchException_QNAME, PageSizeIsTooMuchException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPageNumberException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidPageNumberException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidPageNumberException")
    public JAXBElement<InvalidPageNumberException> createInvalidPageNumberException(InvalidPageNumberException value) {
        return new JAXBElement<InvalidPageNumberException>(_InvalidPageNumberException_QNAME, InvalidPageNumberException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidTransactionTypeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidTransactionTypeException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidTransactionTypeException")
    public JAXBElement<InvalidTransactionTypeException> createInvalidTransactionTypeException(InvalidTransactionTypeException value) {
        return new JAXBElement<InvalidTransactionTypeException>(_InvalidTransactionTypeException_QNAME, InvalidTransactionTypeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPageSizeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidPageSizeException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "InvalidPageSizeException")
    public JAXBElement<InvalidPageSizeException> createInvalidPageSizeException(InvalidPageSizeException value) {
        return new JAXBElement<InvalidPageSizeException>(_InvalidPageSizeException_QNAME, InvalidPageSizeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionDoesNotBelongToAccount }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransactionDoesNotBelongToAccount }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "TransactionDoesNotBelongToAccount")
    public JAXBElement<TransactionDoesNotBelongToAccount> createTransactionDoesNotBelongToAccount(TransactionDoesNotBelongToAccount value) {
        return new JAXBElement<TransactionDoesNotBelongToAccount>(_TransactionDoesNotBelongToAccount_QNAME, TransactionDoesNotBelongToAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnableToGetTransactionsException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnableToGetTransactionsException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "UnableToGetTransactionsException")
    public JAXBElement<UnableToGetTransactionsException> createUnableToGetTransactionsException(UnableToGetTransactionsException value) {
        return new JAXBElement<UnableToGetTransactionsException>(_UnableToGetTransactionsException_QNAME, UnableToGetTransactionsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TooMuchAccountsException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TooMuchAccountsException }{@code >}
     */
    @XmlElementDecl(namespace = "com.misc.bis.behdad.service", name = "TooMuchAccountsException")
    public JAXBElement<TooMuchAccountsException> createTooMuchAccountsException(TooMuchAccountsException value) {
        return new JAXBElement<TooMuchAccountsException>(_TooMuchAccountsException_QNAME, TooMuchAccountsException.class, null, value);
    }

}
