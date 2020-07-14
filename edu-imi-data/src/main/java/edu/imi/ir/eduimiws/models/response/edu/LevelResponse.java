package edu.imi.ir.eduimiws.models.response.edu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "levels",description = "Class representing a level in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "level")
@Relation(collectionRelation = "levels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponse extends RepresentationModel<LevelResponse> {

    @Schema(title = "Level Public ID",maxLength = 36)
    private String levelPublicId;

    @Schema(title = "Level Description",maxLength = 150)
    private String description;

    @Schema(title = "Level Code",maxLength = 10)
    private String code;

    @Schema(title = "Company Public Id",maxLength = 36)
    private String companyPublicId;

    @Schema(title = "Termic Status",maxLength = 120)
    private String termicStatus;

    @Schema(title = "Creator Public Id",maxLength = 36)
    private String creatorPublicId;

    @Schema(title = "Editor Public ID",maxLength = 36)
    private String editorPublicId;

    @Schema(title = "Create Date",maxLength = 10)
    private String createDate;

    @Schema(title = "Edit Date",maxLength = 10)
    private String editDate;

    @Schema(title = "Payment Type",maxLength = 1)
    private String paymentType;

    @Schema(title = "Title",maxLength = 50)
    private String title;

    @Schema(title = "Certificate Title",maxLength = 50)
    private String certTitle;
}
