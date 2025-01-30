package edu.imi.ir.eduimiws.domain.edu;

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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_STUDENT_COURSE_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_STUDENT_COURSE_API")
public class StudentCourseApiEntity extends BaseEntity {

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "STUDENT_COURSE_ID")
    private StudentCourseEntity studentCourse;

    @Column(name = "DELETED_STUDENT_COURSE_ID")
    private Long deletedStudentCourseId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGISTER_ID")
    private RegisterEntity register;

    @Column(name = "REGISTER_PUBLIC_ID", length = 500)
    private String registerPublicId;

    @Column(name = "STUDENT_COURSE_PUBLIC_ID", length = 500)
    private String studentCoursePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_COURSE_ID")
    private PeriodCourseEntity periodCourse;

    @Column(name = "PERIOD_COURSE_PUBLIC_ID", length = 500)
    private String periodCoursePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity periodId;

    @Column(name = "PERIOD_PUBLIC_ID", length = 500)
    private String periodPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @Column(name = "COURSE_PUBLIC_ID", length = 500)
    private String coursePublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    private StudentEntity student;

    @Column(name = "STUDENT_PUBLIC_ID", length = 500)
    private String studentPublicId;
}
