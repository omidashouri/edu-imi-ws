package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.QueryHint;

public interface TermPresentedGroupRepository extends CrudRepository<TermPresentedGroupEntity, Long> {

    Page<TermPresentedGroupEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "TermPresentedGroupEntity.termPresentedGroupApi",
            type = EntityGraph.EntityGraphType.LOAD)
    TermPresentedGroupEntity findByTermPresentedGroupApi_TermPresentedGroupPublicId(String termPresentedGroupPublicId);

    @EntityGraph(value = "TermPresentedGroupEntity.findAllWithTermPresentedCourseAGraphFieldCourse", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({
            @QueryHint(name = org.hibernate.jpa.HibernateHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.HibernateHints.HINT_READ_ONLY, value = "true")
    })
    Page<TermPresentedGroupEntity> readAllBy(Pageable pageable);

}
