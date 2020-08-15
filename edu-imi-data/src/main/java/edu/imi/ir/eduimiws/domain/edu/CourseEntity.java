package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_COURSE", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_COURSE")
public class CourseEntity extends BaseEntity {

    @Column(name = "CODE", length = 20)
    private String code;

    @Column(name = "FNAME", length = 300)
    private String fname;

    @Column(name = "LNAME", length = 300)
    private String lname;

    @Column(name = "TUNIT")
    private Long tunit;

    @Column(name = "ACTIVITY_STATUS", precision = 2, scale = 0)
    private Long activityStatus;

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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "DELETE_STATUS", precision = 2, scale = 0)
    private Long deleteStatus;

    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "COURSE_TYPE_ID")
    private Long courseTypeId;

    @Column(name = "CTIME", precision = 4, scale = 0)
    private Long ctime;

    @Column(name = "COURSE_CATEGORY_ID")
    private Long courseCategoryId;

    @Column(name = "SILABES_FILE", length = 200)
    private String silabesFile;

    @Column(name = "SILABES", length = 4000)
    private String silabes;

    @Column(name = "COURSE_AIM", length = 4000)
    private String courseAim;

    @Column(name = "COURSE_REF", length = 4000)
    private String courseRef;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEVEL_ID")
    private LevelEntity level;

    @Column(name = "LEVEL_ID", insertable = false, updatable = false)
    private Long levelId;

    @Transient
    public Long getLevelId() {
        return levelId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "course", fetch = FetchType.LAZY)
    private CourseApiEntity courseApi;
}
