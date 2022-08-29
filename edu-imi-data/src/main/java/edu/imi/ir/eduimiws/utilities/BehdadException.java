package edu.imi.ir.eduimiws.utilities;

public enum BehdadException {

    _PasswordIsNotStrong("PasswordIsNotStrongException","رمز عبور ضعیف است"),
    _UnableToAuthenticate("UnableToAuthenticateException","امکان احراز هویت وجود ندارد"),
    _InvalidCredential("InvalidCredentialException","اطلاعات احراز هویت نامعتبر است"),
    _UserTemporarilySuspended("UserTemporarilySuspendedException","کاربر به طور موقت مسدود شده است"),
    _UnableToChangePassword("UnableToChangePasswordException","امکان تغییر رمز عبور وجود ندارد"),
    _InvalidIdentifier("InvalidIdentifierException","شناسه واریز نامعتبر است"),
    _UnableToGenerateIdentifier("UnableToGenerateIdentifierException","امکان تولید شناسه واریز وجود ندارد"),
    _Verhoeff("VerhoeffException","شناسه از منظر الگوریتم ورهوف نامعتبر است"),
    _IdentifierIsNotEffective("IdentifierIsNotEffectiveException","شناسه واریز فعال نیست"),
    _InvalidAmount("InvalidAmountException","مبلغ معتبر نیست"),
    _IdentifierNotFound("IdentifierNotFoundException","شناسه واریز یافت نشد"),
    _InvalidDate("InvalidDateException","تاریخ معتبر نیست"),
    _InvalidIdentifierCode("InvalidIdentifierCodeException","شناسه واریز معتبر نیست"),
    _InvalidAccountNumber("InvalidAccountNumberException","شماره حساب معتبر نیست"),
    _IdentifierIsExist("IdentifierIsExistException","شناسه واریز تکراری است"),
    _InvalidIdentifierType("InvalidIdentifierTypeException","نوع شناسه واریز نامعتبر است"),
    _InvalidIdentifierControlType("InvalidIdentifierControlTypeException","نوع کنترل شناسه واریز نامعتبر است"),
    _PageSizeIsTooMuch("PageSizeIsTooMuchException","تعداد در هر صفحه بیش از حد مجاز است"),
    _InvalidPageNumber("InvalidPageNumberException","شماره صفحه نامعتبر است"),
    _InvalidTransactionType("InvalidTransactionTypeException","نوع تراکنش نامعتبر است"),
    _InvalidPageSize("InvalidPageSizeException","تعداد در هر صفحه نامعتبر است"),
    _UnableToGetTransactions("UnableToGetTransactionsException","امکان دریافت اطلاعات تراکنش وجود ندارد"),
    _TooMuchAccounts("TooMuchAccountsException","تعداد حساب ها بیش از حد مجاز است"),
    _TransactionDoesNotBelongToAccount("TransactionDoesNotBelongToAccount","تراکنش با اطلاعات حساب مطابقت ندارد");


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
