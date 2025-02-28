package edu.imi.ir.eduimiws.models.dto.attendance;

import edu.imi.ir.eduimiws.utilities.attendance.AcceptanceState;
import edu.imi.ir.eduimiws.utilities.attendance.DayOfWeek;
import edu.imi.ir.eduimiws.utilities.attendance.IoSourceType;
import edu.imi.ir.eduimiws.utilities.attendance.RecordIoType;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IoRecordDataModelDto implements Serializable {

    private static final long serialVersionUID = -6418993011478359054L;

    private Long id;
    private Long ioRecordId;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private DayOfWeek dayOfWeek;
    private String finalDateInText;
    private String finalTimeInText;
    private String finalRecordIoTypeInText;
    private RecordIoType recordIoType;
    private String acceptanceStateInText;
    private AcceptanceState acceptanceState;
    private String ioSourceTypeInText;
    private IoSourceType ioSourceCode;
    private Timestamp createDateTs;
    private Timestamp editDateTs;
    private String Description;
}
