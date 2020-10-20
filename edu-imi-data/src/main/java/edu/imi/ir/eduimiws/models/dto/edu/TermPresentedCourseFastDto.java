package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedCourseFastDto implements Serializable {

    private static final long serialVersionUID = -8161736928186596595L;

    private Long id;

    //   for Descriptive (begin) :
    private String courseName;
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
