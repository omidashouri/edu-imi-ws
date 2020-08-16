package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedGroupApiDto implements Serializable {

    private static final long serialVersionUID = -6947230466653465673L;

    private Long id;

    private TermPresentedGroupDto termPresentedGroupDto;

    private Long termPresentedGroupId;

    private String termPresentedGroupPublicId;

    private ProfessorDto professorDto;

    private Long professorId;

    private String professorPublicId;

    private TermPresentedCourseDto termPresentedCourseDto;

    private Long termPresentedCourseId;

    private String trmPresentedCoursePublicId;

    private String termPresentedGroupEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
