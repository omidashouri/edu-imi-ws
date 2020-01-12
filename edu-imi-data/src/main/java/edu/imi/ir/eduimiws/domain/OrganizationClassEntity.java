package edu.imi.ir.eduimiws.domain;


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
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS",sequenceName = "SEQ_ORGANIZATION_CLASS_ID",allocationSize = 1)
@Table(schema = "MAINPARTS",name = "TBL_ORGANIZATION_CLASS")
public class OrganizationClassEntity extends BaseEntity {

    @Column(name="EFFICIENCY_COEFFICIENT")
    private String efficiencyCoefficient;

    @Column(name="CLASS_NAME")
    private String className;

    @Column(name="PERFORMANCE_COEFFICIENT")
    private String performanceCoefficient;

    @Column(name="CREATOR_ID")
    private String creatorId;

    @Column(name="EDITOR_ID")
    private String editorId;

    @Column(name="CREATE_DATE")
    private String createDate;

    @Column(name="EDIT_DATE")
    private String editDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "organizationPositionId",cascade = CascadeType.PERSIST)   //with cascade when save user the address information also saved
    private List<PersonEntity> personEntities= new ArrayList<>();


}
