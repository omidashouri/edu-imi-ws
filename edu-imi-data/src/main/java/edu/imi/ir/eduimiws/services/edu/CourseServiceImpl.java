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
        Page<CourseEntity> coursePages = courseRepository
                .findAllBy(pageable);
        return coursePages;
    }

    @Override
    public CourseEntity findByCoursePublicId(String coursePublicId) {
        CourseEntity course = courseRepository
                .findByCourseApi_CoursePublicId(coursePublicId);
        return course;
    }
}
