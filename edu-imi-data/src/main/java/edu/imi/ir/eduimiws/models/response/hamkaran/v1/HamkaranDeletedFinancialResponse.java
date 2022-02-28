package edu.imi.ir.eduimiws.models.response.hamkaran.v1;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Schema(name = "HamkaranDeletedFinancialResponse",description = "Hamkaran Deleted Financial Response")
@JsonRootName(value = "HamkaranDeletedFinancialResponse")
@Relation(collectionRelation = "HamkaranDeletedFinancialResponses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranDeletedFinancialResponse {

    private HamkaranStatus status;

    private List<HamkaranDeleted> deleteds= new ArrayList<>();

    private HamkaranPagination pagination;

}
