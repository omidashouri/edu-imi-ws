package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class PeriodContractDto implements Serializable {

    private static final long serialVersionUID = 2514168189180840253L;

    private Long id;

    private PeriodDto periodDto;
    private String periodPublicId;
    private Long periodId;

    private ContractEduDto contractEduDto;
    private String contractEduPublicId;
    private Long contractEduId;

    private PersonDto creatorDto;
    private String personPublicId;
    private Long personId;

    private String createDate;

    private PersonDto editorDto;
    private String editorPublicId;
    private Long editorId;

    private String editDate;

    private String baseContract;

    private Long price;

    private PeriodContractApiDto periodContractApiDto;
    private String periodContractApiId;
}
