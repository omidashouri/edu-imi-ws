package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseFastDto {

    //   for Descriptive (begin) :
    private String periodName;
    private String courseName;
    //   for Descriptive (end) :

    private String periodCoursePublicId;

    private String periodPublicId;

    private String coursePublicId;

    private String startDate;

    private String endDate;

    private Long time;

    private Long sessionNumber;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long courseTypeId;

    private Long scoreLowBound;

    private Long scoreAcceptBound;

    private Long scoreHighBound;

    private String scoreQualityValues;

    private String scoreAcceptedQuality;

    private Long scoringWay;

    private String inAverage;

}
