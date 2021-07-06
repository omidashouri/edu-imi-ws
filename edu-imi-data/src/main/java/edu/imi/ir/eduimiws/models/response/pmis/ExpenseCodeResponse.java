package edu.imi.ir.eduimiws.models.response.pmis;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Schema(name = "expenseCodes", description = "Class representing a expense code in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "expenseCode")
@Relation(collectionRelation = "expenseCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCodeResponse extends RepresentationModel<ExpenseCodeResponse> {

    @Schema(title = "Expense Code", type = "number")
    private Long expenseCode;

    @Schema(title = "Expense Title", maxLength =500 )
    private String expenseTitle;

    @Schema(title = "Expense Title", maxLength =36 )
    private String expenseCodePublicId;

    @Schema(title = "Expense Status", type = "number",
    description = "1 for active and 0 for deactivate")
    private Integer status;

    @Schema(title = "Expense Description", maxLength =500 )
    private String description;

    @Schema(title = "Creator Public Id", maxLength =500 )
    private String creatorPublicId;

    @Schema(title = "Editor Public Id", maxLength =500 )
    private String editorPublicId;

    @Schema(title = "Create Date" )
    private String createDateTs;

    @Schema(title = "Edit Date", maxLength = 30)
    private Timestamp editDateTs;

    @Schema(title = "Delete Date", maxLength = 30)
    private Timestamp deleteDateTs;
}
