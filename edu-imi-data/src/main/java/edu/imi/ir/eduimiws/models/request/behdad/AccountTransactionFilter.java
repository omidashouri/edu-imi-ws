package edu.imi.ir.eduimiws.models.request.behdad;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@Tag(name = "behdadaccounts")
@Schema(name = "AccountTransactionFilter", description = "Class representing Account Transaction Filter ")
@JsonRootName(value = "accountTransactionFilter")
@Relation(collectionRelation = "accountTransactionFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionFilter implements Serializable {

    private String accountNumber;
    private String fromDateTime;
    private String paymentIdentifier;
    private String toDateTime;
}
