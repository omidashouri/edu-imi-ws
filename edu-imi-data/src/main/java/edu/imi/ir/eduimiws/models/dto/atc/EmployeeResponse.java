package edu.imi.ir.eduimiws.models.dto.atc;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

    private Long businessPartnerId;
    private String employeeCode;
    private String fullName;
}
