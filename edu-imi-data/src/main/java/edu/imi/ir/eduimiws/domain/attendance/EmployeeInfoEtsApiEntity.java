package edu.imi.ir.eduimiws.domain.attendance;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "ATC", sequenceName = "SEQ_EMPLOYEE_INFO_ETS_API", allocationSize = 1)
@Table(schema = "ATC", name = "TBL_EMPOYEE_INFO_ETS_API")
public class EmployeeInfoEtsApiEntity extends BaseEntity {

    @Column(name = "EMPLOYEE_INFO_ID")
    private Long employeeInfoId;

    @Column(name = "EMPLOYEE_CODE", length = 255)
    private String employeeCode;

    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;

    @Column(name = "LAST_NAME", length = 255)
    private String lastName;

    @Column(name = "EMPLOYMENT_START_DATE", length = 20)
    private String employmentStartDate;

    @Column(name = "EMPLOYMENT_TERMINATION_DATE", length = 20)
    private String employmentTerminationDate;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "EDIT_DATE")
    private Timestamp editDate;

}
