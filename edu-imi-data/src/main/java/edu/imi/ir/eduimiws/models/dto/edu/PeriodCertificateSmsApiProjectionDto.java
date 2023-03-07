package edu.imi.ir.eduimiws.models.dto.edu;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCertificateSmsApiProjectionDto implements Serializable {

    private static final long serialVersionUID = 8017245854658495577L;

    private Long pcsaid;

    private String fullName;

    private String phone;

    private String fieldName;

    private String PeriodName;

    private Long activityStatus;

    private String deliveryDate;

    private Long financialStatus;

    private String finalStatus;

    private String registerType;


}
