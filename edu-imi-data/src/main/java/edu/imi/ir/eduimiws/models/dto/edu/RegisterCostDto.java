package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.edu.CostTypeEntity;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class RegisterCostDto implements Serializable {

    private static final long serialVersionUID = -4511554764002039989L;

    private Long id;

    private RegisterDto registerDto;
    private String registerPublicId;
    private Long registerId;

    private CostTypeEntity costType;

    private Long cvalue;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String createDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String editDate;

    private String remark;

    private TermPeriodDto termPeriodDto;
    private Long termPeriodId;
    private String termPeriodPublicId;

    private Long finalCost;

    private RegisterCostApiDto registerCostApiDto;
    private String registerCostPublicId;
    private Long registerCostApiId;
}
