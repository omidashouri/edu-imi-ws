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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_COURSE_CATEGORY_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_COURSE_CATEGORY_API")
public class CourseCategoryApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "COURSE_CATEGORY_ID")
    private CourseCategoryEntity courseCategory;

    @Column(name = "COURSE_CATEGORY_PUBLIC_ID", length = 500)
    private String courseCategoryPublicId;

    @Column(name = "COURSE_CATEGORY_EDIT_DATE", length = 10)
    private String courseCategoryEditDate;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;
}
