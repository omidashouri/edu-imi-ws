package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationApiEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationApiRepository extends CrudRepository<OrganizationApiEntity, Long> {

    Optional<OrganizationApiEntity> findByOrganizationPublicId(String organizationPublicId);
}
