package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.repositories.edu.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Long studentCount() {
        return studentRepository.count();
    }

    @Override
    public StudentEntity selectLastRecord() {
        return studentRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<StudentEntity> findAllByOrderByCreateDateDesc(Pageable pageable) {
        Page<StudentEntity> studentPages = studentRepository
                .findAllByDeleteStatusIsNotNullOrderByCreateDateDesc(pageable);
        return studentPages;
    }

    @Override
    public StudentEntity findByStudentPublicIdOrderByCreateDateDesc(String studentPublicId) {
        StudentEntity student = studentRepository
                .findByStudentApi_StudentPublicIdAndDeleteStatusNotNullOrderByCreateDateDesc(studentPublicId);
        return student;
    }


}
