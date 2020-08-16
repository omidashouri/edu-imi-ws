package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_PROFESSOR", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PROFESSOR")
public class ProfessorEntity extends BaseEntity {


    @Column(name = "FIRST_NAME", length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30)
    private String lastName;

    @Column(name = "NATION_CODE", length = 15)
    private String nationCode;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "CODE", length = 20)
    private String code;

    @Column(name = "PROFESSOR_TYPE", length = 20)
    private String professorType;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @Column(name = "ACTIVITY_STATUS")
    private Long activityStatus;

    @Column(name = "DELETE_STATUS")
    private Long deleteStatus;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @Column(name = "FINAL_SCORE")
    private Long finalScore;

    @Column(name = "START_YEAR", length = 10)
    private String startYear;

    @Column(name = "DUTY_HOUR")
    private Long dutyHour;

    @Column(name = "ACCEPTED_HOUR")
    private Long acceptedHour;

    @Column(name = "IS_INNER", length = 1)
    private String isInner;

    @Column(name = "DUTY_HOUR_MONTH")
    private Long dutyHourMonth;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "professorId", fetch = FetchType.LAZY)
    private ProfessorApiEntity professorApi;
}
