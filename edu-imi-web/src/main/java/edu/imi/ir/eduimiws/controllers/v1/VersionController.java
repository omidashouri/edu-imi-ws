package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.VersionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/version")
@RequiredArgsConstructor
@Tag(name = "Version", description = "Application version API")
public class VersionController {

    private static final ZoneId SERVER_ZONE = ZoneId.of("GMT+03:30");
    private static final String FALLBACK_VERSION = "2.0.0";

    private final ObjectProvider<BuildProperties> buildProperties;

    @Operation(
            summary = "Get application version",
            description = "Returns the Maven project version and the current server date-time",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = VersionResponse.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("hasAuthority('API_V1_VERSION_READ')")
    public ResponseEntity<VersionResponse> getVersion() {
        String version = buildProperties.stream()
                .findFirst()
                .map(BuildProperties::getVersion)
                .orElse(FALLBACK_VERSION);

        String dateTime = OffsetDateTime.now(SERVER_ZONE).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return ResponseEntity.ok(new VersionResponse(version, dateTime));
    }
}
