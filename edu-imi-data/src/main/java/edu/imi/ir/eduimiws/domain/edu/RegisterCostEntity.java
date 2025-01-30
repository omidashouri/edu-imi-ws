package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_REGISTER_COST", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER_COST")
public class RegisterCostEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COST_TYPE_ID")
    private CostTypeEntity costType;

    @Column(name = "CVALUE")
    private Long cvalue;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @Column(name = "REMARK", length = 200)
    private String remark;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_TERM_ID")
    private TermPeriodEntity periodTerm;

    @Column(name = "FINAL_COST")
    private Long finalCost;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "registerCost", fetch = FetchType.LAZY)
    private RegisterCostApiEntity registerCostApi;
}
