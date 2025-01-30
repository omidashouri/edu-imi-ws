package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_COST_TYPE", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_COST_TYPE")
public class CostTypeEntity extends BaseEntity {


    @Column(name = "TITLE", length = 200)
    private String title;

    @Column(name = "CVALUE")
    private Long cvalue;

    @Column(name = "TYPE", length = 1)
    private String type;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

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

    @Column(name = "ACTIVITY_STATUS", length = 3)
    private String activityStatus;

    @Column(name = "CASH_AMOUNT")
    private Long cashAmount;

    @Column(name = "CHANGEABLE", length = 1)
    private String changeable;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "costType", fetch = FetchType.LAZY)
    private CostTypeApiEntity costTypeApi;
}
