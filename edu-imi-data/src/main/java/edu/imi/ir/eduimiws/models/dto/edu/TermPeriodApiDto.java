package edu.imi.ir.eduimiws.models.dto.edu;

import java.io.Serializable;
import java.sql.Timestamp;

public class TermPeriodApiDto implements Serializable {

    private static final long serialVersionUID = 6393520299653105908L;

    private Long id;

    private TermPeriodDto termPeriodDto;
    private Long termPeriodId;

    private String termPeriodPublicId;

    private Long deletedTermPeriodId;

    private TermDto termDto;
    private Long termId;

    private String termPublicId;

    private PeriodDto periodDto;
    private Long periodId;

    private String periodPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
