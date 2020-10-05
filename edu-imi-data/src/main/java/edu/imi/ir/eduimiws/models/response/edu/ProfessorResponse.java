package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "professor", description = "Professor specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "professor")
@Relation(collectionRelation = "professors")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorResponse extends RepresentationModel<ProfessorResponse> {


    private String professorPublicId;

    private String firstName;

    private String lastName;

    private String nationCode;

    private String email;

    private String code;

    private String professorType;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private String personPublicId;

    private Long finalScore;

    private String startYear;

    private Long dutyHour;

    private Long acceptedHour;

    private String isInner;

    private Long dutyHourMonth;

    private String personName;
}
