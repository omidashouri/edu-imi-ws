package edu.imi.ir.eduimiws.models.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "Version", description = "Application version and current server date-time")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "version")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionResponse {

    @Schema(description = "Maven project version", example = "2.0.0")
    private String version;

    @Schema(description = "Current server date-time (ISO-8601)", example = "2026-11-07T23:45:00+03:30")
    private String dateTime;
}
