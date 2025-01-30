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
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_ACCOUNT_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_ACCOUNT_API")
public class AccountApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @Column(name = "ACCOUNT_PUBLIC_ID", length = 500)
    private String accountPublicId;

    @Column(name = "DELETED_ACCOUNT_ID")
    private Long deletedAccountId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "COMPANY_PUBLIC_ID", length = 500)
    private String companyPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;


}
