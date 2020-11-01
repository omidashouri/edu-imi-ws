package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodCourseEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodCourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodCourseServiceImpl implements PeriodCourseService {

    private final PeriodCourseRepository periodCourseRepository;

    @Override
    public Page<PeriodCourseEntity> findAllByPageable(Pageable pageable) {
        Page<PeriodCourseEntity> periodCoursePages = periodCourseRepository
                .findAllBy(pageable);
        return periodCoursePages;
    }

    @Override
    public PeriodCourseEntity findByPeriodCoursePublicId(String periodCoursePublicId) {
        PeriodCourseEntity periodCourse = periodCourseRepository
                .findByPeriodCourseApi_PeriodCoursePublicId(periodCoursePublicId);
        return periodCourse;
    }

    @Override
    public List<PeriodCourseEntity> findAllByPeriodIdAndPeriodType(Long periodId, String periodType) {
        List<PeriodCourseEntity> periodCourses = periodCourseRepository
                .findAllByPeriod_IdAndPeriod_Type(periodId, periodType);
        return periodCourses;
    }
}

