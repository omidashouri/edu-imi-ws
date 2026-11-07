package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentCourseEntity;
import edu.imi.ir.eduimiws.repositories.edu.StudentCourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;


    @Override
    public List<StudentCourseEntity> saveAllStudentCourses(List<StudentCourseEntity> newStudentCourses) {
        log.info("StudentCourseService.saveAllStudentCourses - newStudentCourses: {}", newStudentCourses);
        Iterable<StudentCourseEntity> studentCourseIterable = studentCourseRepository.saveAll(newStudentCourses);
        List<StudentCourseEntity> result = StreamSupport
                .stream(studentCourseIterable.spliterator(), false)
                .collect(Collectors.toList());
        log.info("StudentCourseService.saveAllStudentCourses - resultSize: {}", result == null ? null : result.size());
        return result;
    }
}
