package edu.imi.ir.eduimiws.domain.pmis;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;


@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_CENTER_COST_CODE_API", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_CENTER_COST_CODE_API")
public class CenterCostCodeApiEntity extends BaseEntity {


    @Column(name = "CENTER_COST_CODE_PUBLIC_ID",length = 500)
    private String centerCostCodePublicId;

    @Column(name = "COST_CODE")
    private Long costCode;

    @Column(name = "COST_CODE_TITLE",length = 500)
    private String costCodeTitle;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "LAST_VERSION")
    private Long lastVersion;

    @Column(name = "DESCRIPTION",length = 500)
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR_ID")
    private PersonEntity editor;

}
