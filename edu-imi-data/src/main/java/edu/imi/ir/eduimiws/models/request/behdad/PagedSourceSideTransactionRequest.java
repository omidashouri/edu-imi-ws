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
@Schema(name = "pagedSourceSideTransactionRequest", description = "Class representing Paged Source Side Transaction Request ")
@JsonRootName(value = "pagedSourceSideTransactionRequest")
@Relation(collectionRelation = "pagedSourceSideTransactionRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedSourceSideTransactionRequest implements Serializable {

    private SideTransactionsRequest sideTransactionsRequest;
    private Paging paging;
}
