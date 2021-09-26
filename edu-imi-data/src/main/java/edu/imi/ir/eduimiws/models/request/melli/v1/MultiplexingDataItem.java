package edu.imi.ir.eduimiws.models.request.melli.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "melli",description = "melli MultiPlexing Data Item")
@JsonRootName(value = "multiplexingDataItem")
@Relation(collectionRelation = "multiplexingDataItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultiplexingDataItem implements Serializable {

    @Schema(title = "Iban Number",
            description = "Iban Number")
    @JsonProperty("IbanNumber")
    public Integer ibanNumber;

    @Schema(title = "Value",
            description = "Value")
    @JsonProperty("Value")
    public Long value;
}
