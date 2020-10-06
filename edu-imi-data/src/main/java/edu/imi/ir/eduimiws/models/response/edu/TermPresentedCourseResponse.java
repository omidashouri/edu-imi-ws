package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "termPresentedCourseResponse", description = "Term Presented Course specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "termPresentedCourse")
@Relation(collectionRelation = "termPresentedCourses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedCourseResponse extends RepresentationModel<TermPresentedCourseResponse> {

    //   for Descriptive (begin) :
    private String courseName;
    private String fieldName;
    private String termName;
    private String periodName;
    //   for Descriptive (end) :

    private String termPresentedCoursePublicId;

    private String coursePublicId;

    private String fieldCoursePublicId;

    private String termPublicId;

    private String periodPublicId;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long time;
}
