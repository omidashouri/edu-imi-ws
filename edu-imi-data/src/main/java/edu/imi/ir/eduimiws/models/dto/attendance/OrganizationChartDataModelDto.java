package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationChartDataModelDto implements Serializable {

    private static final long serialVersionUID = 4000512601116131201L;

    private Long organizationChartId;
    private String organizationChartName;
    private EmployeeDataModelDto employeeDataModelDto;
    private Timestamp createDateTs;
    private Timestamp editDateTs;
    private String Description;

}
