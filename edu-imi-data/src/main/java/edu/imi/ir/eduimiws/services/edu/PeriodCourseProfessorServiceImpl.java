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
        Page<PeriodCourseProfessorEntity> periodCourseProfessorPages = periodCourseProfessorRepository
                .findAllBy(pageable);
        return periodCourseProfessorPages;
    }

    @Override
    public PeriodCourseProfessorEntity findByPeriodCourseProfessorPublicId(String periodCourseProfessorPublicId) {
        PeriodCourseProfessorEntity periodCourseProfessor = periodCourseProfessorRepository
                .findByPeriodCourseProfessorApi_PriodCoursProfesorPublicId(periodCourseProfessorPublicId);
        return periodCourseProfessor;
    }

}
