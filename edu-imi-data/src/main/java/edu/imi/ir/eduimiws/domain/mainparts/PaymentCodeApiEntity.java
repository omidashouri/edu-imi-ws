package edu.imi.ir.eduimiws.domain.mainparts;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;


@NamedQueries({
        @NamedQuery(name = "PaymentCodeApiEntity.queryPageablePaymentCodeApiProjection",
                query = " select " +
                        " pcae.paymentCode as paymentCode," +
                        " pcae.paymentCodePublicId as paymentCodePublicId," +
                        " pcae.createDateTs as createDateTs," +
                        " pcae.editDateTs as editDateTs, " +
                        " pcae.deleteDateTs as deleteDateTs," +
                        " crta.personPublicId as creatorPublicId, " +
                        " pcae.description as description," +
                        " pcae.requestIp as requestIp, " +
                        " pcae.requestDescription as requestDescription, " +
                        " pcae.nationalCode as nationalCode," +
                        " exc.expenseCodePublicId as expenseCodePublicId, " +
                        " pcae.expenseCode as expenseCode, " +
                        " exc.expenseTitle as expenseTitle," +
                        " prja.projectPublicId as projectPublicId, " +
                        " pcae.projectCode as projectCode," +
                        " prj.projectName as projectName," +
                        " ba.bankPublicId as bankApiPublicId, " +
                        " pcae.requestCode as requestCode," +
                        " pua.personPublicId as payerUserPublicId, " +
                        " pca.contactPublicId as payerContactPublicId, " +
                        " pc.mobilePhone as payerContactMobilePhone, " +
                        " concat(pc.firstName,' ',pc.lastName) as payerContactFullName, " +
                        " acc.economicalCode as economicalCode, " +
                        " acc.accountName as accountName, " +
                        " acca.accountPublicId as accountPublicId " +
                        " from " +
                        " PaymentCodeApiEntity pcae " +
                        " left join pcae.creator crt left join crt.personApiEntity crta " +
                        " left join pcae.expenseCodeApi exc " +
                        " left join pcae.project prj left join prj.projectApi prja " +
                        " left join pcae.bankApi ba " +
                        " left join pcae.payerUser pu left join pu.personApiEntity pua " +
                        " left join pcae.payerContact pc left join pc.contactWebService pca " +
                        " left join pcae.account acc left join acc.accountApi acca " +
                        " where " +
                        " ( :paymentCode is null or pcae.paymentCode = :paymentCode ) AND " +
                        " ( :requestDescription is null or pcae.requestDescription like concat('%',:requestDescription,'%') ) AND " +
                        " ( :nationalCode is null or pcae.nationalCode = :nationalCode ) AND " +
                        " ( :expenseCode is null or pcae.expenseCode = :expenseCode ) AND " +
                        " ( :expenseTitle is null or exc.expenseTitle like concat('%',:expenseTitle,'%') ) AND " +
                        " ( :projectCode is null or prj.projectCode =  :projectCode ) AND " +
                        " ( :projectName is null or prj.projectName like concat('%',:projectName,'%') ) AND " +
                        " ( :payerContactMobilePhone is null or pc.mobilePhone = :payerContactMobilePhone ) AND " +
                        " ( :payerContactFullName is null or concat(pc.firstName,' ',pc.lastName)  like concat('%',:payerContactFullName,'%') ) AND " +
                        " ( :economicalCode is null or acc.economicalCode = :economicalCode ) AND " +
                        " ( :accountName is null or acc.accountName like concat('%',:accountName,'%') ) " +
                        " ORDER BY pcae.requestDescription desc NULLS LAST "
                /*hints =  {
                        @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                        @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                        @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
                },
                lockMode = LockModeType.READ*/
        )
})






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

    @Column(name = "PAYMENT_CODE",length = 34)
    private String paymentCode;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

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

    @Column(name = "NATIONAL_CODE",length = 11)
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_API_ID")
    private BankApiEntity bankApi;

    @Column(name = "REQUEST_CODE")
    private Long requestCode;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYER_CONTACT_ID")
    private ContactEntity payerContact;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYER_PERSON_ID")
    private PersonEntity payerUser;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

}
