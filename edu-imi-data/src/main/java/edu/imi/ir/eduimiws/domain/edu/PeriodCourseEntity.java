package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "PeriodCourseEntity.periodCourseApiEntityAndPeriodEntityAndCourseEntity",
                attributeNodes = {
                        @NamedAttributeNode("period"),
                        @NamedAttributeNode("course"),
                        @NamedAttributeNode("periodCourseApi")
                }
        ),
        @NamedEntityGraph(name = "PeriodCourseEntity.periodCourseApiEntity",
                attributeNodes = {
                        @NamedAttributeNode("periodCourseApi")
                }
        )
})

//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_COURSE", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_COURSE")
public class PeriodCourseEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @Column(name = "START_DATE", length = 10)
    private String startDate;

    @Column(name = "END_DATE", length = 10)
    private String endDate;

    @Column(name = "TIME", precision = 3, scale = 0)
    private Long time;

    @Column(name = "SESSION_NUMBER", precision = 3, scale = 0)
    private Long sessionNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    //    do not have table
    @Column(name = "COURSE_TYPE_ID")
    private Long courseTypeId;

    @Column(name = "SCORE_LOW_BOUND", precision = 2, scale = 0)
    private Long scoreLowBound;

    @Column(name = "SCORE_ACCEPT_BOUND", precision = 2, scale = 0)
    private Long scoreAcceptBound;

    @Column(name = "SCORE_HIGH_BOUND", precision = 3, scale = 0)
    private Long scoreHighBound;

    @Column(name = "SCORE_QUALITY_VALUES", length = 100)
    private String scoreQualityValues;

    @Column(name = "SCORE_ACCEPTED_QUALITY", length = 100)
    private String scoreAcceptedQuality;

    @Column(name = "SCORING_WAY", precision = 2, scale = 0)
    private Long scoringWay;

    @Column(name = "IN_AVERAGE", length = 1)
    private String inAverage;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "periodCourse", fetch = FetchType.LAZY)
    private PeriodCourseApiEntity periodCourseApi;


}
