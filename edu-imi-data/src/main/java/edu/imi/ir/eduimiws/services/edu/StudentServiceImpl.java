package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.StudentEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.StudentOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.StudentOnly;
import edu.imi.ir.eduimiws.repositories.edu.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentOnlyMapper studentOnlyMapper;

    @Override
    public Long countStudentByIdLessThanEqual(Long studentId) {
        Long studentCount = studentRepository.countByIdLessThanEqual(studentId);
        return studentCount;
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

    @Override
    public List<StudentEntity> findAllStudentOnlyByIdBetween(Long startId,Long endId) {
        List<StudentOnly> allStudentOnlys = studentRepository.findAllStudentOnlyByIdBetween(startId,endId);
        List<StudentEntity> allStudents = studentOnlyMapper
                .toStudentEntities(allStudentOnlys, new CycleAvoidingMappingContext());
        return allStudents;
    }

    @Override
    public List<StudentEntity> selectAllStudentOnly() {
        List<StudentOnly> studentOnlys = studentRepository.findAllStudentOnly();
        studentOnlys.sort(Comparator.comparing(StudentOnly::getId));
        List<StudentEntity> allStudents = studentOnlyMapper
                .toStudentEntities(studentOnlys, new CycleAvoidingMappingContext());
        return allStudents;
    }

    @Override
    public StudentEntity findFirstByIdLessThanOrderByIdDesc(Long studentId) {
        StudentEntity student = studentRepository.findFirstByIdLessThanEqualOrderByIdDesc(studentId);
        return student;
    }

    @Override
    public Long selectStudentLastSequenceNumber() {
        return studentRepository.selectLastSequenceNumber();
    }


}
