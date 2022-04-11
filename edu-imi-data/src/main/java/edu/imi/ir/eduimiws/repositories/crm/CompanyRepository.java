package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

    @EntityGraph(value = "CompanyEntity.findByCompanyApi", type = EntityGraph.EntityGraphType.LOAD)
    CompanyEntity findByCompanyApi_CompanyPublicId(String companyPublicId);

    @EntityGraph(value = "CompanyEntity.findByCompanyApi", type = EntityGraph.EntityGraphType.LOAD)
    CompanyEntity readById(Long id);
}
