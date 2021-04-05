package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyApiEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyApiRepository extends CrudRepository<CompanyApiEntity, Long> {

    Optional<CompanyApiEntity> findByCompanyPublicId(String companyPublicId);
}
