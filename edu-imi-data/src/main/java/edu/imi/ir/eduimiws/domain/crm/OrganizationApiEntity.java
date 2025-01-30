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
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_ORGANIZATION_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_ORGANIZATION_API")
public class OrganizationApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @Column(name = "ORGANIZATION_PUBLIC_ID", length = 500)
    private String organizationPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @Column(name = "ACCOUNT_PUBLIC_ID", length = 500)
    private String accountPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETED_DATE_TS")
    private Timestamp deletedDateTs;

    @Column(name = "DELETED_ORGANIZATION_ID")
    private Long deletedOrganizationId;
}
