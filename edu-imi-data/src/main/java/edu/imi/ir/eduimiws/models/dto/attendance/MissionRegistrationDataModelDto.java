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
public class MissionRegistrationDataModelDto implements Serializable {

    private static final long serialVersionUID = 4287572270452960973L;

    private Long id;
    private Long missionRegistrationId;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private DayOfWeek dayOfWeek;
    private String beginDateInText;
    private String beginTimeInText;
    private String endDateInText;
    private String endTimeInText;
    private String missionNameInText;
    private MissionName missionName;
    private String missionTypeInText;
    private MissionType missionType;
    private String acceptanceStateInText;
    private AcceptanceState acceptanceState;
    private String sourceTypeInText;
    private SourceType missionSourceType;
    private Timestamp createDateTs;
    private Timestamp editDateTs;
    private String Description;

}
