package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;

import java.io.Serializable;

public class PreRegisterDto implements Serializable {

    private static final long serialVersionUID = -910510449737713265L;

    private Long id;

    private PeriodDto periodDto;
    private Long periodId;
    private String periodPublicId;


    private ContactDto contactDto;
    private Long contactId;
    private String contactPublicId;

    private String activityStatus;

    private String deleteStatus;

    private PersonDto creator;
    private String creatorPublicId;
    private Long creatorId;

    private String createDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String editDate;

    private Long financialStatus;

    private String fway;

    private String rfrom;

    private PeriodContractDto periodContractDto;
    private Long periodContractId;
    private String periodContractPublicId;

    private ContractEduDto contractEduDto;
    private Long contractEduId;
    private String contractEduPublicId;

    private AccountDto accountDto;
    private Long accountId;
    private String accountPublicId;

    private Long fee;

    private String registerType;

    private String registerFrom;

    private String educationType;

    private String descrption;

    private PreRegisterApiDto preRegisterApiDto;
    private String preRegisterPublicId;
    private Long preRegisterApiId;
}
