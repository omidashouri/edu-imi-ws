package edu.imi.ir.eduimiws.models.dto.atc;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllVacationRegistrationsByDateResponseDto implements Serializable {

    private static final long serialVersionUID = 3176727427927451743L;

    private VacationRegistrationDataModelDto vacationRegistrationDataModel;

}
