package edu.imi.ir.eduimiws.models.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationStatus {

    @Schema(
            description = "Operation Result"
    )
    private String operationResult;

    @Schema(
            description = "Operation Name"
    )
    private String operationName;
}
