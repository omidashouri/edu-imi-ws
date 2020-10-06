package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedCourseFastDto {

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
