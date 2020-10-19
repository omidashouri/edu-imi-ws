package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.ParameterEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_REFUND", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_REFUND")
public class RefundEntity extends BaseEntity {

    @Column(name = "SUBJECT", length = 500)
    private String subject;

    @Column(name = "PRICE", length = 20)
    private String price;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "PAYMENT_TYPE", length = 20)
    private String paymentType;

    @Column(name = "PLAN_ID")
    private Long planId;

    @Column(name = "RE_DATE", length = 10)
    private String reDate;

    @Column(name = "SECTION_ID")
    private Long sectionId;

    @Column(name = "SECTION_NAME", length = 30)
    private String sectionName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    private ParameterEntity bank;

    @Column(name = "BANK_ACCOUNT_OWNER", length = 50)
    private String bankAccountOwner;

    @Column(name = "BANK_CARD_NUMBER", length = 20)
    private String bankCardNumber;

    @Column(name = "TO_PERSON", length = 150)
    private String toPerson;

    @Column(name = "ACTIVITY_STATUS", length = 2)
    private String activityStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "refund", fetch = FetchType.LAZY)
    private RefundApiEntity refundApi;
}
