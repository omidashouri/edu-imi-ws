package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTypeDto implements Serializable {

    private static final long serialVersionUID = -7438887939678818838L;

    private Long id;
    private String projectTypePublicId;

    private String projectTypeName;

    private ProjectTypeDto parent;
    private Long parentId;
    private String parentPublicId;

    private PersonDto creator;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private String editDate;

    private PersonDto editor;
    private Long editorId;
    private String editorPublicId;

    private String projectType;

}
