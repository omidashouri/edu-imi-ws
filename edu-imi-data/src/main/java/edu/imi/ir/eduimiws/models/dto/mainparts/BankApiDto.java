package edu.imi.ir.eduimiws.models.dto.mainparts;

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
public class BankApiDto implements Serializable {

    private static final long serialVersionUID = 7773633125629803782L;

    private Long id;

    private String bankPublicId;

    private String bankName;

    private String bankCode;

    private PersonDto creator;
    private String creatorPublicId;
    private Long creatorId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private PersonDto editor;
    private String editorPublicId;
    private Long editorId;

    private String description;
}
