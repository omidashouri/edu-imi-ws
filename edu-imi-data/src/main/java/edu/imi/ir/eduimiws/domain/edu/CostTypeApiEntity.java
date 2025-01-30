package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_COST_TYPE_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_COST_TYPE_API")
public class CostTypeApiEntity extends BaseEntity {


    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "COST_TYPE_ID")
    private CostTypeEntity costType;

    @Column(name = "COST_TYPE_PUBLIC_ID", length = 500)
    private String costTypePublicId;

    @Column(name = "DELETED_COST_TYPE_ID")
    private Long deletedCostTypeId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "COMPANY_PUBLIC_ID", length = 500)
    private String companyPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;
}
