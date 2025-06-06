package edu.imi.ir.eduimiws.utilities.behdad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum TransactionStatusType {

    DON("DON","انجام شده","وضعیت تراکنشی که محقق شده و مبلغ آن بر مانده آن طبقه تراکنش متناظر آن تاثیر می گذارد"),
    PND("PND","انتظار سیستمی","وضعیت تراکنشی که به صورت سیستمی ثبت شده است و بنا به کسب و کار سیستم در انتظار تغییر وضعیت به انجام شده یا باطل توسط سیستم می باشد. مبلغ تراکنش های دارای این وضعیت روی مانده طبقه تراکنش متناظر آنها تاثیر نمی گذارد"),
    UPD("UPD","انتظار کاربری","وضعیت تراکنشی که به صورت سیستمی ثبت شده است و بنا به کسب و کار سیستم در انتظار تغییر وضعیت به انجام شده یا باطل توسط کاربر می باشد. مبلغ تراکنش های دارای این وضعیت روی مانده طبقه تراکنش متناظر آنها تاثیر نمی گذارد"),
    EDP("EDP","انتظار لحظه ای","وضعیت تراکنشی است که به طور آنی محقق نشده بلکه با گذشت مدت زمان کوتاهی (چند ثانیه) از زمان ثبت محقق می گردد. اغلب در حساب هایی که در آنها تعداد زیادی تراکنش در مدت زمانی کئتاه ثبت می شوند، تراکنش ها ابتدا با این وضعیت ثبت شده و سپس به وضعیت انجام شده می رند. مبلغ تراکنش های دارای این وضعیت روی مانده طبقه تراکنش متناظر آنها تاثیر نمی گذارد"),
    CNL("CNL","باطل","وضعیت تراکنشی که ابطال شده است. مبلغ تراکنش های دارای این وضعیت روی مانده طبقه تراکنش متناظر آنها تاثیر نمی گذارد"),
    UNKNOWN("UNKNOWN","نامشخص", "نامشخص");

    private final String code;
    private final String title;
    private final String description;

    TransactionStatusType(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    @JsonCreator
    public static TransactionStatusType getTransactionStatusType(String code) {
        for (TransactionStatusType transactionMediaType : TransactionStatusType.values()) {
            if (Objects.equals(transactionMediaType.getCode(), code)) {
                return transactionMediaType;
            }
        }
        return TransactionStatusType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (TransactionStatusType transactionStatusType : TransactionStatusType.values()) {
            if (transactionStatusType == this)
                return transactionStatusType.getDescription();
        }
        return TransactionStatusType.UNKNOWN.getDescription();
    }
}
