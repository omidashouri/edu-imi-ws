package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface StudentService {

    Long studentCount();

    StudentEntity selectLastRecord();

    Page<StudentEntity> findAllByOrderByCreateDateDesc (Pageable pageable);

    StudentEntity findByStudentPublicIdOrderByCreateDateDesc(String studentPublicId);


}
