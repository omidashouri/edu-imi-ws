package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllMissionRegistrationsByDateResponseDto implements Serializable {

    private static final long serialVersionUID = 2395010507421407481L;

    private MissionRegistrationDataModelDto missionRegistrationDataModel;

}
