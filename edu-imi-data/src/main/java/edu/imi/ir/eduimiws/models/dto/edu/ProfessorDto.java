package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto implements Serializable {

    private static final long serialVersionUID = 6758616963582060437L;

    private Long id;

    private String firstName;

    private String lastName;

    private String nationCode;

    private String email;

    private String code;

    private String professorType;

    private PersonDto creatorDto;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private PersonDto personDto;

    private Long personId;

    private String personPublicId;

    private Long finalScore;

    private String startYear;

    private Long dutyHour;

    private Long acceptedHour;

    private String isInner;

    private Long dutyHourMonth;

    private ProfessorApiDto professorApiDto;
}
