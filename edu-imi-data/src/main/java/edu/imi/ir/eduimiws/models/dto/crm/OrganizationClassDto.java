package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationClassDto implements Serializable {

    private static final long serialVersionUID = -1399927646864237840L;

    private Long id;

    private Long efficiencyCoefficient;

    private String className;

    private Long performanceCoefficient;

    private PersonDto creatorId;

    private PersonDto editorId;

    private String createDate;

    private String editDate;

}
