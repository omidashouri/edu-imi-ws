package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "TermPresentedGroupEntity.termPresentedGroupApi",
                attributeNodes = {
                        @NamedAttributeNode("termPresentedGroupApi")
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_TERM_PRESENTED_GROUP", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_TERM_PRESENTED_GROUP")
public class TermPresentedGroupEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ID")
    private ProfessorEntity professor;

    @Column(name = "PROFESSOR_ID", insertable = false, updatable = false)
    private Long professorId;

    @Transient
    public Long getProfessorId() {
        return professorId;
    }

    @Column(name = "GROUP_NUMBER")
    private Long groupNumber;

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

    //  add later
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRESENTED_COURSE_ID")
    private TermPresentedCourseEntity termPresentedCourse;

    @Column(name = "CAPACITY", precision = 4, scale = 0)
    private Long capacity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSISTANT_ID")
    private ProfessorEntity assistant;

    @Column(name = "START_DATE", length = 10)
    private String startDate;

    @Column(name = "END_DATE", length = 10)
    private String endDate;

    @Column(name = "CUNIT")
    private Long cunit;

    @Column(name = "CTIME", precision = 5, scale = 0)
    private Long ctime;

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

    // do not have table for it
    @Column(name = "LICENSE_PROFESSOR_ID")
    private Long licenseProfessorId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "termPresentedGroup", fetch = FetchType.LAZY)
    private TermPresentedGroupApiEntity termPresentedGroupApi;
}
