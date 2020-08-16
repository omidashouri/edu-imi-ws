package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseApiDto implements Serializable {

    private static final long serialVersionUID = 5007632992275434069L;

    private Long id;

    private PeriodCourseDto periodCourseDto;

    private Long periodCourseId;

    private String periodCoursePublicId;

    private PeriodDto periodDto;

    private Long periodId;

    private String periodPublicId;

    private CourseDto courseDto;

    private Long courseId;

    private String coursePublicId;

    private String periodCourseEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
