package edu.imi.ir.eduimiws.utilities;

public enum BehdadTransactionMethod {

    _General("General","عملیاتی که در در لیست نیست یا توسط کاربر مشخص نشده است");

    final String code;
    final String description;

    BehdadTransactionMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
