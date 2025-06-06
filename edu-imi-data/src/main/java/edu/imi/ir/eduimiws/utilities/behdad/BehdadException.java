package edu.imi.ir.eduimiws.utilities.behdad;

public enum BehdadException {

    PASSWORD_IS_NOT_STRONG("PasswordIsNotStrongException","رمز عبور ضعیف است"),
    UNABLE_TO_AUTHENTICATE("UnableToAuthenticateException","امکان احراز هویت وجود ندارد"),
    INVALID_CREDENTIAL("InvalidCredentialException","اطلاعات احراز هویت نامعتبر است"),
    USER_TEMPORARILY_SUSPENDED("UserTemporarilySuspendedException","کاربر به طور موقت مسدود شده است"),
    UNABLE_TO_CHANGE_PASSWORD("UnableToChangePasswordException","امکان تغییر رمز عبور وجود ندارد"),
    INVALID_IDENTIFIER("InvalidIdentifierException","شناسه واریز نامعتبر است"),
    UNABLE_TO_GENERATE_IDENTIFIER("UnableToGenerateIdentifierException","امکان تولید شناسه واریز وجود ندارد"),
    VERHOEFF("VerhoeffException","شناسه از منظر الگوریتم ورهوف نامعتبر است"),
    IDENTIFIER_IS_N0T_EFFECTIVE("IdentifierIsNotEffectiveException","شناسه واریز فعال نیست"),
    INVALID_AMOUNT("InvalidAmountException","مبلغ معتبر نیست"),
    IDENTIFIER_NOT_FOUND("IdentifierNotFoundException","شناسه واریز یافت نشد"),
    INVALID_DATE("InvalidDateException","تاریخ معتبر نیست"),
    INVALID_IDENTIFIER_CODE("InvalidIdentifierCodeException","شناسه واریز معتبر نیست"),
    INVALID_ACCOUNT_NUMBER("InvalidAccountNumberException","شماره حساب معتبر نیست"),
    IDENTIFIER_IS_EXIST("IdentifierIsExistException","شناسه واریز تکراری است"),
    INVALID_IDENTIFIER_TYPE("InvalidIdentifierTypeException","نوع شناسه واریز نامعتبر است"),
    INVALID_IDENTIFIER_CONTROL_TYPE("InvalidIdentifierControlTypeException","نوع کنترل شناسه واریز نامعتبر است"),
    PAGE_SIZE_IS_TOO_MUCH("PageSizeIsTooMuchException","تعداد در هر صفحه بیش از حد مجاز است"),
    INVALID_PAGE_NUMBER("InvalidPageNumberException","شماره صفحه نامعتبر است"),
    INVALID_TRANSACTION_TYPE("InvalidTransactionTypeException","نوع تراکنش نامعتبر است"),
    INVALID_PAGE_SIZE("InvalidPageSizeException","تعداد در هر صفحه نامعتبر است"),
    UNABLE_TO_GET_TRANSACTIONS("UnableToGetTransactionsException","امکان دریافت اطلاعات تراکنش وجود ندارد"),
    TOO_MUCH_ACCOUNTS("TooMuchAccountsException","تعداد حساب ها بیش از حد مجاز است"),
    INAPPROPRIATE_IDENTIFIER("InappropriateIdentifierException","شناسه واریز شرایط شناسه های واریز تسهیم را ندارد"),
    INVALID_ACCOUNT_CREDENTIAL("InvalidAccountCredentialException","شناسه یا رمز عبور نادرست است"),
    UNABLE_T0_GENERATE_NEW_IDENTIFIER("UnableToGenerateNewIdentifierException","شناسه واریز جدید قابل ایجاد نیست"),
    INVALID_CERTIFICATE("InvalidCertificateException","گواهی کاربر برای ورود با این شناسه و رمز عبور نامعتبر است"),
    UNABLE_TO_GET_CLIENT_CERTIFICATE("UnableToGetClientCertificateInfoException","گواهی کاربر برای احراز هویت قابل شناسایی نیست"),
    EXPIRE_OR_NOT_VALID_CERTIFICATE("ExpiredOrNotValidCertificateException","گواهی کاربر منقضی شده است یا متناسب با این سامانه نیست"),
    PASSWORD_SHOULD_BE_CHANGE("PasswordShouldBeChangeException","رمز عبور می بایست تغییر کند"),
    TRANSACTION_DOES_NOT_BELONG_T0_ACCOUNT("TransactionDoesNotBelongToAccount","تراکنش با اطلاعات حساب مطابقت ندارد");


    final String message_en;
    final String message_fa;

    BehdadException(String message_en, String message_fa) {
        this.message_en = message_en;
        this.message_fa = message_fa;
    }

    public String getMessage_fa() {
        return message_fa;
    }

    public String getMessage_en() {
        return message_en;
    }
}
