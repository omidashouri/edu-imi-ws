package edu.imi.ir.eduimiws.models.request.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Schema(name = "behdadaccounts", description = "Class representing Side Transactions Request ")
@JsonRootName(value = "sideTransactionsRequest")
@Relation(collectionRelation = "sideTransactionsRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SideTransactionsRequest implements Serializable {

    private String accountNumber;
    private long transactionId;
}
