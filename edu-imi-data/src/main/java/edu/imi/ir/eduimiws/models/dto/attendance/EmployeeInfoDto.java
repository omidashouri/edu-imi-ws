package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDto implements Serializable {

    private static final long serialVersionUID = -3922408293781191289L;

    private Long id;
    private Long employeeInfoId;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String employmentStartDate;
    private String employmentTerminationDate;
    private Timestamp createDate;
    private Timestamp editDate;
}
