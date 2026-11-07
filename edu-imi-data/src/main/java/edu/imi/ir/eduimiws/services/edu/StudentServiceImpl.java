package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
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
        log.info("StudentService.countStudentByIdLessThanEqual - studentId: {}", studentId);
        Long result = studentRepository.countByIdLessThanEqual(studentId);
        log.info("StudentService.countStudentByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public StudentEntity selectLastRecord() {
        log.info("StudentService.selectLastRecord - start");
        StudentEntity result = studentRepository.findFirstByOrderByIdDesc();
        log.info("StudentService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Page<StudentEntity> findAllByOrderByCreateDateDesc(Pageable pageable) {
        log.info("StudentService.findAllByOrderByCreateDateDesc - pageable: {}", pageable);
        Page<StudentEntity> result = studentRepository
                .findAllByDeleteStatusIsNotNullOrderByCreateDateDesc(pageable);
        log.info("StudentService.findAllByOrderByCreateDateDesc - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public StudentEntity findByStudentPublicIdOrderByCreateDateDesc(String studentPublicId) {
        log.info("StudentService.findByStudentPublicIdOrderByCreateDateDesc - studentPublicId: {}", studentPublicId);
        StudentEntity result = studentRepository
                .findByStudentApi_StudentPublicIdAndDeleteStatusNotNullOrderByCreateDateDesc(studentPublicId);
        log.info("StudentService.findByStudentPublicIdOrderByCreateDateDesc - result: {}", result);
        return result;
    }

    @Override
    public StudentEntity findByStudentPublicId(String studentPublicId) {
        log.info("StudentService.findByStudentPublicId - studentPublicId: {}", studentPublicId);
        StudentEntity result = studentRepository
                .findByStudentApi_StudentPublicId(studentPublicId);
        log.info("StudentService.findByStudentPublicId - result: {}", result);
        return result;
    }

    @Override
    public List<StudentEntity> findAllStudentOnlyByIdBetween(Long startId, Long endId) {
        log.info("StudentService.findAllStudentOnlyByIdBetween - startId: {}, endId: {}", startId, endId);
        List<StudentOnly> allStudentOnlys = studentRepository.findAllStudentOnlyByIdBetween(startId, endId);
        List<StudentEntity> result = studentOnlyMapper
                .toStudentEntities(allStudentOnlys, new CycleAvoidingMappingContext());
        log.info("StudentService.findAllStudentOnlyByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<StudentEntity> selectAllStudentOnly() {
        log.info("StudentService.selectAllStudentOnly - start");
        List<StudentOnly> studentOnlys = studentRepository.findAllStudentOnly();
        studentOnlys.sort(Comparator.comparing(StudentOnly::getId));
        List<StudentEntity> result = studentOnlyMapper
                .toStudentEntities(studentOnlys, new CycleAvoidingMappingContext());
        log.info("StudentService.selectAllStudentOnly - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public StudentEntity findFirstByIdLessThanOrderByIdDesc(Long studentId) {
        log.info("StudentService.findFirstByIdLessThanOrderByIdDesc - studentId: {}", studentId);
        StudentEntity result = studentRepository.findFirstByIdLessThanEqualOrderByIdDesc(studentId);
        log.info("StudentService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectStudentLastSequenceNumber() {
        log.info("StudentService.selectStudentLastSequenceNumber - start");
        Long result = studentRepository.selectLastSequenceNumber();
        log.info("StudentService.selectStudentLastSequenceNumber - result: {}", result);
        return result;
    }

    @Override
    public StudentEntity saveNewStudent(StudentEntity newStudent) {
        log.info("StudentService.saveNewStudent - newStudent: {}", newStudent);
        StudentEntity result = studentRepository.save(newStudent);
        log.info("StudentService.saveNewStudent - result: {}", result);
        return result;
    }

    @Override
    public List<StudentEntity> findAllByPerson(PersonEntity person) {
        log.info("StudentService.findAllByPerson - person: {}", person);
        List<StudentEntity> result = studentRepository.findAllByPerson(person);
        log.info("StudentService.findAllByPerson - resultSize: {}", result == null ? null : result.size());
        return result;
    }


}
