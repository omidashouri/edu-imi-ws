package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    @EntityGraph(value = "StudentEntity.findStudentSubGraphUserApiService", type = EntityGraph.EntityGraphType.LOAD)
    Page<StudentEntity> findAllByDeleteStatusIsNotNullOrderByCreateDateDesc(Pageable pageable);

    @EntityGraph(value = "StudentEntity.findStudentSubGraphUserApiService", type = EntityGraph.EntityGraphType.LOAD)
    StudentEntity findByStudentApi_StudentPublicIdAndDeleteStatusNotNullOrderByCreateDateDesc(String studentPublicId);

    StudentEntity findFirstByOrderByIdDesc();
}
