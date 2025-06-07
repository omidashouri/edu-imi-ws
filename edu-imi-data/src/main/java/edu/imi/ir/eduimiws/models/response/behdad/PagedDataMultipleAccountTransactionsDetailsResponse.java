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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "behdadaccounts")
@Schema(name = "PagedDataMultipleAccountTransactionsDetailsResponse", description = "Class representing Paged Data Bank Transaction Response")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "pagedDataMultipleAccountTransactionsDetailsResponse")
@Relation(collectionRelation = "pagedDataMultipleAccountTransactionsDetailsResponses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class PagedDataMultipleAccountTransactionsDetailsResponse extends PagedDataResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<TransactionDetail> multipleAccountTransactionsDetails = new ArrayList<>();

}
