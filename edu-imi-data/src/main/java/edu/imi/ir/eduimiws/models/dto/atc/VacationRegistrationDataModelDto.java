package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacationRegistrationDataModelDto implements Serializable {

    private static final long serialVersionUID = 7732845258589930457L;

    private Long id;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private String beginDateInText;
    private String beginTimeInText;
    private String endDateInText;
    private String endTimeInText;
    private String vacationName;
    private String vacationTypeInText;
    private String acceptanceStateInText;
    private String sourceTypeInText;

}
