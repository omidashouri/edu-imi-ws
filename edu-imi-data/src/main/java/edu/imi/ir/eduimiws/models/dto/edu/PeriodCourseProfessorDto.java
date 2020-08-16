package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCourseProfessorDto implements Serializable {

    private static final long serialVersionUID = -6948468843159754038L;

    private Long id;

    private String periodCourseProfessorPublicId;

    private PeriodCourseDto periodCourseDto;

    private Long periodCourseId;

    private String periodCoursePublicId;

    private ProfessorDto professorDto;

    private Long professorId;

    private String professorPublicId;

    private PersonDto creatorDto;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private PersonEntity editor;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private Long professorContractId;

    private Long licenseProfessorId;

    private PeriodCourseProfessorApiDto periodCourseProfessorApiDto;

    private Long periodCourseProfessorApiId;
}
