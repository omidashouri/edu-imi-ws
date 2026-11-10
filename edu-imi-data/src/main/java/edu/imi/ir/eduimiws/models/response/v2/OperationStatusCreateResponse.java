package edu.imi.ir.eduimiws.models.response.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Schema(name = "operationStatusCreate", description = "Operation status for logged create POSTs")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class OperationStatusCreateResponse extends BaseResponseDto {

    @Schema(description = "Operation Result")
    private String operationResult;

    @Schema(description = "Operation Name")
    private String operationName;

    @Schema(description = "Operation Description")
    private String description;
}
