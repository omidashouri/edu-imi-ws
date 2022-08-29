package edu.imi.ir.eduimiws.models.dto.crm.farapayamak;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyBaseDto implements Serializable {

    private static final long serialVersionUID = 3384000244970711698L;

    @JsonProperty("Value")
    private String value;

    @JsonProperty("RetStatus")
    private Integer retStatus;

    @JsonProperty("StrRetStatus")
    private String StrRetStatus;
}
