package edu.imi.ir.eduimiws.domain.pmis;


import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;





@NamedEntityGraphs({
        @NamedEntityGraph(name = "ProjectEntity.findProjectProjectApi",
                attributeNodes = {
                        @NamedAttributeNode(value = "projectApi")
                }
        )
})


@NamedQueries({
        @NamedQuery(name = "ProjectEntity.queryPageablePaymentCodeApiProjection",
                query = " select " +
                        " prj.id as id,"+
                        " prja.projectPublicId as projectPublicId ,"+
                        " prj.projectCode as projectCode , " +
                        " prj.projectName as projectName , " +
                        " prj.lastVersion as lastVersion " +
                        " from " +
                        " ProjectEntity prj " +
                        " left join prj.projectApi prja " +
                        " where " +
                        " ( :id is null or prj.id = :id ) AND " +
                        " ( :projectPublicId is null or prja.projectPublicId = :projectPublicId ) AND " +
                        " ( :projectCode is null or prj.projectCode like concat('%',:projectCode,'%') ) AND " +
                        " ( :projectName is null or prj.projectName like concat('%',:projectName,'%') ) AND " +
                        " ( :lastVersion is null or prj.lastVersion = :lastVersion ) "
                /*       " ORDER BY con.lastName desc NULLS LAST "
                hints =  {
                        @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                        @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                        @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
                },
                lockMode = LockModeType.READ*/
        )
})



@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//,region = "period")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "PMIS", sequenceName = "SEQ_PROJECT", allocationSize = 1)
@Table(schema = "PMIS", name = "TBL_PROJECT")
public class ProjectEntity extends BaseEntity {


    @Column(name = "LAST_VERSION", length =1 )
    private String lastVersion;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "PREVIOUS_VERSION_ID")
    private ProjectEntity previousVersion;

    @Column(name = "VERSION_NUMBER")
    private Long versionNumber;

    @Column(name = "PROJECT_NAME", length =500 )
    private String projectName;

    @Column(name = "PROJECT_CODE", length =30 )
    private String projectCode;

    @Column(name = "START_DATE", length =10 )
    private String startDate;

    @Column(name = "END_DATE", length =10 )
    private String endDate;

    @Column(name = "PROJECT_BUDGET")
    private Long projectBudget;

    @Column(name = "WEIGHT_PERCENT")
    private Long weightPercent;

    @Column(name = "DESCRIPTION", length =400 )
    private String description;

    @Column(name = "IMPROVE_PERCENT")
    private Long improvePercent;

    @Column(name = "PROJECT_OPERATION_TYPE", length =10 )
    private String projectOperationType;

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "CREATE_DATE", length =10 )
    private String createDate;

    @Column(name = "CREATOR_ID")
    private Long creator;

//    Later Add
    @Column(name = "OPERATIONAL_PLAN_ID")
    private Long operationalPlanId;

    @Column(name = "REPORT_PATTERN_NUMBER" )
    private Long reportPatternNumber;

    @Column(name = "REPORT_PATTERN_UNIT", length =20 )
    private String reportPatternUnit;

    @Column(name = "AFFECT_EFFICIENCY", length =1 )
    private Character affectEfficiency;

    @Column(name = "STATUS_FOR_TIMESHIT", length =1 )
    private Character statusForTimeshit;

    @Column(name = "PROJECT_STATUS_ID")
    private Long projectStatusId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_TYPE_ID")
    private ProjectTypeEntity projectType;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = true)
    @JoinColumn(name = "MOTHER_PROJECT_ID")
    private ProjectEntity motherProject;

    @Column(name = "SALE_PRESENT_AMOUNT")
    private Long salePresentAmount;

    @Column(name = "SALE_PRESENT", length =1 )
    private Character salePresent;

    @Column(name = "BENEFIT", length =1 )
    private Character benefit;

    @Column(name = "BENEFIT_AMOUNT")
    private Long benefitAmount;

    @Column(name = "PRESENT_BENEFIT_DESCRIPTION", length =200 )
    private String presentBenefitDescription;

    @Column(name = "BUDGET_COFFICIENT")
    private Long budgetCofficient;

    @Column(name = "START_DATE_PLAN", length =10 )
    private String startDatePlan;

    @Column(name = "END_DATE_PLAN", length =10 )
    private String endDatePlan;

//    Add Later
    @Column(name = "OFFER_ID")
    private Long offerId;

//    Add Later
    @Column(name = "REQUEST_ID")
    private Long requestId;

    @Column(name = "INCOME_INDICATOR")
    private Long incomeIndicator;

    @Column(name = "ORG_COST_CODE_ID")
    private Long orgCostCodeId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private PersonEntity manager;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTER_ID")
    private PersonEntity executer;

    @Column(name = "TASK_SCHEDULE_CONFIRMED", length =1 )
    private String taskScheduleConfirmed;

    @Column(name = "PLAN_IMPROVEMENT_PERCENT")
    private Long planImprovementPercent;

    @Column(name = "SUSPEND_REASON_ID")
    private Long suspendReasonId;

    @Column(name = "FILE_OLD_NAME", length =50 )
    private String fileOldName;

    @Column(name = "LESSON_LEARN", length =4000 )
    private String lessonLearn;

    @Column(name = "FILE_NEW_NAME", length =20 )
    private String fileNewName;

    @Column(name = "STAGE_ID")
    private Long stageId;

//    Add Later
    @Column(name = "MAIN_CONTRACT_ID")
    private Long mainContractId;

    @Column(name = "SUPERVISOR_ID")
    private Long supervisorId;

    @Column(name = "COORDINATE_X")
    private Long coordinateX;

    @Column(name = "COORDINATE_Y")
    private Long coordinateY;

    @Column(name = "COORDINATE_LANG")
    private Long coordinateLang;

    @Column(name = "COORDINATE_LAT", length =20 )
    private String coordinateLat;

//    Add Later
    @Column(name = "PROJECT_ADDITIONAL_INFO_ID")
    private Long projectAdditionalInfoId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ProjectApiEntity projectApi;


}
