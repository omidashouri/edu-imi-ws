package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDepositCodeApiProjectionCustomTwoDto implements Serializable {

    private static final long serialVersionUID = 6299357522286897019L;

    private String publicId;

    private String depositCode;

    private String description;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private String projectName;

    private String projectCode;

    private String creatorFullName;

    private String editorFullName;

}
