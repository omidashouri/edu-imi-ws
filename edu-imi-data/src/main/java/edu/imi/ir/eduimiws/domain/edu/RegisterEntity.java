package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_REGISTER", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER")
public class RegisterEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERIOD_ID")
    private PeriodEntity period;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STUDENT_ID")
    private StudentEntity student;

    @Column(name="ACTIVITY_STATUS",precision = 2,scale = 0)
    private Long activityStatus;

    @Column(name="DELETE_STATUS",precision = 2,scale = 0)
    private Long deleteStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CREATOR")
    private PersonEntity creator;

    @Column(name="CREATE_DATE",length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EDITOR")
    private PersonEntity editor;

    @Column(name="EDIT_DATE",length = 10)
    private String editDate;

    @Column(name="FINANCIAL_STATUS",precision = 2,scale = 0)
    private Long financialStatus;

    @Column(name="REGISTER_TYPE",length = 20)
    private String registerType;

    @Column(name="FEE")
    private Long fee;

    @Column(name="PERIOD_CONTRACT_ID")
    private Long periodContractId;

    @Column(name="STATUS_DATE",length = 10)
    private String statusDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ACCOUNT_ID")
    private AccountEntity account;

    @Column(name="CONTRACT_ID")
    private Long contractId;

    @Column(name="REGISTER_DATE",length = 10)
    private String registerDate;

    @Column(name="PAID_FEE")
    private Long paidFee;

    @Column(name="DISCOUNT",precision = 20,scale = 0)
    private Long discount;

    @Column(name="TOTAL_PAID")
    private Long totalPaid;

    @Column(name="FINAL_SCORE")
    private Long finalScore;

    @Column(name="FINAL_STATUS",length = 20)
    private String finalStatus;

    @Column(name="FINANCIAL_DESC",length = 1000)
    private String financialDesc;

    @Column(name="REGISTER_FROM",length = 20)
    private String registerFrom;

    @Column(name="FILE_NEW_NAME",length = 50)
    private String fileNewName;

    @Column(name="FILE_OLD_NAME",length = 50)
    private String fileOldName;

    @Column(name="CARD_NO",length = 20)
    private String cardNo;

    @Column(name="EDUCATION_TYPE",length = 10)
    private String educationType;

    @Column(name="ATTACH_DATE",length = 10)
    private String attachDate;

    @Column(name="HAS_SANAD",length = 1)
    private String hasSanad;

    @Column(name="TEMP_SCORE",length = 20)
    private String tempScore;

    @Column(name="TEMP_TIME",length = 20)
    private String tempTime;

    @Column(name="TERM_FEE")
    private Long termFee;

    @Column(name="TEMP_DATE",length = 10)
    private String tempDate;

    @Column(name="FINANCIAL_STATUS_DATE",length = 10)
    private String financialStatusDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FINANCIAL_PERSON_ID")
    private PersonEntity financialPerson;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name="FROM_REGISTER_ID")
    private RegisterEntity fromRegister;

}
