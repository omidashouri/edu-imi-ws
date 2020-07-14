package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Clob;

@Schema(name = "levels",description = "Class representing a level in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "level")
@Relation(collectionRelation = "levels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldResponse extends RepresentationModel<FieldResponse> {

    @Schema(title = "Field Public ID",maxLength = 36)
    private String fieldPublicId;

    @Schema(title = "Level Public ID",maxLength = 36)
    private String levelPublicId;

    @Schema(title = "Education Category Public ID",maxLength = 36)
    private String eduCategoryPublicId;

    @Schema(title = "Code",maxLength = 20)
    private String code;

    @Schema(title = "Persian Name",maxLength = 500)
    private String fname;

    @Schema(title = "Latin Name",maxLength = 20)
    private String lname;

    @Schema(title = "TUnit",type = "number")
    private Long tunit;

    @Schema(title = "PUnit",type = "number")
    private Long punit;

    @Schema(title = "Total Unit",type = "number")
    private Long totalUnit;

    @Schema(title = "Activity Status",type = "number")
    private Long activityStatus;

    @Schema(title = "Creator Public Id",maxLength = 36)
    private String creatorPublicId;

    @Schema(title = "Create Date",maxLength = 10)
    private String createDate;

    @Schema(title = "Editor Public Id",maxLength = 36)
    private String editorPublicId;

    @Schema(title = "Edit Date",maxLength = 10)
    private String editDate;

    @Schema(title = "Company Public Id",maxLength = 36)
    private String companyPublicId;

    @Schema(title = "Description",maxLength = 4000)
    private String description;

    @Schema(title = "Note",maxLength =  500)
    private String note;

    @Schema(title = "Diploma Type Public Id",maxLength =36)
    private String diplomaTypePublicId;

    @Schema(title = "Exame Type",maxLength =  10)
    private String examType;

    @Schema(title = "Description",maxLength =36)
    private String contactPublicId;

    @Schema(title = "Description",maxLength = 36)
    private String organizationPublicId;

    @Schema(title = "Termic Status",maxLength =  10)
    private String termicStatus;

    @Schema(title = "Description",maxLength = 36)
    private String supervisorPublicId;

    @Schema(title = "Description",type = "Clob")
    private Clob tableau;

    @Schema(title = "Description", type="number")
    private Long lastPeriodNumber;

    @Schema(title = "Plan Public Id",maxLength = 36)
    private String planPublicId;

    @Schema(title = "Executor Public Id",maxLength = 36)
    private String executerPublicId;

    @Schema(title = "Capacity",type="number")
    private Long capacity;

    @Schema(title = "Pre Certificate",maxLength = 36)
    private String preCertificatePublicId;

    @Schema(title = "Foreign Fee",maxLength = 1)
    private String foriegnFee;

    //    TBL_COEFFICIENT
    @Schema(title = "Pre Coefficient Public Id",maxLength =36)
    private String preCoefficientPublicId;

    @Schema(title = "Score Low Bound",type="number")
    private Long scoreLowBound;

    @Schema(title = "Score Accept Bound",type="number")
    private Long scoreAcceptBound;

    @Schema(title = "Score High Bound",type="number")
    private Long scoreHighBound;

    @Schema(title = "Score Quality Value",maxLength = 50)
    private String scoreQualityValues;

    @Schema(title = "Score Accepted Quality",maxLength = 100)
    private String scoreAcceptedQuality;

    @Schema(title = "Certificate Need Score",maxLength = 1)
    private String certNeedScore;

    @Schema(title = "Certificate Need Presence",maxLength = 1)
    private String certNeedPresence;

    @Schema(title = "Certificate Accept Presence",type="number")
    private Long certAcceptedPresence;

    @Schema(title = "Scoring Way",type="number")
    private Long scoringWay;

    @Schema(title = "Need Permission ForAgency",maxLength = 1)
    private String needPermitionForAgancy;

    @Schema(title = "Certificate Unit",maxLength =  1)
    private String certUnit;

    @Schema(title = "Certificate Time",maxLength =  1)
    private String certTime;

    @Schema(title = "Certificate Score",maxLength =  1)
    private String certScore;

    @Schema(title = "Certificate Date",maxLength =  1)
    private String certDate;

    @Schema(title = "Certificate Back",maxLength =  1)
    private String certBack;

    @Schema(title = "Certificate Birth",maxLength =  1)
    private String certBirth;

    @Schema(title = "Certificate Equipment",maxLength =  1)
    private String certEqui;

    @Schema(title = "Certificate Law",maxLength =  1)
    private String certLaw;

    @Schema(title = "Certificate Publish",maxLength =  1)
    private String certSodor;

    @Schema(title = "Certificate Description",maxLength =  1)
    private String certDesc;

    @Schema(title = "Site Introduction",type = "Clob")
    private Clob siteIntroduction;

    @Schema(title = "Site Contacts",type="Clob" )
    private Clob siteContacts;

    @Schema(title = "Site Aim",type = "Clob")
    private Clob siteAim;

    @Schema(title = "Site Content",type = "Clob")
    private Clob siteContents;

    @Schema(title = "Site Condition",type="Cob")
    private Clob siteConditions;

    @Schema(title = "Site T Methods",type="Clob")
    private Clob siteTmethods;

    @Schema(title = "Site Register",type="Clob")
    private Clob siteRegisterR;

    @Schema(title = "Certificate Goal",maxLength =  1)
    private String certGoal;

    @Schema(title = "Certificate Teaching Method",maxLength =  1)
    private String certTeachingmethods;

    @Schema(title = "Certificate Content",maxLength =  1)
    private String certContent;

    @Schema(title = "Cer Tuition",maxLength =  1)
    private String certTuition;

    @Schema(title = "Certificate Backing Space",type="number")
    private Long certBackLineSpacing;

    @Schema(title = "Certificate Back Font Size",type="number")
    private Long certBackFontSize;

    @Schema(title = "Certificate Description Font Size",type="number")
    private Long certDescriptFontSize;

    @Schema(title = "Is International",type="number")
    private Long isInternational;


}
