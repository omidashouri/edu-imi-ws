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
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_CLIENT_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_CLIENT_API")
public class ClientApiEntity extends BaseEntity {

    @Column(name = "CLIENT_PUBLIC_ID", length = 500)
    private String clientPublicId;

    @Column(name = "CLIENT_ID", length = 500, nullable = false, unique = true)
    private String clientId;

    @Column(name = "CLIENT_SECRET_HASH", length = 500, nullable = false)
    private String clientSecretHash;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_API_ID", nullable = false, unique = true)
    private PersonApiEntity personApi;

    @Column(name = "PERSON_API_ID", insertable = false, updatable = false)
    private Long personApiId;

    @Column(name = "COMPANY_NAME", length = 500)
    private String companyName;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "ENABLED", precision = 1, scale = 0)
    private Long enabled;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
