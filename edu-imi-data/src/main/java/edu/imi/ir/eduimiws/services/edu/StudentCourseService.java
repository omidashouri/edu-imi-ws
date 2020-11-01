package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentCourseEntity;

import java.util.List;

public interface StudentCourseService {

    List<StudentCourseEntity> saveAllStudentCourses(List<StudentCourseEntity> studentCourses);
}
