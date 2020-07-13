package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_CATEGORY_API", allocationSize = 1)
@Table(schema = "EDU",name="TBL_EDU_CATEGORY_API")
public class EduCategoryApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EDU_CATEGORY_ID")
    private EduCategoryEntity eduCategory;

    @Column(name="EDU_CATEGORY_ID", insertable = false, updatable = false)
    private Long eduCategoryId;

    @Transient
    public Long getEduCategoryId() {
        return eduCategoryId;
    }

    @Column(name="EDU_CATEGORY_PUBLIC_ID",length = 500)
    private String eduCategoryPublicId;

    @Column(name="EDU_CATEGORY_EDIT_DATE",length = 10)
    private String eduCategoryEditDate;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

}
