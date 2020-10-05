package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorFastDto {

    //   for Descriptive (begin)
    private String personName;
    //   for Descriptive (end)

    private String professorPublicId;

    private String firstName;

    private String lastName;

    private String nationCode;

    private String email;

    private String code;

    private String professorType;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private String personPublicId;

    private Long finalScore;

    private String startYear;

    private Long dutyHour;

    private Long acceptedHour;

    private String isInner;

    private Long dutyHourMonth;

}
