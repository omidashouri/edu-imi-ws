package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface TermPresentedCourseRepository extends CrudRepository<TermPresentedCourseEntity, Long> {

    Page<TermPresentedCourseEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "TermPresentedCourseEntity.termPresentedCourseApi", type = EntityGraph.EntityGraphType.LOAD)
    TermPresentedCourseEntity findByTermPresentedCourseApi_TrmPresentedCoursePublicId(String termPresentedCoursePublicId);
}
