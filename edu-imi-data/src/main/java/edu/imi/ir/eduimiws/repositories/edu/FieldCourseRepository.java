package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface FieldCourseRepository extends CrudRepository<FieldCourseEntity, Long> {

    Page<FieldCourseEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "FieldCourseEntity.fieldCourseApi", type = EntityGraph.EntityGraphType.LOAD)
    FieldCourseEntity findByFieldCourseApi_FieldCoursePublicId(String fieldCoursePublicId);
}
