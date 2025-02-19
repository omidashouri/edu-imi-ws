package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDto implements Serializable {

    private static final long serialVersionUID = -3922408293781191289L;

    private Long id;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthDate;
    // private EtsAccountNumberDto accountNumber
}
