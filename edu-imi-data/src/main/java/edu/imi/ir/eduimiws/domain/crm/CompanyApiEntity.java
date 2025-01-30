package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_COMPANY_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_COMPANY_API")
public class CompanyApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "COMPANY_PUBLIC_ID", length = 500)
    private String companyPublicId;

    @Column(name = "DELETED_COMPANY_ID")
    private Long deletedCompanyId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
