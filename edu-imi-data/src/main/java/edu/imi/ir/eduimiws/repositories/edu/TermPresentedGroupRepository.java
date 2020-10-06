package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface TermPresentedGroupRepository extends CrudRepository<TermPresentedGroupEntity, Long> {

    Page<TermPresentedGroupEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "TermPresentedGroupEntity.termPresentedGroupApi",
            type = EntityGraph.EntityGraphType.LOAD)
    TermPresentedGroupEntity findByTermPresentedGroupApi_TermPresentedGroupPublicId(String termPresentedGroupPublicId);
}
