package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_COURSE_PROFESSO_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_COURSE_PROFESSO_API")
public class PeriodCourseProfessorApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "PERIOD_COURSE_PROFESSOR_ID")
    private PeriodCourseProfessorEntity periodCourseProfessor;

    @Column(name = "PRIOD_COURS_PROFESOR_PUBLIC_ID", length = 500)
    private String priodCoursProfesorPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @Column(name = "PERIOD_PUBLIC_ID", length = 500)
    private String periodPublicId;

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
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @Column(name = "COURSE_PUBLIC_ID", length = 500)
    private String coursePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ID")
    private ProfessorEntity professor;

    @Column(name = "PROFESSOR_PUBLIC_ID", length = 500)
    private String professorPublicId;

    @Column(name = "PRIOD_COURS_PROFESOR_EDIT_DATE", length = 10)
    private String priodCoursProfesorEditDate;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;
}
