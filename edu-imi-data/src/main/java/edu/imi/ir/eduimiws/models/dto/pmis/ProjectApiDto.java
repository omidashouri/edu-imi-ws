package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApiDto implements Serializable {

    private static final long serialVersionUID = 8320876397937908851L;

    private Long id;
    private String projectPublicId;

    private ProjectDto project;
    private Long projectId;

    private ProjectTypeDto projectType;
    private Long projectTypeId;

    private String projectTypePublicId;

    private PersonDto executor;
    private Long executorId;

    private String executorPublicId;

    private PersonDto manager;
    private Long managerId;

    private String managerPublicId;

    private String lastVersion;

    private Long projectRequestId;

    private String projectRequestPublicId;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private Long deletedProjectId;

    private String description;

}
