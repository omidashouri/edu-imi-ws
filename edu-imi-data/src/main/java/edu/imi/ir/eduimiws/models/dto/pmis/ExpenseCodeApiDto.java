package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

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

    private Integer status;

    private String description;

    private PersonDto creator;
    private Long creatorId;
    private String creatorPublicId;

    private PersonEntity editor;
    private Long editorId;
    private String editorPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
