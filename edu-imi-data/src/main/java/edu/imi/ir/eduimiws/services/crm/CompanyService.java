package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;

@MappingUtil.CompanyService
public interface CompanyService {

    @MappingUtil.ImiCompanyPublicId
    String getImiCompanyPublicId();

    CompanyDto getImiCompanyDtoById();

    CompanyEntity getImiCompanyEntity();
}
