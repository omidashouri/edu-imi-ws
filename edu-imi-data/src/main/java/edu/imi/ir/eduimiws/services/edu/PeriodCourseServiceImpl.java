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
        log.info("PeriodCourseService.findAllByPageable - pageable: {}", pageable);
        Page<PeriodCourseEntity> result = periodCourseRepository
                .findAllBy(pageable);
        log.info("PeriodCourseService.findAllByPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public PeriodCourseEntity findByPeriodCoursePublicId(String periodCoursePublicId) {
        log.info("PeriodCourseService.findByPeriodCoursePublicId - periodCoursePublicId: {}", periodCoursePublicId);
        PeriodCourseEntity result = periodCourseRepository
                .findByPeriodCourseApi_PeriodCoursePublicId(periodCoursePublicId);
        log.info("PeriodCourseService.findByPeriodCoursePublicId - result: {}", result);
        return result;
    }

    @Override
    public List<PeriodCourseEntity> findAllByPeriodIdAndPeriodType(Long periodId, String periodType) {
        log.info("PeriodCourseService.findAllByPeriodIdAndPeriodType - periodId: {}, periodType: {}", periodId, periodType);
        List<PeriodCourseEntity> result = periodCourseRepository
                .findAllByPeriod_IdAndPeriod_Type(periodId, periodType);
        log.info("PeriodCourseService.findAllByPeriodIdAndPeriodType - resultSize: {}", result == null ? null : result.size());
        return result;
    }
}
