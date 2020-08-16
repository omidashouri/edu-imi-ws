package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldCourseDto implements Serializable {

    private static final long serialVersionUID = 5632717939614626785L;

    private Long id;

    private String fieldCoursePublicId;

    private String coursePublicId;

    private Long courseId;

    private CourseDto courseDto;

    private String fieldPublicId;

    private Long fieldId;

    private FieldDto fieldDto;

    private Long courseTypeId;

    private String creatorPublicID;

    private Long creatorId;

    private PersonDto creatorDto;

    private String createDate;

    private String editorPublicId;

    private Long editorId;

    private PersonDto editorDto;

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

    private Long fieldCourseApiId;

    private FieldCourseApiDto fieldCourseApiDto;

}
