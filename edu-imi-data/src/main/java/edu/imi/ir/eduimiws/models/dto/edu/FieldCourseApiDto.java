package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldCourseApiDto implements Serializable {

    private static final long serialVersionUID = 6955287640741789501L;

    private Long id;

    private FieldCourseDto fieldCourseDto;

    private Long fieldCourseId;

    private String fieldCoursePublicId;

    private CourseDto courseDto;

    private Long courseId;

    private String coursePublicId;

    private FieldDto fieldDto;

    private Long fieldId;

    private String fieldPublicId;

    private String fieldCourseEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
