package edu.imi.ir.eduimiws.models.dto.attendance;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllOrganizationChartListResponseDto implements Serializable {

    private static final long serialVersionUID = 6778611573753502152L;

    private OrganizationChartDataModelDto organizationChartDataModel;

    private EmployeeDataModelDto employees;

}
