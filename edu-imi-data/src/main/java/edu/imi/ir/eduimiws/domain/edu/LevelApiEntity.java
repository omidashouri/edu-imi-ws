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
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_LEVEL_API", allocationSize = 1)
@Table(schema = "EDU",name="TBL_LEVEL_API")
public class LevelApiEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LEVEL_ID")
    private LevelEntity level;

    @Column(name="LEVEL_ID", insertable = false, updatable = false)
    private Long levelId;

    @Transient
    public Long getLevelId() {
        return levelId;
    }

    @Column(name="LEVEL_PUBLIC_ID",length = 500)
    private String levelPublicId;

    @Column(name="LEVEL_DELETE_STATUS",precision = 1,scale = 0)
    private Long levelDeleteStatus;

    @Column(name="LEVEL_EDIT_DATE",length = 10)
    private String levelEditDate;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name="DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;
}
