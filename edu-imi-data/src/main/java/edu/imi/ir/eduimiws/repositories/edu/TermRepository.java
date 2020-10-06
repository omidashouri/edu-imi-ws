package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface TermRepository extends CrudRepository<TermEntity, Long> {

    Page<TermEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "TermEntity.termApi", type = EntityGraph.EntityGraphType.LOAD)
    TermEntity findByTermApi_TermPublicId(String termPublicId);
}
