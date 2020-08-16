package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryApiDto implements Serializable {

    private static final long serialVersionUID = 1981962113903483300L;

    private Long id;

    private Long courseCategoryDId;

    private CourseCategoryDto courseCategoryDto;

    private String courseCategoryPublicId;

    private String courseCategoryEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
