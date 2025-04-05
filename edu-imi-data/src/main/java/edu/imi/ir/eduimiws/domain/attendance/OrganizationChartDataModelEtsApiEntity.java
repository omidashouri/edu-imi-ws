package edu.imi.ir.eduimiws.domain.attendance;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_TBL_ORGANIZATION_CHART_DATA_MODEL_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_ORGANIZATION_CHART_DATA_MODEL_ETS_API")
public class OrganizationChartDataModelEtsApiEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORGANIZATION_CHART_ID")
    private Long organizationChartId;

    @Column(name = "ORGANIZATION_CHART_NAME", length = 500)
    private String organizationChartName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_INFO_ID")
    private EmployeeInfoEtsApiEntity employee;

}
