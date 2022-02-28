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

@Schema(name = "HamkaranFinancialResponse",description = "Hamkaran Financial Response")
@JsonRootName(value = "HamkaranFinancialResponse")
@Relation(collectionRelation = "HamkaranFinancialResponses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranFinancialResponse {

    private HamkaranStatus status;

    private HamkaranPagination pagination;

    private List<HamkaranData> data= new ArrayList<>();

    private HamkaranHeader headers;
}
