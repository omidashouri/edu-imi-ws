package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "fieldApi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_FIELD_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_FIELD_API")
public class FieldApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FIELD_ID")
    private FieldEntity field;

    @Column(name="FIELD_ID", insertable = false, updatable = false)
    private Long fieldId;

    @Transient
    public Long getFieldId() {
        return fieldId;
    }

    @Column(name="FIELD_PUBLIC_ID",length = 500)
    private String fieldPublicId;

    @Column(name="FIELD_DELETE_STATUS", precision = 1,scale = 0)
    private Long fieldDeleteStatus;

    @Column(name="FIELD_ACTIVITY_STATUS", precision = 1,scale = 0)
    private Long fieldActivityStatus;

    @Column(name="FIELD_EDIT_DATE",length = 10)
    private String fieldEditDate;

    @Column(name="LEVEL_ID", insertable = false, updatable = false)
    private Long levelId;

    @Transient
    public Long getLevelId() {
        return levelId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LEVEL_ID")
    private LevelEntity level;

    @Column(name="LEVEL_PUBLIC_ID", length = 500)
    private String levelPublicId;

    @Column(name="EDU_CATEGORY_ID", insertable = false, updatable = false)
    private Long eduCategoryId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EDU_CATEGORY_ID")
    private EduCategoryEntity eduCategory;

    @Column(name="EDU_CATEGORY_PUBLIC_ID", length = 500)
    private String eduCategoryPublicId;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

}
