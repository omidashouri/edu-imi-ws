package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeriodCourseService {

    Page<PeriodCourseEntity> findAllByPageable(Pageable pageable);

    PeriodCourseEntity findByPeriodCoursePublicId(String periodCoursePublicId);
}
