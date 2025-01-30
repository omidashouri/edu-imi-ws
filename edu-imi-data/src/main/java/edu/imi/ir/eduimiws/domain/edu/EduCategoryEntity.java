package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;


@NamedNativeQueries({
        @NamedNativeQuery(name = "EduCategoryEntity.selectCurrentSequenceNumber",
                query = " select  EDU.SEQ_EDU_CATEGORY.nextval from dual "
        )
})

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//, region = "eduCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_CATEGORY", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_EDU_CATEGORY")
public class EduCategoryEntity extends BaseEntity {

    @Column(name="TITLE",length = 100)
    private String title;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "PARENT_ID")
    private EduCategoryEntity parent;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", nullable = false, columnDefinition = " Long default '4' ")
    @ColumnDefault("4")
    private CompanyEntity company;

    @Column(name = "COMPANY_ID", insertable = false, updatable = false)
    private Long companyId;

    @Transient
    public Long getCompanyId() {
        return companyId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "eduCategory", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private EduCategoryApiEntity eduCategoryApi;
}
