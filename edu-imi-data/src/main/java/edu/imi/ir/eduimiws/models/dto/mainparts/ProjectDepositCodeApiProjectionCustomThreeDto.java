package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiProjectionCustomThreeDto implements Serializable {

    private static final long serialVersionUID = 6056315723188841231L;

    private String publicI;

    private String depositCode;

    private String description;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private String projectName;

    private String projectCode;

    private String projectCreateDate;

    private Long projectStatusId;

    private String projectTypeName;

    private String startDatePlan;

    private String endDatePlan;

    private String lastVersion;

    private Character statusForTimeshit;

    private String creatorFullName;

    private String editorFullName;

    private String executor;

    private String projectPublicId;

}
