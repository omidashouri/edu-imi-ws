package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;


//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_TERM_PRESENTED_GROUP_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_TERM_PRESENTED_GROUP_API")
public class TermPresentedGroupApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "TERM_PRESENTED_GROUP_ID")
    private TermPresentedGroupEntity termPresentedGroup;

    @Column(name = "TERM_PRESENTED_GROUP_PUBLIC_ID", length = 500)
    private String termPresentedGroupPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ID")
    private ProfessorEntity professorId;

    @Column(name = "PROFESSOR_PUBLIC_ID", length = 500)
    private String professorPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_PRESENTED_COURSE_ID")
    private TermPresentedCourseEntity termPresentedCourse;

    @Column(name = "TRM_PRESENTED_COURSE_PUBLIC_ID", length = 500)
    private String termPresentedCoursePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TERM_ID")
    private TermEntity term;

    @Column(name = "TERM_PUBLIC_ID", length = 500)
    private String termPublicId;

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
    @JoinColumn(name = "FIELD_COURSE_ID")
    private FieldCourseEntity fieldCourse;

    @Column(name = "FIELD_COURSE_PUBLIC_ID", length = 500)
    private String fieldCoursePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @Column(name = "COURSE_PUBLIC_ID", length = 500)
    private String coursePublicId;


    @Column(name = "TERM_PRESENTED_GROUP_EDIT_DATE", length = 10)
    private String termPresentedGroupEditDate;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;
}
