package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseApiDto implements Serializable {

    private static final long serialVersionUID = 7667505280571773982L;

    private Long id;

    private Long courseId;

    private CourseDto courseDto;

    private String coursePublicId;

    private String courseEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;

    private Long courseCategoryId;

    private CourseCategoryDto courseCategoryDto;

    private String courseCategoryPublicId;

    private LevelDto levelDto;

    private Long levelId;

    private String levelPublicId;
}
