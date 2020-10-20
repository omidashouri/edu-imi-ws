package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseApiDto implements Serializable {

    private static final long serialVersionUID = -3602416522456799300L;

    private Long id;

    private Timestamp editDateTs;

    private StudentCourseDto studentCourseDto;
    private Long studentCourseId;

    private Long deletedStudentCourseId;

    private RegisterDto registerDto;
    private Long registerId;

    private String registerPublicId;

    private String studentCoursePublicId;

    private PeriodCourseDto periodCourseDto;
    private Long periodCourseId;

    private String periodCoursePublicId;

    private PeriodDto periodDto;
    private Long periodId;

    private String periodPublicId;

    private CourseDto courseDto;
    private Long courseId;

    private String coursePublicId;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private StudentDto studentDto;
    private Long studentId;

    private String studentPublicId;
}
