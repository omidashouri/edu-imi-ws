package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PRE_REGISTER_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PRE_REGISTER_API")
public class PreRegisterApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "PRE_REGISTER_ID")
    private PreRegisterEntity preRegister;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID")
    private ContactEntity contact;

    @Column(name = "PRE_REGISTER_PUBLIC_ID", length = 500)
    private String preRegisterPublicId;

    @Column(name = "PERIOD_PUBLIC_ID", length = 500)
    private String periodPublicId;

    @Column(name = "CONTACT_PUBLIC_ID", length = 500)
    private String contactPublicId;

    @Column(name = "PRE_REGISTER_DELETE_STATUS")
    private Long preRegisterDeleteStatus;

    @Column(name = "PRE_REGISTER_ACTIVITY_STATUS")
    private Long preRegisterActivityStatus;

    @Column(name = "PRE_REGISTER_EDIT_DATE", length = 10)
    private String preRegisterEditDate;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "DELETED_PRE_REGISTER_ID")
    private Long deletedPreRegisterId;
}
