package edu.imi.ir.eduimiws.utilities.behdad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@MappingUtil.TransactionMethodConverter
@Getter
public enum TransactionMethod {

    GENERAL("GENERAL","چک دولتی"),
    FEE("FEE","دستور پرداخت"),
    REVERSAL("REVERSAL","دستور پرداخت پایا"),
    FEE_REVERSAL("FEE_REVERSAL","دستور پرداخت ساتنا"),
    ATM_WITHDRAW("ATM_WITHDRAW","اداره معاملات ریالی"),
    ATM_PAYMANT("ATM_PAYMANT","چک بانک صنعت و معدن"),
    ATM_TRANSFER("ATM_TRANSFER","انتقال خودپرداز"),
    ATM_TRANSFER_TO("ATM_TRANSFER_TO","انتقال به توسط خودپرداز"),
    ATM_TRANSFER_FROM("ATM_TRANSFER_FROM","انتقال از توسط خودپرداز"),
    ATM_VOUCHER("ATM_VOUCHER","کارت شارژ خودپرداز"),
    POS_BUY("POS_BUY","خرید پایانه فروش"),
    POS_BILL_PAYMENT("POS_BILL_PAYMENT","پرداخت قبض پایانه فروش"),
    POS_VOUCHER("POS_VOUCHER","کارت شارژ پایانه فروش"),
    PIN_PAD_WITHDRAW("PIN_PAD_WITHDRAW","برداشت پایانه بانکی"),
    PIN_PAD_TRANSFER("PIN_PAD_TRANSFER","انتقال پایانه بانکی"),
    PIN_PAD_TRANSFER_TO("PIN_PAD_TRANSFER_TO","انتقال به پایانه بانکی"),
    PIN_PAD_TRANSFER_FROM("PIN_PAD_TRANSFER_FROM","انتقال از پایانه بانکی"),
    INTERNET_BUY("INTERNET_BUY","خرید اینترنتی"),
    INTERNET_BILL_PAYMENT("INTERNET_BILL_PAYMENT","پرداخت قبض اینترنتی"),
    INTERNET_TRANSFER("INTERNET_TRANSFER","انتقال اینرتنتی"),
    INTERNET_TRANSFER_TO("INTERNET_TRANSFER_TO","انتقال به توسط اینترنت"),
    INTERNET_TRANSFER_FROM("INTERNET_TRANSFER_FROM","انتقال از توسط اینترنت"),
    INTERNET_VOUCHER("INTERNET_VOUCHER","کارت شارژ اینترنت"),
    VRU_BILL_PAYMENT("VRU_BILL_PAYMENT","پرداخت قبض تلفن بانک"),
    MOBILE_BUY("MOBILE_BUY","خرید موبایل بانک"),
    MOBILE_BILL_PAYMENT("MOBILE_BILL_PAYMENT","پرداخت قبض موبایل بانک"),
    TRANSFER_FROM_RTGS("TRANSFER_FROM_RTGS","انتقال از ساتنا"),
    TRANSFER_TO_RTGS("TRANSFER_TO_RTGS","انتقال به ساتنا"),
    TRANSFER_FROM_ACH("TRANSFER_FROM_ACH","انتقال از پایا"),
    TRANSFER_TO_ACH("TRANSFER_TO_ACH","انتقال به پایا"),
    INCOMING("INCOMING","وارده"),
    ISSUE("ISSUE","صادره"),
    SALARY("SALARY","حقوق"),
    GROUP_DEPOSIT("GROUP_DEPOSIT","واریز گروهی"),
    GROUP_WITHDRAW("GROUP_WITHDRAW","برداشت گروهی"),
    COMPLEX_TRANSITION("COMPLEX_TRANSITION","عملیات مرکب"),
    LAST_INSTALLMENT_EARLY_SETTLEMENT("LAST_INSTALLMENT_EARLY_SETTLEMENT","آخرین تراکنش تسویه زودتر از موعد"),
    IDENTIFY_FINE_WITH_DEPOSIT("IDENTIFY_FINE_WITH_DEPOSIT","شناسایی جریمه با وصول"),
    ACHIEVED_IN_DIVIDE("ACHIEVED_IN_DIVIDE","تحقق یافته در تسهیم"),
    ATM_BILL_PAYMENT("ATM_BILL_PAYMENT","تمدید"),
    EXTEND("EXTEND","تمدید"),
    WATER_BILL("WATER_BILL","قبض آب"),
    ELECTRIC_BILL("ELECTRIC_BILL","قبض برق"),
    GAS_BILL("GAS_BILL","قبض گاز"),
    PHONE_BILL("PHONE_BILL","قبض تلفن"),
    MOBILE_BILL("MOBILE_BILL","قبض موبایل"),
    MUNICIPALITY_BILL("MUNICIPALITY_BILL","قبض شهرداری"),
    TAX_BILL("TAX_BILL","قبض مالیات"),
    POLICE_BILL("POLICE_BILL","قبض جریمه"),
    CREDIT_CHEQUE("CREDIT_CHEQUE","واگذاری چک - عادی"),
    GOVERNMENT_CREDIT_CHEQUE("GOVERNMENT_CREDIT_CHEQUE","واگذاری چک - ذینفع دولتی"),
    DEBIT_CHEQUE("DEBIT_CHEQUE","چک عهده"),
    TRANSFER_SALARY_TO_ACH("TRANSFER_SALARY_TO_ACH","واریز حقوق توسط پایا"),
    TRANSFER_SHAPARAK_FROM_ACH("TRANSFER_SHAPARAK_FROM_ACH","انتقال شاپرکی از پایا"),
    ATM_INTERNAL_TRANSFER_BATCH_FILE("ATM_INTERNAL_TRANSFER_BATCH_FILE","رفع مغایرت خودپرداز"),
    SHAP_INTERNAL_TRANSFER_BATCH_FILE("SHAP_INTERNAL_TRANSFER_BATCH_FILE","رفع مغایرت شاپرک"),
    TRANSFER_FROM_POL("TRANSFER_FROM_POL","انتقال از پل"),
    TRANSFER_TO_POL("TRANSFER_TO_POL","انتقال به پل"),
    KIOSK_BUY("KIOSK_BUY","خرید کیوسک"),
    KIOSK_TRANSFER("KIOSK_TRANSFER","انتقال کیوسک"),
    KIOSK_TRANSFER_FROM("KIOSK_TRANSFER_FROM","انتقال از توسط کیوسک"),
    KIOSK_TRANSFER_TO("KIOSK_TRANSFER_TO","انتقال به توسط کیوسک"),
    KIOSK_PAYMENT("KIOSK_PAYMENT","پرداخت کیوسک"),
    KIOSK_VOUCHER("KIOSK_VOUCHER","خرید شازژ توسط کیوسک"),
    MOBILE_VOUCHER("MOBILE_VOUCHER","خرید شازژ توسط موبایل بانک"),
    CRS_RECEIPT("CRS_RECEIPT","واریز وجه توسط خوددریافت"),
    UNKNOWN("UNKNOWN", "نامشخص");

    private final String code;
    private final String description;

    TransactionMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappingUtil.TransactionMethodByCode
    @JsonCreator
    public static TransactionMethod getTransactionMethod(String code) {
        for (TransactionMethod transactionMethod : TransactionMethod.values()) {
            if (Objects.equals(transactionMethod.getCode(), code)) {
                return transactionMethod;
            }
        }
        return TransactionMethod.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (TransactionMethod transactionMethod : TransactionMethod.values()) {
            if (transactionMethod == this)
                return transactionMethod.getDescription();
        }
        return TransactionMethod.UNKNOWN.getDescription();
    }
}
