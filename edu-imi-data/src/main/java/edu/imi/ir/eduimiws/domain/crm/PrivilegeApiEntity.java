package edu.imi.ir.eduimiws.domain.crm;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "CRM",sequenceName = "SEQ_PRIVILEGE_API_ID",allocationSize = 1)
@Table(schema = "CRM",name = "TBL_PRIVILEGE_API")
public class PrivilegeApiEntity extends BaseEntity {

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

    @ManyToMany(mappedBy = "privileges")
    private Collection<RoleApiEntity> roles;

    public PrivilegeApiEntity(String privilegeName){
        this.setName(privilegeName);
        this.setCreateDateTs(new Timestamp(new Date().getTime()));
    }

}
