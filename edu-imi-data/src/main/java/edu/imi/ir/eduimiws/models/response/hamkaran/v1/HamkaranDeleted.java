package edu.imi.ir.eduimiws.models.response.hamkaran.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({"deletedVoucherId", "referenceNumber", "voucherNumber","voucherSequence",
                    "voucherDailyNumber","fiscalYearRef","fiscalYear","voucherDate",
                    "shamsiVoucherDate","voucherCreator","deleter","deleterUserName",
                    "dateOfRemoval","shamsiDateOfRemoval"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranDeleted {

    @JsonProperty("deletedVoucherID")
    private Long deletedVoucherId;

    private String referenceNumber;

    private Long voucherNumber;

    private Long voucherSequence;

    private Long voucherDailyNumber;

    private Long fiscalYearRef;

    private Long fiscalYear;

    private String voucherDate;

    private String shamsiVoucherDate;

    private String voucherCreator;

    private String deleter;

    private String deleterUserName;

    private String dateOfRemoval;

    private String shamsiDateOfRemoval;
}
