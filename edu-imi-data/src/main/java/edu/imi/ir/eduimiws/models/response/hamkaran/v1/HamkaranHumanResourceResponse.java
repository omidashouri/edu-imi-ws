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

@Schema(name = "HamkaranHumanResourceResponse",description = "Hamkaran Human Resource Response")
@JsonRootName(value = "HamkaranHumanResourceResponse")
@Relation(collectionRelation = "HamkaranHumanResourceResponsees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranHumanResourceResponse {

    private HamkaranStatus status;

    private HamkaranPagination pagination;

    private List<HamkaranHumanResourceData> data= new ArrayList<>();

    private HamkaranHeader headers;
}
