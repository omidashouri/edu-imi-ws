package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDataModelDto implements Serializable {

    private static final long serialVersionUID = 2885534629078643976L;

    private Long businessPartnerId;
    private String employeeCode;
    private String fullName;
}
