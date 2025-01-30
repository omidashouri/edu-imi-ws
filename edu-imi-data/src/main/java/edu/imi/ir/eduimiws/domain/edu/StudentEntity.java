package edu.imi.ir.eduimiws.domain.edu;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.projections.edu.StudentOnly;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "StudentEntity.findStudentSubGraphUserApiService",
                attributeNodes = {
                        @NamedAttributeNode(value = "person", subgraph = "person-subGraph"),
                        @NamedAttributeNode(value = "studentApi")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "person-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "personApiEntity")
                                },
                                type = PersonApiEntity.class)
                }
        ),
        @NamedEntityGraph(name = "StudentEntity.findStudentApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "studentApi")
                }
        )
})

@SqlResultSetMapping(
        name = "StudentOnly",
        classes = {
                @ConstructorResult(
                        targetClass = StudentOnly.class,
                        columns = {
                                @ColumnResult(name = "idR", type = Long.class),
                                @ColumnResult(name = "personIdR", type = Long.class),
                                @ColumnResult(name = "deleteStatusR", type = Long.class),
                                @ColumnResult(name = "activityStatusR", type = Long.class),
                                @ColumnResult(name = "studentEditDateR", type = String.class)
                        }
                )
        }
)
@NamedNativeQueries({
        @NamedNativeQuery(name = "StudentEntity.selectAllStudentOnly",
                query = " select ID as idR, PERSON_ID as personIdR, DELETE_STATUS as deleteStatusR, ACTIVITY_STATUS as activityStatusR, " +
                        " EDIT_DATE as studentEditDateR  from EDU.TBL_STUDENT ",
                resultSetMapping = "StudentOnly"),
        @NamedNativeQuery(name = "StudentEntity.selectAllStudentOnlyByIdBetween",
                query = " select ID as idR, PERSON_ID as personIdR, DELETE_STATUS as deleteStatusR, ACTIVITY_STATUS as activityStatusR, " +
                        " EDIT_DATE as studentEditDateR  from EDU.TBL_STUDENT where ID between :beginStudentId and :endStudentId ",
                resultSetMapping = "StudentOnly"),
        @NamedNativeQuery(name = "StudentEntity.selectCurrentSequenceNumber",
                query = " select EDU.SEQ_STUDENT.nextval from dual "
        )
})

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_STUDENT", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_STUDENT")
public class StudentEntity extends BaseEntity {


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @Column(name = "PERSON_ID", insertable = false, updatable = false)
    private Long personId;

    @Transient
    public Long getPersonId() {
        return personId;
    }

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "NATION_CODE", length = 15)
    private String nationCode;

    @Column(name = "CODE", length = 20)
    private String code;

    @Column(name = "ACTIVITY_STATUS")
    private Long activityStatus;

    @Column(name = "DELETE_STATUS")
    private Long deleteStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR_ID")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @Column(name = "DESCRIPTION", length = 150)
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private StudentApiEntity studentApi;
}
