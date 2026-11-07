package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import edu.imi.ir.eduimiws.repositories.edu.CourseRepository;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Page<CourseEntity> findAllByPageable(Pageable pageable) {
        log.info("CourseService.findAllByPageable - pageable: {}", pageable);
        Page<CourseEntity> result = courseRepository
                .findAllBy(pageable);
        log.info("CourseService.findAllByPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public CourseEntity findByCoursePublicId(String coursePublicId) {
        log.info("CourseService.findByCoursePublicId - coursePublicId: {}", coursePublicId);
        CourseEntity result = courseRepository
                .findByCourseApi_CoursePublicId(coursePublicId);
        log.info("CourseService.findByCoursePublicId - result: {}", result);
        return result;
    }
}
