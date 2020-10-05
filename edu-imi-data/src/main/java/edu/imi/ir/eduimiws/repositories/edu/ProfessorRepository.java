package edu.imi.ir.eduimiws.repositories.edu;


import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Long> {

    @EntityGraph(value = "ProfessorEntity.professorApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    Page<ProfessorEntity> findAllBy(Pageable pageable);

    @EntityGraph(value = "ProfessorEntity.professorApiEntity", type = EntityGraph.EntityGraphType.LOAD)
    ProfessorEntity findByProfessorApi_ProfessorPublicId(String professorPublicId);
}
