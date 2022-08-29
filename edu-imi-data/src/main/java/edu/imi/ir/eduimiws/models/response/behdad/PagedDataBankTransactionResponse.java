package edu.imi.ir.eduimiws.models.response.behdad;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Tag(name = "behdadaccounts")
@Schema(name = "PagedDataBankTransactionResponse", description = "Class representing Paged Data Bank Transaction Response")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "pagedDataBankTransactionResponse")
@Relation(collectionRelation = "pagedDataBankTransactionResponses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class PagedDataBankTransactionResponse extends PagedDataResponse<BankTransaction>{

/*  do not uncomment
    private List<BankTransaction> bankTransactions;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalCount;*/
}
