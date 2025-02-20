package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IoRecordDataModelDto implements Serializable {

    private static final long serialVersionUID = -6418993011478359054L;

    private Long id;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private String finalDateInText;
    private String finalTimeInText;
    private String finalRecordIoTypeInText;
    private String acceptanceStateInText;
    private String ioSourceTypeInText;
}
