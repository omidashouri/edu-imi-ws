package edu.imi.ir.eduimiws.models.dto.crm.farapayamak;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @JsonProperty("MyBase")
    private MyBaseDto myBaseDto;

    @JsonProperty("Data")
    private List<DataDto> dataDtos = new ArrayList<>();


}
