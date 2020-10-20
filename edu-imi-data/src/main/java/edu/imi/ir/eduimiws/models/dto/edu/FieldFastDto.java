package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldFastDto {

    private static final long serialVersionUID = 4884953995945875223L;

    private Long id;

    private String fieldPublicId;

    private String levelPublicId;

    private String eduCategoryPublicId;

    private String code;

    private String fname;

    private String lname;

    private Long tunit;

    private Long punit;

    private Long totalUnit;

    private Long activityStatus;

    private String creatorPublicID;

    private String createDate;

    private Long editorId;

    private String editorPublicID;

    private String editDate;

    private String companyPublicId;

    private String description;

    private String note;

    private String diplomaTypePublicId;

    private String examType;

    private String contactPublicId;

    private String organizationPublicId;

    private String termicStatus;

    private String supervisorPublicId;

    private String tableau;

    private Long lastPeriodNumber;

    private Long planId;

//    planPublicId not available

    private Long executerId;

//    not joined in database to tbl_person
//    private Long executerPublicId;

    private Long capacity;

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

    private String siteIntroduction;

    private String siteContacts;

    private String siteAim;

    private String siteContents;

    private String siteConditions;

    private String siteTmethods;

    private String siteRegisterR;

    private String certGoal;

    private String certTeachingmethods;

    private String certContent;

    private String certTuition;

    private Long certBackLineSpacing;

    private Long certBackFontSize;

    private Long certDescriptFontSize;

    private Long isInternational;
}
