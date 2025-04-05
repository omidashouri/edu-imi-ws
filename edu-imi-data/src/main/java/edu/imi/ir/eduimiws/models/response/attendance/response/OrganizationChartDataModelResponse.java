package edu.imi.ir.eduimiws.models.response.attendance.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.dto.attendance.EmployeeDataModelDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@JsonRootName(value = "organizationChartDataModel")
@Relation(collectionRelation = "organizationChartDataModels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationChartDataModelResponse implements Serializable {

    private Long id;
    private Long organizationChartId;
    private String organizationChartName;
    private EmployeeDataModelDto employeeDataModelDto;
}
