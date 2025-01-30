package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_COURSE_CATEGORY", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_COURSE_CATEGORY")
public class CourseCategoryEntity extends BaseEntity {


    @Column(name = "TITLE", length = 200)
    private String title;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "PARENT")
    private CourseCategoryEntity parent;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity companyId;

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
    @OneToOne(mappedBy = "courseCategory", fetch = FetchType.LAZY)
    private CourseCategoryApiEntity courseCategoryApi;
}
