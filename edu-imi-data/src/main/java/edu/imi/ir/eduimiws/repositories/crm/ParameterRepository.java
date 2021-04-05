package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ParameterEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends CrudRepository<ParameterEntity, Long> {

    @EntityGraph(value = "ParameterEntity.findByParameterApi", type = EntityGraph.EntityGraphType.LOAD)
    ParameterEntity findByParameterApi_ParameterPublicId(String parameterPublicId);
}
