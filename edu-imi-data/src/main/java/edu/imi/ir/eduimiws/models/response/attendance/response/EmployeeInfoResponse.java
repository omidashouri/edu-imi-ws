package edu.imi.ir.eduimiws.models.response.attendance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoResponse implements Serializable {

    private Long id;
    private Long employeeInfoId;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String employmentStartDate;
    private String employmentTerminationDate;
}
