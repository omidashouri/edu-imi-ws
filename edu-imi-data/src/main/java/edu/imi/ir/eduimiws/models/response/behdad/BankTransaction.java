package edu.imi.ir.eduimiws.models.response.behdad;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.math.BigDecimal;

@Schema(name = "behdadaccounts", description = "Class representing Bank Transaction")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "bankTransaction")
@Relation(collectionRelation = "bankTransactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction implements Serializable {

    private String accountNumber;
    private BigDecimal amount;
    private BigDecimal balance;
    private String description;
    private String destinationAccountNumber;
    private boolean groupTransfer;
    private String sourceAccountNumber;
    private String transactionDate;
    private Long transactionId;
    private String transactionIdentifier;
    private String transactionMediaSerial;
    private String transactionMediaType;
    private String transactionMethod;
    private String transactionStatusDate;
    private String transactionStatusTime;
    private String transactionStatusType;
    private String transactionTime;
    private String transactionType;
}
