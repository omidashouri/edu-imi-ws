package edu.imi.ir.eduimiws.domain.pmis;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_PROJECT_API", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_PROJECT_API")
public class ProjectApiEntity extends BaseEntity {

    @Column(name = "PROJECT_PUBLIC_ID", length = 500)
    private String projectPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_TYPE_ID")
    private ProjectTypeEntity projectType;

    @Column(name = "PROJECT_TYPE_PUBLIC_ID", length = 500)
    private String projectTypePublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTOR_ID")
    private PersonEntity executor;

    @Column(name = "EXECUTOR_PUBLIC_ID", length = 500)
    private String executorPublicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private PersonEntity manager;

    @Column(name = "MANAGER_PUBLIC_ID", length = 500)
    private String managerPublicId;

    @Column(name = "LAST_VERSION", length = 1)
    private String lastVersion;

    @Column(name = "PROJECT_REQUEST_ID")
    private Long projectRequestId;

    @Column(name = "PROJECT_REQUEST_PUBLIC_ID", length = 500)
    private String projectRequestPublicId;

    @Column(name = "CREATE_DATE_TS")
    private java.sql.Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private java.sql.Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private java.sql.Timestamp deleteDateTs;

    @Column(name = "DELETED_PROJECT_ID")
    private Long deletedProjectId;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

}
