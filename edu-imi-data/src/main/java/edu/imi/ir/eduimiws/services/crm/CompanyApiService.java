package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;

public interface CompanyApiService {

    CompanyApiEntity findByCompanyPublicId(String companyPublicId);

    CompanyEntity findCompanyByCompanyPublicId(String companyPublicId);
}
