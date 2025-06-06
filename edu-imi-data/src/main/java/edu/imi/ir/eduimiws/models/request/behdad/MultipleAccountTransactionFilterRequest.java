package edu.imi.ir.eduimiws.models.request.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Tag(name = "behdadaccounts")
@Schema(name = "MultipleAccountTransactionFilterRequest",
        description = "Class representing Paged Multiple Account Transactions Details Request ")
@JsonRootName(value = "multipleAccountTransactionFilterRequest")
@Relation(collectionRelation = "multipleAccountTransactionFilterRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultipleAccountTransactionFilterRequest {

    @JsonProperty("accountNumbers")
    private List<String> accountNumbers;
    @JsonProperty("fromDateTime")
    private String fromDateTime;
    @JsonProperty(value = "paymentIdentifier",defaultValue = "null")
    private String paymentIdentifier;
    @JsonProperty("toDateTime")
    private String toDateTime;
}
