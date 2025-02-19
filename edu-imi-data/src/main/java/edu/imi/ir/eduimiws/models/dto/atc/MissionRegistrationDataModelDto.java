package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRegistrationDataModelDto implements Serializable {

    private static final long serialVersionUID = 4287572270452960973L;

    private Long id;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private String dayOfWeekInText;
    private String beginDateInText;
    private String beginTimeInText;
    private String endDateInText;
    private String endTimeInText;
    private String missionName;
    private String missionTypeInText;
    private String acceptanceStateInText;
    private String sourceTypeInText;

}
