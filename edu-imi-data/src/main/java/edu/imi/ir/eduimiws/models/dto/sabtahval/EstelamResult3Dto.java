package edu.imi.ir.eduimiws.models.dto.sabtahval;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstelamResult3Dto extends EstelamResultDto implements Serializable {

    private String deathDate;
    private String exceptionMessage;
}
