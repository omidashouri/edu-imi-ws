package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;




@NamedEntityGraphs({
        @NamedEntityGraph(name = "ProjectDepositCodeApiEntity.findProjectProjectApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "project",subgraph = "project-subGraph"),
                        @NamedAttributeNode(value = "creator",subgraph = "creator-subGraph"),
                        @NamedAttributeNode(value = "editor",subgraph = "editor-subGraph")
                },
                subgraphs = {
                        @NamedSubgraph(name = "project-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "projectApi")
                                }
                        ),
                        @NamedSubgraph(name = "creator-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "personApiEntity")
                                }
                        ),
                        @NamedSubgraph(name = "editor-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "personApiEntity")
                                }
                        )
                }
        )
})


//left join to projectdepositCodeEntity for depositCode&depositPublicId
@NamedQueries(value = {
        @NamedQuery(name = "ProjectDepositCodeApiEntity.queryByProjectDepositCodeApi",
                query = "select "+
                        " project.id as projecId,"+
                        " projectApi.projectPublicId as projectPublicId ,"+
                        " project.projectCode as projectCode , " +
                        " project.projectName as projectName , " +
                        " project.lastVersion as projectLastVersion " +
                        " from " +
                        " ProjectEntity project " +
                        " left join project.projectApi projectApi " +
                        " where " +
                        " ( :id is null or project.id = :id ) AND " +
                        " ( :projectPublicId is null or projectApi.projectPublicId = :projectPublicId ) AND " +
                        " ( :projectCode is null or project.projectCode like concat('%',:projectCode,'%') ) AND " +
                        " ( :projectName is null or project.projectName like concat('%',:projectName,'%') ) AND " +
                        " ( :lastVersion is null or project.lastVersion = :lastVersion ) "

        )
})


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "MAINPARTS", sequenceName = "SEQ_PROJECT_DEPOSIT_CODE_API", allocationSize = 1)
@Table(schema = "MAINPARTS", name = "TBL_PROJECT_DEPOSIT_CODE_API")

public class ProjectDepositCodeApiEntity extends BaseEntity {


    @Column(name = "PUBLIC_ID", length = 500)
    private String publicId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

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

    @Column(name = "DEPOSIT_CODE")
    private String depositCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_DATE_TS")
    private Timestamp createDateTs;

    @Column(name = "DELETE_DATE_TS")
    private Timestamp deleteDateTs;

    @Column(name = "EDIT_DATE_TS")
    private Timestamp editDateTs;


}
