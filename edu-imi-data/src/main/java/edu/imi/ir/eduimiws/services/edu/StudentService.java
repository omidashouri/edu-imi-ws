package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentService {


    Long countStudentByIdLessThanEqual(Long StudentId);

    StudentEntity selectLastRecord();

    Page<StudentEntity> findAllByOrderByCreateDateDesc (Pageable pageable);

    StudentEntity findByStudentPublicIdOrderByCreateDateDesc(String studentPublicId);

    List<StudentEntity> findAllStudentOnlyByIdBetween(Long startId, Long EndId);

    List<StudentEntity> selectAllStudentOnly();

    StudentEntity findFirstByIdLessThanOrderByIdDesc(Long studentId);

    Long selectStudentLastSequenceNumber();



}
