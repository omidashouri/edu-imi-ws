package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;


@NamedEntityGraphs({
    @NamedEntityGraph(name = "PeriodApiEntity.periodApiFastGraph", attributeNodes = {
            @NamedAttributeNode("periodId"),
            @NamedAttributeNode("periodPublicId"),
            @NamedAttributeNode("canRegisterOnline"),
            @NamedAttributeNode("periodEditDate"),
            @NamedAttributeNode("deleteTs")}),
    @NamedEntityGraph(name = "PeriodApiEntity.periodApiPeriodFastGraph", attributeNodes = {
            @NamedAttributeNode("periodPublicId"),
            @NamedAttributeNode("deleteTs"),
            @NamedAttributeNode(value = "period", subgraph = "period-subgraph")
    }
            , subgraphs = {
            @NamedSubgraph(
                    name = "period-subgraph",
                    attributeNodes = {
                            @NamedAttributeNode("name"),
                            @NamedAttributeNode("startDate"),
                            @NamedAttributeNode("endDate")
                    })
    })
})
//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "periodApi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PERIOD_API", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD_API")
public class PeriodApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERIOD_ID")
    private PeriodEntity period;

    @Column(name = "PERIOD_ID", insertable = false, updatable = false)
    private Long periodId;

    @Transient
    public Long getPeriodId() {
        return periodId;
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID")
    private FieldEntity field;

    @Column(name = "FIELD_ID",insertable = false, updatable = false)
    private Long fieldId;

    @Transient
    public Long getFieldId() {
        return fieldId;
    }

    @Column(name="FIELD_PUBLIC_ID")
    private String fieldPublicId;

    @Column(name = "PERIOD_EDIT_DATE", length = 10)
    private String periodEditDate;

    @Column(name="PERIOD_PUBLIC_ID",length = 500)
    private String periodPublicId;

    @Column(name="DESCRIPTION",length = 500)
    private String description;

    @Column(name="CAN_REGISTER_ONLINE",length = 15)
    private String canRegisterOnline;

    @Column(name="CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name="EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteTs;
}
