package edu.imi.ir.eduimiws.domain.pmis;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

//@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//,region = "period")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_PROJECT_TYPE", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_PROJECT_TYPE")
public class ProjectTypeEntity extends BaseEntity {


    @Column(name = "PROJECT_TYPE_NAME", length =100 )
    private String projectTypeName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "PARENT_ID")
    private ProjectTypeEntity parent;

    @Column(name = "CREATOR_ID")
    private Long creatorId;

    @Column(name = "CREATE_DATE", length =10 )
    private String createDate;

    @Column(name = "EDIT_DATE", length =10 )
    private String editDate;

    @Column(name = "EDITOR_ID" )
    private Long editorId;

    @Column(name = "PROJECT_TYPE", length =20 )
    private String projectType;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "projectType", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ProjectTypeApiEntity projectTypeApi;

}
