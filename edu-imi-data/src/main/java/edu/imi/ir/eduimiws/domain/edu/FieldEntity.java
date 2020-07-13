package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.*;
import lombok.*;
import oracle.sql.CLOB;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_FIELD", allocationSize = 1)
@Table(schema = "EDU", name="TBL_FIELD")
public class FieldEntity extends BaseEntity {

    @Column(name="CODE",length = 20)
    private String code;

    @Column(name="FNAME",length = 500)
    private String fname;

    @Column(name="LNAME",length = 500)
    private String lname;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEVEL_ID")
    private LevelEntity level;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private EduCategoryEntity eduCategory;

    @Column(name="TUNIT")
    private Long tunit;

    @Column(name="PUNIT")
    private Long punit;

    @Column(name="TOTAL_UNIT")
    private Long totalUnit;

    @Column(name="ACTIVITY_STATUS")
    private Long activityStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name="CREATE_DATE",length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name="EDIT_DATE",length = 10)
    private String editDate;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID", nullable = false, columnDefinition = " Long default '4' ")
    @ColumnDefault("4")
    private CompanyEntity company;

    @Column(name="DESCRIPTION",length = 4000)
    private String description;

    @Column(name="NOTE",length = 500)
    private String note;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIPLOMATYPE_ID")
    private ParameterEntity diplomaType;

    @Column(name="EXAM_TYPE",length = 10)
    private String examType;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DESIGNER_ID")
    @ColumnDefault("4")
    private ContactEntity contact;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @Column(name="TERMIC_STATUS",length = 10)
    private String termicStatus;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPERVISOR_ID")
    private PersonEntity supervisor;

    @Column(name="TABLEAU")
    private CLOB tableau;

    @Column(name="LAST_PERIOD_NUMBER")
    private Long lastPeriodNumber;

//    TBL_PLAN_OLD
    @Column(name="PLAN_ID")
    private Long planId;

    @Column(name="EXECUTER_ID")
    private Long executerId;

    @Column(name="CAPACITY")
    private Long capacity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRE_CERTIFICATE_ID")
    private ParameterEntity preCertificate;

    @Column(name="FORIEGN_FEE",length = 1)
    private String foriegnFee;

//    TBL_COEFFICIENT
    @Column(name="PRE_COEFFICIENT_ID")
    private Long preCoefficientId;

    @Column(name="SCORE_LOW_BOUND")
    private Long scoreLowBound;

    @Column(name="SCORE_ACCEPT_BOUND")
    private Long scoreAcceptBound;

    @Column(name="SCORE_HIGH_BOUND")
    private Long scoreHighBound;

    @Column(name="SCORE_QUALITY_VALUES",length = 50)
    private String scoreQualityValues;

    @Column(name="SCORE_ACCEPTED_QUALITY",length = 100)
    private String scoreAcceptedQuality;

    @Column(name="CERT_NEED_SCORE",length = 1)
    private String certNeedScore;

    @Column(name="CERT_NEED_PRESENCE",length = 1)
    private String certNeedPresence;

    @Column(name="CERT_ACCEPTED_PRESENCE")
    private Long certAcceptedPresence;

    @Column(name="SCORING_WAY")
    private Long scoringWay;

    @Column(name="NEED_PERMITION_FOR_AGANCY",length = 1)
    private String needPermitionForAgancy;

    @Column(name="CERT_UNIT",length = 1)
    private String certUnit;

    @Column(name="CERT_TIME",length = 1)
    private String certTime;

    @Column(name="CERT_SCORE",length = 1)
    private String certScore;

    @Column(name="CERT_DATE",length = 1)
    private String certDate;

    @Column(name="CERT_BACK",length = 1)
    private String certBack;

    @Column(name="CERT_BIRTH",length = 1)
    private String certBirth;

    @Column(name="CERT_EQUI",length = 1)
    private String certEqui;

    @Column(name="CERT_LAW",length = 1)
    private String certLaw;

    @Column(name="CERT_SODOR",length = 1)
    private String certSodor;

    @Column(name="CERT_DESC",length = 1)
    private String certDesc;

    @Column(name="SITE_INTRODUCTION")
    private CLOB siteIntroduction;

    @Column(name="SITE_CONTACTS")
    private CLOB siteContacts;

    @Column(name="SITE_AIM")
    private CLOB siteAim;

    @Column(name="SITE_CONTENTS")
    private CLOB siteContents;

    @Column(name="SITE_CONDITIONS")
    private CLOB siteConditions;

    @Column(name="SITE_TMETHODS")
    private CLOB siteTmethods;

    @Column(name="SITE_REGISTER_R")
    private CLOB siteRegisterR;

    @Column(name="CERT_GOAL",length = 1)
    private String certGoal;

    @Column(name="CERT_TEACHINGMETHODS",length = 1)
    private String certTeachingmethods;

    @Column(name="CERT_CONTENT",length = 1)
    private String certContent;

    @Column(name="CERT_TUITION",length = 1)
    private String certTuition;

    @Column(name="CERT_BACK_LINE_SPACING")
    private Long certBackLineSpacing;

    @Column(name="CERT_BACK_FONT_SIZE")
    private Long certBackFontSize;

    @Column(name="CERT_DESCRIPT_FONT_SIZE")
    private Long certDescriptFontSize;

    @Column(name="IS_INTERNATIONAL")
    private Long isInternational;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "field", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private FieldApiEntity fieldApi;
}
