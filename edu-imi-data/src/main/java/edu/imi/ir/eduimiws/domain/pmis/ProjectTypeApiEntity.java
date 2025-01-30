package edu.imi.ir.eduimiws.domain.pmis;


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
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_PROJECT_TYPE_API", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_PROJECT_TYPE_API")
public class ProjectTypeApiEntity extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_TYPE_ID")
    private ProjectTypeEntity projectType;

    @Column(name = "PROJECT_TYPE_PUBLIC_ID", length = 500)
    private String projectTypePublicId;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "DELETED_PROJECT_TYPE_ID")
    private Long deletedProjectTypeId;
}
