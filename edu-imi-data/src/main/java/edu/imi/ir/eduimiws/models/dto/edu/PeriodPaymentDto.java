package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class PeriodPaymentDto implements Serializable {

    private static final long serialVersionUID = 7177827280011543041L;

    private Long id;

    private PeriodDto periodDto;
    private Long periodId;
    private String periodPublicId;

    private String paymentDate;

    private Long paymentPrice;

    private Long paymentPercent;

    private String createDate;

    private PersonDto creatorDto;
    private String creatorPublicId;
    private Long creatorId;

    private String editDate;

    private PersonDto editorDto;
    private String editorPublicId;
    private Long editorId;

    private PeriodPaymentApiDto periodPaymentApiDto;
    private String periodPaymentPublicId;
    private Long periodPaymentApiId;
}
