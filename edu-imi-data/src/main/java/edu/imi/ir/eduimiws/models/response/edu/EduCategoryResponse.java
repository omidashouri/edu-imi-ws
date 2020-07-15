package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "EduCategories",description = "Class representing a Education Categories in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "eduCategory")
@Relation(collectionRelation = "eduCategories")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EduCategoryResponse extends RepresentationModel<EduCategoryResponse> {

    @Schema(title = "Education Category Public ID",maxLength = 36)
    private String eduCategoryPublicId;

    @Schema(title = "Title",maxLength =  100)
    private String title;

    @Schema(title = "Education Category Parent Public Id",maxLength =  36)
    private String parentPublicId;

//      companyApi not built
/*    @Schema(title = "Company Public ID",maxLength = 36)
    private String companyPublicId;*/

    @Schema(title = "Editor Public ID",maxLength = 36)
    private String editorPublicId;

    @Schema(title = "Creator Public ID",maxLength = 36)
    private String creatorPublicId;

}
