package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class TermPeriodDto implements Serializable {

    private static final long serialVersionUID = -4850063542019732845L;

    private Long id;

    private TermDto termDto;
    private String termPublicId;
    private Long termId;

    private PeriodDto periodDto;
    private Long periodId;
    private String periodPublicId;

    private String startDate;

    private String endDate;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;

    private String editDate;

    private Long fee;

    private Long feeEquivalent;

    private TermPeriodApiDto termPeriodApiDto;
    private Long termPeriodApiId;
    private String termPeriodPublicId;
}
