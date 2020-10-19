package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.models.dto.crm.ParameterDto;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractEduDto implements Serializable {

    private static final long serialVersionUID = 3664638307826221783L;

    private String numberContract;

    private String startDate;

    private String contractSubject;

    private AccountDto accountDto;
    private String accountPublicId;
    private Long accountId;

    private ParameterDto contractTypeDto;
    private String contractTypePublicId;
    private Long contractTypeId;

    private Long price;

    private String contractDesc;

    private PersonDto creatorDto;
    private String creatorPublicId;
    private Long creatorId;

    private PersonDto editorDto;
    private String editorPublicId;
    private Long editorId;

    private String editDate;

    private String createDate;

    private CompanyDto companyDto;
    private String companyPublicId;
    private Long companyId;

    private String contractType;

    private String fileNewName;

    private String fileOldName;

    private ContractEduApiDto contractEduApiDto;
    private String contractEduApiPublicId;
    private Long contractEduId;
}
