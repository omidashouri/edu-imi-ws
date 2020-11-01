package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeriodCourseService {

    Page<PeriodCourseEntity> findAllByPageable(Pageable pageable);

    PeriodCourseEntity findByPeriodCoursePublicId(String periodCoursePublicId);

    List<PeriodCourseEntity> findAllByPeriodIdAndPeriodType(Long periodId, String periodType);
}
