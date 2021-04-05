package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {


    @EntityGraph(value = "OrganizationEntity.findByOrganizationApi", type = EntityGraph.EntityGraphType.LOAD)
    OrganizationEntity findByOrganizationApi_OrganizationPublicId(String organizationPublicId);

}
