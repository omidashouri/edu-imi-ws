package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponse implements Serializable {

    private static final long serialVersionUID = 6403170931401315106L;

    private String periodPublicId;

    private PeriodFastDto periodFastDto;
}
