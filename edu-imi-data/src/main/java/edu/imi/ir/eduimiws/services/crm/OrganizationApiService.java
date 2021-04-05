package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationApiEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;

public interface OrganizationApiService {

    OrganizationApiEntity findByOrganizationPublicId(String organizationPublicId);

    OrganizationEntity findOrganizationByOrganizationPublicId(String organizationPublicId);
}
