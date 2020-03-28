package edu.imi.ir.eduimiws.models.response.edu;

import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(
            description = "period public id"
    )
    private String periodPublicId;

    @Schema(
            description = "period details"
    )
    private PeriodFastDto periodFastDto;

}
