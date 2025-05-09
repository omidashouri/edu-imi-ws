package edu.imi.ir.eduimiws.models.response.attendance.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

    private Long businessPartnerId;
    private String employeeCode;
    private String fullName;
}
