package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDepositCodeApiDto implements Serializable {

    private static final long serialVersionUID = -7099872336381103093L;

    private Long id;
    private String publicId;

    private ProjectDto projectDto;
    private Long projectId;
    private String projectPublicId;
    private String projectName;
    private String projectCode;
    private String projectLastVersion;


    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;
    private String creatorFullName;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;
    private String editorFullName;

    private String depositCode;
    private String description;
    private Timestamp createDateTs;
    private Timestamp deleteDateTs;
    private Timestamp editDateTs;


}
