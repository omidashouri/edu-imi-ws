package edu.imi.ir.eduimiws.utilities.behdad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum TransactionType {

    JDB("JDB","تایید شناسه با موجود بودن در دیتابیس"),
    JSH("JSH","تایید شناسه با بررسی با Verhoeff مبلغ"),
    SHDB("SHDB","تایید شناسه با بررسی با Verhoeff مبلغ و موجود بودن در دیتابیس"),
    JSHNA("JSHNA","تایید شناسه با بررسی با Verhoeff بدون مبلغ"),
    SHDBNA("SHDBNA","تایید شناسه با بررسی با Verhoeff بدون مبلغ و موجود بودن در دیتابیس"),
    REJ("REJ","عدم تایید شناسه"),
    NOC("NOC","تایید بدون بررسی"),
    JSHDSP("JSHDSP","تایید شناسه یکبار مصرف با Verhoeff مبلغ"),
    UNKNOWN("UNKNOWN", "نامشخص");

    private final String code;
    private final String description;

    TransactionType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator
    public static TransactionType getTransactionType(String code) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (Objects.equals(transactionType.getCode(), code)) {
                return transactionType;
            }
        }
        return TransactionType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType == this)
                return transactionType.getDescription();
        }
        return TransactionType.UNKNOWN.getDescription();
    }
}
