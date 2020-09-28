package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "termCourse", description = "Term Courses specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "termCourse")
@Relation(collectionRelation = "termCourses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedGroupResponse {


    private String termPresentedGroupPublicId;

    private String professorPublicId;

    private String professorFullName;

    private Long groupNumber;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private String termPresentedCoursePublicId;

    private String termPublicId;

    private String termName;

    private String periodPublicId;

    private String periodName;

    private String fieldCoursePublicId;

    private String coursePublicId;

    private String courseName;

    private Long capacity;

    private String assistantPublicId;

    private String assistantName;

    private String startDate;

    private String endDate;

    private Long cunit;

    private Long ctime;

    private Long scoreLowBound;

    private Long scoreAcceptBound;

    private Long scoreHighBound;

    private String scoreQualityValues;

    private String scoreAcceptedQuality;

    private Long scoringWay;


}
