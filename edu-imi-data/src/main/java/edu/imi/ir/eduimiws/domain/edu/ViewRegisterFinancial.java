package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Immutable
@Table(schema = "EDU", name = "TBL_REGISTER_FINANCIAL")
public class ViewRegisterFinancial implements Serializable {

    private static final long serialVersionUID = -2970384231110981238L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "DOC_NUMBER")
    private Long docNumber;

    @Column(name = "DOC_ROW")
    private Long docRow;

    @Column(name = "DOC_DESCRIPTION", length = 1500)
    private String docDescription;

    @Column(name = "DOC_DATE", length = 20)
    private String docDate;

    @Column(name = "BESTANKAR")
    private Long bestankar;

    @Column(name = "BEDEHKAR")
    private Long bedehkar;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE")
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE")
    private String editDate;

    @Column(name = "VOUCHER_ITEM_ID")
    private Long voucherItem;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACT_ID")
    private ContractEduEntity contract;

}
