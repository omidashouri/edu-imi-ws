package edu.imi.ir.eduimiws.models.request.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class BaseRequestDto {

    @NotBlank
    @Schema(title = "Request Id", description = "Unique client-generated request id (UUID) for idempotent logging",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String requestId;
}
