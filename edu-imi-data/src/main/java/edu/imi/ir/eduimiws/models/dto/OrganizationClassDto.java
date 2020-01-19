package edu.imi.ir.eduimiws.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationClassDto implements Serializable {

    private static final long serialVersionUID = -1399927646864237840L;

    private Long efficiencyCoefficient;

    private String className;

    private Long performanceCoefficient;

    private PersonDto creatorId;

    private PersonDto editorId;

    private String createDate;

    private String editDate;

}
