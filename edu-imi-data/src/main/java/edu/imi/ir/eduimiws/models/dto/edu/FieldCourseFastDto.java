package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldCourseFastDto implements Serializable {

    private static final long serialVersionUID = -1791156204140110481L;

    private Long id;

    //   for Descriptive (begin) :
    private String courseName;
    private String fieldName;
    //   for Descriptive (end) :

    private String fieldCoursePublicId;

    private String coursePublicId;

    private String fieldPublicId;

    private Long courseTypeId;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private String ctime;

    private Long tunit;

    private Long scoreLowBound;

    private Long scoreAcceptBound;

    private Long scoreHighBound;

    private String scoreQualityValues;

    private String scoreAcceptedQuality;

    private Long scoringWay;

}
