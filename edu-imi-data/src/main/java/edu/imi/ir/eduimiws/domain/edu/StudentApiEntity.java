package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_STUDENT_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_STUDENT_API")
public class StudentApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STUDENT_ID")
    private StudentEntity student;

    @Column(name = "Student_ID", insertable = false, updatable = false)
    private Long studentId;

    @Transient
    public Long getStudentId() {
        return studentId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERSON_ID")
    private PersonEntity person;

    @Column(name="STUDENT_PUBLIC_ID",length = 500)
    private String studentPublicId;

    @Column(name="PERSON_PUBLIC_ID",length = 500)
    private String personPublicId;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="STUDENT_DELETE_STATUS",precision = 1,scale = 0)
    private Long studentDeleteStatus;

    @Column(name="STUDENT_EDIT_DATE",length = 10)
    private String studentEditDate;

    @Column(name="DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

}
