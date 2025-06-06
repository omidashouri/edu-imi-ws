package edu.imi.ir.eduimiws.models.response.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "behdadaccounts", description = "Class representing Account Transaction Info")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "transactionDetail")
@Relation(collectionRelation = "transactionDetails")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetail implements Serializable {
}
