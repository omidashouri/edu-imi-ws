package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationChartDataModelDto implements Serializable {

    private static final long serialVersionUID = 4000512601116131201L;

    private Long organizationChartId;
    private String organizationChartName;

}
