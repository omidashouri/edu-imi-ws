package edu.imi.ir.eduimiws.utilities.behdad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum TransactionMediaType {

    ORGANIZATIONAL_CHEQUE("CHQ","چک دولتی"),
    PAYMENT_ORDER("POR","دستور پرداخت"),
    PAYA_PAYMENT_ORDER("PAY","دستور پرداخت پایا"),
    SATNA_PAYMENT_ORDER("POG","دستور پرداخت ساتنا"),
    RIAL_TRANSACTION_OFFICE("10","اداره معاملات ریالی"),
    SANAT_MADAN_BANK_CHEQUE("11","چک بانک صنعت و معدن"),
    MELLI_BANK_CHEQUE("12","چک بانک ملی"),
    REFAH_BANK_CHEQUE("13","چک بانک رفاه"),
    MASKAN_BANK_CHEQUE("14","چک بانک مسکن"),
    SEPAH_BANK_CHEQUE("15","چک بانک سپه"),
    KESHAVARZI_BANK_CHEQUE("16","چک بانک کشاورزی"),
    MELLAT_BANK_CHEQUE("17","چک بانک ملت"),
    TEJARAT_BANK_CHEQUE("18","چک بانک تجارت"),
    SADERAT_BANK_CHEQUE("19","چک بانک صادرات"),
    TOSE_SADERAT_BANK_CHEQUE("20","چک بانک توسعه صادرات"),
    POST_BANK_CHEQUE("21","چک پست بانک"),
    TOSE_TAAVON_CHEQUE("22","چک توسعه نعاون"),
    TOSE_ETEBARI_INSTITUTE_CHEQUE("51","چک موسسه اعتباری توسعه"),
    GHAVAMIN_BANK_CHEQUE("52","چک بانک قوامین"),
    KARAFARIN_BANK_CHEQUE("53","چک بانک کارآفرین"),
    PARSIAN_BANK_CHEQUE("54","چک بانک پارسیان"),
    EGHTESAD_NOVIN_BANK_CHEQUE("55","چک بانک اقتصاد نوین"),
    SAMAN_BANK_CHEQUE("56","چک بانک سامان"),
    PASARGAD_BANK_CHEQUE("57","چک بانک پاسارگاد"),
    SARMAYEH_BANK_CHEQUE("58","چک بانک سرمایه"),
    SINA_BANK_CHEQUE("59","چک بانک سینا"),
    GHARZILHASANE_MEHR_IRAN_BANK_CHEQUE("60","چک بانک قرض الحسنه مهر ایران"),
    SHAHR_BANK_CHEQUE("61","چک بانک شهر"),
    AYANDEH_BANK_CHEQUE("62","چک بانک آینده"),
    ANSAR_BANK_CHEQUE("63","چک بانک انصار"),
    GHARDESHGARI_BANK_CHEQUE("64","چک بانک گردشگری"),
    HEKMAT_IRANIAN_BANK_CHEQUE("65","چک بانک حکمت ایرانیان"),
    DEY_BANK_CHEQUE("66","چک بانک دی"),
    BANK_MANTAGHE_ESLAMI_BANK_CHEQUE("67","چک بانک منطقه اسلامی"),
    IRAN_ZAMIN_BANK_CHEQUE("69","چک بانک ایران زمین"),
    RESALAT_BANK_CHEQUE("70","چک بانک رسالت"),
    KOUSAR_CREDIT_INSTITUTE_CHEQUE("73","چک موسسه اعتباری کوثر"),
    ASGARIYEH_CREDIT_INSTITUTE_CHEQUE("75","چک موسسه اعتباری عسگریه"),
    KAVARMIYANEH_BANK_CHECK("78","چک بانک خاورمیانه"),
    TRAN_VENESUELA_COMMUNITY_BANK_CHEQUE("95","چک بانک مشترک ایران و ونزویلا"),
    SATNA_CASH_ORDER_PAYMENT("SCP","دستور پرداخت نقدی ساتنا"),
    BARVAT_CHEQUE("CHBRT","چک بروات"),
    INSTANT_BANK_CHECK("CHF","چک فوری بانک ها"),
    EMPLOYEE_PAYMENT_ORDER("DPK","دستور پرداخت کارمندی"),
    BON_CARD("BNC","بن کارت"),
    SYSTEMATIC_MEDIA("SYS","رسانه سیستمی"),
    BEHDAD_TRANSFER_MONETARY("BTM","انتقال وجوه بهداد"),
    BILL_PAYMENT("BPM","پرداخت قبض"),
    BILL_FEE_DEDUCTION("BFE","برداشت کارمزد قبض"),
    COMMISSION_REFUND("RBF","برگشت کارمزد"),
    MEDIA_RETURNED_BILLS("RBP","رسانه برگشت قبوض"),
    TREASURY_CHECK("CHI","چک خزانه"),
    BANKLET_TRANSFER("CHM","حواله بنکلت"),
    ATM_VIRTUAL_CARD("VAG","کارت مجازی ATM"),
    ISSUED_MEDIA("ISS","رسانه صادره"),
    SALARY_PAYMENT_ORDER("SPO","دستور پرداخت حقوقی"),
    ATM_CARD("ATC","کارت خودپرداز"),
    LETTER("NAM","نامه"),
    DOCUMENT("SAN","سند"),
    CASH_VOUCHER("CRE","فیش نقدی"),
    UNKNOWN("UNKNOWN", "نامشخص");

    private final String code;
    private final String title;

    TransactionMediaType(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @JsonCreator
    public static TransactionMediaType getTransactionMediaType(String code) {
        for (TransactionMediaType transactionMediaType : TransactionMediaType.values()) {
            if (Objects.equals(transactionMediaType.getCode(), code)) {
                return transactionMediaType;
            }
        }
        return TransactionMediaType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (TransactionMediaType transactionMediaType : TransactionMediaType.values()) {
            if (transactionMediaType == this)
                return transactionMediaType.getTitle();
        }
        return TransactionMediaType.UNKNOWN.getTitle();
    }
}
