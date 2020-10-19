package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;

import java.io.Serializable;
import java.sql.Timestamp;

public class CostTypeApiDto implements Serializable {

    private static final long serialVersionUID = -8655008608386197723L;

    private Long id;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private CostTypeDto costTypeDto;
    private Long costTypeId;

    private String costTypePublicId;

    private Long deletedCostTypeId;

    private CompanyDto companyDto;
    private Long companyId;
    private String companyPublicId;

    private Timestamp createDateTs;
}
