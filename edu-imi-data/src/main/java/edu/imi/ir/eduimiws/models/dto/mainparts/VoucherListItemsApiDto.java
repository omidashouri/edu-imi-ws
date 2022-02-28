package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherListItemsApiDto implements Serializable {

    private static final long serialVersionUID = 4002245839533797052L;

    private Long idApi;

    private String publicId;

    private String tarh;

    private Long sanad;

    private Long atf;

    private Long moein;

    private String codeTafzil;

    private Long dl6;

    private String sharh;

    private Long bestankar;

    private Long bedehkar;

    private String tarikhSanad;

    private String tarikhMiladi;

    private Timestamp tarikhMiladiTs;

    private Long eslahiHazfi;

    private String saderKonande;

    private String akharinVirayeshConande;

    private String saleMali;

    private String lastCreateDate;

    private String lastEditDate;

    private String lastCreateDateMiladi;

    private Timestamp lastCreateDateMiladiTs;

    private String lastEditDateMiladi;

    private Timestamp lastEditDateMiladiTs;

    private Long voucherNumber;

    private Long voucherSequence;

    private Long voucherDailyNumber;

    private Long fiscalYearRef;

    private Long fiscalYear;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long voucherDeleteItemsId;

    private Long recordStatus;

    private String searchQuery;

}
