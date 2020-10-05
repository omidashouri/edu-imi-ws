package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseFastDto {

    //   for Descriptive (begin) :
    private String courseCategoryName;
    private String levelName;
    //   for Descriptive (end) :

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

}
