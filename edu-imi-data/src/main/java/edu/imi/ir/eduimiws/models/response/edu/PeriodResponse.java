package edu.imi.ir.eduimiws.models.response.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponse extends RepresentationModel<PeriodResponse> {

    private String periodPublicId;

    private PeriodFastDto periodFastDto;


}
