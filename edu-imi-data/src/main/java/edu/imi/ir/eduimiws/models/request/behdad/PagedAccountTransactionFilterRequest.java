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
@Schema(name = "pagedAccountTransactionFilterRequest", description = "Class representing Paged Account Transaction Filter Request ")
@JsonRootName(value = "pagedAccountTransactionFilterRequest")
@Relation(collectionRelation = "pagedAccountTransactionFilterRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedAccountTransactionFilterRequest implements Serializable {

    @Schema(title = "Account Transaction Filter",
            description = "Account Transaction Filter")
    private AccountTransactionFilter accountTransactionFilter;

    @Schema(title = "Paging",
            description = "Paging Account Transaction Filter")
    private Paging paging;
}
