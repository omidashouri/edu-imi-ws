package edu.imi.ir.eduimiws.models.response.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionMediaType;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionMethod;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionStatusType;
import edu.imi.ir.eduimiws.utilities.behdad.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.math.BigDecimal;

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

    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private BigDecimal amount;
    private BigDecimal balance;
    private String cardNumber;
    private String description;
    private String destinationAccountNumber;
    private Boolean groupTransfer;
    private String iban;
    private String merchantId;
    private String sourceAccountNumber;
    private String traceNumber;
    private String transactionDate; //yyyyMMdd → jalali
    private Long transactionId;
    private String transactionIdentifier;
    private String transactionMediaSerial;
    private TransactionMediaType transactionMediaType;
    private TransactionMethod transactionMethod;
    private String transactionStan;
    private String transactionStatusDate; //yyyyMMdd → jalali
    private String transactionStatusTime; //HH:mm:ss
    private TransactionStatusType transactionStatusType;
    private String transactionTime; //HH:mm:ss
    private TransactionType transactionType;

}
