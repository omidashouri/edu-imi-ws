package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CenterCostCodeApiDto implements Serializable {

    private static final long serialVersionUID = 5703859428876133216L;

    private Long id;

    private String centerCostCodePublicId;

    private Long costCode;

    private String costCodeTitle;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long lastVersion;

    private String description;

    private PersonDto creator;
    private Long creatorId;
    private String creatorPublicId;

    private PersonDto editor;
    private Long editorId;
    private String editorPublicId;
}
