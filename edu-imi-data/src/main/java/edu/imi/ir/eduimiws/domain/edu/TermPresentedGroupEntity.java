package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "TermPresentedGroupEntity.termPresentedGroupApi",
                attributeNodes = {
                        @NamedAttributeNode("termPresentedGroupApi")
                }
        ),
        @NamedEntityGraph(name = "TermPresentedGroupEntity.findAllWithTermPresentedCourseAGraphFieldCourse",
                attributeNodes = {
                        @NamedAttributeNode(value = "termPresentedCourse", subgraph = "termPresentedCourse-subGraph"),
                        @NamedAttributeNode("professor"),
                        @NamedAttributeNode("termPresentedGroupApi")
                }
                ,
                subgraphs = {
                        @NamedSubgraph(
                                name = "termPresentedCourse-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "fieldCourse"
                                                , subgraph = "fieldCourse-subGraph"
                                        ),
                                        @NamedAttributeNode(value = "term"),
                                        @NamedAttributeNode(value = "period")
                                },
                                type = TermPresentedCourseEntity.class)
                        ,
                        @NamedSubgraph(
                                name = "fieldCourse-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "course")
                                },
                                type = FieldCourseEntity.class)
                }
        )
})

/*@NamedQueries({
        @NamedQuery(name = "TermPresentedGroupEntity.selectAllWithTermPresentedCourseFieldCourseCoursePeriodTermProfessor",
                query = " SELECT tpg FROM TermPresentedGroupEntity tpg " +
                        " LEFT JOIN Fetch tpg.termPresentedGroupApi tpga" +
                        " INNER JOIN FETCH tpg.termPresentedCourse tpc " +
                        " LEFT JOIN tpc.fieldCourse fc LEFT JOIN fc.course " +
                        " LEFT JOIN tpc.period prd  LEFT JOIN tpc.term " +
                        " LEFT JOIN tpg.professor prf " +
                        " ORDER BY tpg.createDate DESC ",
                hints = { @QueryHint(name = QueryHints.HINT_CACHE_MODE,value = "put"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
                }
        )
})*/

/*@NamedNativeQueries({
        @NamedNativeQuery(name = "TermPresentedGroupEntity.selectAllWithTermPresentedCourseFieldCourseCoursePeriodTermProfessor",
                query = " SELECT * FROM edu.tbl_term_presented_group tpg " +
                        " LEFT JOIN edu.tbl_term_presented_group_api   tpga ON tpg.id = tpga.term_presented_group_id " +
                        " WHERE rownum <= 25 ",
*//*                        " LEFT JOIN edu.tbl_term_presented_course      tpc ON tpg.presented_course_id = tpc.id " +
                        " LEFT JOIN edu.tbl_field_course               fc ON tpc.field_course_id = fc.id " +
                        " LEFT JOIN edu.tbl_course                     c ON fc.course_id = c.id " +
                        " LEFT JOIN edu.tbl_period                     pr ON tpc.period_id = pr.id " +
                        " LEFT JOIN edu.tbl_term                       trm ON tpc.term_id = trm.id ",*//*
                hints = {@QueryHint(name = QueryHints.HINT_CACHE_MODE,value = "put"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
                        @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
                }
                ,resultClass = TermPresentedGroupEntity.class
        ),
        @NamedNativeQuery(name = "TermPresentedGroupEntity.countAllWithTermPresentedCourseFieldCourseCoursePeriodTermProfessor",
                query = " SELECT count(*) FROM edu.tbl_term_presented_group tpg " +
                        " LEFT JOIN edu.tbl_term_presented_group_api   tpga ON tpg.id = tpga.term_presented_group_id " +
                        " WHERE rownum <= 25 "
        )
})*/

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
