package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "course", description = "Courses specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "course")
@Relation(collectionRelation = "courses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse extends RepresentationModel<CourseResponse> {


    private String coursePublicId;

    private String code;

    private String fname;

    private String lname;

    private Long tunit;

    private Long activityStatus;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private String companyPublicId;

    private Long deleteStatus;

    private String description;

    private Long courseTypeId;

    private Long ctime;

    private String courseCategoryPublicId;

    private String silabesFile;

    private String silabes;

    private String courseAim;

    private String courseRef;

    private String levelPublicId;

    private String courseCategoryName;

    private String levelName;
}
