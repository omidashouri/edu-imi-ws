package edu.imi.ir.eduimiws.models.dto.crm;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarapayamakReturnedSendSmsDto implements Serializable {

    private static final long serialVersionUID = 5394261482578082713L;

    @JsonProperty("Value")
    private String value;

    @JsonProperty("RetStatus")
    private Integer retStatus;

    @JsonProperty("StrRetStatus")
    private String strRetStatus;
}
