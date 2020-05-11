package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentApiRepository extends CrudRepository<StudentApiEntity,Long> {


    List<StudentApiEntity> findAll();

    StudentApiEntity findFirstByOrderByIdDesc();

    List<StudentApiEntity> findAllByStudentIdIn(List<Long> studentIds);

}
