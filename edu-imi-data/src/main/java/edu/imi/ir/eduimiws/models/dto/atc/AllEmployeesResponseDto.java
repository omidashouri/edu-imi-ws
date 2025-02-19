package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllEmployeesResponseDto implements Serializable {

    private static final long serialVersionUID = 3987210043003957914L;

    private EmployeeDataModelDto employee;
}
