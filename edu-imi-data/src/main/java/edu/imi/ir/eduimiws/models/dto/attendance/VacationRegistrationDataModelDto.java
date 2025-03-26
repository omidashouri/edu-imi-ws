package edu.imi.ir.eduimiws.models.dto.attendance;

import edu.imi.ir.eduimiws.utilities.attendance.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacationRegistrationDataModelDto implements Serializable {

    private static final long serialVersionUID = 7732845258589930457L;

    private Long id;
    private Long vacationRegistrationId;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private DayOfWeek dayOfWeek;
    private String beginDateInText;
    private String beginTimeInText;
    private String endDateInText;
    private String endTimeInText;
    private String vacationNameInText;
    private VacationName vacationName;
    private String vacationTypeInText;
    private VacationType vacationType;
    private String acceptanceStateInText;
    private AcceptanceState acceptanceState;
    private String sourceTypeInText;
    private SourceType vacationSourceType;
    private Timestamp createDateTs;
    private Timestamp editDateTs;
    private String Description;

}
