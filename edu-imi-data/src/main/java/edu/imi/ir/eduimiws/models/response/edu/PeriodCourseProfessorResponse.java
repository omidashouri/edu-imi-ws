package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "periodCourse", description = "Period Courses specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "periodCourse")
@Relation(collectionRelation = "periodCourses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseProfessorResponse extends RepresentationModel<PeriodCourseProfessorResponse> {


    //   for Descriptive (begin) :
    private String courseFName;
    private String professorName;
    private String periodName;
    private Long periodOfferNumber;

    private String fieldCode;
    private String fieldFName;
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

    private String periodCourseProfessorPublicId;

    private String professorPublicId;

}
