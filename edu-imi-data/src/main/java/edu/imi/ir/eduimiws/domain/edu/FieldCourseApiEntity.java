package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;


@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_FIELD_COURSE_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_FIELD_COURSE_API")
public class FieldCourseApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID")
    private FieldEntity field;

    @Column(name = "FIELD_PUBLIC_ID", length = 500)
    private String fieldPublicId;

    @Column(name = "FIELD_COURSE_EDIT_DATE", length = 10)
    private String fieldCourseEditDate;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;
}
