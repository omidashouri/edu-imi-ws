package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedCourseDto implements Serializable {

    private static final long serialVersionUID = 2576524020212792104L;

    private Long id;

    private String termPresentedCoursePublicID;

    private String coursePublicId;

    private Long courseId;

    private String professorPublicId;

    private Long professorId;

    private String presentedGroupPublicId;

    private Long presentedGroupId;

    private String fieldCoursePublicID;

    private Long fieldCourseId;

    private FieldCourseDto fieldCourseDto;

    private String termPublicId;

    private Long termId;

    private TermDto termDto;

    private String periodPublicId;

    private Long periodId;

    private PeriodDto periodDto;

    private String creatorPublicId;

    private Long CreatorId;

    private PersonDto creatorDto;

    private String createDate;

    private String editorPublicId;

    private Long editorId;

    private PersonDto editorDto;

    private String editDate;

    private Long time;

    private Long termPresentedCourseApiId;

    private TermPresentedCourseApiDto termPresentedCourseApiDto;
}
