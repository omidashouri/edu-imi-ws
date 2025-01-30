package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import jakarta.persistence.QueryHint;

public interface PeriodCourseProfessorRepository extends CrudRepository<PeriodCourseProfessorEntity, Long> {

    @EntityGraph(value = "PeriodCourseProfessorEntity.periodCourseProfessorApiEntity",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodCourseProfessorEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "PeriodCourseProfessorEntity.periodCourseProfessorApiEntity",
            type = EntityGraph.EntityGraphType.LOAD)
    PeriodCourseProfessorEntity findByPeriodCourseProfessorApi_PriodCoursProfesorPublicId(String periodCourseProfessorPublicId);

    @Cacheable("periodCourseProfessor")
    @EntityGraph(value = "PeriodCourseProfessorEntity.periodCourseProfessorApiEntityAndPeriodCourseProfessorFieldEntity",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"), //VERY IMPORTANT
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    Page<PeriodCourseProfessorEntity> readAllBy(Pageable pageable);
}
