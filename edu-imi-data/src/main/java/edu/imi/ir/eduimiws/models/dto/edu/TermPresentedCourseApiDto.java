package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedCourseApiDto implements Serializable {

    private static final long serialVersionUID = 4865807489666355589L;

    private Long id;

    private TermPresentedCourseDto termPresentedCourseDto;

    private String trmPresentedCoursePublicId;

    private TermDto termDto;

    private Long termId;

    private String termPublicId;

    private FieldCourseDto fieldCourseDto;

    private Long fieldCourseId;

    private String fieldCoursePublicId;

    private PeriodDto periodDto;

    private Long periodId;

    private String periodPublicId;

    private CourseDto courseDto;

    private Long courseId;

    private String coursePublicId;

    private ProfessorDto professorDto;

    private Long professorId;

    private String professorPublicId;

    private TermPresentedGroupDto termPresentedGroupDto;

    private Long termPresentedGroupId;

    private String termPresentedGroupPublicId;

    private String trmPresentedCourseEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
