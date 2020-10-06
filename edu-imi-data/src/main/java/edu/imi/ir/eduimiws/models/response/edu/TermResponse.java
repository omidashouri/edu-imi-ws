package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "term", description = "Terms specification in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "term")
@Relation(collectionRelation = "terms")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermResponse extends RepresentationModel<TermResponse> {

    private String termPublicId;

    private String termName;

    private String startDate;

    private String endDate;

    private String creatorPublicId;

    private String createDate;

    private String editorPublicId;

    private String editDate;

    private String companyPublicId;

    private String regStartDate;

    private String regEndDate;

    private String year;

    private Long currentTerm;

    private String type;
}
