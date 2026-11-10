package edu.imi.ir.eduimiws.models.request.edu.v1;

import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Schema(name = "periodPublicIdCreate", description = "Generate period public ids (logged POST)")
@JsonRootName(value = "periodPublicIdCreate")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PeriodPublicIdCreateRequest extends BaseRequestDto {
}
