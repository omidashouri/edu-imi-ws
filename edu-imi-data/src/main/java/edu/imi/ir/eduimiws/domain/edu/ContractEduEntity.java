package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_CONTRACT", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_CONTRACT_EDU")
public class ContractEduEntity extends BaseEntity {


    @Column(name = "NUMBER_CONTRACT", length = 20)
    private String numberContract;

    @Column(name = "START_DATE", length = 10)
    private String startDate;

    @Column(name = "CONTRACT_SUBJECT", length = 400)
    private String contractSubject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CONTRACT_TYPE_ID")
    private ParameterEntity contractTypeEntity;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "CONTRACT_DESC", length = 4000)
    private String contractDesc;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR_ID")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "CONTRACT_TYPE", length = 10)
    private String contractType;

    @Column(name = "FILE_NEW_NAME", length = 50)
    private String fileNewName;

    @Column(name = "FILE_OLD_NAME", length = 50)
    private String fileOldName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "contractEdu", fetch = FetchType.LAZY)
    private ContractEduApiEntity contractEduApi;
}
