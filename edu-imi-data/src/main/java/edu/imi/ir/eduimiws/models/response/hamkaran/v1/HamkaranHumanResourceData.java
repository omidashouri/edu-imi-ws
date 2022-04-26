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
public class HamkaranHumanResourceData {

    private Long id;

    @JsonProperty("shomare_mostakhdem")
    private String shomareMostakhdem;

    @JsonProperty("shomare_personeli")
    private String shomarePersoneli;

    @JsonProperty("code_melli")
    private String codeMelli;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("fullname")
    private String fullName;

    private Long employeeId;

    @JsonProperty("mablaghe_paein_hokm")
    private Long mablaghePaeinHokm;

    @JsonProperty("shoghl_id")
    private Long shoghlId;

    @JsonProperty("shoghl")
    private String shoghl;

    @JsonProperty("noe_gharardad_id")
    private Long noeGharardadId;

    @JsonProperty("noe_gharardad")
    private String noeGharardad;

    @JsonProperty("post_id")
    private Long postId;

    @JsonProperty("post")
    private String post;

    @JsonProperty("gorouh_id")
    private Long gorouhId;

    @JsonProperty("gorouh")
    private String gorouh;

    @JsonProperty("confirmdate")
    private String confirmDate;

    @JsonProperty("confirmdate_shamsi")
    private String confirmDateShamsi;

    @JsonProperty("noe_hokmId")
    private Long noeHokmId;

    @JsonProperty("noe_hokm")
    private String noeHokm;

    private Long departmentId;

    @JsonProperty("department_title")
    private String departmentTitle;

    @JsonProperty("last_create_date")
    private String lastCreateDate;

    @JsonProperty("last_edit_date")
    private String lastEditDate;

    @JsonProperty("karkarde_saati")
    private Long karkardeSaati;



}
