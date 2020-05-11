package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentApiEntity;
import edu.imi.ir.eduimiws.domain.edu.StudentEntity;

import java.util.List;

public interface StudentApiService {

    StudentApiEntity selectLastRecord();

    Long studentApiCount();

    List<StudentApiEntity> generateStudentApiPublicId(List<StudentEntity> newStudentEntities);

    List<StudentApiEntity> findAllByStudentIdIn(List<Long> studentIds);
}
