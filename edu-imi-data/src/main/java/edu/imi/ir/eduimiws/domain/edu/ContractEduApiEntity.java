package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.ParameterEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_CONTRACT_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_CONTRACT_EDU_API")
public class ContractEduApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "CONTRACT_EDU_ID")
    private ContractEduEntity contractEdu;

    @Column(name = "DELETED_CONTRACT_EDU_ID")
    private Long deletedContractEduId;

    @Column(name = "CONTRACT_EDU_PUBLIC_ID", length = 500)
    private String contractEduPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARAMETER_ID")
    private ParameterEntity parameter;

    @Column(name = "PARAMETER_PUBLIC_ID", length = 500)
    private String parameterPublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;
}
