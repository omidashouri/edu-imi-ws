package edu.imi.ir.eduimiws.models.dto.mainparts;


import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDeleteItemsApiDto implements Serializable {

    private static final long serialVersionUID = -2110391622158221204L;

    private Long idApi;

    private String publicId;

    private String referenceNumber;

    private Long voucherNumber;

    private Long voucherSequence;

    private Long voucherDailyNumber;

    private Long fiscalYearRef;

    private Long fiscalYear;

    private String voucherDate;

    private Timestamp voucherDateTs;

    private String shamsiVoucherDate;

    private String voucherCreator;

    private String deleter;

    private String deleterUserName;

    private String dateOfRemoval;

    private Timestamp dateOfRemovalTs;

    private String shamsiDateOfRemoval;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private Timestamp editDateTs;

    private Long recordStatus;

}
