package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_ROLE_API_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_ROLE_API")
public class RoleApiEntity extends BaseEntity {

    @Column(name = "NAME",length = 100)
    private String name;

    @Column(name = "ROLE_PUBLIC_ID",length = 500)
    private String rolePublicId;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION",length = 500)
    private String description;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "editor_id")
    private Long editorId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(schema = "CRM",
            name = "TBL_ROLE_PRIVILEGE_API",
    joinColumns =
        @JoinColumn(name = "ROLE_API_ID",referencedColumnName = "ID"),
    inverseJoinColumns =
        @JoinColumn(name = "PRIVILEGE_API_ID",referencedColumnName = "ID"))
    private Set<PrivilegeApiEntity> privileges;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.MERGE)
    private Collection<PersonApiEntity> personApis;

    public RoleApiEntity(String roleName){
        this.setName(roleName);
    }
}
