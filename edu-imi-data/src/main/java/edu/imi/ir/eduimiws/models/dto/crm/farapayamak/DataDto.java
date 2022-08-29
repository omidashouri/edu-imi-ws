package edu.imi.ir.eduimiws.models.dto.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto implements Serializable {

    private static final long serialVersionUID = 2541989704006913055L;

    @JsonProperty("MsgID")
    private Integer messageId;

    @JsonProperty("Body")
    private String body;

    @JsonProperty("SendDate")
    private String sendDate;

    @JsonProperty("Sender")
    private String sender;

    @JsonProperty("Receiver")
    private String receiver;

    @JsonProperty("FirstLocation")
    private Integer firstLocation;

    @JsonProperty("CurrentLocation")
    private Integer currentLocation;

    @JsonProperty("Parts")
    private Integer parts;

    @JsonProperty("RecFailed")
    private Integer recFailed;

    @JsonProperty("RecSuccess")
    private Integer recSuccess;

    @JsonProperty("IsUnicode")
    private Boolean isUnicode;
}
