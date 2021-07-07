package edu.imi.ir.eduimiws.domain.mainparts;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_PAYMENT_CODE_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_PAYMENT_CODE_API")
public class PaymentCodeApiEntity extends BaseEntity {

    @Column(name = "PAYMENT_CODE_PUBLIC_ID",length = 500)
    private String paymentCodePublicId;

    @Column(name = "payment_code",length = 34)
    private String paymentCode;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "REQUEST_ID")
    private Long requestId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @Column(name = "DESCRIPTION",length = 500)
    private String description;

    @Column(name = "REQUEST_IP",length = 500)
    private String requestIp;

    @Column(name = "REQUEST_DESCRIPTION",length = 500)
    private String requestDescription;

    @Column(name = "NATIONAL_CODE",length = 10)
    private String nationalCode;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXPENSE_CODE_ID")
    private ExpenseCodeApiEntity expenseCodeApi;

    @Column(name = "EXPENSE_CODE")
    private Long expenseCode;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

    @Column(name = "PROJECT_CODE", length = 30)
    private String projectCode;

    @Column(name = "BANK_ID")
    private Long bankId;

    @Column(name = "BANK_CODE", length = 10)
    private String bankCode;

    @Column(name = "REQUEST_CODE")
    private Long requestCode;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID")
    private ContactEntity contact;
}
