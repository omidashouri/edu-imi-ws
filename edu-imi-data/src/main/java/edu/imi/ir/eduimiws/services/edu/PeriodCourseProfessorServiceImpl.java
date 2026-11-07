package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodCourseProfessorRepository;
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
public class PeriodCourseProfessorServiceImpl implements PeriodCourseProfessorService {

    private final PeriodCourseProfessorRepository periodCourseProfessorRepository;

    @Override
    public Page<PeriodCourseProfessorEntity> findAllByPageable(Pageable pageable) {
        log.info("PeriodCourseProfessorService.findAllByPageable - pageable: {}", pageable);
        Page<PeriodCourseProfessorEntity> result = periodCourseProfessorRepository
                .findAllBy(pageable);
        log.info("PeriodCourseProfessorService.findAllByPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public PeriodCourseProfessorEntity findByPeriodCourseProfessorPublicId(String periodCourseProfessorPublicId) {
        log.info("PeriodCourseProfessorService.findByPeriodCourseProfessorPublicId - periodCourseProfessorPublicId: {}", periodCourseProfessorPublicId);
        PeriodCourseProfessorEntity result = periodCourseProfessorRepository
                .findByPeriodCourseProfessorApi_PriodCoursProfesorPublicId(periodCourseProfessorPublicId);
        log.info("PeriodCourseProfessorService.findByPeriodCourseProfessorPublicId - result: {}", result);
        return result;
    }

    @Override
    public Page<PeriodCourseProfessorEntity> findAllByPeriodCourseProfessorFieldNamePageable(Pageable pageable) {
        log.info("PeriodCourseProfessorService.findAllByPeriodCourseProfessorFieldNamePageable - pageable: {}", pageable);
        Page<PeriodCourseProfessorEntity> result = periodCourseProfessorRepository
                .readAllBy(pageable);
        log.info("PeriodCourseProfessorService.findAllByPeriodCourseProfessorFieldNamePageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

}
