package edu.imi.ir.eduimiws.models.response.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class BaseResponseDto {

    @Schema(title = "Request Id", description = "Echo of the client requestId from the request body")
    private String requestId;

    @Schema(title = "Trace No", description = "Trace id from MDC (traceId)")
    private String traceNo;

    @Schema(title = "Effective Date", description = "Server effective date for the response")
    private LocalDate effectiveDate;
}
