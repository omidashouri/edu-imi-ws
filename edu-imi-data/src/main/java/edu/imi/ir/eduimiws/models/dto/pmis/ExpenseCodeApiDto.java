package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCodeApiDto implements Serializable {

    private static final long serialVersionUID = 5659723488027077379L;

    private Long id;
    private Long expenseCode;

    private String expenseTitle;

    private String expenseCodePublicId;

    private Number status;

    private String description;

    private PersonDto creator;
    private Long creatorId;
    private String creatorPublicId;

    private PersonEntity editor;
    private Long editorId;
    private String editorPublicId;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;
}