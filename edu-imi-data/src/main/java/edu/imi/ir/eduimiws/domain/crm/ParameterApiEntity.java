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
@SequenceGenerator(name = "entity_sequence", schema = "CRM", sequenceName = "SEQ_PARAMETER_API_ID", allocationSize = 1)
@Table(schema = "CRM", name = "TBL_PARAMETER_API")
public class ParameterApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "PARAMETER_ID")
    private ParameterEntity parameter;

    @Column(name = "PARAMETER_PUBLIC_ID", length = 500)
    private String parameterPublicId;

    @Column(name = "DELETED_PARAMETER_ID")
    private Long deletedParameterId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
