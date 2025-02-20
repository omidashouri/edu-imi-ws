package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDataModelDto implements Serializable {

    private static final long serialVersionUID = 2885534629078643976L;

    private Long businessPartnerId;
    private String employeeCode;
    private String fullName;
}
