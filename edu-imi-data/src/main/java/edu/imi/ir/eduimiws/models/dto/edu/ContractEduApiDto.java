package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.ParameterDto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ContractEduApiDto implements Serializable {

    private static final long serialVersionUID = -5357795023570741188L;

    private ContractEduDto contractEduDto;
    private Long contractEduId;

    private Long deletedContractEduId;

    private String contractEduPublicId;

    private ParameterDto parameterDto;
    private Long parameterId;

    private String parameterPublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

}
