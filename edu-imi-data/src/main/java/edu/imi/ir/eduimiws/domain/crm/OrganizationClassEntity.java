package edu.imi.ir.eduimiws.domain.crm;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS",sequenceName = "SEQ_ORGANIZATION_CLASS",allocationSize = 1)
@Table(schema = "MAINPARTS",name = "TBL_ORGANIZATION_CLASS")
public class OrganizationClassEntity extends BaseEntity {

    @Column(name="EFFICIENCY_COEFFICIENT")
    private Long efficiencyCoefficient;

    @Column(name="CLASS_NAME")
    private String className;

    @Column(name="PERFORMANCE_COEFFICIENT")
    private Long performanceCoefficient;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

//    @Getter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR_ID")
    private PersonEntity editor;

    @Column(name="CREATE_DATE")
    private String createDate;

    @Column(name="EDIT_DATE")
    private String editDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "organizationPosition",cascade = CascadeType.MERGE)
    private List<PersonEntity> personEntities= new ArrayList<>();


}
