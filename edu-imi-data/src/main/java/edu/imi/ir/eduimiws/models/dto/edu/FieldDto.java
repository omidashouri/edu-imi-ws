package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import lombok.*;

import java.io.Serializable;
import java.sql.Clob;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldDto implements Serializable {

    private static final long serialVersionUID = 839540328420122716L;

    private String fieldPublicId;

    private Long id;

    private String code;

    private String fname;

    private String lname;

    private LevelEntity level;

    private Long levelId;

    private String levelPublicId;

    private EduCategoryEntity eduCategory;

    private Long eduCategoryId;

    private String eduCategoryPublicId;

    private Long tunit;

    private Long punit;

    private Long totalUnit;

    private Long activityStatus;

    private PersonEntity creator;

    private Long creatorId;

    private String creatorPublicID;

    private String createDate;

    private PersonEntity editor;

    private Long editorId;

    private String editorPublicID;

    private String editDate;

    private CompanyEntity company;

    private Long companyId;

    private String companyPublicId;

    private String description;

    private String note;

    private ParameterEntity diplomaType;

    private String examType;

    private ContactEntity contact;

    private Long contactId;

    private Long contactPublicId;

    private OrganizationEntity organization;

    private Long organizationId;

    private String organizationPublicId;

    private String termicStatus;

    private PersonEntity supervisor;

    private Long supervisorId;

    private String supervisorPublicId;

    private Clob tableau;

    private Long lastPeriodNumber;

    private Long planId;

    private Long executerId;

//    not joined in database to tbl_person
//    private Long executerPublicId;

    private Long capacity;

    private ParameterEntity preCertificate;

    private Long preCertificateId;

    private String preCertificatePublicId;

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

    private Clob siteIntroduction;

    private Clob siteContacts;

    private Clob siteAim;

    private Clob siteContents;

    private Clob siteConditions;

    private Clob siteTmethods;

    private Clob siteRegisterR;

    private String certGoal;

    private String certTeachingmethods;

    private String certContent;

    private String certTuition;

    private Long certBackLineSpacing;

    private Long certBackFontSize;

    private Long certDescriptFontSize;

    private Long isInternational;

}
