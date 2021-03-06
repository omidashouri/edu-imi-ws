package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseProfessorEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeriodCourseProfessorService {

    Page<PeriodCourseProfessorEntity> findAllByPageable(Pageable pageable);

    PeriodCourseProfessorEntity findByPeriodCourseProfessorPublicId(String periodCourseProfessorPublicId);

    @Cacheable(value = "periodCourseProfessor")
    Page<PeriodCourseProfessorEntity> findAllByPeriodCourseProfessorFieldNamePageable(Pageable pageable);
}
