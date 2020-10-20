package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedGroupFastDto implements Serializable {

    private static final long serialVersionUID = 5572333122640894417L;

    private Long id;

    //   for Descriptive (begin) :
    private String courseName;
    private String termName;
    private String professorFullName;
    private String periodName;
    //   for Descriptive (end) :

    private String termPresentedGroupPublicId;

    private String professorPublicId;

    private String termPresentedCoursePublicId;

    private String termPublicId;

    private String periodPublicId;

    private String fieldCoursePublicId;

    private String coursePublicId;

    private String creatorPublicId;

    private Long groupNumber;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long capacity;

    private String assistantPublicId;

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

    private Long licenseProfessorId;

}
