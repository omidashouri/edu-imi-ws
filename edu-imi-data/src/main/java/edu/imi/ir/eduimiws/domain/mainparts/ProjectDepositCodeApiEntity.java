package edu.imi.ir.eduimiws.domain.mainparts;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.sql.Timestamp;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "ProjectDepositCodeApiEntity.findProjectProjectApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "project", subgraph = "project-subGraph"),
                        @NamedAttributeNode(value = "creator", subgraph = "creator-subGraph"),
                        @NamedAttributeNode(value = "editor", subgraph = "editor-subGraph")
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

@NamedQueries(value = {
        @NamedQuery(name = "ProjectDepositCodeApiEntity.queryAllProjectDepositCodeApiCustomTwo",
                query = "select " +
                        "pdca.publicId    as publicId , " +
                        "pdca.depositCode   as depositCode , " +
                        "pdca.description    as description, " +
                        "pdca.createDateTs   as createDateTs, " +
                        "pdca.editDateTs   as editDateTs, " +
                        "pdca.deleteDateTs   as deleteDateTs, " +
                        "p.projectName as projectName, " +
                        "p.projectCode as  projectCode, " +
                        "concat(c.firstName,' ',c.lastName)  as creatorFullName , " +
                        "concat(e.firstName,' ',e.lastName)  as editorFullName " +
                        " from " +
                        " ProjectDepositCodeApiEntity pdca " +
                        " left join pdca.project p " +
                        " left join pdca.creator c " +
                        " left join pdca.editor  e " +
                        " where " +
                        "( :publicId  is null or   pdca.publicId  = :publicId )  AND " +
                        "( :depositCode  is null or pdca.depositCode  = :depositCode ) AND " +
                        "( :createDateTs  is null or pdca.createDateTs  = :createDateTs ) AND " +
                        "( :editDateTs   is null or pdca.editDateTs  = :editDateTs )  AND " +
                        "( :deleteDateTs is null or pdca.deleteDateTs = :deleteDateTs ) AND " +
                        "( :description  is null or  pdca.description like concat('%', :description,'%') ) AND " +
                        "( :projectCode  is null or p.projectCode  = :projectCode ) AND " +
                        "( :projectName  is null or p.projectName  like concat('%', :projectName,'%') ) AND " +
                        "( :creatorFullName  is null or concat(c.firstName,' ',c.lastName) like concat('%',:creatorFullName,'%') ) AND " +
                        "( :editorFullName  is null or concat(e.firstName,' ',e.lastName) like concat('%', :editorFullName,'%') ) " +
                        " ORDER BY pdca.createDateTs desc, p.projectName ASC NULLS LAST "

        )
//        ->
               ,@NamedQuery(name = "ProjectDepositCodeApiEntity.queryAllProjectDepositCodeApiCustomThree",
                        query = "select " +
                                "pdca.publicId    as publicId ,  " +
                                "pdca.depositCode   as depositCode , " +
                                "pdca.description    as description, " +
                                "pdca.createDateTs   as createDateTs, " +
                                "pdca.editDateTs   as editDateTs, " +
                                "pdca.deleteDateTs   as deleteDateTs, " +
                                "p.projectName as projectName, " +
                                "p.projectCode as  projectCode, " +
                                "p.createDate  as  projectCreateDate," +
                                "p.projectStatusId as projectStatusId," +
                                "pt.projectTypeName as projectTypeName, " +
                                "p.startDatePlan as startDatePlan, " +
                                "p.endDatePlan as endDatePlan, " +
                                "p.lastVersion as lastVersion, " +
                                "p.statusForTimeshit as statusForTimeshit, " +
                                "concat(c.firstName,' ',c.lastName)  as creatorFullName , " +
                                "concat(e.firstName,' ',e.lastName)  as editorFullName , " +
                                "concat(exc.firstName,' ',exc.lastName)  as executor , " +
                                "pa.projectPublicId as projectPublicId " +
                                " from " +
                                " ProjectDepositCodeApiEntity pdca " +
                                " right outer join pdca.project p " +
                                " left join pdca.creator c " +
                                " left join pdca.editor  e " +
                                " left join p.executer  exc " +
                                " left join p.projectType pt " +
                                " left join p.projectApi pa" +
                                " where " +
                                "( :publicId  is null or   pdca.publicId  = :publicId )  AND " +
                                "( :depositCode  is null or pdca.depositCode  = :depositCode ) AND " +
                                "( :description  is null or  pdca.description like concat('%', :description,'%') ) AND " +
                                "( :createDateTs  is null or pdca.createDateTs  = :createDateTs ) AND " +
                                "( :editDateTs   is null or pdca.editDateTs  = :editDateTs )  AND " +
                                "( :deleteDateTs is null or pdca.deleteDateTs = :deleteDateTs ) AND " +
                                "( :projectName  is null or p.projectName  like concat('%', :projectName,'%') ) AND " +
                                "( :projectCode  is null or p.projectCode  = :projectCode ) AND " +
                                "( :projectCreateDate is null or p.createDate = :projectCreateDate ) AND " +
                                "( :projectStatusId is null or p.projectStatusId = :projectStatusId ) AND " +
                                "( :projectTypeName is null or pt.projectTypeName = :projectTypeName ) AND " +
                                "( :startDatePlan is null or p.startDatePlan = :startDatePlan ) AND " +
                                "( :endDatePlan is null or p.endDatePlan = :endDatePlan ) AND " +
                                "( :lastVersion is null or p.lastVersion = :lastVersion ) AND " +
                                "( :statusForTimeshit is null or p.statusForTimeshit = :statusForTimeshit ) AND " +
                                "( :creatorFullName  is null or concat(c.firstName,' ',c.lastName) like concat('%',:creatorFullName,'%') ) AND " +
                                "( :editorFullName  is null or concat(e.firstName,' ',e.lastName) like concat('%', :editorFullName,'%') ) AND " +
                                "( :executer  is null or concat(exc.firstName,' ',exc.lastName) like concat('%', :executer,'%') ) AND " +
                                "( :projectPublicId is null or pa.projectPublicId = :projectPublicId ) " +
                                " ORDER BY p.createDate desc, p.projectCode desc NULLS FIRST "


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

        public class ProjectDepositCodeApiEntity extends BaseEntity{


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
