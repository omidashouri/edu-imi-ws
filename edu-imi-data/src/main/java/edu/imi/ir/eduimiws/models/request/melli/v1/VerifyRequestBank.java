package edu.imi.ir.eduimiws.models.request.melli.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "melliPayments",description = "melli verify request bank")
@JsonRootName(value = "verify")
@Relation(collectionRelation = "verify")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyRequestBank {

    @Schema(title = "Token",
            description = "Token")
    @JsonProperty("Token")
    public String token;

    @Schema(title = "Sign Data",
            description = "Sign Data")
    @JsonProperty("SignData")
    public String signData;

}
