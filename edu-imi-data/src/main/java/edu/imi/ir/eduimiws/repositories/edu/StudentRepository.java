package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.models.projections.edu.StudentOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

    @EntityGraph(value = "StudentEntity.findStudentSubGraphUserApiService", type = EntityGraph.EntityGraphType.LOAD)
    Page<StudentEntity> findAllByDeleteStatusIsNotNullOrderByCreateDateDesc(Pageable pageable);

    @EntityGraph(value = "StudentEntity.findStudentSubGraphUserApiService", type = EntityGraph.EntityGraphType.LOAD)
    StudentEntity findByStudentApi_StudentPublicIdAndDeleteStatusNotNullOrderByCreateDateDesc(String studentPublicId);

    List<StudentEntity> findAllByPerson(PersonEntity person);

    @EntityGraph(value = "StudentEntity.findStudentSubGraphUserApiService", type = EntityGraph.EntityGraphType.LOAD)
    StudentEntity findByStudentApi_StudentPublicId(String studentPublicId);

    StudentEntity findFirstByOrderByIdDesc();

    StudentEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    @Query(name = "StudentEntity.selectAllStudentOnlyByIdBetween", nativeQuery = true)
    List<StudentOnly> findAllStudentOnlyByIdBetween(@Param("beginStudentId") Long beginStudentId,
                                                    @Param("endStudentId") Long endStudentId);

    @Query(name = "StudentEntity.selectAllStudentOnly", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)
    List<StudentOnly> findAllStudentOnly();

    @Query(name = "StudentEntity.selectCurrentSequenceNumber", nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long studentId);
}
