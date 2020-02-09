package edu.imi.ir.eduimiws.models.response.edu;

import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PeriodResponse {

    @Column(name="NAME",length = 500)
    private String name;

    @Column(name="START_DATE",length = 10)
    private String startDate;

    @Column(name="END_DATE",length = 10)
    private String endDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID")
    private FieldEntity field;

    @Column(name="TYPE",length = 10)
    private String type;

    @Column(name="FEE")
    private Long fee;

    @Column(name="OFFER_NUMBER")
    private Long offerNumber;

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

    @Column(name="ACTIVITY_STATUS",precision = 2,scale = 0)
    private Long activityStatus;

    @Column(name="DELETE_STATUS",precision = 2,scale = 0)
    private Long deleteStatus;

    @Column(name="PRESENT_TYPE",precision = 3,scale = 0)
    private Long presentType;

    @Column(name="TEMP_TYPE",length = 3)
    private String tempType;

    @Column(name="MAX_CAPACITY",precision = 3,scale = 0)
    private String maxCapacity;

    @Column(name="MIN_CAPACITY",precision = 3,scale = 0)
    private String minCapacity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTER_ID")
    private PersonEntity executer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACADEMIC_ID")
    private PersonEntity academic;

    //    TBL_PLAN_OLD
    @Column(name="PLAN_ID")
    private Long planId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @Column(name="TOTAL_UNIT")
    private Long totalUnit;

    @Column(name="THESIS_UNIT",length = 20)
    private String thesisUnit;

    @Column(name="TUNIT",precision = 3,scale = 0)
    private Long tunit;

    @Column(name="PUNIT",precision = 3,scale = 0)
    private String punit;

    @Column(name="VARIABLE_NAME",length = 200)
    private String variableName;

    //    TBL_CERTIFICATE_TEMPLATE
    @Column(name="CERTIFICATE_TEMPLATE_ID")
    private Long certificateTemplateId;

    @Column(name="EXECUTER_CAPACITY",precision = 6,scale = 0)
    private Long executerCapacity;

    @Column(name="FEE_FOREIGN")
    private Long feeForeign;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private ParameterEntity currency;

    @Column(name="REG_START_DATE",length = 10)
    private String regStartDate;

    @Column(name="REG_END_DATE",length = 10)
    private String regEndDate;

    @Column(name="DESCRIPTION",length = 4000)
    private String description;

    @Column(name="SCHEDULE",length = 250)
    private String schedule;

    @Column(name="PERIOD_ORG_FEE")
    private Long periodOrgFee;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name="CAN_REGISTER_ONLINE",length = 15)
    private String canRegisterOnline;

    @Column(name="CARD_NO_PERFIX",length = 20)
    private String cardNoPerfix;

    @Column(name="FEE_VARIABLE")
    private Long feeVariable;

    @Column(name="FEE_EQUIVALENT_FIXED")
    private Long feeEquivalentFixed;

    @Column(name="FEE_EQUIVALENT_VARIABLE")
    private Long feeEquivalentVariable;

    @Column(name="ONLINE_REG_COST_PERCENT")
    private Long onlineRegCostPercent;

    @Column(name="CARD_NO_PERFIX_R",length = 20)
    private String cardNoPerfixR;

    //    TBL_PERIOD_HOLDING_REQ_ITEM
    @Column(name="PERIOD_HOLDING_ID")
    private Long periodHoldingId;

    @Column(name="HOLDING_TYPE",length = 20)
    private String holdingType;

    @Column(name="HOLDING_LANGUAGE",length = 2)
    private String holdingLanguage;

    @Column(name="CERTIFICATE_DESC",length = 3000)
    private String certificateDesc;



}
