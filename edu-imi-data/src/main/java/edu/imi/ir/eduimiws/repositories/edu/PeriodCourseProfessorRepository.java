package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface PeriodCourseProfessorRepository extends CrudRepository<PeriodCourseProfessorEntity, Long> {

    @EntityGraph(value = "PeriodCourseProfessorEntity.periodCourseProfessorApiEntityAndPeriodCourseEntity",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodCourseProfessorEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "PeriodCourseProfessorEntity.periodCourseProfessorApiEntity",
            type = EntityGraph.EntityGraphType.LOAD)
    PeriodCourseProfessorEntity findByPeriodCourseProfessorApi_PriodCoursProfesorPublicId(String periodCourseProfessorPublicId);
}
