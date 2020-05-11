package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_REGISTER_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_REGISTER_API")
public class RegisterApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "REGISTER_ID", insertable = false, updatable = false)
    private Long registerId;

    @Transient
    public Long getRegisterId() {
        return registerId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERIOD_ID")
    private PeriodEntity period;

    @Column(name = "PERIOD_ID", insertable = false, updatable = false)
    private Long periodId;

    @Transient
    public Long getPeriodId() {
        return periodId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STUDENT_ID")
    private StudentEntity student;

    @Column(name = "STUDENT_ID", insertable = false, updatable = false)
    private Long studentId;

    @Transient
    public Long getStudentId() {
        return studentId;
    }

    @Column(name="REGISTER_PUBLIC_ID",length = 500)
    private String registerPublicId;

    @Column(name="PERIOD_PUBLIC_ID",length = 500)
    private String periodPublicId;

    @Column(name="STUDENT_PUBLIC_ID",length = 500)
    private String studentPublicId;

    @Column(name="REGISTER_DELETE_STATUS",precision = 1,scale = 0)
    private Long registerDeleteStatus;

    @Column(name="REGISTER_ACTIVITY_STATUS",precision = 1,scale = 0)
    private Long registerActivityStatus;

    @Column(name="REGISTER_EDIT_DATE",length = 10)
    private String registerEditDate;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

}
