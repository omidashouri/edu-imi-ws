package edu.imi.ir.eduimiws.models.response.hamkaran.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranHeader {

    @JsonProperty("api-key")
    private String apiKey;
}
