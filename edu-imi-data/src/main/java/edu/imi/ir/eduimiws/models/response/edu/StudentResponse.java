package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;



@Schema(name = "students",description = "Class representing a student in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "student")
@Relation(collectionRelation = "students")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse extends RepresentationModel<StudentResponse> {

    @Schema(title = "Student Public ID",maxLength = 36)
    private String studentPublicId;

    @Schema(title = "User Public ID",maxLength = 36)
    private String userPublicId;

    @Schema(name="FIRST_NAME",maxLength = 100)
    private String firstName;

    @Schema(name="LAST_NAME",maxLength = 100)
    private String lastName;

    @Schema(name="NATION_CODE",maxLength = 15)
    private String nationCode;

    @Schema(name="Student CODE",maxLength = 20)
    private String code;

    @Schema(name="ACTIVITY_STATUS",type = "number")
    private Long activityStatus;

    @Schema(name="DELETE_STATUS",type = "number")
    private Long deleteStatus;

    @Schema(title = "Creator Public ID",maxLength = 36)
    private String creatorPublicId;

    @Schema(name="CREATE_DATE",maxLength = 10)
    private String createDate;

    @Schema(title = "Editor Public ID",maxLength = 36)
    private String editorPublicId;

    @Schema(name="EDIT_DATE",maxLength = 10)
    private String editDate;

    @Schema(name="DESCRIPTION",maxLength = 150)
    private String description;
}
