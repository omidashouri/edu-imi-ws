package edu.imi.ir.eduimiws.domain.mainparts;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_VOUCHERDELETEITEMS_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_VOUCHERDELETEITEMS_API")
public class VoucherDeleteItemsApiEntity extends BaseEntity {

    @Column(name = "ID_API")
    private Long idApi;

    @Column(name = "PUBLIC_ID", length = 500)
    private String publicId;

    @Column(name = "REFERENCE_NUMBER", length = 500)
    private String referenceNumber;

    @Column(name = "VOUCHER_NUMBER")
    private Long voucherNumber;

    @Column(name = "VOUCHER_SEQUENCE")
    private Long voucherSequence;

    @Column(name = "VOUCHER_DAILY_NUMBER")
    private Long voucherDailyNumber;

    @Column(name = "FISCAL_YEAR_REF")
    private Long fiscalYearRef;

    @Column(name = "FISCAL_YEAR")
    private Long fiscalYear;

    @Column(name = "VOUCHER_DATE", length = 500)
    private String voucherDate;

    @Column(name = "VOUCHER_DATE_TS")
    private Timestamp voucherDateTs;

    @Column(name = "SHAMSI_VOUCHER_DATE", length = 500)
    private String shamsiVoucherDate;

    @Column(name = "VOUCHER_CREATOR", length = 500)
    private String voucherCreator;

    @Column(name = "DELETER", length = 500)
    private String deleter;

    @Column(name = "DELETER_USER_NAME", length = 500)
    private String deleterUserName;

    @Column(name = "DATE_OF_REMOVAL", length = 500)
    private String dateOfRemoval;

    @Column(name = "DATE_OF_REMOVAL_TS")
    private Timestamp dateOfRemovalTs;

    @Column(name = "SHAMSI_DATE_OF_REMOVAL", length = 500)
    private String shamsiDateOfRemoval;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "RECORD_STATUS")
    private Long recordStatus;
}
