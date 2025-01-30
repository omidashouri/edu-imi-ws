package edu.imi.ir.eduimiws.models.dto.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ProjectTypeEntity;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTypeApiDto implements Serializable {

    private static final long serialVersionUID = -5012090644056415283L;

    private Long id;

    private ProjectTypeDto projectType;
    private Long projectTypeId;

    private String projectTypePublicId;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;

    private Long deletedProjectTypeId;
}
