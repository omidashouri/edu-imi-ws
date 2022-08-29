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

import java.util.ArrayList;
import java.util.List;

@Tag(name = "behdadaccounts")
@Schema(name = "listAccountTransactionInfosResponse", description = "Class representing Paged Data Account Transaction Info Response")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "listAccountTransactionInfosResponse")
@Relation(collectionRelation = "listAccountTransactionInfosResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class ListAccountTransactionInfosResponse {

    private List<AccountTransactionInfo> accountTransactionInfos = new ArrayList<>();
}
