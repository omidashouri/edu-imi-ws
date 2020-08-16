package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseDto implements Serializable {

    private static final long serialVersionUID = 6766046197742445451L;

    private Long id;

    private String periodCoursePublicId;

    private PeriodDto periodDto;

    private Long periodId;

    private String periodPublicId;

    private CourseDto courseDto;

    private long courseId;

    private String coursePublicId;

    private String startDate;

    private String endDate;

    private Long time;

    private Long sessionNumber;

    private PersonDto creatorDto;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;

    private Long editorId;

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

    private PeriodCourseApiDto periodCourseApiDto;

    private Long periodCourseApiId;
}
