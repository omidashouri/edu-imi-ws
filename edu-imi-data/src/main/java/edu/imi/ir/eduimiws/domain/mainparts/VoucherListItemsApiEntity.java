package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.models.projections.mainparts.VoucherListItemsDeleted;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "voucherListItemsDeleted",
                classes = {
                        @ConstructorResult(
                                targetClass = VoucherListItemsDeleted.class,
                                columns = {
                                        @ColumnResult(name = "voucherListItemsId", type = Long.class),
                                        @ColumnResult(name = "voucherListItemsIdApi", type = Long.class),
                                        @ColumnResult(name = "deleteItemsId", type = Long.class),
                                        @ColumnResult(name = "deleteItemsIdApi", type = Long.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(name = "voucherListItemsDeleted.count",
                columns = @ColumnResult(name = "cnt")
        )
})


//todo: add year to concat
@NamedNativeQueries({
        @NamedNativeQuery(name = "VoucherListItemsApiEntity.queryAllVoucherListItemsDeleted",
                query = " select vli.ID as voucherListItemsId, vli.ID_API as voucherListItemsIdApi, " +
                        " vdi.ID as deleteItemsId, vdi.ID_API as deleteItemsIdApi" +
                        " from MAINPARTS.TBL_VOUCHERLISTITEMS_API vli " +
                        " INNER JOIN MAINPARTS.TBL_VOUCHERDELETEITEMS_API vdi " +
                        " ON concat(concat(vli.VOUCHER_NUMBER, vli.VOUCHER_SEQUENCE), vli.VOUCHER_DAILY_NUMBER) = " +
                        " concat(concat(vdi.VOUCHER_NUMBER, vdi.VOUCHER_SEQUENCE),vdi.VOUCHER_DAILY_NUMBER) " +
                        " where " +
                        " vli.VOUCHER_DELETE_ITEMS_ID IS NULL ",
                resultSetMapping = "voucherListItemsDeleted"),
        @NamedNativeQuery(name = "VoucherListItemsApiEntity.queryAllVoucherListItemsDeleted.count",
                query = " select count(*) " +
                        " from MAINPARTS.TBL_VOUCHERLISTITEMS_API vli " +
                        " INNER JOIN MAINPARTS.TBL_VOUCHERDELETEITEMS_API vdi " +
                        " ON concat(concat(vli.VOUCHER_NUMBER, vli.VOUCHER_SEQUENCE), vli.VOUCHER_DAILY_NUMBER) = " +
                        " concat(concat(vdi.VOUCHER_NUMBER, vdi.VOUCHER_SEQUENCE),vdi.VOUCHER_DAILY_NUMBER) " +
                        " where " +
                        " vli.VOUCHER_DELETE_ITEMS_ID IS NULL ",
                resultSetMapping = "voucherListItemsDeleted.count")
})



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_VOUCHERLISTITEMS_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_VOUCHERLISTITEMS_API")
public class VoucherListItemsApiEntity extends BaseEntity {

    @Column(name = "ID_API")
    private Long idApi;

    @Column(name = "PUBLIC_ID", length = 500)
    private String publicId;

    @Column(name = "TARH", length = 500)
    private String tarh;

    @Column(name = "SANAD")
    private Long sanad;

    @Column(name = "ATF")
    private Long atf;

    @Column(name = "MOEIN")
    private Long moein;

    @Column(name = "CODE_TAFZIL", length = 500)
    private String codeTafzil;

    @Column(name = "DL6")
    private Long dl6;

    @Column(name = "SHARH", length = 500)
    private String sharh;

    @Column(name = "BESTANKAR")
    private Long bestankar;

    @Column(name = "BEDEHKAR")
    private Long bedehkar;

    @Column(name = "TARIKH_SANAD", length = 500)
    private String tarikhSanad;

    @Column(name = "TARIKH_MILADI", length = 500)
    private String tarikhMiladi;

    @Column(name = "TARIKH_MILADI_TS")
    private Timestamp tarikhMiladiTs;

    @Column(name = "ESLAHI_HAZFI")
    private Long eslahiHazfi;

    @Column(name = "SADER_KONANDE", length = 500)
    private String saderKonande;

    @Column(name = "AKHARIN_VIRAYESH_CONANDE", length = 500)
    private String akharinVirayeshConande;

    @Column(name = "SALEMALI", length = 500)
    private String saleMali;

    @Column(name = "LAST_CREATE_DATE", length = 500)
    private String lastCreateDate;

    @Column(name = "LAST_EDIT_DATE", length = 500)
    private String lastEditDate;

    @Column(name = "LAST_CREATE_DATE_MILADI", length = 500)
    private String lastCreateDateMiladi;

    @Column(name = "LAST_CREATE_DATE_MILADI_TS")
    private Timestamp lastCreateDateMiladiTs;

    @Column(name = "LAST_EDIT_DATE_MILADI", length = 500)
    private String lastEditDateMiladi;

    @Column(name = "LAST_EDIT_DATE_MILADI_TS")
    private Timestamp lastEditDateMiladiTs;

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

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "VOUCHER_DELETE_ITEMS_ID")
    private Long voucherDeleteItemsId;

    @Column(name = "RECORD_STATUS")
    private Long recordStatus;
}
