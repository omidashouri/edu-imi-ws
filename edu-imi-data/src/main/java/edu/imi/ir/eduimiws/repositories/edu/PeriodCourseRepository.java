package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface PeriodCourseRepository extends CrudRepository<PeriodCourseEntity, Long> {

    @EntityGraph(value = "PeriodCourseEntity.periodCourseApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodCourseEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "PeriodCourseEntity.periodCourseApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    PeriodCourseEntity findByPeriodCourseApi_PeriodCoursePublicId(String periodCoursePublicId);
}
