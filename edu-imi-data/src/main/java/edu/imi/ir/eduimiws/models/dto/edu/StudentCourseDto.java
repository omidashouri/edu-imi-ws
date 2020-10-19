package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class StudentCourseDto implements Serializable {

    private static final long serialVersionUID = -1869985511182016440L;

    private Long id;

    private RegisterDto registerDto;
    private Long registerId;
    private String registerPublicId;

    private PeriodCourseDto periodCourseDto;
    private Long periodCourseId;
    private String periodCoursePublicId;

    private String status;

    private Long score;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String editDate;

    private Long deleteStatus;

    private String finalStatus;

    private StudentCourseApiDto studentCourseApiDto;
    private Long studentCourseApiId;
    private String studentCoursepublicId;
}
