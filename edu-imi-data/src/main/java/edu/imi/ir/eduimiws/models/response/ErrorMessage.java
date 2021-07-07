package edu.imi.ir.eduimiws.models.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {


    @Schema(
            description = "error date time",
            example = "2020-03-28T06:27:59.049Z"
    )
    private String errorDateTime;

    @Schema(
            description = "HTTP status error code",
            example = "400"
    )
    private String errorCode;

    @Schema(
            description = "Error Message and detail",
            example = "Bad Request"
    )
    private String errorMessage;
}
