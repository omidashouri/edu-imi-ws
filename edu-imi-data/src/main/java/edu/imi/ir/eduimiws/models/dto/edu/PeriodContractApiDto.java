package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodContractApiDto implements Serializable {

    private static final long serialVersionUID = -9210382724721247755L;

    private Long id;

    private PeriodContractDto periodContractDto;
    private Long periodContractId;

    private Long deletedPeriodContractId;

    private String periodContractPublicId;

    private PeriodDto periodDto;
    private Long periodId;

    private String periodPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
