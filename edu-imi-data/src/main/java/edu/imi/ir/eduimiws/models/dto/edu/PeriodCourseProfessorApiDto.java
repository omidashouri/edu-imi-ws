package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseProfessorApiDto implements Serializable {

    private static final long serialVersionUID = 5296273303567771191L;

    private Long id;

    private PeriodCourseProfessorDto periodCourseProfessorDto;

    private Long periodCourseProfessorId;

    private String priodCoursProfesorPublicId;

    private PeriodDto periodDto;

    private Long periodId;

    private String periodPublicId;

    private PeriodCourseDto periodCourseDto;

    private Long periodCourseId;

    private String periodCoursePublicId;

    private CourseDto courseDto;

    private Long courseId;

    private String coursePublicId;

    private ProfessorDto professorDto;

    private Long professorId;

    private String professorPublicId;

    private String priodCoursProfesorEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp deleteDateTs;

    private java.sql.Timestamp editDateTs;

    private String description;
}
