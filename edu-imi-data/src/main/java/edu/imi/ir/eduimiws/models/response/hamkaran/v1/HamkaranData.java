package edu.imi.ir.eduimiws.models.response.hamkaran.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranData {


    private Long id;

    private String tarh;

    private Long sanad;

    private Long atf;

    private Long moeein;

    private String codtafsil;

    @JsonProperty("dL6")
    private Long dl6;

    private String sharh;

    private String bestankar;

    private String bedehkar;

    @JsonProperty("tarikh_sanad")
    private String tarikhSanad;

    @JsonProperty("tarikh_miladi")
    private String tarikhMiladi;

    @JsonProperty("eslahi_hazfi")
    private String eslahiHazfi;

    @JsonProperty("saderkonnade")
    private String saderKonande;

    @JsonProperty("akharin_virayesh_konande")
    private String akharinVirayeshKonande;

    @JsonProperty("salemali")
    private Long saleMali;

    @JsonProperty("last_create_date")
    private String lastCreateDate;

    @JsonProperty("last_edit_date")
    private String lastEdiDate;

    @JsonProperty("last_create_date_miladi")
    private String lastCreateDateMiladi;

    @JsonProperty("last_edit_date_miladi")
    private String lastEditDateMiladi;

    private Long voucherNumber;

    private Long voucherSequence;

    private Long voucherDailyNumber;

    private Long fiscalYearRef;

    private Long fiscalYear;

}
