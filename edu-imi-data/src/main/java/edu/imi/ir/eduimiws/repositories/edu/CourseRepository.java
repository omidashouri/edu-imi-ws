package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

    @EntityGraph(value = "CourseEntity.courseApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    Page<CourseEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "CourseEntity.courseApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    CourseEntity findByCourseApi_CoursePublicId(String coursePublicId);
}
