package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.CLOB;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDto implements Serializable {

    private static final long serialVersionUID = 1l;

    private String code;

    private String fname;

    private String lname;

    private LevelEntity level;

    private EduCategoryEntity eduCategory;

    private Long tunit;

    private Long punit;

    private Long totalUnit;

    private Long activityStatus;

    private PersonEntity creator;

    private String createDate;

    private PersonEntity editor;

    private String editDate;

    private CompanyEntity company;

    private String description;

    private String note;

    private ParameterEntity diplomaType;

    private String examType;

    private ContactEntity contact;

    private OrganizationEntity organization;

    private String termicStatus;

    private PersonEntity supervisor;

    private CLOB tableau;

    private Long lastPeriodNumber;

    private Long planId;

    private Long executerId;

    private Long capacity;

    private ParameterEntity preCertificate;

    private String foriegnFee;

    private Long preCoefficientId;

    private Long scoreLowBound;

    private Long scoreAcceptBound;

    private Long scoreHighBound;

    private String scoreQualityValues;

    private String scoreAcceptedQuality;

    private String certNeedScore;

    private String certNeedPresence;

    private Long certAcceptedPresence;

    private Long scoringWay;

    private String needPermitionForAgancy;

    private String certUnit;

    private String certTime;

    private String certScore;

    private String certDate;

    private String certBack;

    private String certBirth;

    private String certEqui;

    private String certLaw;

    private String certSodor;

    private String certDesc;

    private CLOB siteIntroduction;

    private CLOB siteContacts;

    private CLOB siteAim;

    private CLOB siteContents;

    private CLOB siteConditions;

    private CLOB siteTmethods;

    private CLOB siteRegisterR;

    private String certGoal;

    private String certTeachingmethods;

    private String certContent;

    private String certTuition;

    private Long certBackLineSpacing;

    private Long certBackFontSize;

    private Long certDescriptFontSize;

    private Long isInternational;

}
