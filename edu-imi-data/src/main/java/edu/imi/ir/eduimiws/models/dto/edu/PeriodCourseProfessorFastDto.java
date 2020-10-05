package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseProfessorFastDto {

    //   for Descriptive (begin) :
    private String courseFName;
    private String professorName;
    //   for Descriptive (end)

    private String periodCourseStartDate;
    private String periodCourseEndDate;
    private Long periodCourseTime;
    private Long periodCourseSessionNumber;
    private Long periodCourseCourseTypeId;
    private Long periodCourseScoreLowBound;
    private Long periodCourseScoreAcceptBound;
    private Long periodCourseScoreHighBound;
    private String periodCourseScoreQualityValues;
    private String periodCourseScoreAcceptedQuality;
    private Long periodCourseScoringWay;
    private String periodCourseInAverage;

    private String periodName;
    private String periodStartDate;
    private String periodEndDate;
    private Long periodOfferNumber;
    private Long periodActivityStatus;
    private Long periodDeleteStatus;
    private String periodCanRegisterOnLine;

    private String fieldCode;
    private String fieldFName;
    //   for Descriptive (end) :


    private Long id;

    private String periodCourseProfessorPublicId;

    private String periodPublicId;

    private String coursePublicId;

    private Long periodCourseId;

    private String periodCoursePublicId;

    private Long professorId;

    private String professorPublicId;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private Long professorContractId;

    private Long licenseProfessorId;

    private Long periodCourseProfessorApiId;

}
