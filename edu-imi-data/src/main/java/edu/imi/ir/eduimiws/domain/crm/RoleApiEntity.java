package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

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

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "editor_id")
    private Long editorId;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(schema = "CRM",
            name = "TBL_ROLE_PRIVILEGE_API",
    joinColumns =
        @JoinColumn(name = "ROLE_API_ID",referencedColumnName = "ID"),
    inverseJoinColumns =
        @JoinColumn(name = "PRIVILEGE_API_ID",referencedColumnName = "ID"))
    private Collection<PrivilegeApiEntity> privileges;
}
