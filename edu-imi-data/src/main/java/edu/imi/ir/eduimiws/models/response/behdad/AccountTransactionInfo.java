package edu.imi.ir.eduimiws.models.response.behdad;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.math.BigDecimal;

@Schema(name = "behdadaccounts", description = "Class representing Account Transaction Info")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "accountTransactionInfo")
@Relation(collectionRelation = "accountTransactionInfos")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionInfo implements Serializable {

    private String accountNumber;
    private BigDecimal amount;
    private long transactionId;
    private String transactionIdentifier;
}
