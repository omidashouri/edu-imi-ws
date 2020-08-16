package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermPresentedGroupDto implements Serializable {

    private static final long serialVersionUID = 586171581649732869L;

    private Long id;

    private String termPresentedGroupPublicId;

    private String professorPublicId;

    private Long professorId;

    private ProfessorDto professorDto;

    private Number groupNumber;

    private String creatorPublicId;

    private Long creatorId;

    private PersonDto creatorDto;

    private String createDate;

    private String editorPublicId;

    private Long editorId;

    private PersonDto editorDto;

    private String editDate;

    private String termPresentedCoursePublicId;

    private Long termPresentedCourseId;

    private TermPresentedCourseDto termPresentedCourseDto;

    private Long capacity;

    private String assistantPublicId;

    private Long assistantId;

    private ProfessorDto assistantDto;

    private String startDate;

    private String endDate;

    private Long cunit;

    private Long ctime;

    private Long scoreLowBound;

    private Long scoreAcceptBound;

    private Long scoreHighBound;

    private String scoreQualityValues;

    private String scoreAcceptedQuality;

    private Long scoringWay;

    private Long licenseProfessorId;

    private Long termPresentedGroupApiId;

    private TermPresentedGroupApiDto termPresentedGroupApiDto;
}
