package edu.imi.ir.eduimiws.models.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class OperationStatus extends RepresentationModel<OperationStatus> {

    @Schema(
            description = "Operation Result"
    )
    private String operationResult;

    @Schema(
            description = "Operation Name"
    )
    private String operationName;

    @Schema(
            description = "Operation Description"
    )
    private String description;
}
