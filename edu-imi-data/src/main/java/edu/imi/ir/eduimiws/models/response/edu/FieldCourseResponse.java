package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "fieldCourse", description = "Filed Courses specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "fieldCourse")
@Relation(collectionRelation = "fieldCourses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldCourseResponse extends RepresentationModel<FieldCourseResponse> {

    //   for Descriptive (begin) :
    private String courseName;
    private String fieldName;
    //   for Descriptive (end) :

    private String fieldCoursePublicId;

    private String coursePublicId;

    private String fieldPublicId;

    private Long courseTypeId;

    private String creatorPublicID;

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
