package edu.imi.ir.eduimiws.models.dto.edu;

import java.io.Serializable;
import java.sql.Timestamp;

public class PeriodPaymentApiDto implements Serializable {

    private static final long serialVersionUID = 5309455476035039165L;

    private Long id;

    private PeriodPaymentDto periodPaymentDto;

    private Long deletedPeriodPaymentId;

    private String periodPaymentPublicId;

    private PeriodDto periodDto;
    private String periodDtoId;

    private String periodPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
