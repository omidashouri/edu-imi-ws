package edu.imi.ir.eduimiws.models.dto.atc;

import lombok.*;

import java.io.Serializable;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllEmployeeInfoResponseDto implements Serializable {

    private static final long serialVersionUID = 7529007437946284379L;

    private EmployeeInfoDto employeeInfo;
    private String nationalCode;
    private String certificateId;
    private String certificatePublishDate;
    private String certificatePublishRegion;
    private Long insuranceNo;
    private String employmentStartDate;
    private String employmentTerminationDate;
    private String jobPositionName;
    private String address;
    private Long genderId;
    private String genderName;
    private String mobileNumber;

}
