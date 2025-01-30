package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "FieldCourseEntity.fieldCourseApi",
                attributeNodes = {
                        @NamedAttributeNode("fieldCourseApi")
                }
        )
})

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_FIELD_COURSE", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_FIELD_COURSE")
public class FieldCourseEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "FIELD_ID")
    private FieldEntity field;

    //    do not have table
    @Column(name = "COURSE_TYPE_ID")
    private Long courseTypeId;

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

    @Column(name = "EDIT_DATE", length = 20)
    private String editDate;

    @Column(name = "ACTIVITY_STATUS")
    private Long activityStatus;

    @Column(name = "DELETE_STATUS")
    private Long deleteStatus;

    @Column(name = "CTIME", length = 20)
    private String ctime;

    @Column(name = "TUNIT")
    private Long tunit;

    @Column(name = "SCORE_LOW_BOUND", precision = 2, scale = 0)
    private Long scoreLowBound;

    @Column(name = "SCORE_ACCEPT_BOUND", precision = 2, scale = 0)
    private Long scoreAcceptBound;

    @Column(name = "SCORE_HIGH_BOUND", precision = 3, scale = 0)
    private Long scoreHighBound;

    @Column(name = "SCORE_QUALITY_VALUES", length = 15)
    private String scoreQualityValues;

    @Column(name = "SCORE_ACCEPTED_QUALITY", length = 100)
    private String scoreAcceptedQuality;

    @Column(name = "SCORING_WAY", precision = 2, scale = 0)
    private Long scoringWay;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "fieldCourse", fetch = FetchType.LAZY)
    private FieldCourseApiEntity fieldCourseApi;
}
